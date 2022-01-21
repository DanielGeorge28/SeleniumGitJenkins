package Basic;

import org.testng.annotations.*;

public class TestNgbasic {
	
//	public static void main (String ash[])
//	{
//		System.out.println("hell9i");
//	}
	@BeforeSuite
	public void setup()
	{
		System.out.println("Set-up properly");
	}
	
	@BeforeTest
	public void login()
	{
		System.out.println("launched");
	}
	
	@BeforeClass
   public void lauchBrowser()
 {
	 System.out.println("logintoapp");
 }
	
	@BeforeMethod
	public void eneterUrl()
	{
		System.out.println("Enter URL");
	}
	
	
	@Test
	public void googleTitle()
	{
		System.out.println("google title tect");
	}
	@AfterMethod
	public void logout()
	{
		System.out.println("logout from app");
	}
	@AfterTest
	public void deletecookies()
	{
		System.out.println("deleteAll cookies");
	}
	@AfterClass
	public void closeBrowswer() {
		System.out.println("Close browswer");
	}
	@AfterSuite
	public void report()
	{
		System.out.println("generate the report");
	}
}

