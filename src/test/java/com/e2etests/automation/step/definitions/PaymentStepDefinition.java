package com.e2etests.automation.step.definitions;

import com.e2etests.automation.page_objects.PaymentPage;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaymentStepDefinition {

	private PaymentPage paymentPage;

	public PaymentStepDefinition() {
		this.paymentPage = new PaymentPage();

	}

	@When("I click on the checkout button")
	public void iClickOnTheCheckoutButton() {

		paymentPage.click(paymentPage.getCheckoutBtn());
	}

	@When("I head toward the checkout page {string}")
	public void iHeadTowardTheCheckoutPage(String checkoutM) {
		paymentPage.verificationMessage(paymentPage.getCheckoutPageMessage(), checkoutM);
	}

	@When("I enter a valid data in the firstname field {string}")
	public void iEnterAValidDataInTheFirstnameField(String firstN) {
		paymentPage.fillInput(paymentPage.getFirstNameInput(), firstN);
	}

	@When("I enter a valid data in the lastname field {string}")
	public void iEnterAValidDataInTheLastnameField(String lastN) {
		paymentPage.fillInput(paymentPage.getLastNameInput(), lastN);

	}

	@When("I enter a valid data in the zip field {string}")
	public void iEnterAValidDataInTheZipField(String zipCode) {
		paymentPage.fillInput(paymentPage.getZipCodeInput(), zipCode);
	}

	@When("I click on the continue button")
	public void iClickOnTheContinueButton() {

		paymentPage.click(paymentPage.getContinueBtn());

	}

	@When("I head toward the checkout overview page {string}")
	public void iHeadTowardTheCheckoutOverviewPage(String ovPageM) {

		paymentPage.verificationMessage(paymentPage.getOverviewPageMessage(), ovPageM);
	}

	@When("I click on the finish button")
	public void iClickOnTheFinishButton() {
		paymentPage.click(paymentPage.getFinishBtn());
	}

	@Then("I head toward the completed checkout page {string}")
	public void iHeadTowardTheCompletedCheckoutPage(String completedM) {

		paymentPage.verificationMessage(paymentPage.getOrderPassedMessage(), completedM);
	}

}
