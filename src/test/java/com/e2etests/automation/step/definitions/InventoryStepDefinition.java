package com.e2etests.automation.step.definitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.e2etests.automation.page_objects.InventoryPage;

import com.e2etests.automation.utils.Setup;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InventoryStepDefinition {

	private InventoryPage inventoryPage;
	

	public InventoryStepDefinition() {
		this.inventoryPage = new InventoryPage();
		
	}

	@When("I click on the addToCart button {string}")
	public void iClickOnTheAddToCartButton(String productbtn) {
		inventoryPage.click(productbtn);
	}

	@When("I click on the cart icon")
	public void iClickOnTheCartIcon() {
		inventoryPage.click(inventoryPage.getCartIcon());

	}

	@When("I head toward the cart page {string}")
	public void iHeadTowardTheCartPage(String cartMsg) {
		inventoryPage.verificationMessage(inventoryPage.getCartPageCheck(), cartMsg);
	}

	@Then("I check if the product is added correctly {string}")
	public void iCheckIfTheProductIsAddedCorrectly(String productName) {
		inventoryPage.verificationMessage(inventoryPage.getCartproductName(), productName);
	}

	@When("I add the following products to the cart:")
	public void iAddTheFollowingProductsToTheCart(DataTable dataTable) {

		List<String> productButtons = dataTable.asList(String.class); // Convert the DataTable to a List<String>

		for (String button : productButtons) {

			inventoryPage.click(button);

		}

	}

	@Then("I check if the products are added correctly:")
	public void iCheckIfTheProductsAreAddedCorrectly(List<String> productNames) {

		List<WebElement> cartItems = Setup.getDriver().findElements(By.className("cart_item"));
		for (String productName : productNames) {
			boolean isPresent = cartItems.stream().anyMatch(item -> item.getText().contains(productName));
			Assert.assertTrue("Product not found in cart: " + productName, isPresent);
		}

	}

	@When("I click on delete button   {string}")
	public void iClickOnDeleteButton(String productDeleteId) {
		inventoryPage.click(productDeleteId);
	}

	@Then("I check if the product is not displayed")
	public void iCheckIfTheProductIsNotDisplayed() {

		inventoryPage.isDisplayed();

	}

}