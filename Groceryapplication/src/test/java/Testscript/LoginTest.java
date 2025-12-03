package Testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Utilities.ExcelUtilities;

public class LoginTest extends Base {
	
		@Test
		public void verifyUserIsAbleToLoginUsingValidCredentials() throws IOException {
			String username=ExcelUtilities.getStringData(1, 0, "loginpage");
			String password=ExcelUtilities.getStringData(1, 1, "loginpage");
			LoginPage loginpage=new LoginPage(driver);
			loginpage.enterTheUsername(username);
			loginpage.enterPassword(password);
			loginpage.clicksignin();
			boolean homepage=loginpage.isHomePageDisplayed();
			Assert.assertTrue(homepage);
			}
		

}
