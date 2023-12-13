package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {

	
	 //initalization
		public CreateProductPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//img[@title='Create Product...']")
		private WebElement ProductImg;
		
		@FindBy(name="productname")
		private WebElement productName;
		
		@FindBy(xpath="(//input[@title='Save [Alt+S]'])[2]")
		private WebElement saveButton;

		public WebElement getProductImg() {
			return ProductImg;
		}

		public WebElement getProductName() {
			return productName;
		}

		public WebElement getSaveButton() {
			return saveButton;
		}
		
		public void clickProductImg()
		{
			ProductImg.click();
		}
		public void productName(String Name)
		{
			productName.sendKeys(Name);
			}
		public void clickSaveButton()
		{
			
			saveButton.click();
		}
}
