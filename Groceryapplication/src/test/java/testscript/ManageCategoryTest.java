package testscript;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtilities;
import utilities.FakerUtilities;

public class ManageCategoryTest extends Base{
	HomePage homepage;
	ManageCategoryPage managecategorypage;
	
	public WebElement choosefile;

	@Test(description="adding new category")
	public void verifyUserIsAbleToAddNewCategory() throws IOException
	{
		String username=ExcelUtilities.getStringData(1, 0, "loginpage");
		String password=ExcelUtilities.getStringData(1, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage=loginpage.enterTheUsername(username).enterPassword(password);
		//loginpage.enterPassword(password);
		homepage=loginpage.clicksignin();
		
		//String category="new boutique";
		FakerUtilities fakerutilities=new FakerUtilities();
		String category=fakerutilities.creatARandomFirstName();
		//ManageCategoryPage managecategorypage=new ManageCategoryPage(driver);
		managecategorypage=homepage.clickCategoryMoreInfo();
		managecategorypage.clickAddNewButton().selectCategoryField(category).clickDiscount().chooseImageFile().clickSaveButton();
		//managecategorypage.selectCategoryField(category);
		//managecategorypage.clickDiscount();
		//managecategorypage.clickSaveButton();
		boolean alert=managecategorypage.isAlertDisplayed();
		Assert.assertTrue(alert,Constant.ADDINGNEWCATEGORY);
		
		
	}

}
