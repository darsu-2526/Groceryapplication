package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Constant.Constant;
import Utilities.FileUploadUtilities;
import Utilities.PageUtilities;

public class ManageCategoryPage {
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']")WebElement categorymoreinfo;
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
	public void clickMoreInfo()
	{
		categorymoreinfo.click();
	}
	public void clickAddNewButton()
	{
		newbutton.click();
	}
	public void selectCategoryField(String categogy)
	{
		categorytextfield.sendKeys(categogy);
	}
	public void clickDiscount()
	{
		discount.click();
	}
	public void chooseImageFile()
	
	{
	    FileUploadUtilities fileuploadutilities=new FileUploadUtilities();
	    fileuploadutilities.fileUploadUsingSendKeys(choosefile, Constant.TESTIMAGE);
	}
	public void clickSaveButton()
	{
		PageUtilities pageutilities=new PageUtilities(driver);
		pageutilities.click(driver,savebutton);
		
	}
	public boolean isAlertDisplayed()
	{
		return alert.isDisplayed();
	}
}
