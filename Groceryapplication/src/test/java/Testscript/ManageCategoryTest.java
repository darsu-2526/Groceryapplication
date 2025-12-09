package Testscript;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.ManageCategoryPage;
import Utilities.ExcelUtilities;

public class ManageCategoryTest extends Base{
	public WebElement choosefile;

	@Test
	public void verifyUserIsAbleToAddNewCategory() throws IOException
	{
		String username=ExcelUtilities.getStringData(1, 0, "loginpage");
		String password=ExcelUtilities.getStringData(1, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterPassword(password);
		loginpage.clicksignin();
		
		String categogy="Test boutique";
		ManageCategoryPage managecategorypage=new ManageCategoryPage(driver);
		managecategorypage.clickMoreInfo();
		managecategorypage.clickAddNewButton();
		managecategorypage.selectCategoryField(categogy);
		managecategorypage.clickDiscount();
		managecategorypage.chooseImageFile();
		managecategorypage.clickSaveButton();
		boolean alert=managecategorypage.isAlertDisplayed();
		Assert.assertTrue(alert);
		
		
	}

}
