package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
//@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news'and @class='small-box-footer']")WebElement managenewsmoreinfo;
@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement newbutton;
@FindBy(xpath="//textarea[@id='news']")WebElement newsfield;
@FindBy(xpath="//button[@class='btn btn-danger']")WebElement savebutton;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;


public WebDriver driver;
public ManageNewsPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
}

/*public void clickMoreInfoManageNews()
{
	managenewsmoreinfo.click();
}*/
public ManageNewsPage clickNewButton()
{
	newbutton.click();
	return this;
}
public ManageNewsPage enterNews(String news)
{
	newsfield.sendKeys(news);
	return this;
}
public ManageNewsPage clickSave()
{
	savebutton.click();
	return this;
}
public boolean isAlertDisplayed()
{
	return alert.isDisplayed();
}
}
