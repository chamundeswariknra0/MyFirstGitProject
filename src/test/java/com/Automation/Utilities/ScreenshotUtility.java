package com.Automation.Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.Automation.Base.BaseEngine;

public interface ScreenshotUtility 
{
	public static String screenshot() throws IOException
	{
	File file= ((TakesScreenshot) BaseEngine.getDriver()).getScreenshotAs(OutputType.FILE);
	String imagePath = BaseEngine.getCurDir()+"G:\\MyFramework\\Automation\\Screenshots\\"+BaseEngine.getTcName()+".png";	
	FileUtils.copyFile(file,new File(imagePath));
	return imagePath;
	}
}
