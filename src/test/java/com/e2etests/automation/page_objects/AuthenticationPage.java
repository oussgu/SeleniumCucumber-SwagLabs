package com.e2etests.automation.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.SeleniumUtils;
import com.e2etests.automation.utils.Setup;


public class AuthenticationPage {

	private ConfigFileReader configFileReader;

	private SeleniumUtils utils;
	
	// @FindBy

	@FindBy(how = How.XPATH, using = "//input[@id='user-name']")
	private WebElement userNameInput;

	@FindBy(how = How.ID, using = "password")
	private WebElement passwordInput;

	@FindBy(how = How.ID, using = "login-button")
	private WebElement loginButton;

	@FindBy(how = How.CLASS_NAME, using = "title")
	private WebElement successLoginMessage;

	@FindBy(how = How.XPATH, using = "//div[@class='error-message-container error']")
	private WebElement errorLoginMessage;

	@FindBy(how = How.ID, using = "react-burger-menu-btn")
	private WebElement menuIcon;

	@FindBy(how = How.ID, using = "logout_sidebar_link")
	private WebElement logoutButton;

	@FindBy(how = How.XPATH, using = "//h4[normalize-space()='Accepted usernames are:']")
	private WebElement successLogoutMessage;

	// contructor

	public AuthenticationPage() {
		PageFactory.initElements(Setup.getDriver(), this);
		this.configFileReader = new ConfigFileReader();

		this.utils = new SeleniumUtils();
		
	}

	// getters

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getMenuIcon() {
		return menuIcon;
	}

	public WebElement getLogoutButton() {
		return logoutButton;
	}

	public WebElement getUserNameInput() {
		return userNameInput;
	}

	public WebElement getPasswordInput() {
		return passwordInput;
	}

	public WebElement getSuccessLoginMessage() {
		return successLoginMessage;
	}

	public WebElement getErrorLoginMessage() {
		return errorLoginMessage;
	}

	public WebElement getSuccessLogoutMessage() {
		return successLogoutMessage;
	}

	// Methods

	public void goToURL() {
		Setup.getDriver().get(configFileReader.getProperties("home.url"));
	}

	public void fillInput(WebElement field, String data) {

		utils.writeText(field, data);
	}

	public void click(WebElement btn) {
		utils.waitForElementToBeClickable(btn);
		btn.click();

	}

	public void verificationMessage(WebElement message, String text) {

		utils.assertEquals(message, text);

	}

}