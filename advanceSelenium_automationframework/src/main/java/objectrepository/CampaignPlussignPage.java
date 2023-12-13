package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPlussignPage {
	
	public CampaignPlussignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Create Campaign...']")
	private WebElement createplussign;

	public WebElement getCreateplussign() {
		return createplussign;
	}
	
	public void clickonPlussign()
	{
		createplussign.click();
	}

}
