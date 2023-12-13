package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignWithProduct {
	@Test(groups="RegressionTest")	
	public  void run1() {
		WebDriverUtility wutil=new WebDriverUtility();
		// launching browser
WebDriverManager.edgedriver().setup();
WebDriver driver=new EdgeDriver();
		//login to application
driver.get("http://localhost:8888");
driver.manage().window().maximize();//
driver.findElement(By.name("user_name")).sendKeys("admin");
driver.findElement(By.name("user_password")).sendKeys("admin");
driver.findElement(By.id("submitButton")).click();

driver.findElement(By.linkText("Products")).click();
driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();

 driver.findElement(By.name("productname")).sendKeys("bluetooth");
driver.findElement(By.name("button")).click();
driver.findElement(By.linkText("More")).click();
driver.findElement(By.linkText("Campaigns")).click();
driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();

driver.findElement(By.xpath("//img[@alt='Select']")).click();
wutil.switchToWindow(driver, "Products&action");
System.out.println("Switched to child window");

				
				
				
				
				
				
				
				
				
				
				
				
				

	}

}
