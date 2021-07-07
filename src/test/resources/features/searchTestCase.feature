@searchFunctionality
Feature: Search functionality
  As a user of demoShopQA Website, I should be able to search for articles

  @searchArticle
  Scenario: Search for articles
    Given I am in the homepage
    When I click on the button Search
    Then An input text should be displayed with label "TYPE AND PRESS ENTER TO SEARCH" in order to search for my article
    When I enter "Dress" in the search text and hit the enter of the keyboard
    Then I should have 16 articles displayed

  @searchArticleWithDataSet
  Scenario Outline: Search for articles
    Given I am in the homepage
    When I click on the button Search
    Then An input text should be displayed with label "TYPE AND PRESS ENTER TO SEARCH" in order to search for my article
    When I enter <articleName> in the search text and hit the enter of the keyboard
    Then I should have <nbProducts> articles displayed

    Examples: 
      | articleName | nbProducts |
      | Dress       |         16 |
      | t-shirt     |          8 |
