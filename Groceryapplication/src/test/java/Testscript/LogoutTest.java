package Testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Constant.Constant;
import Pages.LoginPage;
import Pages.LogoutPage;
import Pages.HomePage;
import Utilities.ExcelUtilities;

public class LogoutTest extends Base {
	HomePage homepage;

	@Test(description="logout from the system")
	public void verifyUserIsAbleToLogout() throws IOException
	{
		
		String username=ExcelUtilities.getStringData(1, 0, "loginpage");
		String password=ExcelUtilities.getStringData(1, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterPassword(password);
		loginpage.clicksignin();
		LogoutPage logoutpage=new LogoutPage(driver);
		logoutpage.clickAdmin();
		logoutpage.selectLogout();
		logoutpage.isSigninDisplayed();
		boolean signin=logoutpage.isSigninDisplayed();
		Assert.assertTrue(signin,Constant.LOGOUTFROMTHESYSTEM);
	}
}
