package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class LocationChange extends BaseClass {

	Actions act = new Actions(driver);


	public LocationChange(WebDriver driver)
	{

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath="//span[@class='nav-line-1 nav-progressive-content']")
	WebElement selectlocation;

	@FindBy(xpath="//input[@class='a-button-input']")
	WebElement selectadd;


	public void selectAddress()
	{

		act.doubleClick(selectlocation).perform();
		act.doubleClick(selectadd).perform();


	}


}
