package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class DigitalContentAndDevicesFun extends BaseClass {

	Actions act = new Actions(driver);

	public DigitalContentAndDevicesFun(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	@FindBy(id="nav-hamburger-menu")
	WebElement allmenu;

	@FindBy(xpath="//a[normalize-space()='Amazon miniTV- FREE entertainment']")
	WebElement amazonmini;

	@FindBy(xpath="//body/div[@id='hmenu-container']/div[@id='hmenu-canvas']/div[@id='hmenu-content']/ul[@class='hmenu hmenu-visible']/li[8]/a[1]")
	WebElement echoandalexa;


	@FindBy(xpath="//a[normalize-space()='See all devices with Alexa']")
	WebElement alexabtn;

	@FindBy(xpath="//div/ul/li/a/i[@class='nav-sprite hmenu-arrow-next']")
	WebElement firetvbtn;


	public void amazonMiniFun() {
		allmenu.click();

		if(amazonmini.isDisplayed())
		{
			act.doubleClick(amazonmini).perform();

		}

		else

			System.out.println("AmazonMini not Available..");
		log.info("AmazonMini not Available..");
	}


	public void echoAndAlexaFun() {


		allmenu.click();
		implicitWait(10);

		if(echoandalexa.isDisplayed()) {

			act.doubleClick(echoandalexa).perform();
			act.doubleClick(alexabtn).perform();
		}

	}

	public void checkAllFun()
	{

		allmenu.click();
		implicitWait(10);


		List<WebElement> list = driver.findElements(By.xpath("//div/ul/li/a[@data-menu-id]"));

		for (WebElement allfun : list) {

			if(list.contains(allfun)) {
				act.doubleClick(allfun).perform();
			}
			else
				System.out.println("function not avilable...");


		}

	}

}
