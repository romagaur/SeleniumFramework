package genericUtilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

@SuppressWarnings("deprecation")
public class ListenerImplementation implements ITestListener{

	@SuppressWarnings("deprecation")
	public void onTestFailure(ITestResult result) {
	    
		String testData = result.getMethod().getMethodName();
		 
		@SuppressWarnings("deprecation")
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
	
	

}
