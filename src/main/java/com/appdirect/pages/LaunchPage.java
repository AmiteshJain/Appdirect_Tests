package com.appdirect.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.appdirect.base.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LaunchPage extends BasePage{
	
	public LaunchPage(WebDriver driver,ExtentTest test){
		super(driver,test);	
	}
		
	public HomePage gotoHomePage(String Url){
		// open the application url
		test.log(LogStatus.INFO, "Opening the url - " + Url);
		driver.get(Url);
		test.log(LogStatus.PASS, "URL Opened Successfully - " + Url);
		//navigate to Home Page
		HomePage HomePage = new HomePage(driver,test);
		PageFactory.initElements(driver, HomePage);
		return HomePage;
	}
}
