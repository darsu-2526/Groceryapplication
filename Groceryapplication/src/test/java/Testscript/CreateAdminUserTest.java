package Testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.CreateAdminUserPage;
import Pages.LoginPage;
import Utilities.ExcelUtilities;

public class CreateAdminUserTest extends Base {
	@Test
	public void verifyUserIsAbleToCreateNewAdminUser() throws IOException {
		
		String username=ExcelUtilities.getStringData(1, 0, "loginpage");
		String password=ExcelUtilities.getStringData(1, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterPassword(password);
		loginpage.clicksignin();
		
		String adminusername=ExcelUtilities.getStringData(1, 0, "adminusers");
		String adminpassword=ExcelUtilities.getStringData(1, 1, "adminusers");
		CreateAdminUserPage createadminuserpage=new CreateAdminUserPage(driver);
		createadminuserpage.clickMoreInfo();
		createadminuserpage.clickNewButton();
		createadminuserpage.enterUsername(adminusername);
		createadminuserpage.enterPassword(adminpassword);
		createadminuserpage.selectUserType();
		createadminuserpage.clickSave();
		boolean alert=createadminuserpage.isAlertDisplayed();
		Assert.assertTrue(alert);
		
		
	}

}
