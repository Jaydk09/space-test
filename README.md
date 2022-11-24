# SpaceX Automation Task

## Getting Started

**Opening this project**

This is a Maven project built using Selenide(Selenium Wrapper),Java and Cucumber in page object model design pattern.
There are a number of ways you can open this project, however the easiest way should be the following;

**Intellij Community Edition - [download](https://www.jetbrains.com/idea/download)**

*  Open Intellij
*  Click open project
*  Navigate to the POM.xml in the Space-test directory, select and click open
*  Click on Open as a project

## Executing tests

* Open "src/test/resources/features/spaceFilter.feature"
* Copy relevant Feature/Scenario tags 
* Open "src/test/java/RunCukesTest.java"
* Paste/update tag in "tags" value
* Open "Maven" tab and execute relevant maven goal ex:- "mvn clean verify"

## Generating and checking Allure test reports

* After executing the test as above
* Open "Maven" tab and execute maven goal :- "mvn allure:report"
* Logs should display Report generated successfully - BUILD SUCCESS.
* Right click on "target/allure-reports/index.html" and "Open in" > "Browser" of choice

## Changing browser

* Tests are executed by default in Chrome browser (Downloading and configuring drivers are not required)
* Browser can be changed in "src/test/java/base/TestBase.java" by updating "Configuration.browser" value to eg:- "edge"

## Screenshots

* Upon test failure due to element locators, a .png screenshot will be taken and placed in "build/reports/tests"
