package com.e2etests.automation.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Setup {

	private static WebDriver driver;

	public static Logger LOGGER = LogManager.getLogger(Setup.class.getName());

	/**
	 * This method is used to open browser. This method is called before the
	 * invocation of each test method in the given class. In this method we need to
	 * pass browser name which will invoke the respective driver.
	 *
	 * @throws MalformedURLException the malformed URL exception
	 * @Before Methods annotated with @Before will execute before every scenario.
	 */

	@Before
	public void setDriver(Scenario scenario) {
        LOGGER.info("  Scenario : "+scenario.getName()+" started");
		String browser = System.getProperty("browser");

		if (browser == null) {
			browser = "chrome";
		}
		switch (browser) {

		case "chrome":
			ChromeOptions chromeOptions = new ChromeOptions();
			driver = new ChromeDriver(chromeOptions);
			driver.manage().window().maximize();
			break;

		case "firefox":
			FirefoxProfile profile = new FirefoxProfile();
			FirefoxOptions fireFoxOptions = new FirefoxOptions();
			fireFoxOptions.setCapability("platform", Platform.WIN10);
			fireFoxOptions.setProfile(profile);
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;

		default:
			throw new IllegalArgumentException("browser\"" + browser + "\" is not supported");
		}

	}

	/* GETTER */
	public static WebDriver getDriver() {
		return driver;
	}

}
