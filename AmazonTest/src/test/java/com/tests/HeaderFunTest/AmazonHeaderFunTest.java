package com.tests.HeaderFunTest;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.LoginFun;
import com.pages.headerfunpages.AmazonHeaderFun;

public class AmazonHeaderFunTest extends BaseClass {

	public static LoginFun lp = null;
	public static AmazonHeaderFun ah=null;

	@BeforeSuite
	public void setup() throws IOException {
		initialization();
		reportInit();

		implicitWait(10);
		lp = new LoginFun(driver);
		ah = new AmazonHeaderFun(driver);

		lp.loginBySite();

	}
	
	@AfterSuite
	public void tearDown() throws InterruptedException {
		
		reports.flush();
		
		Thread.sleep(5000);
		
		driver.close();
	}
	
	@Test
	public void amazonMiniFunTest() {
		
		ah.amazonMini();
		
	}
	
	
	@Test(dependsOnMethods ="amazonMiniFunTest")
	public void sellFunTest() throws IOException {
	    homePage();
		ah.sellFun();
		
	}
	
	@Test(dependsOnMethods ="sellFunTest")
	public void bestSellerFunTest() throws IOException {
		homePage();
		ah.bestSellerFun();
		
	}
	
	@Test(dependsOnMethods ="bestSellerFunTest")
	public void giftCardsFunTest() throws IOException {
		homePage();
		ah.giftcardsFun();
	}
	
	@Test(dependsOnMethods ="giftCardsFunTest")
	public void browingHistoryFunTest() throws Exception {
		homePage();
		ah.browingHistoryFun();
		
	}
	
	@Test(dependsOnMethods ="browingHistoryFunTest")
	public void groceryGourmetFoodsFunTest() throws IOException {
		
		homePage();
		ah.groceryGourmetFoodsFun();
	}
	
	@Test(dependsOnMethods ="groceryGourmetFoodsFunTest")
	public void amazonpayFunTest() throws IOException {
		
		homePage();
		ah.amazonpayFun();
	}
	
	
	

}
