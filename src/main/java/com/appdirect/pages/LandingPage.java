package com.appdirect.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.appdirect.base.BasePage;
import com.appdirect.util.AppConstants;
import com.relevantcodes.extentreports.ExtentTest;

public class LandingPage extends BasePage{
	
	
	@FindBy(xpath=AppConstants.SIGNUP_LINK)
	public WebElement signuplink;
	
	
	public LandingPage(WebDriver driver, ExtentTest test){
		super(driver,test);
	}
	
	
}
