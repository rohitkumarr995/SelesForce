package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportTestNG {
	public static ExtentReports extent;
	
	public static ExtentReports getExtentReport() {
		
		String Path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(Path);
		reporter.config().setDocumentTitle("Test Result");
		reporter.config().setReportName("Web Automation Test");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester Name", "Rohit");
		return extent;
	}

}
