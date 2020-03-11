package anandraina.FlipkartAutomation.stepdefinition;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import anandraina.FlipkartAutomation.constants.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class OrderLifeCycleStepDefinition {
	WebDriver chromedriver;
	WebDriverWait wait;
	WebElement email;
	WebElement passwd;
	WebElement login;
	WebElement searchbox;
	WebElement productList;
	WebElement productName;
	WebElement addToCart;
	WebElement removeLinkText;
	WebElement removeButton;
	WebElement profileDropdown;
	WebElement logout;
	Boolean waitForText;
	
	@Given("^User opens the website$")
	public void userOpensTheWebsite() {
		System.setProperty("webdriver.chrome.driver", "./BrowserDrivers/chromedriver.exe");
		chromedriver = new ChromeDriver();
		chromedriver.manage().window().maximize();
		chromedriver.get(Constants.Resources.URL);
		wait = new WebDriverWait(chromedriver, 30);
	}

	@When("^User logs in to their account$")
	public void userLogsInToTheirAccount() throws InterruptedException {
		email = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector(Constants.ElementFactory.EMAIL_TEXTFIELD)));
		email.sendKeys(Constants.Resources.EMAIL);
		passwd = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(Constants.ElementFactory.PASSWORD_PASSWORDFIELD)));
		passwd.sendKeys(Constants.Resources.PASSWORD);
		login = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Constants.ElementFactory.LOGIN_BUTTON)));
		login.click();
	}

	@Then("^User searches for product$")
	public void userSearchesForProduct() throws InterruptedException {
		Thread.sleep(1000);
		searchbox = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(Constants.ElementFactory.SEARCHBOX_TEXTFIELD)));
		searchbox.sendKeys(Constants.Resources.PRODUCT_NAME);
		productList = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(Constants.ElementFactory.PRODUCT_LISTITEM)));
		productList.click();
	}

	@Then("^Add an item to cart$")
	public void addAnItemToCart() throws InterruptedException {
		productName = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector(Constants.ElementFactory.PRODUCTNAME_LINKTEXT)));
		productName.click();
		Thread.sleep(1000);
		Set<String> handles = chromedriver.getWindowHandles();
		String currentHandle = chromedriver.getWindowHandle();
		for (String handle : handles) {
			if (!handle.equals(currentHandle)) {
				chromedriver.switchTo().window(handle);
			}
		}
		addToCart = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector(Constants.ElementFactory.ADDTOCART_BUTTON)));
		addToCart.click();
	}

	@Then("^Take screenshot of product in cart$")
	public void takeScreenshotOfProductInCart() throws IOException, InterruptedException {
		waitForText = wait.until(ExpectedConditions
				.textToBePresentInElementLocated(By.cssSelector(Constants.ElementFactory.MYCART_ID), "My Cart"));
		/*
		 * Use following import statement to avoid deprecated method :
		 * "import org.junit.Assert;"
		 */
		// Assert used here to check whether page contents have been loaded
		Assert.assertEquals(true, waitForText);
		TakesScreenshot screenshot = ((TakesScreenshot) chromedriver);
		File screenshot_file = screenshot.getScreenshotAs(OutputType.FILE);
		File destination = new File("./Screenshots/screenshot.jpg");
		FileUtils.copyFile(screenshot_file, destination);
	}

	@Then("^Remove the item from cart$")
	public void removeTheItemFromCart() throws InterruptedException {
		removeLinkText = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(Constants.ElementFactory.REMOVE_LINKTEXT)));
		removeLinkText.click();
		removeButton = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Constants.ElementFactory.REMOVE_BUTTON)));
		removeButton.click();
	}

	@Then("^Logout from the account$")
	public void logoutFromTheAccount() throws InterruptedException {
		Thread.sleep(1000);
		profileDropdown = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector(Constants.ElementFactory.PROFILESECTION_DROPDOWN)));
		Actions actions = new Actions(chromedriver);
		actions.moveToElement(profileDropdown).perform();
		logout = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(Constants.ElementFactory.LOGOUT_LISTITEM)));
		actions.click(logout).perform();
	}

	@Then("^Close the browser$")
	public void closeTheBrowser() throws InterruptedException {
		Thread.sleep(5000);
		chromedriver.quit();
	}
}