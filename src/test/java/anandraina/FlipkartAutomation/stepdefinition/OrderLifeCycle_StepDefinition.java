package anandraina.FlipkartAutomation.stepdefinition;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import anandraina.FlipkartAutomation.constants.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrderLifeCycle_StepDefinition {
	WebDriver chromedriver;

	@Given("^User opens the website$")
	public void User_opens_the_website() {
		System.setProperty("webdriver.chrome.driver", "./BrowserDrivers/chromedriver.exe");
		chromedriver = new ChromeDriver();
		chromedriver.manage().window().maximize();
		chromedriver.get(Constants.Resources.URL);
	}

	@When("^User logs in to their account$")
	public void User_logs_in_to_their_account() throws InterruptedException {
		chromedriver.findElement(By.cssSelector(Constants.ElementFactory.EMAIL_TEXTFIELD))
				.sendKeys(Constants.Resources.EMAIL);
		chromedriver.findElement(By.xpath(Constants.ElementFactory.PASSWORD_PASSWORDFIELD))
				.sendKeys(Constants.Resources.PASSWORD);
		chromedriver.findElement(By.cssSelector(Constants.ElementFactory.LOGIN_BUTTON)).click();
		Thread.sleep(4000);
	}

	@Then("^User searches for product$")
	public void User_searches_for_product() throws InterruptedException {
		chromedriver.findElement(By.xpath(Constants.ElementFactory.SEARCHBOX_TEXTFIELD))
				.sendKeys(Constants.Resources.PRODUCT_NAME);
		Thread.sleep(2000);
		chromedriver.findElement(By.xpath(Constants.ElementFactory.PRODUCT_LISTITEM)).click();
	}

	@Then("^Add an item to cart$")
	public void Add_an_item_to_cart() throws InterruptedException {
		Thread.sleep(3000);
		chromedriver.findElement(By.cssSelector(Constants.ElementFactory.PRODUCTNAME_LINKTEXT)).click();
		Thread.sleep(1000);
		Set<String> handles = chromedriver.getWindowHandles();
		String currentHandle = chromedriver.getWindowHandle();
		for (String handle : handles) {
			if (!handle.equals(currentHandle)) {
				chromedriver.switchTo().window(handle);
			}
		}
		chromedriver.findElement(By.cssSelector(Constants.ElementFactory.ADDTOCART_BUTTON)).click();
	}

	@Then("^Take screenshot of product in cart$")
	public void Take_screenshot_of_product_in_cart() throws IOException, InterruptedException {
		Thread.sleep(2000);
		TakesScreenshot screenshot = ((TakesScreenshot) chromedriver);
		File screenshot_file = screenshot.getScreenshotAs(OutputType.FILE);
		File destination = new File("./Screenshots/screenshot.jpg");
		FileUtils.copyFile(screenshot_file, destination);
	}

	@Then("^Remove the item from cart$")
	public void Remove_the_item_from_cart() throws InterruptedException {
		Thread.sleep(2000);
		chromedriver.findElement(By.xpath(Constants.ElementFactory.REMOVE_LINKTEXT)).click();
		Thread.sleep(1000);
		chromedriver.findElement(By.cssSelector(Constants.ElementFactory.REMOVE_BUTTON)).click();
		Thread.sleep(1000);
	}

	@Then("^Logout from the account$")
	public void Logout_from_the_account() throws InterruptedException {
		Actions actions = new Actions(chromedriver);
		actions.moveToElement(
				chromedriver.findElement(By.cssSelector(Constants.ElementFactory.PROFILESECTION_DROPDOWN))).perform();
		Thread.sleep(1000);
		actions.click(chromedriver.findElement(By.xpath(Constants.ElementFactory.LOGOUT_LISTITEM))).perform();
	}

	@Then("^Close the browser$")
	public void Close_the_browser() throws InterruptedException {
		Thread.sleep(5000);
		chromedriver.quit();
	}
}