package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class CreateAdminUserPage {
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")WebElement moreinfo;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement newbutton;
	@FindBy(xpath="//input[@id='username']")WebElement username;
	@FindBy(xpath="//input[@id='password']")WebElement password;
	@FindBy(xpath="//select[@id='user_type']")WebElement usertype;
	@FindBy(xpath="//button[@name='Create']")WebElement savebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	
	
	public WebDriver driver;
	
	public CreateAdminUserPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);		
	}
	public void clickMoreInfo()
	{
		moreinfo.click();
	}
	public void clickNewButton()
	{
		newbutton.click();
	}
	public void enterUsername(String adminusername)
	{
		username.sendKeys(adminusername);
	}
	public void enterPassword(String adminpassword)
	{
		password.sendKeys(adminpassword);
	}
	public void selectUserType()
	{
		PageUtilities pageutilities=new PageUtilities();
		pageutilities.selectByVisibleText(usertype, "Admin");
		
	}
	public void clickSave()
	{
		savebutton.click();
	}
	public boolean isAlertDisplayed()
	{
		return alert.isDisplayed();
	}
	
	
	
	
	

}
