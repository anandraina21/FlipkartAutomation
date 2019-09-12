Feature: Order Life Cycle for Flipkart 

Scenario: User adding an item to cart 

	Given User opens the website
	When User logs in to their account 
	Then User searches for product
	Then Add an item to cart
	Then Take screenshot of product in cart
	Then Remove the item from cart
	Then Logout from the account 
	Then Close the browser