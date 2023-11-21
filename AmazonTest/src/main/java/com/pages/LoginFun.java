package com.pages;

import java.io.IOException;
import java.sql.Driver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.BaseClass;
import com.utilities.DriverUtils;
import com.utilities.PropertiesUtils;

public class LoginFun extends BaseClass {

	@FindBy(id = "ap_email")
	WebElement username;

	@FindBy(id = "ap_password")
	WebElement password;

	@FindBy(id = "continue")
	WebElement continuebtn;

	@FindBy(id = "signInSubmit")
	WebElement signin;

	@FindBy(id = "nav-logo-sprites")
	WebElement homepage;
	
	@FindBy(xpath="//span[normalize-space()='Account & Lists']")
	WebElement loginicon;
	
	@FindBy(xpath="//div[@id='nav-flyout-ya-signin']//span[@class='nav-action-inner'][normalize-space()='Sign in']")
	WebElement loginbtn;

	public LoginFun(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void loginWithValidCredential() throws IOException {
		String url = PropertiesUtils.readProperty("url");
		driver.get(url);

		String uname = PropertiesUtils.readProperty("username");
		String pass = PropertiesUtils.readProperty("password");

		username.sendKeys(uname);
		continuebtn.click();
		password.sendKeys(pass);
		signin.click();
		explecitWait(homepage);

		//homepage.click();

		String actTitle = driver.getTitle();
		String reqTitile = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";

		if (actTitle.equals(reqTitile)) {
			System.out.println("Login Sucessful");
		} else
			System.out.println("Login Not Sucessful");

		//Assert.assertEquals(actTitle, reqTitile);

	}

	public void loginWithInvalidpPassword() throws IOException {


		String url = PropertiesUtils.readProperty("url");
		driver.get(url);

		String uname = PropertiesUtils.readProperty("username");
		String invalidpass = PropertiesUtils.readProperty("invalidpassword");

		username.sendKeys(uname);
		continuebtn.click();
		password.sendKeys(invalidpass);
		signin.click();

		String actTitle = driver.getTitle();
		String reqTitile = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";

		if (actTitle.equals(reqTitile)) {
			System.out.println("Login Sucessful");
		} else
			System.out.println("Login Not Sucessful = Wrong Password Entered");

	}
	
	public void loginBySite() throws IOException {
		
		String url = PropertiesUtils.readProperty("urlmain");
		driver.get(url);

		loginicon.click();
//		loginbtn.click();
		
		implicitWait(10);
		
		String uname = PropertiesUtils.readProperty("username");
		String validpass = PropertiesUtils.readProperty("password");

		username.sendKeys(uname);
		continuebtn.click();
		password.sendKeys(validpass);
		signin.click();
		

		
	}



}
