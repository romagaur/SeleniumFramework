package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import genericUtilities.excelFileUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectrepository.CreateOrganizationPage;
import objectrepository.HomePage;
import objectrepository.LoginPage;

public class CreateOrganizationTest {
	
	
    @Test
	public  void createOrganizationTest() throws Throwable {
		//Create Object of all Utilities
		
		excelFileUtility eUtil = new excelFileUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		JavaUtility jUtil = new JavaUtility();
		WebDriver driver = null;

		// Step 1: Read all the required Data
		/* Common Data */
		String BROWSER = pUtil.readdatafrompropertyfile("browser");
		String URL = pUtil.readdatafrompropertyfile("url");
		String USERNAME = pUtil.readdatafrompropertyfile("username");
		String PASSWORD = pUtil.readdatafrompropertyfile("password");

		/* Test Data */
		String LASTNAME = eUtil.readdatafromexcelfile("Contacts", 1,2);
		String ORGNAME = eUtil.readdatafromexcelfile("Contacts", 7, 3)+jUtil.getRandomNumber();

if (BROWSER.equalsIgnoreCase("Chrome"))// true f
{
WebDriverManager.chromedriver().setup();
 driver = new ChromeDriver();
}
else if (BROWSER.equalsIgnoreCase("Firefox")) // t f
{
WebDriverManager.firefoxdriver().setup();
 driver = new FirefoxDriver();
} 
else if (BROWSER.equalsIgnoreCase("Edge"))// f
{
WebDriverManager.edgedriver().setup();
 driver = new EdgeDriver();
} 
else {
System.out.println("invalid Browser name");
}


// Step 2: Launch the browser - PolyMorphism - Run Time - Driver
//wUtil.waitForPageLoad(driver);
driver.get(URL);

	//pom class implementing
	LoginPage login1=new LoginPage(driver);
	
	//calling using getter methods
	/*login1.getUserTextField().sendKeys(USERNAME);
	login1.getPasswordTextField().sendKeys(PASSWORD);
	login1.getLoginButton().click();*/
	
	//calling using Business Logics
	login1.loginToApp(USERNAME, PASSWORD);
	
	//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	 //driver.findElement(By.id("submitButton")).click();;
		
	HomePage home=new HomePage(driver);
	home.organizationLink();
	//driver.findElement(By.linkText("Organizations")).click();
	CreateOrganizationPage org=new CreateOrganizationPage(driver);
	org.clickOrgPlus();
	//driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	
	//JavaUtility jlib=new JavaUtility();
	int ranNum = jUtil.getRandomNumber();
	/*Random ran = new Random();
     int ranNum = ran.nextInt(1000);*/
	
//	FileInputStream fes = new FileInputStream("./src/test/resources/AdvSelenium7to9am.xlsx");
//	Workbook book = WorkbookFactory.create(fes);
//	Sheet sheet = book.getSheet("Organization");
//	Row row = sheet.getRow(0);
//     Cell cell = row.getCell(0);
//    String OrgName = cell.getStringCellValue()+ranNum;
	
	//excelFileUtility elib=new excelFileUtility();
	
	//String OrgName = elib.getExcelData("Organization", 0, 0)+ranNum;
	String OrgName = eUtil.readdatafromexcelfile("Organization", 1, 2)+ranNum;
	driver.findElement(By.name("accountname")).sendKeys(OrgName);
    Thread.sleep(2000);
    
   String orgNum = eUtil.readdatafromexcelfile("Organization", 4, 2);
  // driver.findElement(By.id("phone")).sendKeys(orgNum);
    
  
 // driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
    org.getSaveButton().click();
 
/*String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
 if(actData.contains(OrgName))
 {
	 System.out.println("pass");
 }
 else
	 
 {
	 System.out.println("fail");
 }*/
 
/*	WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions act = new Actions(driver);
	act.moveToElement(element).click().perform();
	driver.findElement(By.linkText("Sign Out")).click();*/
	Thread.sleep(2000);
 home.logoutOfApp(driver);
    //driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
    //driver.findElement(By.linkText("Sign Out")).click();
 }
	
}
