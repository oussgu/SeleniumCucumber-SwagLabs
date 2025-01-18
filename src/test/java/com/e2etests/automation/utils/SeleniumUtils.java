package com.e2etests.automation.utils;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains all the methods required by selenium to perform actions
 * on webelement. It is a repository so that same code need not to be written
 * again.
 */
public class SeleniumUtils extends BasePage {

	/** driver. */
	private WebDriver driver;

	/**
	 * Instanciation de common utils.
	 */
	public SeleniumUtils() {
		super();
		this.driver = Setup.getDriver();
	}

	// Generic Methods

	/**
	 * methode Wait for element to be clickable
	 *
	 * @param locator
	 */
	public void waitForElementToBeClickable(WebElement locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	/**
	 * method to clear field.
	 *
	 * @param element
	 */
	public void clearField(WebElement element) {
		try {
			element.clear();
		} catch (Exception e) {
			log.info(String.format("The following element could not be cleared: [%s]", element.getText()));
		}
	}

	/**
	 * methode write text.
	 *
	 * @param elementAttr
	 * @param text
	 */
	public void writeText(WebElement elementAttr, String text) {
		if (elementAttr.getClass().getName().contains("By")) {
			clearField(elementAttr);
			driver.findElement((By) elementAttr).sendKeys(text);
		} else {
			clearField(elementAttr);
			elementAttr.sendKeys(text);
		}
	}

	// Validation Method

	public void assertEquals(WebElement element, String text) {
		String text1 = element.getText();
		Assert.assertEquals(text1, text);

	}

	// Class Common Methods

	public void fillInput(WebElement field, String data) {

		writeText(field, data);
	}

	public void click(WebElement btn) {
		waitForElementToBeClickable(btn);
		btn.click();

	}

	public void click(String idProduct) {
		WebElement product = Setup.getDriver().findElement(By.id(idProduct));

		waitForElementToBeClickable(product);
		product.click();

	}

	public void verificationMessage(WebElement message, String text) {

		assertEquals(message, text);

	}

}
