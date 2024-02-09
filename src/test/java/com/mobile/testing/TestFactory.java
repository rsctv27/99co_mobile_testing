package com.mobile.testing;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidStartScreenRecordingOptions;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

public class TestFactory {

    private static ThreadLocal<AppiumDriverLocalService> appiumServer = new ThreadLocal<>();
    private static ThreadLocal<AppiumDriver> appiumDriver = new ThreadLocal<>();

    protected static PageFactory pageFactory;

    public void setup() {
        startAppiumServer();
        startSession();
    }

    public void shutdown() {
        endSession();
        stopAppiumServer();
    }

    public AppiumDriver getAppiumDriver() {
        return appiumDriver.get();
    }

    public void takeScreenshoot(Scenario scenario) {
        byte[] screenshot = new TestFactory().getAppiumDriver().getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());
    }

    public void startRecording() {
        AndroidDriver driver = (AndroidDriver) getAppiumDriver();
        driver.startRecordingScreen(new AndroidStartScreenRecordingOptions()
                .withVideoSize("1280x720")
                .withTimeLimit(Duration.ofSeconds(200)));
    }

    public void endRecording(Scenario scenario) throws IOException {
        AndroidDriver driver = (AndroidDriver) getAppiumDriver();
        String video = driver.stopRecordingScreen();

        byte[] data = Base64.getDecoder().decode(video);

        String destinationPath = "target/recording.mp4";
        Path path = Paths.get(destinationPath);
        Files.write(path, data);

        scenario.attach(data, "video/mp4", scenario.getName());
    }

    private void startAppiumServer() {
        AppiumDriverLocalService server;

        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
        serviceBuilder.usingAnyFreePort();
        serviceBuilder.withArgument(() -> "--base-path", "/wd/hub");
        serviceBuilder.withIPAddress("127.0.0.1");
        serviceBuilder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        serviceBuilder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");
        serviceBuilder.withStartUpTimeOut(30, TimeUnit.SECONDS);

        server = AppiumDriverLocalService.buildService(serviceBuilder);
        server.start();

        if(!server.isRunning()){
            throw new AppiumServerHasNotBeenStartedLocallyException("Appium server not started. ABORT!!!");
        }
        appiumServer.set(server);
    }

    private void startSession() {
        AndroidDriver driver;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        capabilities.setCapability(MobileCapabilityType.APP, "./android.wdio.native.app.v1.0.8.apk");
        capabilities.setCapability("appPackage", "com.wdiodemoapp");
        capabilities.setCapability("appWaitPackage", "com.wdiodemoapp");
        capabilities.setCapability("autoGrantPermissions", "true");

        driver = new AndroidDriver(appiumServer.get().getUrl(), capabilities);
        appiumDriver.set(driver);
        pageFactory = new PageFactory(driver);
    }

    private void endSession() {
        if (appiumDriver.get() != null) {
            appiumDriver.get().quit();
            appiumDriver.set(null);
        }
    }

    private void stopAppiumServer() {
        if (appiumServer.get() != null) appiumServer.get().stop();
    }
}
