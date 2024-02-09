package com.mobile.testing;

import com.mobile.testing.page_objects.BasePage;
import com.mobile.testing.page_objects.HomePage;
import com.mobile.testing.page_objects.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class PageFactory {

    private final AndroidDriver<AndroidElement> androidDriver;

    public PageFactory(AndroidDriver<AndroidElement> androidDriver) {
        this.androidDriver = androidDriver;
    }

    public BasePage basePage() {
        return new BasePage(this.androidDriver);
    }

    public HomePage homePage() { return new HomePage(this.androidDriver); }

    public LoginPage loginPage() { return new LoginPage(this.androidDriver); }
}

