package Practice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Scenario1 {
@Test
public void scenario1test()
{
	//public static void main(String[] args) throws Throwable {
		// launching browser
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		//login to application
		driver.get("http://localhost:8888");
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//navigate to contacts link
		
		driver.findElement(By.linkText("Contacts")).click();
		
		//click on create contact look up image
		
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("firstname")).sendKeys("GARIMA");
		driver.findElement(By.name("lastname")).sendKeys("GAUR");
		driver.findElement(By.name("button")).click();
		Assert.assertEquals(false, true);
		
	WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	
	Actions act=new Actions(driver);
	act.moveToElement(ele).perform();
	driver.findElement(By.linkText("Sign Out")).click();
	
	
	
	
}}