package com.appdirect.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.appdirect.base.BasePage;
import com.appdirect.util.AppConstants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SignupPage extends BasePage{
	
	@FindBy(xpath=AppConstants.SIGNUP_BUTTON)
	public WebElement signupButton;
	
	@FindBy(xpath=AppConstants.SIGNUP_EMAIL)
	public WebElement signupemail;
	
	@FindBy(xpath=AppConstants.SIGNUPSUCCESS_TEXT)
	public WebElement signupsuccesstext;
	
	@FindBy(xpath=AppConstants.SIGNUPFAILURE_TEXT)
	public WebElement signupfailuretext;
	
	
	public SignupPage(WebDriver driver, ExtentTest test){
		super(driver,test);
	}
	public void doSignUp(String usName){
		test.log(LogStatus.INFO, "signUp as - "+usName);	
		//enter an email address in Email field
		enterText(signupemail, AppConstants.SIGNUP_EMAIL, usName);
		//click on Sign Up button
		clickElement(signupButton,AppConstants.SIGNUP_BUTTON);
	}
		
	public Object validateSignUp(){
			test.log(LogStatus.INFO, "validate SignUp");	
			//validate SignUp
			boolean signUpSuccess=isElementPresent(AppConstants.SIGNUPSUCCESS_TEXT);
			if(signUpSuccess){
				test.log(LogStatus.PASS, "SignUp Success");
				LandingPage landingPage = new LandingPage(driver,test);
				PageFactory.initElements(driver, landingPage);
				return landingPage;
				
			}
			else{
				test.log(LogStatus.WARNING, "SignUp Not Success");
				SignupPage SignupPage = new SignupPage(driver,test);
			    PageFactory.initElements(driver, SignupPage);
				return SignupPage;
			}
		}
	
}
