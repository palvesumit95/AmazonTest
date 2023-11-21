package com.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.basic.BasicTabbedPaneUI.TabbedPaneLayout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
import com.utilities.PropertiesUtils;

public class AddProductToCart extends BaseClass{

	Actions actions = new Actions(driver);

	public AddProductToCart(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}


	@FindBy(id="twotabsearchtextbox")
	WebElement searchbox;

	@FindBy(id="nav-search-submit-button")
	WebElement submitbtn;

	@FindBy(xpath="//span[@class='a-size-medium a-color-base a-text-normal'][contains(text(),'realme 11 Pro 5G (Sunrise Beige, 8GB RAM, 256GB Storage')]")
	WebElement productsearch;

	@FindBy(xpath="//span[normalize-space()='realme 11x 5G (Midnight Black, 8GB RAM, 128GB Storage)']")
	WebElement productsearch1;

	@FindBy(xpath="//input[@id='add-to-cart-button']")
	WebElement addtocartbtn;

	@FindBy(xpath="/html/body/div[8]/div[3]/div[3]/div/div[1]/div[3]/div[1]/div[2]/div[3]/span/span/input")
	WebElement checkoutbtn;

	@FindBy(xpath="//p[@class='a-text-left a-size-base'][contains(text(),'8GB RAM + 128GB Storage')]")
	WebElement storagebtn;

	@FindBy(xpath="//p[@class='a-text-left a-size-base'][contains(text(),'6GB RAM & 128GB Storage')]")
	WebElement storagebtn1;

	@FindBy(id="attach-close_sideSheet-link")
	WebElement closexcartwindow;

	@FindBy(xpath="//img[@alt='Purple Dawn']")
	WebElement changecolour;

	@FindBy(id="seeMoreDetailsLink")
	WebElement seemoreproductdetailfun;

	@FindBy(xpath="//a[@id='S']")
	WebElement homepageicon;

	@FindBy(id="attach-sidesheet-view-cart-button")
	WebElement cartframe;


	@FindBy(xpath="/html/body/div[8]/div[3]/div[3]/div/div[1]/div[3]/div[1]/div[2]/div[3]/form/span/span/input")
	WebElement cartbtn;


	public void addProduct() throws IOException {


		searchbox.clear();

		actions.doubleClick(searchbox).perform();

		String product = PropertiesUtils.readProperty("product");

		searchbox.sendKeys(product);

		actions.doubleClick(submitbtn).perform();

		productsearch.click();

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		actions.doubleClick(addtocartbtn).perform();

		implicitWait(15);
		cartbtn.click();


		//TO CHECK CURRENT OPEN WINDOWS:-
		//		
		//		implicitWait(30);
		//		
		//		ArrayList<String> handles = new ArrayList<String>(driver.getWindowHandles());
		//		for (String window : handles) {
		//			System.out.println(window.length());
		//			System.out.println(".......................");
		//			System.out.println(driver.getTitle());
		//		}




	}


	public void changeStorage() throws IOException {

		homepageicon.click();
		searchbox.clear();
		actions.doubleClick(searchbox).perform();

		String product1 = PropertiesUtils.readProperty("product1");

		searchbox.sendKeys(product1);

		actions.doubleClick(submitbtn).perform();

		productsearch1.click();

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		actions.doubleClick(storagebtn1).perform();

		log.info("Storage Change Sucesfully");


	}


	public void changeColour() throws IOException {

		homepageicon.click();
		searchbox.clear();
		actions.doubleClick(searchbox).perform();

		String product1 = PropertiesUtils.readProperty("product1");

		searchbox.sendKeys(product1);

		actions.doubleClick(submitbtn).perform();

		productsearch1.click();

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));


		actions.doubleClick(changecolour).perform();


	}

	public void seeMoreProductdetail() throws IOException {


		homepageicon.click();
		searchbox.clear();

		actions.doubleClick(searchbox).perform();

		String product1 = PropertiesUtils.readProperty("product1");

		searchbox.sendKeys(product1);

		actions.doubleClick(submitbtn).perform();

		productsearch1.click();

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		actions.doubleClick(seemoreproductdetailfun).build().perform();

	}
}
