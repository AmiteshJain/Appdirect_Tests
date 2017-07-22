package com.appdirect.util;

import java.util.Date;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null) {
			Date d=new Date();
			String fileName=d.toString().replace(":", "_").replace(" ", "_")+".html";
			String reportPath =AppConstants.REPORTS_PATH+fileName;
 
			extent = new ExtentReports(reportPath, true, DisplayOrder.NEWEST_FIRST);
		}
		return extent;
	}
}
