package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignsPage {

	public CreateCampaignsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Create Campaign...']")
	private WebElement CampaignsPlus;
	
	@FindBy(name="campaignname")
	private WebElement campaignsName;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])")
	private WebElement saveButton;

	public WebElement getCampaignsPlus() {
		return CampaignsPlus;
	}

	public WebElement getCampaignsName() {
		return campaignsName;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	//Business Logics
	public void clickCampPlusimg()
	{
		CampaignsPlus.click();
	}
	public void campaignsName(String campName)
	{
		campaignsName.sendKeys(campName);
	}
	public void clickSaveButton()
	{
		saveButton.click();
	}
	
	
}
