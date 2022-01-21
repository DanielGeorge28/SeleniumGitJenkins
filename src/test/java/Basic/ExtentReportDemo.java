package Basic;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportDemo {
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest extentTest;
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass()
	{
//		htmlReporter = new ExtentHtmlReporter("./reports/extent.html"); 
//		htmlReporter.config().setEncoding("utf-8");
//		htmlReporter.config().setDocumentTitle("Daniel Automation Report");
//		htmlReporter.config().setReportName("Tata test result");
//		
//		extent = new ExtentReports();
//		extent.attachReporter(htmlReporter);
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\da.george\\eclipse-workspace\\Selenium\\driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		 driver.manage().window().maximize();
		
	}
	@Test
	public void testsuccefull()
	{
		driver.get("https://google.com");
	//	extentTest =extent.createTest("Succesfull test");
	//	extentTest.log(Status.PASS, "Test method succesful");
		
	}
	@Test
	public void testfail()
	{
		driver.get("https://google.com");
	//	extentTest =extent.createTest("failed test");
	//	extentTest.log(Status.FAIL, "Test method FAILED");
		Assert.fail("Executing failed test method");
		
	}
	@Test
	public void testSkipped()
	{
		driver.get("https://google.com");
	//	extentTest =extent.createTest("Skipped test");
	//	extentTest.log(Status.SKIP, "Test method Skipped");
		throw new SkipException("Executing Skipped test method");
		
	}
//	@AfterMethod
//	public void afterMethod(ITestResult result)
//	{
//		String methodName =result.getMethod().getMethodName();
//		if(result.getStatus()==ITestResult.FAILURE)
//		{
//			String exceptionMessage =Arrays.toString(result.getThrowable().getStackTrace());
//			extentTest.fail("<details><summary><b><font color=red>Exception Occured,click to see details:"
//					+"</font></b></summary>" +exceptionMessage.replaceAll(",","<br>") +"</details> \n ");
//			
//			String path =takeScreenshotName(result.getMethod().getMethodName());
//			try {
//				extentTest.fail("<br> <font colour= red>" +"Screenshot of failure" + "</font></br>");
//				extentTest.addScreenCaptureFromPath(path);
//				
//			}
//			catch(IOException e)
//			{
//				extentTest.fail("Test failed , cannot attach screenshot");
//				
//			}
//			String logText ="<b>Test Method "+ methodName +" Failed</b>";
//			Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
//			extentTest.log(Status.FAIL, m);
//		}
//		else if(result.getStatus()==ITestResult.SUCCESS)
//		{
//			String logText ="<b>Test Method "+ methodName +" Successfull</b>";
//			Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
//			extentTest.log(Status.PASS, m);
//		}
//		else if(result.getStatus()==ITestResult.SKIP)
//		{
//			String logText ="<b>Test Method "+ methodName +"Skipped</b>";
//			Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
//			extentTest.log(Status.SKIP, m);	
//		}
//		
//	}
//	@AfterClass
//	public void afterClass()
//
//	{
//		System.out.println("Flushing");
//		driver.quit();
//		extent.flush();
//	}

//	public String takeScreenshotName(String methodName)
//	{
//		String filename =getScreenshotName(methodName);
//		String directory = System.getProperty("user.dir")+"/screenshots/";
//		new File(directory).mkdirs();
//		String path = directory +filename;
//		
//		try {
//			File screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//			FileUtils.copyFile(screenshot, new File(path));
//			System.out.println("=========Screenshot taken in"+path);
//		}
//		catch(Exception e)
//		{
//		e.printStackTrace(); 	
//		}
//		return path;
//	}
//	public static String getScreenshotName(String methodName)
//	{
//		Date d = new Date();
//		String fileName = methodName+"_"+d.toString().replace(":", "_").replace(" ", "_")+".png";
//		return fileName;
//	}

}
