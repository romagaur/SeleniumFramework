package Practice;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.excelFileUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectrepository.CampaignPlussignPage;
import objectrepository.CreateCampaignfillDetails;
import objectrepository.HomePage;
import objectrepository.LoginPage;
import objectrepository.Validationpage;
import genericUtilities.BaseClass;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;

@Listeners(genericUtilities.ListenerImplementation.class)

@Test(retryAnalyzer=genericUtilities.RetryImplementation.class)
public class CreateCampaignTest extends BaseClass{

	public  void createCampaignTest() throws Throwable {
		/*
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new EdgeDriver();
		
		driver.manage().window().maximize();
		excelFileUtility eUtil = new excelFileUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		JavaUtility jUtil = new JavaUtility();
		*/
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String BROWSER = pUtil.readdatafrompropertyfile("browser");
		String URL = pUtil.readdatafrompropertyfile("url");
		String USERNAME = pUtil.readdatafrompropertyfile("username");
		String PASSWORD = pUtil.readdatafrompropertyfile("password");

		driver.get(URL);
		//HardCoding
	/*	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();*/
		
		 LoginPage lp=new LoginPage(driver);
         lp.loginToApp(USERNAME, PASSWORD);
         
		
	//WebElement moreLink = driver.findElement(By.linkText("More"));
		HomePage home=new HomePage(driver);
		home.clickonmore();
         
       //  Actions act = new Actions(driver);
		//act.moveToElement(moreLink).perform();
		//driver.findElement(By.linkText("Campaigns")).click();
	
		home.clickoncampaign();
		
		//driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		
		CampaignPlussignPage create =new CampaignPlussignPage(driver);
		
		create.clickonPlussign();
		Assert.assertEquals(false, true);
		int ranNum = jUtil.getRandomNumber();
		
		
		String CampaginName = eUtil.readdatafromexcelfile("Campaigns", 0, 0)+ranNum;
		
		//driver.findElement(By.name("campaignname")).sendKeys(CampaginName);
	    
		CreateCampaignfillDetails campgname=new CreateCampaignfillDetails(driver);
		campgname.fillDetails(CampaginName);
		
	    //driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])")).click();
		campgname.clickonsave();
		 Thread.sleep(2000);
		 
		 Validationpage campvalidate= new Validationpage(driver);
		 
		 String Actdata = campvalidate.getValidateCampaign();
		
		 Assert.assertEquals(Actdata, CampaginName);
		 
		 // String Actdata = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
		
		/* if(Actdata.contains(CampaginName))
		{
			System.out.println("pass");
			
		}
		else
		{
			System.out.println("fail");
		}*/
		 Thread.sleep(2000);
		
		  driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		  driver.findElement(By.linkText("Sign Out")).click();
	}

	
}