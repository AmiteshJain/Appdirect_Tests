package com.appdirect.base;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.appdirect.util.AppConstants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BasePage {

	public WebDriver driver;
	public ExtentTest test;
	
	public BasePage(WebDriver driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
	}
	
	public boolean isElementPresent(String locator){
		int s = driver.findElements(By.xpath(locator)).size();
		if(s==0){
			//test.log(LogStatus.WARNING, "Element not found");
			//reportFailure("Element with locator " + locator + " Not found");
			return false;
		}
		else{
			//test.log(LogStatus.INFO, "Element found");
			return true;
		}		
	}
	
	public void clickElement(WebElement element,String locator){
		if(isElementPresent(locator)){
			element.click();
		    test.log(LogStatus.PASS, "Element with locator " + locator + " found and clicked");		
			}
		else
			reportFailure("Element with locator " + locator + " Not found");
		}
	
	public void enterText(WebElement element,String locator, String text){
		if(isElementPresent(locator)){
			element.sendKeys(text);
		    test.log(LogStatus.PASS, "Element with locator " + locator + " found and text entered");
			}
		else
			reportFailure("Element with locator " + locator + " Not found");
		}	

	public void reportFailure(String failureMessage){
		test.log(LogStatus.FAIL, failureMessage);
		takeScreenShot();
		Assert.fail(failureMessage);
	}
	
	public void takeScreenShot(){
		Date d=new Date();
		String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
		String filePath=AppConstants.REPORTS_PATH+"screenshots//"+screenshotFile;
		// store screenshot in that file
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(scrFile, new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	test.log(LogStatus.INFO,test.addScreenCapture(filePath));
	}
}
