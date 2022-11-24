package hooks;

import base.TestBase;
import com.codeborne.selenide.Configuration;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook extends TestBase {
    String scenarioName = null;

    @Before
    public void before(io.cucumber.java.Scenario scenario) {
        selenideConfig();
        scenarioName = scenario.getName();
        System.out.println("\n <------------------ Scenario start : " + scenarioName + " --------->");
    }

    @After
    public void after() {
//        Configuration.holdBrowserOpen = true;
        System.out.println("\n <------------------ Scenario End --------------------------------->");
    }
}
