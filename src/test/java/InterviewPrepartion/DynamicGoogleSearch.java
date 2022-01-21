package InterviewPrepartion;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DynamicGoogleSearch {

	public static void main(String[] args) throws InterruptedException  {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\da.george\\eclipse-workspace\\Selenium\\driver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com");
		System.out.println("Launched Firefox");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Automation");
		
		//Dynamic search for "automation engineer
		Thread.sleep(2000);
		List<WebElement> list =driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='wM6W7d']"));
		// TODO Auto-generated method stub
		System.out.println("Size of the list is"+list.size());
		
		for (int i=0; i<list.size();i++)
		{
		  String value=list.get(i).getText();	
		  if(value.equalsIgnoreCase("automation testing"))
		  {
			  System.out.println("Found the value is " +value);
			  break;
		  }
		}
		driver.close();
	
	}

}
