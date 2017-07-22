package com.appdirect.util;


public class AppConstants {
	
	//driver paths
	public static final String CHROME_DRIVER_EXE = System.getProperty("user.dir")+"\\chromedriver.exe";
	public static final String IE_DRIVER_EXE = System.getProperty("user.dir")+"\\IEDriverServer.exe";
	public static final String GECKO_DRIVER_EXE = System.getProperty("user.dir")+"\\geckodriver.exe";
	// locators
	public static final String LOGIN_LINK  = "//*[text() = 'Log In']";
	public static final String SIGNUP_LINK  = "//*[text()='Sign Up']";
	public static final String SIGNUP_EMAIL  = "//input[@name = 'emailAddress']";
	public static final String SIGNUP_BUTTON  = "//button[contains(text(),'Sign Up')]";
	public static final String SIGNUPSUCCESS_TEXT  = "//*[text() = 'Thanks for registering.']";
	public static final String SIGNUPFAILURE_TEXT  = "//*[text() = 'This email address has already been registered in our system. Please register with a new email address.']";
		
	//Test Data paths
	public static final String REPORTS_PATH = System.getProperty("user.dir")+"\\TestReports\\";
	public static final String DATA_XLS_PATH = System.getProperty("user.dir")+"\\data\\Data.xlsx";
	public static final String TESTDATA_SHEET = "TestData";
	public static final Object RUNMODE_COL = "Runmode";
	public static final String TESTCASES_SHEET = "TestCases";
	




	


	


	




	



	

}
