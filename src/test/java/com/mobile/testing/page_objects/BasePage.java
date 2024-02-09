package com.mobile.testing.page_objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {

    protected AndroidDriver<AndroidElement> androidDriver;

    public BasePage(AndroidDriver<AndroidElement> androidDriver) {
        this.androidDriver = androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(this.androidDriver), this);
    }

    public void waitElementVisible(MobileElement e) {
        WebDriverWait wait = new WebDriverWait(androidDriver, 30);
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public void waitElementClickable(MobileElement e) {
        WebDriverWait wait = new WebDriverWait(androidDriver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(e));
    }

    public void waitElementVisibleXpath(String xpath, int timeout) {
        WebDriverWait wait = new WebDriverWait(androidDriver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public void waitElementClickableXpath(String xpath, int timeout) {
        WebDriverWait wait = new WebDriverWait(androidDriver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    public void waitElementInvisibleXpath(String xpath, int timeout) {
        WebDriverWait wait = new WebDriverWait(androidDriver, timeout);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
    }

    public void swipe(double input_start_x, double input_end_x){
        Dimension dimension = this.androidDriver.manage().window().getSize();
        int start_x = (int) (dimension.width * input_start_x);
        int start_y = dimension.height/2;
        int end_x = (int) (dimension.width * input_end_x);
        int end_y = dimension.height/2;

        TouchAction touchAction = new TouchAction(this.androidDriver);
        touchAction.press(PointOption.point(start_x, start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(end_x,end_y)).release().perform();
        delay(3000);
    }

    public void swipe_left() {
        swipe(0.9, 0.1);
    }

    public void click(MobileElement e) {
        waitElementVisible(e);
        e.click();
    }

    public void sendKeys(MobileElement e, String txt) {
        waitElementVisible(e);
        e.sendKeys(txt);
    }

    protected void delay(int milliseconds) {
        try {
            Thread.sleep((long)milliseconds);
        } catch (InterruptedException var3) {
            var3.printStackTrace();
        }
    }
}

