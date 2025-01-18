package com.e2etests.automation.utils;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;

/**
 * Class Wait.
 */
public class Wait extends BasePage {

	/** driver. */
	private WebDriver driver;

	/**
	 * Instanciation de wait.
	 */
	public Wait() {
		// this.driver = driver;

		this.driver = Setup.getDriver();
	}

	/**
	 * methode Wait until condition.
	 *
	 * @param condition
	 * @param timeoutMessage
	 * @param timeout
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void waitUntilCondition(ExpectedCondition condition, String timeoutMessage, Duration timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.withMessage(timeoutMessage);
		wait.until(condition);
	}

	/**
	 * methode For loading.
	 *
	 * @param timeout
	 */
	public void forLoading(Duration timeout) {

		ExpectedCondition<Object> condition = ExpectedConditions
				.jsReturnsValue("return document.readyState==\"complete\";");
		String timeoutMessage = "Page didn't load after " + timeout + " seconds.";

		waitUntilCondition(condition, timeoutMessage, timeout);
		

	}

	/**
	 * methode For element to be displayed.
	 *
	 * @param timeout
	 * @param webElement
	 * @param webElementName
	 */
	public void forElementToBeDisplayed(Duration timeout, WebElement webElement, String webElementName) {
		ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOf(webElement);
		String timeoutMessage = webElementName + " wasn't displayed after " + timeout + " seconds.";
		waitUntilCondition(condition, timeoutMessage, timeout);
	}

	/**
	 * methode For presence of elements.
	 *
	 * @param timeout
	 * @param elementLocator
	 * @param elementName
	 */
	public void forPresenceOfElements(Duration timeout, By elementLocator, String elementName) {
		ExpectedCondition<List<WebElement>> condition = ExpectedConditions
				.presenceOfAllElementsLocatedBy(elementLocator);
		String timeoutMessage = elementName + " elements were not displayed after " + timeout + " seconds.";
		waitUntilCondition(condition, timeoutMessage, timeout);
	}

	public void forPresenceOfElement(Duration timeout, WebElement element, String elementName) {
		ExpectedCondition<List<WebElement>> condition = ExpectedConditions.visibilityOfAllElements(element);
		String timeoutMessage = elementName + " elements were not displayed after " + timeout + " seconds.";
		waitUntilCondition(condition, timeoutMessage, timeout);
	}

	/**
	 * methode Wait until clickable.
	 *
	 * @param driver
	 * @param by
	 * @return web element
	 */
	public static WebElement waitUntilClickable(WebDriver driver, By by) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.elementToBeClickable(by));
	}

}
