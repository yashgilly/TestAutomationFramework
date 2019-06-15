package org.com.FrameWork;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.com.ObjectMainMobile.MobileTestMainClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.TestNG;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.mongodb.diagnostics.logging.Logger;
import org.testng.ITestContext;
import org.testng.ITestResult;

public class BrowserAndDriverClass implements InitCommonMethods {
	
	
	public static WebDriver driver;
	
	String browserName;
	
	static String environmentName;
	
	public static String applicationName;
	
	Properties properties;
	
	BufferedReader reader;
	
	
	public void readProperty()
	{	
		 try {
		 reader = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\src\\test\\java\\Configuration.properties"));
		 properties = new Properties();
		 properties.load(reader);
		 }
		 catch (Exception e) {
			 System.out.println(e.getMessage());
		}
	}
	
	public String getBrowserName()
	{
		try
		{
			readProperty();
			browserName = properties.getProperty("Browser");
			if(browserName != null)
			{
				return browserName;
			}
		}
		 catch (Exception e) {
				System.out.println(e.getMessage());
			}
		return browserName;
	}
	
	public String getEnvironmentName()
	{
		try
		{
			readProperty();
			environmentName = properties.getProperty("Environment");
			if(environmentName != null)
			{
				return environmentName;
			}
		}
		 catch (Exception e) {
				System.out.println(e.getMessage());
			}
		return environmentName;
	}
	
	public String getApplicationName()
	{
		try
		{
			readProperty();
			applicationName = properties.getProperty("ApplicationName").trim();
			if(applicationName != null)
			{
				return applicationName;
			}
		}
		 catch (Exception e) {
				System.out.println(e.getMessage());
			}
		return applicationName;
	}
	
	/*public WebDriver callBowser()
	{
		try
		{
			initDriver(getBrowserName());
			return driver;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return driver;
	}*/
	
	public WebDriver initDriver(String browserName)
	{
		try
		{
			if(browserName.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Downloads\\FrameWork - Selenium\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				return driver;
			}
				
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		return driver;
	}

}
