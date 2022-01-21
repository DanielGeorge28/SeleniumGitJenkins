package Util;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	
	public static ExtentReports createInstance()
	{
		try {
			htmlReporter = new ExtentHtmlReporter("./reports/extent1.html");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Daniel Automation Report");
		htmlReporter.config().setReportName("Tata test result");
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		return extent;
	}
	
	public String reportName()
	{
		return null;
	}
	public String takeScreenshotName(WebDriver driver,String methodName)
	{
		String filename =getScreenshotName(methodName);
		String directory = System.getProperty("user.dir")+"/screenshots/";
		new File(directory).mkdirs();
		String path = directory +filename;
		
		try {
			File screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(path));
			System.out.println("=========Screenshot taken in"+path);
		}
		catch(Exception e)
		{
		e.printStackTrace(); 	
		}
		return path;
	}
	public static String getScreenshotName(String methodName)
	{
		Date d = new Date();
		String fileName = methodName+"_"+d.toString().replace(":", "_").replace(" ", "_")+".png";
		return fileName;
	}

}
