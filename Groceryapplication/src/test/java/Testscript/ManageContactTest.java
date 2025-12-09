package Testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.ManageContactPage;
import Utilities.ExcelUtilities;

public class ManageContactTest extends Base {
	
	@Test
	public void verifyUserIsAbleToUpdateContactDetails() throws IOException 
	{
		String username=ExcelUtilities.getStringData(1, 0, "loginpage");
		String password=ExcelUtilities.getStringData(1, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterPassword(password);
		loginpage.clicksignin();
		
		
		
		ManageContactPage managecontactpage=new ManageContactPage(driver);
		String  phonenumber=ExcelUtilities.getIntegerData(1, 0, "managecontact");
		String email=ExcelUtilities.getStringData(1, 1, "managecontact");
		String address=ExcelUtilities.getStringData(1, 2, "managecontact");
		String deliverytime=ExcelUtilities.getIntegerData(1, 3, "managecontact");
		String deliverychargelimit=ExcelUtilities.getIntegerData(1, 4, "managecontact");
		managecontactpage.clickMoreinfo();
		managecontactpage.clickEdit();
		managecontactpage.updateAddress(address);
		managecontactpage.updatePhonenumber(phonenumber);
		managecontactpage.updateEmail(email);
		managecontactpage.updateDeliveryTime(deliverytime);
		managecontactpage.updateDeliveryChargeLimit(deliverychargelimit);
		managecontactpage.clickUpdate();
		boolean alert=managecontactpage.alertDisplayed();
		Assert.assertTrue(alert);
		
		
		
		
		
		
		
		}
	

}
