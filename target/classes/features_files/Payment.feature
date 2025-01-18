
Feature: Payment
  As a User, i want to connect to my account and add multiple product to my cart in order to buy them 
@Payment
Scenario Outline: I want to login to my account and add multiple products to the cart in order to buy 
    Given I connect to the swagLabs application
    When I enter a valid data for the username field "standard_user"
    And I enter a valid data for the password field "secret_sauce"
    And I click on the Login button
    And I head toward the inventory page "Products"
    And I add the following products to the cart:
      | add-to-cart-sauce-labs-backpack     |
      | add-to-cart-sauce-labs-bike-light   |
      | add-to-cart-sauce-labs-bolt-t-shirt |
    And I click on the cart icon
    And I head toward the cart page "Your Cart"
    And I check if the products are added correctly:
      | Sauce Labs Backpack     |
      | Sauce Labs Bike Light   |
      | Sauce Labs Bolt T-Shirt |
    And I click on the checkout button
    And I head toward the checkout page "Checkout:"
    And I enter a valid data in the firstname field "ronaldo"
    And I enter a valid data in the lastname field "cristiano"
    And I enter a valid data in the zip field "2050"
    And I click on the continue button 
    And I head toward the checkout overview page "Checkout: Overview"
    And I click on the finish button
    Then I head toward the completed checkout page "Thank you for your order!"

    Examples: 
      | productbutton                   | productname         |
      | add-to-cart-sauce-labs-backpack | Sauce Labs Backpack |
