package org.com.FrameWork;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.utils.FileUtil;

public class CommonMethods extends BrowserAndDriverClass {

	public void launchApplication(String url)
	{
		try
		{
			if(driver==null || driver.toString().equals("null"))
			{
			initDriver(getBrowserName());
			}
			driver.get(url);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void clickElement(By element)
	{
		try
		{
			driver.findElement(element).click();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static String getScreenshot(String path) throws HeadlessException, AWTException, IOException
	{
		BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(image, "png", new File(path));
		return path; 
	}
	
	public void sendValues(By element,String value)
	{
		try
		{
			driver.findElement(element).sendKeys(value);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void readExcelData()
	{
		try
		{
			//get data from excel
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
