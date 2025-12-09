package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class ManageContactPage {
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact' and @class='small-box-footer']")WebElement moreinfo;
	@FindBy(xpath="//i[@class='fas fa-edit']")WebElement edit;
	@FindBy(xpath="//input[@id='phone']")WebElement phonenumberfield;
	@FindBy(xpath="//input[@id='email'and @name='email']")WebElement emailfield;
	@FindBy(xpath="//textarea[@id='content' and @name='address']")WebElement addressfield;
	@FindBy(xpath="//textarea[@id='content' and @name='del_time']")WebElement deliverytimefield;
	@FindBy(xpath="//input[@id='del_limit' and @name='del_limit']")WebElement deliverychargelimitfield;
	@FindBy(xpath="//button[@class='btn btn-block-sm btn-info']")WebElement update;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	
	
	public WebDriver driver;
	public ManageContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void clickMoreinfo()
	{
		PageUtilities pageutilities=new PageUtilities(driver);
		pageutilities.click(driver, moreinfo);
	
	}
	public void clickEdit()
	{
		edit.click();
	}
	public void updatePhonenumber(String phonenumber)
	{
		phonenumberfield.clear();
		phonenumberfield.sendKeys(phonenumber);
	}
	public void updateEmail(String email)
	{
		emailfield.clear();
		emailfield.sendKeys(email);
	}
	public void updateAddress(String address)
	{
		addressfield.clear();
		addressfield.sendKeys(address);
	}
	public void updateDeliveryTime(String deliverytime)
	{
		deliverytimefield.clear();
		deliverytimefield.sendKeys(deliverytime);
	}
	public void updateDeliveryChargeLimit(String deliverychargelimit)
	{
		deliverychargelimitfield.clear();
		deliverychargelimitfield.sendKeys(deliverychargelimit);
	}
	public void clickUpdate()
	{
		update.click();
	}
	public boolean alertDisplayed()
	{
		return alert.isDisplayed();
	}
}
