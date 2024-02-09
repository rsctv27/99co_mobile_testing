package com.mobile.testing.steps;

import com.mobile.testing.TestFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;

public class Hooks {

    @Before(order=0)
    public static void setup() {
        new TestFactory().setup();
        new TestFactory().startRecording();
    }

    @AfterStep(order=0)
    public void AfterStep(Scenario scenario) {
       new TestFactory().takeScreenshoot(scenario);
    }

    @After(order=1)
    public static void shutdown(Scenario scenario) throws IOException {
        new TestFactory().endRecording(scenario);
        new TestFactory().shutdown();
    }
}
