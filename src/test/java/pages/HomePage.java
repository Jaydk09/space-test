package pages;

import base.TestBase;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;


public class HomePage extends TestBase {

    private final SelenideElement launchList = $("ul.launch-list");
    private final SelenideElement appFilters = $("div.app__filters");
    private final SelenideElement filterByYearDropdown = $("select.select[name=\"Filter By Year\"]");
    private final SelenideElement sortFilterBtn = $("button.button.button--sort");
    protected List<SelenideElement> launchItemList = (List<SelenideElement>) $$("li.launch-item");
    protected List<SelenideElement> rocketLaunchNumbersList = (List<SelenideElement>) $$("span.launch-item__number");
    protected List<SelenideElement> rocketLaunchLabelList = (List<SelenideElement>) $$("span.launch-item__label");
    protected List<SelenideElement> rocketLaunchDateList = (List<SelenideElement>) $$("span.launch-item__date");
    protected List<SelenideElement> rocketLaunchNameList = (List<SelenideElement>) $$("span.launch-item__rocket");

    //  Opens URL set as base page in TestBase
    protected void openHomePage() {
        open("");
    }

    protected void assertPageTitle() {
        Allure.addAttachment("Page Title : ", Objects.requireNonNull(title()));
        assertThat(title()).isEqualToIgnoringCase("React App");
    }

    protected void assertAppFiltersDisplayed() {
        appFilters.isEnabled();
    }

    protected void homePageIsInitialized() {
        assertPageTitle();
        assertAppFiltersDisplayed();
    }

    protected void assertLaunchListIsDisplayed() {
        launchList.should(appear);
    }

    protected void getTotalLaunchesListed() {
        Allure.addAttachment("Total launches listed : ", String.valueOf(launchItemList.size()));
        System.out.println("Total launches listed : " + launchItemList.size());
    }

    protected void assertFilterByYearDropdownEnabled() {
        filterByYearDropdown.isEnabled();
    }

    protected void assertFilterByYearDropdownIsSetToDefault() {
        assertFilterByYearDropdownEnabled();
        assertThat(filterByYearDropdown.getSelectedText()).isEqualTo("Filter By Year");
    }

    protected void assertSortFilterButtonEnabled() {
        sortFilterBtn.isEnabled();
    }

    protected void setDisplayFilterToDescending() {
        assertSortFilterButtonEnabled();
        if (sortFilterBtn.getText().equalsIgnoreCase("Sort Ascending")) {
            sortFilterBtn.click();
        }
    }

    protected void assertResultsDisplayedAreForYear(String yearSet) {
        for (WebElement launchDate : rocketLaunchDateList) {
            String[] yearDisplayed = launchDate.getText().split(" ");
            Allure.addAttachment("Launch Date : ", launchDate.getText());
            System.out.println("Date DISPLAYED : " + launchDate.getText());
            assertThat(yearDisplayed[2]).isEqualTo(yearSet);
        }
    }

    protected void selectYearFromFilter(String year) {
        assertFilterByYearDropdownEnabled();
        filterByYearDropdown.selectOptionByValue(year);
        Allure.addAttachment("YEAR SELECTED : ", filterByYearDropdown.getSelectedText());
    }

    protected void assertResultsDisplayedInAlphabeticalOrder() {
        ArrayList<String> labels = new ArrayList<>();
        for (SelenideElement rocketLaunchLabel : rocketLaunchLabelList) {
            labels.add(rocketLaunchLabel.getText());
        }
        Allure.addAttachment("Actual Order : ", String.valueOf(labels));
        System.out.println("LABELS LISTED IN FOLLOWING ORDER : \n" + labels);
        List<String> expectedOrderList = new ArrayList<>(labels);
        Collections.sort(expectedOrderList);
        Collections.reverse(expectedOrderList);
        Allure.addAttachment("Expected Order : ", String.valueOf(expectedOrderList));
        System.out.println("\n Expected Order List in DESCENDING : \n" + expectedOrderList);

        assertThat(labels).containsSequence(expectedOrderList);

    }
    //    protected void getRocketLaunchNumbersListCount() {
//        Allure.addAttachment("TOTAL ROCKET LAUNCHES :", String.valueOf(rocketLaunchNumbersList.size()));
//        System.out.println(rocketLaunchNumbersList.size());
//
//    }
//
//    protected int getRocketLaunchLabelListCount() {
//        Allure.addAttachment("TOTAL ROCKET LAUNCHES :", String.valueOf(rocketLaunchLabelList.size()));
//        return rocketLaunchLabelList.size();
//    }
//
//    protected int getRocketLaunchDateListCount() {
//        Allure.addAttachment("TOTAL ROCKET LAUNCHES :", String.valueOf(rocketLaunchDateList.size()));
//        return rocketLaunchDateList.size();
//    }
//
//    protected int getRocketLaunchNameListCount() {
//        Allure.addAttachment("TOTAL ROCKET LAUNCHES :", String.valueOf(rocketLaunchNameList.size()));
//        return rocketLaunchNameList.size();
//    }

    //    protected void getAllRocketNumbersList() {
//        for (SelenideElement eachElement : rocketLaunchNumbersList) {
//            Allure.addAttachment("ROCKET NUMBER :", eachElement.getText());
//            System.out.println(eachElement.getText());
//        }
//    }
//    protected String getRocketLaunchNumbersList() {
//        String rocketLaunchNo = "";
//        for (SelenideElement rocketLaunchNumber : rocketLaunchNumbersList) {
//            rocketLaunchNo = rocketLaunchNumber.getText();
//        }
//        System.out.println("ROCKET LAUNCH NUMBER : " + rocketLaunchNo);
//        return rocketLaunchNo;
//    }


}
