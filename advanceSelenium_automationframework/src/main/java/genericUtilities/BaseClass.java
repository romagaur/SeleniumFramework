	package genericUtilities;

	import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectrepository.HomePage;
import objectrepository.LoginPage;

/**
 * this class consists of basic configuration annotations of testng
 * @author Garima
 *
 */

	@Test
	@Listeners(genericUtilities.ListenerImplementation.class)
	public class BaseClass {
	
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public excelFileUtility eUtil = new excelFileUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public JavaUtility jUtil = new JavaUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver;
	
	@BeforeSuite(groups={"SmokeTest","RegressionTest"})
	public void bsConfig()
	{
		System.out.println("=== DB Connection SuccessFul ===");
	}
	
	
	@BeforeClass(groups={"SmokeTest","RegressionTest"})
    public void bcConfig() throws IOException
	{
		String BROWSER = pUtil.readdatafrompropertyfile("browser");
		String URL = pUtil.readdatafrompropertyfile("url");
		
	
		
		if(BROWSER.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println(BROWSER+" === Browser launched");
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println(BROWSER+" === Browser launched");
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println(BROWSER+" === Browser launched");
		}
		else
		{
			System.out.println("--invalid browser Name--");
		}
		
		sdriver=driver;
		
		wUtil.maximizeWindow(driver);
		//wUtil.waitForPageLoad(driver);
		
		driver.get(URL);
		
	}
	
	@BeforeMethod(groups={"SmokeTest","RegressionTest"})
	public void bmConfig() throws IOException
	{
		String USERNAME = pUtil.readdatafrompropertyfile("username");
		String PASSWORD = pUtil.readdatafrompropertyfile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("=== Login SuccessFul ===");
	}
	
	
	@AfterMethod(groups={"SmokeTest","RegressionTest"})
	public void amConfig() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		hp.logoutOfApp(driver);
		System.out.println("=== Logout SuccessFul ===");
	}
	
	@AfterClass(groups={"SmokeTest","RegressionTest"})
	public void acConfig()
	{
		driver.quit();
		System.out.println("=== Browser closed SuccessFully ===");
	}
	
	@AfterSuite(groups={"SmokeTest","RegressionTest"})
	public void asConfig()
	{
		System.out.println("=== DB closed SuccessFully ===");
	}
}