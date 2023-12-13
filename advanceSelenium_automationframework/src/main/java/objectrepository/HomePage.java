package objectrepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class HomePage {
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText="More")
	private WebElement moreLink;
	
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignLink;

	@FindBy(linkText="Contacts")
	private WebElement contactPage;
	
	@FindBy(linkText="Organizations")
	private WebElement organizationpage;
	
	@FindBy(linkText="Organizations")
	private WebElement OrganizationLink;
	
	public WebElement getOrganizationLink() {
		return OrganizationLink;
	}

	//logout
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminlink;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutlink;
	
	//product link
	@FindBy(linkText="Products")
	private WebElement productLink;

	public WebElement getProductLink() {
		return productLink;
	}




	public WebElement getOrganizationpage() {
		return organizationpage;
	}


	

	public WebElement getContactPage() {
		return contactPage;
	}


	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampaignLink() {
		return campaignLink;
	}

	public WebElement getAdminlink() {
		return adminlink;
	}

	public WebElement getSignoutlink() {
		return signoutlink;
	}



	public void clickonmore()
	{
		moreLink.click();
	}
	
	public void clickoncampaign()
	{
		campaignLink.click();
	}
	
	public void clickoncontactslink() {
		contactPage.click();
		
	}
	
	public void clickonorganization() {
		organizationpage.click();
		
	}
	
	
	public void logoutOfApp(WebDriver driver)
	{
		WebDriverUtility wUtil = new WebDriverUtility();
		wUtil.mouseHoverAction(driver, adminlink);
		signoutlink.click();
	}

	public void productLink1()
	{
		productLink.click();
	}
	
	public void organizationLink()
	{
		OrganizationLink.click();
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
