package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtilities;

public class HomePage {
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")WebElement moreinfocreateadminuser;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']")WebElement categorymoreinfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact' and @class='small-box-footer']")WebElement moreinfocontactpage;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext' and @class='small-box-footer']")WebElement managefootermoreinfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news'and @class='small-box-footer']")WebElement managenewsmoreinfo;
	public WebDriver driver;
	public HomePage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public CreateAdminUserPage clickMoreInfoCreateAdminUser()
	{
		moreinfocreateadminuser.click();
		return new CreateAdminUserPage(driver);
	}
	public ManageCategoryPage clickCategoryMoreInfo()
	{
		categorymoreinfo.click();
		return new ManageCategoryPage(driver);
	}
	public ManageContactPage clickManageContactPageMoreinfo()
	{
		PageUtilities pageutilities=new PageUtilities(driver);
		pageutilities.click(driver,moreinfocontactpage);
		return new ManageContactPage(driver);
	
	}
	public ManageFooterPage clickMoreInfoManageFooter()
	{
		managefootermoreinfo.click();
		return new ManageFooterPage(driver);
	}
	public ManageNewsPage clickMoreInfoManageNews()
	{
		managenewsmoreinfo.click();
		return new ManageNewsPage(driver);
	}
	
	
	
	
	
	
	
	
	
	
}
