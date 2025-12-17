package testscript;

import java.io.IOException;
import java.lang.invoke.ConstantBootstraps;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.CreateAdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtilities;
import utilities.FakerUtilities;

public class CreateAdminUserTest extends Base {
	CreateAdminUserPage createadminuserpage;
	HomePage homepage;
	@Test(description="create new admin user with valid username and password")
	public void verifyUserIsAbleToCreateNewAdminUser() throws IOException {
		
		String username=ExcelUtilities.getStringData(1, 0, "loginpage");
		String password=ExcelUtilities.getStringData(1, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage=loginpage.enterTheUsername(username).enterPassword(password);
		//loginpage.enterPassword(password);
		homepage=loginpage.clicksignin();
		FakerUtilities fakerutilities=new FakerUtilities();
		String adminusername=fakerutilities.creatARandomFirstName();
		String adminpassword=fakerutilities.creatARandomFirstName();
		//String adminusername=ExcelUtilities.getStringData(1, 0, "adminusers");
		//String adminpassword=ExcelUtilities.getStringData(1, 1, "adminusers");
		//CreateAdminUserPage createadminuserpage=new CreateAdminUserPage(driver);
		createadminuserpage=homepage.clickMoreInfoCreateAdminUser();
		createadminuserpage.clickNewButton().enterUsername(adminusername).enterPassword(adminpassword).selectUserType().clickSave();
		//createadminuserpage.enterUsername(adminusername);
		//createadminuserpage.enterPassword(adminpassword);
		//createadminuserpage.selectUserType();
		//createadminuserpage.clickSave();
		boolean alert=createadminuserpage.isAlertDisplayed();
		Assert.assertTrue(alert,Constant.ADDINGNEWADMINUSER);
		
		
	}

}
