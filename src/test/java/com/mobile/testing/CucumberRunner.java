package com.mobile.testing;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-report.html", "json:target/cucumber-report.json"},
        features = "src/test/resources/",
        glue = {"com.mobile.testing"}
)
public class CucumberRunner { }

