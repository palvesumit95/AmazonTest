package com.tests;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.DigitalContentAndDevicesFun;
import com.pages.LoginFun;

public class DigitalContentAndDevicesFunTest extends BaseClass{

	public static LoginFun lp = null;
	public static DigitalContentAndDevicesFun df = null;

	@BeforeSuite
	public void setup() throws IOException {

		initialization();
		reportInit();

		lp = new LoginFun(driver);
		df = new DigitalContentAndDevicesFun(driver);
		lp.loginBySite();


	}

	@AfterSuite
	public void tearDown() {
		reports.flush();
		//driver.close();

	}

	@Test(dependsOnMethods = "echoAndAlexaFunTest")
	public void amazonMiniFunTest() throws Exception {
		lp.homePage();
		df.amazonMiniFun();
		
	}
	
	@Test
	public void echoAndAlexaFunTest() throws IOException {

		df.echoAndAlexaFun();
		
	}
	
	@Test
	public void checkAllFunTest()
	{
		
	df.checkAllFun();	
	}

}
