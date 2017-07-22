package com.appdirect.testcases;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.appdirect.pages.HomePage;
import com.appdirect.pages.LandingPage;
import com.appdirect.pages.LaunchPage;
import com.appdirect.pages.LoginPage;
import com.appdirect.pages.SignupPage;
import com.appdirect.testcases.base.BaseTest;
import com.appdirect.util.AppConstants;
import com.appdirect.util.DataUtil;
import com.relevantcodes.extentreports.LogStatus;

public class SignUpTest extends BaseTest{
	String testCaseName="SignUpTest";
	
	@Test(dataProvider="getData")
	public void doLogin(Hashtable<String,String> data){
		test = extent.startTest("SignUp Test " + data.get("Case") + " - " +  data.get("Browser"));
		if(!DataUtil.isTestExecutable(xls, testCaseName) ||  data.get(AppConstants.RUNMODE_COL).equals("N")){
			test.log(LogStatus.SKIP, "Skipping the test as Runmode is No");
			throw new SkipException("Skipping the test as Runmode is No");
		}
		
		test.log(LogStatus.INFO, "Starting SignUp test on " + data.get("Browser"));
		//open browser
		init(data.get("Browser"));
		
		LaunchPage launchPage =new LaunchPage(driver,test);
		PageFactory.initElements(driver, launchPage);
		//goto Home Page
		HomePage homePage = launchPage.gotoHomePage(data.get("Url"));
		//goto login Page
		LoginPage loginPage =  homePage.gotoLoginPage();
		//goto SigUp Page
		SignupPage signupPage =  loginPage.gotoSignUp();
		//do signUp
		signupPage.doSignUp(data.get("Email"));
		//validate Signup 
		Object page = signupPage.validateSignUp();
		
		String actualResult="";
		
		if(page instanceof LandingPage)
			actualResult="Success";
		else
			actualResult="Unsuccessful";
		
		if(!actualResult.equals(data.get("ExpectedResult"))){
			
			reportFailure("SignUp Test Failed");
		}
		
		test.log(LogStatus.PASS, "SignUp Test Passed");
		takeScreenShot();
	}
	@AfterMethod
	public void quit(){
		if(extent!=null){
			extent.endTest(test);
			extent.flush();
		}
		if(driver!=null)
			driver.quit();
	}
	
	@DataProvider
	public Object[][] getData(){
		return DataUtil.getData(xls, testCaseName);
	}
	

}
