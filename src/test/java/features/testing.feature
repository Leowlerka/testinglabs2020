Feature: Page Testing
  Scenario: Test Jetpacktravel Page
    Given User is on the Jetpacktravel page
    When Log in jet
    Then Test the first country
    And Close Firefox

   Scenario: Test MyShows Page
    Given User is on the MyShows page
    When Log in MyShows
    Then Test serials
    And Close Firefox

    Scenario: Test MyShowsProfile Page
    Given User is on the MyShowsProfile page
    When Test name
    Then Test reward
    And Close Firefox