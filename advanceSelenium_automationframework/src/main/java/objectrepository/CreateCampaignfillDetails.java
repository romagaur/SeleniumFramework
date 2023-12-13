package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignfillDetails {

	public CreateCampaignfillDetails(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="campaignname")
	private WebElement createdetails;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])")
	private WebElement savebutton;

	public WebElement getCreatedetails() {
		return createdetails;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}
	
	public void fillDetails(String name)
	{
		createdetails.sendKeys(name);
	}
	
	
	public void clickonsave()
	{
		savebutton.click();
	}
	
	
	
	
}
