package base;

import com.codeborne.selenide.Configuration;

public class TestBase {

    public void selenideConfig() {
        Configuration.pageLoadTimeout = 10000;
        Configuration.pollingInterval = 100;
        Configuration.timeout = 10000;
        Configuration.headless = false;
        Configuration.fastSetValue = true;
        Configuration.webdriverLogsEnabled = true;
        Configuration.screenshots = true;
//        Configuration.browser = "edge";  // chrome is default
        Configuration.browserSize = "1980x1000";
        Configuration.driverManagerEnabled = true;
        Configuration.browserCapabilities.setCapability("networkConnectionEnabled", true);
        Configuration.baseUrl = "https://fe-automation-tool.s3.eu-west-1.amazonaws.com/index.html";
    }


}
