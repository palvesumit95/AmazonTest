package com.tests;

import java.io.IOException;

import org.openqa.selenium.remote.ProtocolHandshake.Result;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.LoginFun;
import com.utilities.PropertiesUtils;

public class LoginFunTest extends BaseClass {

	LoginFun lp = null;

	@BeforeSuite
	public void setup() throws IOException {
		initialization();
		reportInit();
		lp = new LoginFun(driver);

	}

	@AfterSuite
	public void tearDown() {
		reports.flush();
		driver.close();

	}

	@Test
	public void loginTestWithValidData() throws IOException {

		lp.loginWithValidCredential();


	}

	@Test(dependsOnMethods = "loginTestWithValidData")
	public void loginTestWithInvalidUsername() throws IOException  {

		lp.loginWithInvalidpPassword();
		implicitWait(30);

	}




}
