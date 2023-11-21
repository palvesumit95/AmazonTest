package com.tests;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.LocationChange;
import com.pages.LoginFun;

public class LocationChangeTest extends BaseClass {

	public static LoginFun lp = null;
	public static LocationChange lc = null;


	@BeforeSuite
	public void setup() throws IOException
	{
		initialization();
		reportInit();
		lp = new LoginFun(driver);
		lc = new LocationChange(driver);

		lp.loginBySite();
		implicitWait(10);

	}


	@AfterSuite
	public void tearDown()
	{
		reports.flush();
		driver.close();

	}

	@Test
	public void locationChangeTest()
	{

		lc.selectAddress();
		log.info("Address Select Sucesfully");

	}

}
