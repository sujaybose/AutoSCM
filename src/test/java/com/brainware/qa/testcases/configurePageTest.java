/*
 * @author Sujay Kumar Bose
 * 
 */

package com.brainware.qa.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.brainware.qa.base.TestBase;
import com.brainware.qa.pages.AmountSettings;
import com.brainware.qa.pages.ConfigurePage;
import com.brainware.qa.pages.LoginPage;
import com.brainware.qa.pages.ProcessingSettings;
import com.brainware.qa.util.TestUtil;

public class configurePageTest extends TestBase {

	LoginPage loginPage;
	// HomePage homePage;
	TestUtil testUtil;
	ConfigurePage configurePage;
	//AmountSettings amountSettings;

	String sheetName = "contacts";

	/*
	 * public configurePageTest(){ super();
	 * 
	 * }
	 */

	@BeforeTest
	public void setUp() throws InterruptedException {

		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		configurePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		// driver.wait(6000);
	}

	@Test(priority = 1)
	public void verifyconfigurePageLabel() {
		Assert.assertTrue(configurePage.verifyConfigureLabel(), "contacts label is missing on the page");
	}

	@Test(priority = 2)
	public void loginPageTitleTest() throws InterruptedException {
		String title = configurePage.verifyConfigurePageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Configure Project");
	}

	@Test(priority = 3)
	public void selectSettingsDropDown() throws InterruptedException {
		// configurePage.wait(3000);
		configurePage.selectProfileDropdown(prop.getProperty("project"), prop.getProperty("settings"), prop.getProperty("profile"));

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
