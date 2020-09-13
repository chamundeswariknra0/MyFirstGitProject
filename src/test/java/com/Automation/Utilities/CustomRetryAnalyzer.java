package com.Automation.Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

//to rerun failed tcs we use IRetryAnalyzer
public class CustomRetryAnalyzer implements IRetryAnalyzer
{

	@Override
	public boolean retry(ITestResult result) 
	{
		// TODO Auto-generated method stub
		return false;
	}
}
