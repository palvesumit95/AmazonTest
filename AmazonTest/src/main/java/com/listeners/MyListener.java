package com.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.base.BaseClass;

import com.utilities.DriverUtils;

public class MyListener extends BaseClass implements ITestListener {

	public void configReport() {

		spark.config().setDocumentTitle("Amazon Test");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("Amazon Test Report");



		reports.setSystemInfo("Sumit Pc", "TestAmazon");
		reports.setSystemInfo("OS", "Windows 10");
		reports.setSystemInfo("Browser", "Chrome");


	}



	@Override
	public void onTestStart(ITestResult result) {

		test = reports.createTest(result.getName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		//test.log(Status.PASS, "testcase passed with name as "+result.getName());

		test.log(Status.PASS, MarkupHelper.createLabel("testcase is passed with name as"+result.getName(),ExtentColor.GREEN ));

	}

	@Override
	public void onTestFailure(ITestResult result) {
		//		test.log(Status.FAIL, "testcase failed with name as "+result.getName());
		//		String path=DriverUtils.getScreenshot(result.getName());
		//		test.addScreenCaptureFromPath(path);


		test.log(Status.FAIL,MarkupHelper.createLabel("Testcase Is Failed With Name as "+" " + result.getName(), ExtentColor.RED));
		String path = DriverUtils.getScreenshot(result.getName());
		test.addScreenCaptureFromPath(path);
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		//test.log(Status.SKIP, "testcase skipped with name as "+result.getName());

		test.log(Status.SKIP, "testcase is skipped with name as " + result.getName());

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		configReport();
		System.out.println("On Start Method Invoked");

	}

	@Override
	public void onFinish(ITestContext context) {

	}

}
