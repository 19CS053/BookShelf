Feature: BookShelf Page Scenarios

  Scenario: Search BookShelves and Display the Results
    Given Filter  Bookshelves below Rs15000
    And exclude out of stock
    And Select storage type open
    And Sort by price High to Low
    And fetched the items
    When print all details in console output
    Then retrieve any one SubMenu data from living menu
