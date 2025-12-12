package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Constant.Constant;
import Utilities.FileUploadUtilities;
import Utilities.PageUtilities;

public class ManageCategoryPage {
	//@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']")WebElement categorymoreinfo;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement newbutton;
	@FindBy(xpath="//input[@id='category']")WebElement categorytextfield;;	@FindBy(xpath="//li[@id='134-selectable']")WebElement discount;
	@FindBy(xpath="//input[@id='main_img']")WebElement choosefile;
	@FindBy(xpath="//button[@class='btn btn-danger']")WebElement savebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	
	
	public WebDriver driver;
	public ManageCategoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	/*public ManageCategoryPage clickCategoryMoreInfo()
	{
		categorymoreinfo.click();
		return this;
	}*/
	public ManageCategoryPage clickAddNewButton()
	{
		newbutton.click();
		return this;
	}
	public ManageCategoryPage  selectCategoryField(String categogy)
	{
		categorytextfield.sendKeys(categogy);
		return this;
	}
	public ManageCategoryPage clickDiscount()
	{
		discount.click();
		return this;
	}
	public ManageCategoryPage chooseImageFile()
	
	{
	    FileUploadUtilities fileuploadutilities=new FileUploadUtilities();
	    fileuploadutilities.fileUploadUsingSendKeys(choosefile, Constant.TESTIMAGE);
		return this;
	}
	public ManageCategoryPage clickSaveButton()
	{
		PageUtilities pageutilities=new PageUtilities(driver);
		pageutilities.click(driver,savebutton);
		return this;
		
	}
	public boolean isAlertDisplayed()
	{
		return alert.isDisplayed();
	}
}
