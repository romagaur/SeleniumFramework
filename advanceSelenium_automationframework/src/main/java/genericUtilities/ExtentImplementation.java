package genericUtilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentImplementation implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getName());
	}
		


	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName());
		test.log(Status.PASS, result.getThrowable());
		
	}

	public void onTestFailure(ITestResult result) {
		
		 
		String testData = result.getMethod().getMethodName();
		 
		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
		 File src=edriver.getScreenshotAs(OutputType.FILE);
		
				
	try
	{
		FileUtils.copyFile(src, new File("./ScreenShots/"+testData+".png"));
			
	
	}catch(Exception e)
	
	{
		e.printStackTrace();
	}
		
	}

	public void onTestSkipped(ITestResult result) {
		
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
		
		
	}

	public void onStart(ITestContext context) {
		
		JavaUtility jutil = new JavaUtility();
		int ranNum=jutil.getRandomNumber();
		
		ExtentSparkReporter spark=new ExtentSparkReporter("ExtentReport/Report.html"+ranNum);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Testing");
		spark.config().setReportName("Garima");
		
		//system configuration
		
		report=new ExtentReports();
		
		report.attachReporter(spark);
		report.setSystemInfo("executed by", "GARIMA");
		report.setSystemInfo("reviewed by", "Gaur");
			
	}

	public void onFinish(ITestContext context) {
		
		report.flush();
		
	}

		
	
	
	
}
