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
		
		String categogy="Test boutique";
		//ManageCategoryPage managecategorypage=new ManageCategoryPage(driver);
		managecategorypage=homepage.clickCategoryMoreInfo();
		managecategorypage.clickAddNewButton().selectCategoryField(categogy).clickDiscount().chooseImageFile().clickSaveButton();
		//managecategorypage.selectCategoryField(categogy);
		//managecategorypage.clickDiscount();
		//managecategorypage.clickSaveButton();
		boolean alert=managecategorypage.isAlertDisplayed();
		Assert.assertTrue(alert,Constant.ADDINGNEWCATEGORY);
		
		
	}

}
