@Amazon
Feature: Test Amazon search functionality

  @Cart
  Scenario Outline: As a customer when i search a product, I want to see if third position on second page is avaliable for purchase and can added to the card
    Given user navigate to Amazon Webpage
    And search <product>
    And navigate to second page
    And select the third item
    Then user is able to add it to the cart

    Examples:
    |product    |
    |playstation|
    |xbox       |
