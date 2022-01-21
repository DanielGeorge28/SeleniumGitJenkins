package Util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class TestListnerDemo implements ITestListener {
 
	public ExtentReports extent =ExtentManager.createInstance();
	//public ExtentTest extentTest; 
	public static ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result)
	{
		System.out.println("---------------TestCreated----------------------");
//		ExtentManager manage= new ExtentManager();
//		extent= manage.createInstance();
		ExtentTest test =extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		System.out.println("extent test value"+extentTest.toString());
		System.out.println("test value is " +test.toString());
	}
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("---------------Test Passed----------------------");
		String logText ="<b>Test Method "+ result.getMethod().getMethodName() +" Successfull</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
//		ExtentTest test =extent.createTest(result.getMethod().getMethodName());
//		test.log(Status.PASS, m);
		extentTest.get().log(Status.PASS, m);
	}
	public void onTestFailure(ITestResult result)
	
	{
		System.out.println("---------------Test Failed----------------------");
		String logText ="<b>Test Method "+ result.getMethod().getMethodName() +" Failed</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
//		ExtentTest test =extent.createTest(result.getMethod().getMethodName());
//		test.log(Status.FAIL, m);
		extentTest.get().log(Status.FAIL, m);
	}
	public void onTestSkipped(ITestResult result)
	{
		System.out.println("---------------Test Skipped----------------------");
//		String logText ="<b>Test Method "+ result.getMethod().getMethodName() +"Skipped</b>";
//		Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
//		extentTest.get().log(Status.SKIP, m);
	}
	public void onFinish(ITestContext context)
	{
		System.out.println("value of  extent inside onfinsh"+extent.toString());
		System.out.println("Inside....................Onfinish");
		if(extent!=null)
		{
			extent.flush();
		}
		else {
			System.out.println("Extent is empty");
		}
	}
}
