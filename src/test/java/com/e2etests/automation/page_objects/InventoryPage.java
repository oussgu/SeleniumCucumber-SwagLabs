package com.e2etests.automation.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.e2etests.automation.utils.SeleniumUtils;
import com.e2etests.automation.utils.Setup;

public class InventoryPage {

	private SeleniumUtils utils;

	// Locators /
	@FindBy(how = How.CLASS_NAME, using = "inventory_item_name")
	private WebElement inventoryName;

	@FindBy(how = How.CLASS_NAME, using = "shopping_cart_link")
	private WebElement cartIcon;

	@FindBy(how = How.XPATH, using = "//span[@class='title']")
	private WebElement cartPageCheck;

	@FindBy(how = How.CLASS_NAME, using = "inventory_item_name")
	private WebElement cartproductName;

	public InventoryPage() {
		PageFactory.initElements(Setup.getDriver(), this);
		this.utils = new SeleniumUtils();
	}

	// Getter
	public WebElement getInventoryName() {
		return inventoryName;
	}

	public WebElement getCartIcon() {
		return cartIcon;
	}

	public WebElement getCartPageCheck() {
		return cartPageCheck;
	}

	public WebElement getCartproductName() {
		return cartproductName;
	}

	// Methods /

	public void fillInput(WebElement field, String data) {

		utils.writeText(field, data);
	}

	public void click(WebElement btn) {
		utils.waitForElementToBeClickable(btn);
		btn.click();

	}
	
	public void click(String idProduct) {
		WebElement product = Setup.getDriver().findElement(By.id(idProduct));

		utils.waitForElementToBeClickable(product);
		product.click();

	}

	public void verificationMessage(WebElement message, String text) {

		utils.assertEquals(message, text);

	}

	public boolean isDisplayed() {

		try {

			boolean res = cartproductName.isDisplayed();
			return res;
		} catch (NoSuchElementException e) {
			System.out.println("Element is deleted");
			return false;
		}

	}

}