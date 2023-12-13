package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectrepository.LoginPage;

public class Scenario1WithDDT {

	public static void main(String[] args) throws IOException {
		//read all the required data
		
		/*Common data*/
		
		
		FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p= new Properties();
		p.load(fisp);
		String URL = p.getProperty("url");
		String BROWSER = p.getProperty("browser");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		System.out.println(PASSWORD);
		
		/*TEST DATA*/
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Book1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String LASTNAME = wb.getSheet("CONTACTS").getRow(1).getCell(2).getStringCellValue();
		
		WebDriver driver = null;
		
		//step 2: Launch Browser--RUNTIME POLYMORPHISM
		
		if (BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		
		if (BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		
		if (BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser name");
		}
		
		driver.manage().window().maximize();
		driver.get(URL);
		
		//login to application
		//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		//driver.findElement(By.id("submitButton")).click();
		
		LoginPage lp=new LoginPage(driver);
		//lp.getUserNameEdt().sendKeys(USERNAME);
		//lp.getPasswordEdt().sendKeys(PASSWORD);
		//lp.getLoginBtn().click();
		
		
		lp.loginToApp(USERNAME, PASSWORD);
		
		
		//navigate to contacts link
		
		driver.findElement(By.linkText("Contacts")).click();
		
		//click on create contact look up image
		
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("firstname")).sendKeys("GARIMA");
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		driver.findElement(By.name("button")).click();
		
	WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	
	Actions act=new Actions(driver);
	act.moveToElement(ele).perform();
	driver.findElement(By.linkText("Sign Out")).click();
	
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
