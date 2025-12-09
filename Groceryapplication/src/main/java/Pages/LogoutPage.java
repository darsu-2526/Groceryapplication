package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	@FindBy(xpath="//a[@class='nav-link' and @data-toggle='dropdown']")WebElement admin;
	@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']//parent::a")WebElement logout;
	@FindBy(xpath="//button[@class='btn btn-dark btn-block']")WebElement signin;
	public WebDriver driver;
	public LogoutPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void clickAdmin()
	{
		admin.click();
	}
	public void selectLogout()
	{
		logout.click();
	}
	public boolean isSigninDisplayed()
	{
	return signin.isDisplayed();	
	}

}
