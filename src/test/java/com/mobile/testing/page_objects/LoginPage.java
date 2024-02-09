package com.mobile.testing.page_objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.junit.Assert;

public class LoginPage extends BasePage {


    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Login-screen')]")
    private MobileElement loginScreen;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'input-email')]")
    private MobileElement inputEmail;

    @AndroidFindBy(xpath = "//*[contains(@text, 'Please enter a valid email address')]")
    private MobileElement errorInputEmail;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'input-password')]")
    private MobileElement inputPassword;

    @AndroidFindBy(xpath = "//*[contains(@text, 'Please enter at least 8 characters')]")
    private MobileElement errorInputPassword;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'button-LOGIN')]")
    private MobileElement loginButton;

    @AndroidFindBy(xpath = "//*[contains(@text, 'Success')]")
    private MobileElement successDialogPopUp;

    public LoginPage(AndroidDriver<AndroidElement> androidDriver) {
        super(androidDriver);
    }

    public void is_on_login_page() {
        waitElementVisibleXpath("//*[contains(@content-desc, 'Login-screen')]", 30);
    }

    public void input_email(String number) { sendKeys(inputEmail, number); }

    public void input_password(String number) {
        sendKeys(inputPassword, number);
    }

    public void error_message_input_email() {
        waitElementVisible(errorInputEmail);
        Assert.assertTrue("Error message input email is not displayed!!", errorInputEmail.isDisplayed());
    }

    public void error_message_input_password() {
        waitElementVisible(errorInputPassword);
        Assert.assertTrue("Error message input password is not displayed!!", errorInputPassword.isDisplayed());
    }

    public void click_login_button() {
        click(loginButton);
    }

    public void success_dialog_pop_up() {
        waitElementVisible(successDialogPopUp);
        Assert.assertTrue("Success dialog pop up is not displayed!!", successDialogPopUp.isDisplayed());
    }
}
