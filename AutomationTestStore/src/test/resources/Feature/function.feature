Feature: feature1
Background: background
Given user is on the  homepage of the website automation
When user clicks on products link
And selects two products and add them to cart
Then user is able to see the products in cart
Scenario Outline:
Given user is on the  homepage of the website automation
When user searchs for a "<category>" in product page
Then user is able to add product in the cart of that category
Examples:
|category|
|Top|
|shirt|
 