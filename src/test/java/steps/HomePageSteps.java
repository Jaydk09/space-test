package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;

public class HomePageSteps extends HomePage {

    @Given("User is on home page")
    public void user_is_on_home_page() {
        openHomePage();
    }

    @When("The Page loads")
    public void thePageLoads() {
        homePageIsInitialized();
    }

    @Then("A screen will appear with a list of SpaceX API results")
    public void aScreenWillAppearWithAListOfSpaceXAPIResults() {
        assertLaunchListIsDisplayed();
        getTotalLaunchesListed();
    }

    @Given("Selecting filter")
    public void selecting_filter() {
        assertFilterByYearDropdownEnabled();
    }

    @When("Setting filter by the year to {}")
    public void setting_filter_by_the_year_to(String year) {
        selectYearFromFilter(year);
    }

    @Then("Return a list of only launches in {}")
    public void return_a_list_of_only_launches_in(String yearSet) {
        getTotalLaunchesListed();
        assertResultsDisplayedAreForYear(yearSet);
    }

    @Given("No year filter is on")
    public void no_year_filter_is_on() {
        assertFilterByYearDropdownIsSetToDefault();
    }

    @When("Ordering is done 'descending'")
    public void ordering_is_done_descending() {
        setDisplayFilterToDescending();
    }

    @Then("Items should be ordered alphabetically")
    public void items_should_be_ordered_alphabetically() {
        assertResultsDisplayedInAlphabeticalOrder();
    }

    @And("test the order")
    public void testTheOrder() {
    }
}
