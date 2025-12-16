package Testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Constant.Constant;
import Pages.HomePage;
import Pages.LoginPage;
import Utilities.ExcelUtilities;

public class LoginTest extends Base {
	HomePage homepage;
	LoginPage loginpage;
	
		@Test(groups= {"regression"},retryAnalyzer=Retry.Retry.class,description="user login with valid credentials")
		public void verifyUserIsAbleToLoginUsingValidCredentials() throws IOException {
			String username=ExcelUtilities.getStringData(1, 0, "loginpage");
			String password=ExcelUtilities.getStringData(1, 1, "loginpage");
			//LoginPage loginpage=new LoginPage(driver);
			loginpage=loginpage.enterTheUsername(username).enterPassword(password);
			//loginpage.enterPassword(password);
			homepage=loginpage.clicksignin();
			boolean homepage=loginpage.isHomePageDisplayed();
			Assert.assertTrue(homepage,Constant.LOGINWITHVALIDCREDENTIALS);
			}
		@Test(description="userlogin with valid username and invalid password")
		public void verifyUserLoginUsingValidUsernameAndInvalidPassword() throws IOException {
			String username=ExcelUtilities.getStringData(2, 0, "loginpage");
			String password=ExcelUtilities.getStringData(2, 1, "loginpage");
			LoginPage loginpage=new LoginPage(driver);
			loginpage.enterTheUsername(username);
			loginpage.enterPassword(password);
			loginpage.clicksignin();
			boolean alert=loginpage.isAlertDisplayed();
			Assert.assertTrue(alert,Constant.LOGINWITHVALIDUSERNAMEANDINVALIDPASSWORD);
			}
		
		@Test(description="user login with invalid username and valid password")
		public void VerifyUserLoginUsingInvalidUsernameAndValidPassword() throws IOException
		{
			String username=ExcelUtilities.getStringData(3, 0, "loginpage");
			String password=ExcelUtilities.getStringData(3, 1, "loginpage");
			LoginPage loginpage=new LoginPage(driver);
			loginpage.enterTheUsername(username);
			loginpage.enterPassword(password);
			loginpage.clicksignin();
			boolean alert=loginpage.isAlertDisplayed();
			Assert.assertTrue(alert,Constant.LOGINWITHINVALIDUSERNAMEANDVALIDPASSWORD);
		}
		
		@Test(description="userlogin with invalid username and invalid password",dataProvider ="LoginProvider")
		public void VerifyUserLoginUsingInvalidUsernameAndInvalidPassword(String username,String password) throws IOException
		{
			//String username=ExcelUtilities.getStringData(4, 0, "loginpage");
			//String password=ExcelUtilities.getStringData(4, 1, "loginpage");
			LoginPage loginpage=new LoginPage(driver);
			loginpage.enterTheUsername(username);
			loginpage.enterPassword(password);
			loginpage.clicksignin();
			boolean alert=loginpage.isAlertDisplayed();
			Assert.assertTrue(alert,Constant.LOGINWITHINVALIDUSERNAMEANDINVALIDPASSWORD);
			
		}
		@DataProvider(name="LoginProvider")
		public Object[][] getDataFromTestData() throws IOException{
			return new Object[][] {{ExcelUtilities.getStringData(4, 0,"loginpage"),ExcelUtilities.getStringData(4,1,"loginpage")}};
			
		
		
		}

	}



