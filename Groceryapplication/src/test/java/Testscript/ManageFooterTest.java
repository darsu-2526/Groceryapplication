package Testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.ManageFooterPage;
import Utilities.ExcelUtilities;

public class ManageFooterTest extends Base {
	@Test
	public void verifyTheUserIsAbleToUpdateFooterTextInformations() throws IOException
	{
		String username=ExcelUtilities.getStringData(1, 0, "loginpage");
		String password=ExcelUtilities.getStringData(1, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterPassword(password);
		loginpage.clicksignin();
		
		//String address="Bangalore";
		//String email="darsana.gmail.com";
		//int phonenumber=1234567890;
		String address=ExcelUtilities.getStringData(1, 0, "managefooter");
		String email=ExcelUtilities.getStringData(1, 1, "managefooter");
		String phonenumber=ExcelUtilities.getIntegerData(1, 2, "managefooter");
		ManageFooterPage managefooterpage=new ManageFooterPage(driver);
		
		managefooterpage.clickMoreInfo();
		managefooterpage.clickEdit();
		managefooterpage.updateAddressField(address);
		managefooterpage.updateEmailField(email);
		managefooterpage.updatePhoneNumberfield(phonenumber);
		managefooterpage.clickUpdateButton();
		boolean alert=managefooterpage.isAlertDisplayed();
		Assert.assertTrue(alert);
		
				
		
	}

}
