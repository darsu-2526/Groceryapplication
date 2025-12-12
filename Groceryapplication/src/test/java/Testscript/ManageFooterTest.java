package Testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Constant.Constant;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ManageFooterPage;
import Utilities.ExcelUtilities;

public class ManageFooterTest extends Base {
	HomePage homepage;
	ManageFooterPage managefooterpage;
	@Test(description="updating footertext informations suchas address,email,phonenumber")
	public void verifyTheUserIsAbleToUpdateFooterTextInformations() throws IOException
	{
		String username=ExcelUtilities.getStringData(1, 0, "loginpage");
		String password=ExcelUtilities.getStringData(1, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage=loginpage.enterTheUsername(username).enterPassword(password);
		//loginpage.enterPassword(password);
		homepage=loginpage.clicksignin();
		
		//String address="Bangalore";
		//String email="darsana.gmail.com";
		//int phonenumber=1234567890;
		String address=ExcelUtilities.getStringData(1, 0, "managefooter");
		String email=ExcelUtilities.getStringData(1, 1, "managefooter");
		String phonenumber=ExcelUtilities.getIntegerData(1, 2, "managefooter");
		//ManageFooterPage managefooterpage=new ManageFooterPage(driver);
		
		managefooterpage=homepage.clickMoreInfoManageFooter();
		managefooterpage=managefooterpage.clickEdit().updateAddressField(address).updateEmailField(email)
				.updatePhoneNumberfield(phonenumber).clickUpdateButton();
		//managefooterpage.updateAddressField(address);
		//managefooterpage.updateEmailField(email);
		//managefooterpage.updatePhoneNumberfield(phonenumber);
		//managefooterpage.clickUpdateButton();
		boolean alert=managefooterpage.isAlertDisplayed();
		Assert.assertTrue(alert,Constant.UPDATEFOOTERTEXTINFORMATION);
		
				
		
	}

}
