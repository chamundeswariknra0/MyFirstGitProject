package com.Automation.Base;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.Automation.Utilities.ScreenshotUtility;


public class BaseEngine 
{
	
	private static WebDriver driver;
	private static String curDir;
	private static String tcName;
	@BeforeSuite
	@Parameters("browserType")
	public void openBrowser(String browserType)
	{
		System.out.println("Launching browser");
		curDir=System.getProperty("user.dir");
		if(browserType.equalsIgnoreCase("chrome"))
		{	
			System.setProperty("webdriver.chrome.driver",curDir+"\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driverInit();
		}
		else if (browserType.equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver",curDir+"\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			driverInit();
		}
	
	}
	
	public void driverInit()
	{
		driver.manage().timeouts().implicitlyWait(89, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@BeforeMethod
	public void beforeTcExecution(Method m)
	{
		tcName = m.getName();
		System.out.println("currently executing tc is:"+tcName);	
	}
	
	@AfterMethod
	public void afterTcExecution(ITestResult result) throws IOException
	{
		tcName =result.getName();
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			System.out.println("TC passed:"+tcName);
		}
		else if (result.getStatus()==ITestResult.SKIP) 
		{
			ScreenshotUtility.screenshot();
			System.out.println("TC skipped:"+tcName);		
		}
		else if (result.getStatus()==ITestResult.FAILURE) 
		{
			ScreenshotUtility.screenshot();
			System.out.println("TC failed:"+tcName);
		}
	}
	
	/*public void reportInit()
	{
		com.relevantcodes.extentreports.ExtentReports
	}
	
	
	*/
	
	


	@AfterSuite
	public void closeBrowser()
	{
		driver.close();
		System.out.println("Browser closed");
	}
	
	
	
	public static WebDriver getDriver() {
		return driver;
	}

	public static String getCurDir() {
		return curDir;
	}

	public static String getTcName() {
		return tcName;
	}

}
