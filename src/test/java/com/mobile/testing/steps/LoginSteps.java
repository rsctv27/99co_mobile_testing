package com.mobile.testing.steps;

import com.mobile.testing.TestFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginSteps extends TestFactory {

    @Given("^user will be redirected to login page$")
    public void is_on_login_page() {
        pageFactory.loginPage().is_on_login_page();
    }

    @And("^user input email with \"([^\"]*)\"$")
    public void input_email(String email) {
        pageFactory.loginPage().input_email(email);
    }

    @And("^user input password with \"([^\"]*)\"$")
    public void input_password(String password) {
        pageFactory.loginPage().input_password(password);
    }

    @Then("^user click login button$")
    public void click_login_button() {
        pageFactory.loginPage().click_login_button();
    }

    @Then("^user should see error message input email$")
    public void error_message_input_email() {
        pageFactory.loginPage().error_message_input_email();
    }

    @Then("^user should see error message input password$")
    public void error_message_input_password() {
        pageFactory.loginPage().error_message_input_password();
    }

    @Then("^user should see success dialog pop up$")
    public void success_dialog_pop_up() {
        pageFactory.loginPage().success_dialog_pop_up();
    }

}
