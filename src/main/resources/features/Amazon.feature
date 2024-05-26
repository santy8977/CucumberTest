Feature: Amazon Search
  As a user
  I want to search for products on Amazon
  So that I can find items I want to purchase

  Scenario: Search for a product
    Given I am on the Amazon homepage
    When I search for "laptop"
    Then I should see search results for "laptop"

  Scenario: Search for an invalid product
    Given I am on the Amazon homepage
    When I search for "xyz123"
    Then I should see a message indicating no search results found
