package com.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.LoginFun;
import com.pages.SearchFun;

public class SearchFunTest extends BaseClass {

	public static SearchFun sfun = null;
	public static LoginFun login = null;

	@BeforeSuite
	public void setup() throws IOException {

		initialization();
		reportInit();
		login = new LoginFun(driver);
		sfun = new SearchFun(driver);
		login.loginWithValidCredential();

	}

	@AfterSuite
	public void tearDown() {
		reports.flush();
		driver.close();

	}

	@Test
	public void searchByValidInputTest() throws IOException {

		sfun.searchByValidInput();

		System.out.println("Search Test Passed");
	}

	
	
	@Test(dependsOnMethods = "searchByValidInputTest")
	public void searchByInvalidDataTest() throws IOException {

		sfun = new SearchFun(driver);
		sfun.searchByInvalidData();

		String acttitile = driver.getTitle();
		String exptitle = "Amazon.in : realme 11 pro";

				if (exptitle.equals(acttitile)) {
		
					System.out.println("Search Test with invalid data is Failed");
		
				} else
					System.out.println("search test is passed");

		

	}

}
