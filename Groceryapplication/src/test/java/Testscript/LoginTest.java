package Testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Utilities.ExcelUtilities;

public class LoginTest extends Base {
	
		@Test(groups= {"regression"},retryAnalyzer=Retry.Retry.class)
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
		@Test
		public void verifyUserLoginUsingValidUsernameAndInvalidPassword() throws IOException {
			String username=ExcelUtilities.getStringData(2, 0, "loginpage");
			String password=ExcelUtilities.getStringData(2, 1, "loginpage");
			LoginPage loginpage=new LoginPage(driver);
			loginpage.enterTheUsername(username);
			loginpage.enterPassword(password);
			loginpage.clicksignin();
			boolean alert=loginpage.isAlertDisplayed();
			Assert.assertTrue(alert);
			}
		
		@Test//invalid username and valid password
		public void VerifyUserLoginUsingInvalidUsernameAndValidPassword() throws IOException
		{
			String username=ExcelUtilities.getStringData(3, 0, "loginpage");
			String password=ExcelUtilities.getStringData(3, 1, "loginpage");
			LoginPage loginpage=new LoginPage(driver);
			loginpage.enterTheUsername(username);
			loginpage.enterPassword(password);
			loginpage.clicksignin();
			boolean alert=loginpage.isAlertDisplayed();
			Assert.assertTrue(alert);
		}
		
		@Test//invalid username and invalid password
		public void VerifyUserLoginUsingInvalidUsernameAndInvalidPassword() throws IOException
		{
			String username=ExcelUtilities.getStringData(4, 0, "loginpage");
			String password=ExcelUtilities.getStringData(4, 1, "loginpage");
			LoginPage loginpage=new LoginPage(driver);
			loginpage.enterTheUsername(username);
			loginpage.enterPassword(password);
			loginpage.clicksignin();
			boolean alert=loginpage.isAlertDisplayed();
			Assert.assertTrue(alert);
			
		}

	}



