package com.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utilities.DriverUtils;
import com.utilities.PropertiesUtils;

public class BaseClass {
	
	public static WebDriver driver = null;
	
	public static Logger log = Logger.getLogger(BaseClass.class);
	
	public static ExtentTest test = null;
	public static ExtentReports reports = null;
	public static ExtentSparkReporter spark = null;
	
	public static void initialization() throws IOException {
		
		log.info("Initializing Browser");
		
		
		String browserName = PropertiesUtils.readProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(PropertiesUtils.readProperty("urlmain"));
		
	}
	
	public static void implicitWait(int wait) {
		
		driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
		
	}
	
	public static void explecitWait(WebElement path) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(path));
		
	}
	
	public static void reportInit() {
		
		spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/target/ExtentReport.html");
		reports = new ExtentReports();
		reports.attachReporter(spark);
			
	}
	public static void homePage() throws IOException {
		
	String urlmain = PropertiesUtils.readProperty("urlmain");
	
	driver.get(urlmain);
	}
	
	

		
	}


