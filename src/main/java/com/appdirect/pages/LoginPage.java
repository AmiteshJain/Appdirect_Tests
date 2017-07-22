package com.appdirect.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.appdirect.base.BasePage;
import com.appdirect.util.AppConstants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPage extends BasePage{
	
	@FindBy(xpath=AppConstants.SIGNUP_LINK)
	public WebElement signuplink;
	
	public LoginPage(WebDriver driver, ExtentTest test){
		super(driver,test);
	}
	public SignupPage gotoSignUp(){
		test.log(LogStatus.INFO, "navigate To SignUp Page");	
		//click on Sign Up link
		clickElement(signuplink,AppConstants.SIGNUP_LINK);
		//navigate To SignUp Page
		SignupPage SignupPage = new SignupPage(driver,test);
		PageFactory.initElements(driver, SignupPage);
		return SignupPage;	
	}

}
