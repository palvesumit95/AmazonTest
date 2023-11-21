package com.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
import com.utilities.PropertiesUtils;

public class SearchFun extends BaseClass {
	
	Actions action = new Actions(driver);

	@FindBy(id="twotabsearchtextbox")
	WebElement searchBox;
	
	@FindBy(id="nav-search-submit-button")
	WebElement submit;
	
	
	public SearchFun(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void searchByValidInput() throws IOException {
		
		action.doubleClick(searchBox).build().perform();
		
		String product = PropertiesUtils.readProperty("product");
		
		searchBox.sendKeys(product);
		action.doubleClick(submit).build().perform();
		
	}
	
	
	public void searchByInvalidData() throws IOException {
		
		searchBox.clear();
		action.doubleClick(searchBox).build().perform();
		
		String invalidProduct = PropertiesUtils.readProperty("invalidproduct");
		
		searchBox.sendKeys(invalidProduct);
		action.doubleClick(submit).perform();
		
		
	}
	
	
	
}
