package com.mobile.testing.page_objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends BasePage {

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Home-screen')]")
    private MobileElement homepageScreen;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Home')]")
    private MobileElement homeBottomBar;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Webview')]")
    private MobileElement webviewBottomBar;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Login')]")
    private MobileElement loginBottomBar;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Forms')]")
    private MobileElement formsBottomBar;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Swipe')]")
    private MobileElement swipeBottomBar;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Drag')]")
    private MobileElement dragBottomBar;


    public HomePage(AndroidDriver<AndroidElement> androidDriver) {
        super(androidDriver);
    }

    public void is_on_home_page() {
        waitElementVisibleXpath("//*[contains(@content-desc, 'Home-screen')]", 30);
    }

    public void click_home_bottom_bar() {
        click(homeBottomBar);
    }

    public void click_webview_bottom_bar() {
        click(webviewBottomBar);
    }

    public void click_login_bottom_bar() {
        click(loginBottomBar);
    }

    public void click_forms_bottom_bar() {
        click(formsBottomBar);
    }

    public void click_swipe_bottom_bar() {
        click(swipeBottomBar);
    }

    public void click_drag_bottom_bar() {
        click(dragBottomBar);
    }

}
