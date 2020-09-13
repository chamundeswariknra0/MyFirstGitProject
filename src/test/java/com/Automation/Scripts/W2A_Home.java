package com.Automation.Scripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import com.Automation.Base.BaseEngine;

public class W2A_Home extends BaseEngine
{
	@Test
	public void homePage() throws IOException
	{
		Properties pr = new Properties();
		FileInputStream fip = new FileInputStream("G:\\MyFramework\\Automation\\Repository\\W2A.properties");
		pr.load(fip);
		String pageUrl = pr.getProperty("url");
		getDriver().get(pageUrl);
		System.out.println("Way2Automation");
		
	}

}
