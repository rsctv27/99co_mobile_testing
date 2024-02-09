package com.mobile.testing.steps;

import com.mobile.testing.TestFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class HomeSteps extends TestFactory {

    @Given("^user is on home page$")
    public void is_on_home_page() {
        pageFactory.homePage().is_on_home_page();
    }

    @When("^user click home bottom bar$")
    public void click_home_bottom_bar() {
        pageFactory.homePage().click_home_bottom_bar();
    }

    @When("^user click login bottom bar$")
    public void click_login_bottom_bar() {
        pageFactory.homePage().click_login_bottom_bar();
    }

}
