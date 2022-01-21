package Basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGFlow {
	WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\da.george\\eclipse-workspace\\Selenium\\driver\\geckodriver.exe");
		
	}
	@BeforeMethod
	public void launch()
	{
		 driver = new FirefoxDriver();
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		 driver.get("http://tataaig.com");
	}
	@Test(priority = 0,groups = "title")
	public void verfiyTitle()
	{
		String title=driver.getTitle();
		System.out.println("Title is "+title);
		int i =9/0;
		
	}
	@Test(priority = 2,groups="image")
	public void verfiyImage()
	{
		//String title=driver.getTitle();
		System.out.println("Image verified");
		
	}
	@Test(priority = 1,groups="title",dependsOnMethods = "verfiyTitle")
	public void verfiyHomeIcon()
	{
		//String title=driver.getTitle();
		System.out.println("Homeoage depend on title verified");
		
	}
	@AfterMethod
	public void closeBroswer()
	{
		System.out.println("Closed");
		driver.close();
	}

}
