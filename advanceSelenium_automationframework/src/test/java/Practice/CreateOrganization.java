package Practice;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.PropertyFileUtility;
import genericUtilities.excelFileUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectrepository.HomePage;


@Listeners(genericUtilities.ListenerImplementation.class)
public class CreateOrganization {

	@Test(groups="SmokeTest")
	public  void run() throws InterruptedException, IOException ,NoSuchElementException{
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		PropertyFileUtility pUtil=new PropertyFileUtility();
		
		
		String BROWSER = pUtil.readdatafrompropertyfile("browser");
		String URL = pUtil.readdatafrompropertyfile("url");
		String USERNAME = pUtil.readdatafrompropertyfile("username");
		String PASSWORD = pUtil.readdatafrompropertyfile("password");

		driver.get(URL);
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//driver.findElement(By.linkText("Organizations")).click();
HomePage home=new HomePage(driver);
home.clickonorganization();
		
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

//Random Approach To avoid Duplicates
Random ran = new Random();
int ranNum = ran.nextInt(1000);

excelFileUtility eUtil = new excelFileUtility();
String OrgName = eUtil.readdatafromexcelfile("ORGANIZATION", 1, 2)+ranNum;


driver.findElement(By.name("accountname")).sendKeys(OrgName);
Assert.assertEquals(false, true);

driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
Thread.sleep(1000);
String PrdName = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
if(PrdName.contains(OrgName))
{
	System.out.println("Organization Created");
}
else
{
	System.out.println("Organization not created");
}

driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
driver.findElement(By.linkText("Sign Out")).click();
	}
	}

