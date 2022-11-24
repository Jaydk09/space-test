@spaceX_feature
Feature: SpaceX feature

  Background:
    Given User is on home page

  @validate_data_loaded
  Scenario: Data should load onto the page
    Given The Page loads
    Then A screen will appear with a list of SpaceX API results

  @validate_filter_by_year
  Scenario: Filter by year
    Given Selecting filter
    When Setting filter by the year to 2015
    Then Return a list of only launches in 2015

#  @validate_results_display_order
#  Scenario: Order should be done alphabetically
#    Given No year filter is on
#    When Ordering is done 'descending'
#    Then Items should be ordered alphabetically
#    And test the order