package com.tests;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.AddProductToCart;
import com.pages.LoginFun;

public class AddProductToCartTest extends BaseClass {

	public static LoginFun lp = null;
	public static AddProductToCart ap = null; 


	@BeforeSuite
	public void setup() throws IOException {

		initialization();
		reportInit();
		lp = new LoginFun(driver);
		ap = new AddProductToCart(driver);
		
		lp.loginWithValidCredential();
		implicitWait(10);

	}

	@AfterSuite
	public void tearDown() {

		reports.flush();
		//		driver.close();


	}


	@Test
	public void addProductTest() throws IOException {

		ap.addProduct();

		log.info("Product Added Sucesfully in Cart");

	}

	@Test(dependsOnMethods = "addProductTest")
	public void changeStorageTest() throws IOException {

		ap.changeStorage();
		log.info("Storage Change Sucesfully");

	}
	
	@Test(dependsOnMethods = "changeStorageTest")
	public void changeColourTest() throws IOException {
		
		ap.changeColour();
		log.info("Colour Change to Purple Sucesfully");
		
		
	}
	
	@Test(dependsOnMethods = "changeColourTest")
	public void seeMoreProductDetailFunTest() throws IOException {
		
		ap.seeMoreProductdetail();
		log.info("see more product deatil fun is working....");
		
	}


}
