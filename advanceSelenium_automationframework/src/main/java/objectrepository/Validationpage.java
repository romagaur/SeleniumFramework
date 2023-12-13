package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Validationpage {

	public Validationpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//span[@id='dtlview_Campaign Name']")
	private WebElement validate;

	public WebElement getValidate() {
		return validate;
	}
	
	public String getValidateCampaign() {
		
		
		return validate.getText()
;	}
	
	
	
	
	
	
	
	
	
	
	
	
}

