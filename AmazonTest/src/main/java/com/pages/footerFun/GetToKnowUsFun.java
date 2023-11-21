package com.pages.footerFun;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.BaseClass;

public class GetToKnowUsFun extends BaseClass{

	Actions act = new Actions(driver);


	public GetToKnowUsFun(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath="/html/body/div[1]/div[4]/div[1]/div/div[1]/ul/li[1]/a")
	WebElement aboutusbtn;

	@FindBy(xpath="//a[normalize-space()='Careers']")
	WebElement carrersbtn;

	@FindBy(xpath="//a[normalize-space()='Press Releases']")
	WebElement pressreleasesbtn;

	@FindBy(xpath="//a[normalize-space()='Amazon Science']")
	WebElement amazonsciencebtn;


	public void aboutUsFun() throws InterruptedException, AWTException {

		explecitWait(aboutusbtn);

		aboutusbtn.click();


		String exptitle = "About Amazon India - About Amazon India";

		String acttitle = driver.getTitle();
		Assert.assertEquals(exptitle, acttitle);

		//----------FOR ROBOT OPERATION.................

		//		Robot rb = new Robot();
		//		act.contextClick(aboutusbtn).perform();
		//		rb.keyPress(KeyEvent.VK_DOWN);
		//		rb.keyPress(KeyEvent.VK_ENTER);

	}

	public void careersFun() {

		explecitWait(carrersbtn);

		carrersbtn.click();

		String acttitle = driver.getTitle();
		String exptitle = "Amazon.jobs: Help us build Earth’s most customer-centric company.";

		Assert.assertEquals(exptitle, acttitle);

	}

	public void pressReleasesFun() {

		explecitWait(pressreleasesbtn);

		pressreleasesbtn.click();

		String acttitle = driver.getTitle();
		String exptitle = "Press centre | Amazon India";

		Assert.assertEquals(exptitle, acttitle);


	}

	public void amazonScienceFun() throws InterruptedException {

		explecitWait(amazonsciencebtn);

		amazonsciencebtn.click();

		Thread.sleep(5000);
		String acttitle = driver.getTitle();
		String exptitle = "Amazon Science homepage";

		Assert.assertEquals(exptitle, acttitle);


	}



}
