package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import genericUtilities.excelFileUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectrepository.HomePage;

public class Scenario1withDDTandGU {

	public static void main(String[] args) throws IOException, InterruptedException, FileNotFoundException {
		//Create Object of all Utilities
				excelFileUtility eUtil = new excelFileUtility();
				PropertyFileUtility pUtil = new PropertyFileUtility();
				WebDriverUtility wUtil = new WebDriverUtility();
				//JavaUtility jUtil = new JavaUtility();
				WebDriver driver = null;
				
				
				// Step 1: Read all the required Data
				/* Common Data */
				String BROWSER = pUtil.readdatafrompropertyfile("browser");
				String URL = pUtil.readdatafrompropertyfile("url");
				String USERNAME = pUtil.readdatafrompropertyfile("username");
				String PASSWORD = pUtil.readdatafrompropertyfile("password");
				
				/* Test Data */
				String LASTNAME = eUtil.readdatafromexcelfile("Contacts", 1, 2);

				// Step 2: Launch the browser - PolyMorphism - Run Time - Driver
				if (BROWSER.equalsIgnoreCase("Chrome"))// true f
				{
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
				} else if (BROWSER.equalsIgnoreCase("Firefox")) // t f
				{
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
				} else if (BROWSER.equalsIgnoreCase("Edge"))// f
				{
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
				} else {
					System.out.println("invalid Browser name");
				}

				wUtil.maximizeWindow(driver);
				wUtil.waitForPageLoad(driver);
				driver.get(URL);

				// Step 3: Login to Application
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();

				// Step 4: navigate to Contacts link
				//driver.findElement(By.linkText("Contacts")).click();
				
				HomePage home=new HomePage(driver);
				home.clickoncontactslink();
				// Step 5: click on create contact look Up Image
				driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

				// Step 7: create contact with mandatory fields
				driver.findElement(By.name("lastname")).sendKeys(LASTNAME);

				// Step 7: save
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

				// Step 8: Validate
				String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if (contactHeader.contains(LASTNAME)) {
					System.out.println(contactHeader);
					System.out.println("PASS");
				} else {
					System.out.println("FAIL");
				}

				// Step 9: Logout
				WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));

				wUtil.mouseHoverAction(driver, ele);
				
				Thread.sleep(1000);
				driver.findElement(By.linkText("Sign Out")).click();
				System.out.println("Logout is successfull");

			}
		}








