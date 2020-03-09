$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/main/java/anandraina/FlipkartAutomation/featurefile/OrderLifeCycle_Feature.feature");
formatter.feature({
  "name": "Order Life Cycle for Flipkart",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "User adding an item to cart",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "User opens the website",
  "keyword": "Given "
});
formatter.match({
  "location": "OrderLifeCycle_StepDefinition.User_opens_the_website()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User logs in to their account",
  "keyword": "When "
});
formatter.match({
  "location": "OrderLifeCycle_StepDefinition.User_logs_in_to_their_account()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User searches for product",
  "keyword": "Then "
});
formatter.match({
  "location": "OrderLifeCycle_StepDefinition.User_searches_for_product()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Add an item to cart",
  "keyword": "Then "
});
formatter.match({
  "location": "OrderLifeCycle_StepDefinition.Add_an_item_to_cart()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Take screenshot of product in cart",
  "keyword": "Then "
});
formatter.match({
  "location": "OrderLifeCycle_StepDefinition.Take_screenshot_of_product_in_cart()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Remove the item from cart",
  "keyword": "Then "
});
formatter.match({
  "location": "OrderLifeCycle_StepDefinition.Remove_the_item_from_cart()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Logout from the account",
  "keyword": "Then "
});
formatter.match({
  "location": "OrderLifeCycle_StepDefinition.Logout_from_the_account()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Close the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "OrderLifeCycle_StepDefinition.Close_the_browser()"
});
formatter.result({
  "status": "passed"
});
});