package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class CreateAdminUserPage {
	//@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")WebElement moreinfocreateadminuser;
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
	/*public void clickMoreInfoCreateAdminUser()
	{
		moreinfocreateadminuser.click();
	}*/
	public CreateAdminUserPage clickNewButton()
	{
		newbutton.click();
		return this;
	}
	public CreateAdminUserPage enterUsername(String adminusername)
	{
		username.sendKeys(adminusername);
		return this;
	}
	public CreateAdminUserPage  enterPassword(String adminpassword)
	{
		password.sendKeys(adminpassword);
		return this;
	}
	public CreateAdminUserPage  selectUserType()
	{
		PageUtilities pageutilities=new PageUtilities(driver);
		pageutilities.selectByVisibleText(usertype, "Admin");
		return this;
		
	}
	public CreateAdminUserPage  clickSave()
	{
		savebutton.click();
		return this;
	}
	public boolean isAlertDisplayed()
	{
		return alert.isDisplayed();
	}
	
	
	
	
	

}
