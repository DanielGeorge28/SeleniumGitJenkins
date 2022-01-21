package Basic;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Util.*;

public class DataProviderDemo {
	String filepath="C:\\Users\\da.george\\eclipse-workspace\\Selenium\\excel\\data.xlsx";
	String sheetname="Sheet1";
	WebDriver driver;
	
	@BeforeTest
	public void launch()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\da.george\\eclipse-workspace\\Selenium\\driver\\geckodriver.exe");
		 driver = new FirefoxDriver();
		driver.get("https://www.gmail.com");
		System.out.println("Launched Firefox");
		// TODO Auto-generated method stub
		//driver.close();
	}
	@Test
	public void test1()
	{
		System.out.println("testttttt working");
	}
	@DataProvider(name ="test1data")
	public Object[][] getdata() throws IOException
	{
		Object[][] data= ExcelDataProvider.testdata(filepath, sheetname);
		
		return data;
	}
	
	@Test(dataProvider = "test1data")
	public void login(String username, String password)
	{
		System.out.println("Username is "+username);
		System.out.println("Password is "+password);
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}

}
