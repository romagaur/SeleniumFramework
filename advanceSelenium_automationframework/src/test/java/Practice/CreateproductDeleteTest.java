package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import genericUtilities.excelFileUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectrepository.CreateProductPage;
import objectrepository.DeleteProductPage;
import objectrepository.HomePage;
import objectrepository.LoginPage;

public class CreateproductDeleteTest {
	

	@Test
	public void createProductAndDeleteTest() throws Throwable
	{
		excelFileUtility eUtil = new excelFileUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		JavaUtility jUtil = new JavaUtility();
//Launching the browser
		WebDriverManager.edgedriver().setup();
	WebDriver driver=new EdgeDriver();
		
		//login to application
		String BROWSER = pUtil.readdatafrompropertyfile("browser");
		String URL = pUtil.readdatafrompropertyfile("url");
		String USERNAME = pUtil.readdatafrompropertyfile("username");
		String PASSWORD = pUtil.readdatafrompropertyfile("password");

driver.get(URL);
wUtil.maximizeWindow(driver);

LoginPage login=new LoginPage(driver);
login.loginToApp(USERNAME, PASSWORD);
//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//driver.findElement(By.id("submitButton")).click();

//click on product link
HomePage home=new HomePage(driver);
home.productLink1();
//driver.findElement(By.linkText("Products")).click();

Thread.sleep(2000);
//click on +sign
CreateProductPage productpage=new CreateProductPage(driver);
productpage.clickProductImg();
//driver.findElement(By.xpath("//img[@title='Create Product...']")).click();

//java utility method
int ranNum = jUtil.getRandomNumber();
String productData = eUtil.readdatafromexcelfile("Product", 1, 0);

productpage.productName(productData);
	//driver.findElement(By.name("productname")).sendKeys(productData);

productpage.clickSaveButton();
	//save the data
//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

//product table
DeleteProductPage deletePrd=new DeleteProductPage(driver);
deletePrd.productTable();
//driver.findElement(By.xpath("//a[text()='Products']")).click();
driver.findElement(By.xpath("//table[@class='lvt small']/tbody//td//a[text()='"+productData+"']"
		+ "/../preceding-sibling::td/input")).click();

deletePrd.deletePrdData();
//driver.findElement(By.xpath("//input[@value='Delete']")).click();

wUtil.acceptAlert(driver);
//Alert alt = driver.switchTo().alert();
//alt.accept();

//validation
// List<WebElement> productList = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]"));
//
// boolean flag=false;
// 
// for(WebElement prdName:productList)
// {
//	String actData = prdName.getText();
//	if(actData.contains(productData))//	Markerting293.contains(iphone)
//	{
//		flag=true;
//		break;
//	}
// }
//if(flag)
//{
//	System.out.println("product data is deleted");
//}
//else
//{
//	System.out.println("product data not deleted");
//}
DeleteProductPage page=new DeleteProductPage(driver);
page.validateProduct(driver, productData);

Thread.sleep(2000);
home.logoutOfApp(driver);
	}	
	

}
