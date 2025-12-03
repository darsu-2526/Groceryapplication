package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(name="username")WebElement username;
	@FindBy(xpath="//input[@name='password']")WebElement password;
	@FindBy(xpath="//button[text()='Sign In']")WebElement signin;
	@FindBy(xpath="//p[text()='Dashboard']")WebElement dashboard;
	@FindBy(xpath="//button[@data-dismiss='alert']")WebElement alert;
	
	public WebDriver driver;
	public LoginPage(WebDriver driver) 
	{
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
	
	public void enterTheUsername(String username2) 
	{
		username.sendKeys(username2);
	}
	public void enterPassword(String password2) 
	{
		password.sendKeys(password2);
	}
	public void clicksignin() 
	{
		signin.click();
		
	}
	public boolean isHomePageDisplayed()
	{
		return dashboard.isDisplayed();
	}
	public boolean isAlertDisplayed()
	{
		return alert.isDisplayed();
	}
	

}


