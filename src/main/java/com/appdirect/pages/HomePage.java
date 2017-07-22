package com.appdirect.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.appdirect.base.BasePage;
import com.appdirect.util.AppConstants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage extends BasePage{
	
	@FindBy(xpath=AppConstants.LOGIN_LINK)
	public WebElement loginlink;
	
	
	public HomePage(WebDriver driver, ExtentTest test){
		super(driver,test);
	}
	public LoginPage gotoLoginPage(){
		test.log(LogStatus.INFO, "navigate To Login Page");	
		//click on Log In link
		clickElement(loginlink,AppConstants.LOGIN_LINK);
		//navigate to login page
		LoginPage loginPage = new LoginPage(driver,test);
		PageFactory.initElements(driver, loginPage);
		return loginPage;
	}
}
