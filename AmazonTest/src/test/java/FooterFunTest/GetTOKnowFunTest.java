package FooterFunTest;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.LoginFun;
import com.pages.footerFun.GetToKnowUsFun;


public class GetTOKnowFunTest extends BaseClass {

	public static LoginFun lp = null;
	public static GetToKnowUsFun gt = null;

	@BeforeSuite
	public void setup() throws IOException {

		initialization();
		reportInit();
		implicitWait(10);

		lp = new LoginFun(driver);
		gt = new GetToKnowUsFun(driver);

		lp.loginBySite();

	}

	@AfterSuite
	public void tearDown() {

		reports.flush();
		//driver.close();

	}

	@Test
	public void aboutUsFun() throws Exception, AWTException  {

		gt.aboutUsFun();

	}

	@Test
	public void careersFun() {
		gt.careersFun();
		
	}
	
	@Test
	public void PressReleasesFunTest() {
		
		gt.pressReleasesFun();
		
	}
	
	
	@Test
	public void amazonScienceFunTest() throws InterruptedException {
		
		gt.amazonScienceFun();
	}
	
}
