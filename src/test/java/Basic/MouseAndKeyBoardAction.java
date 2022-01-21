package Basic;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseAndKeyBoardAction {
	WebDriver driver;
	
//	public  void takeShot(WebDriver driver, String filepath) throws IOException
//	{
//		System.out.println("inside method");
//		TakesScreenshot srcshot = (TakesScreenshot)driver;
//		File SrvFile =srcshot.getScreenshotAs(OutputType.FILE);
//		File DestFile = new File(filepath);
//		FileUtils.copyFile(SrvFile, DestFile);
//		//System.out.println("outside method");
//	}

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\da.george\\eclipse-workspace\\Selenium\\driver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://demo.guru99.com/test/login.html");
		System.out.println("Launched Firefox");
		
		// there are complex interactions like Drag-n-Drop and Double-click 
		//which cannot be done by simple WebElement commands. 
		//To handle those types of advance actions we have the Actions class in Selenium.
		// TODO Auto-generated method stub
		
		//Actions class is a collection of individual Action that you want to perform.
		
		
		// 1.  Instantiate Actions class:
		Actions actions = new Actions(driver);
		//Thread.sleep(10000);
	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		//WebElement textfield= driver.findElement(By.xpath("//div[@class='auto-complete__value-container auto-complete__value-container--is-multi css-1hwfws3']"));
		Wait wait = new FluentWait(driver).withTimeout(30,TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS);
		
		WebElement username = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) 
			{
				return  driver.findElement(By.xpath("//input[@name='email']"));
			}
		});
		
		actions.keyDown(username, Keys.SHIFT);
		actions.sendKeys("daniel");
		actions.keyUp(Keys.SHIFT);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	//	takeShot(driver, "C://Users//da.george//eclipse-workspace//Selenium//screenshots//test.png");
		
		WebDriverWait ewait =new WebDriverWait(driver, 10);
		WebElement password = ewait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='passwd']")));
		password.sendKeys("George");
		Action action =actions.build();
		action.perform();
		
		//username.sendKeys("daniel");
		
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.close();
		System.out.println("Close browswer");
		

	}

}
