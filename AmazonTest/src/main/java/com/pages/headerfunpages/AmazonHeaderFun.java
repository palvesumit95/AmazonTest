package com.pages.headerfunpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.base.BaseClass;

public class AmazonHeaderFun extends BaseClass{

	Actions act = new Actions(driver);

	public AmazonHeaderFun(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath="//a[normalize-space()='Amazon miniTV']")
	WebElement amazonminibtn;

	@FindBy(xpath="//a[normalize-space()='Sell']")
	WebElement sellbtn;

	@FindBy(xpath="//a[normalize-space()='Best Sellers']")
	WebElement bestsellerbtn;

	@FindBy(xpath="//a[normalize-space()='Gift Cards']")
	WebElement giftcardsbtn;

	@FindBy(xpath="//span[normalize-space()='Browsing History']")
	WebElement browinghistorybtn;

	@FindBy(xpath="//a[normalize-space()='Grocery & Gourmet Foods']")
	WebElement grocerygourmetfoodsbtn;
	
	@FindBy(xpath="//a[normalize-space()='Amazon Pay']")
	WebElement amazonpaybtn;

	public void amazonMini() {

		act.doubleClick(amazonminibtn).perform();

	}

	public void sellFun() {

		act.doubleClick(sellbtn).perform();

	}

	public void bestSellerFun() {

		act.doubleClick(bestsellerbtn).perform();

	}


	public void giftcardsFun() {


		act.doubleClick(giftcardsbtn).perform();

	}

	public void browingHistoryFun() {

		act.doubleClick(browinghistorybtn).perform();
	}

	public void groceryGourmetFoodsFun() {

		act.doubleClick(grocerygourmetfoodsbtn).perform();

	}

	public void amazonpayFun() {

		act.doubleClick(amazonpaybtn).perform();

	}


}
