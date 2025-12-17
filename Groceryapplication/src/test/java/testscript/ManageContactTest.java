package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtilities;

public class ManageContactTest extends Base {
	HomePage homepage;
	ManageContactPage managecontactpage;
	
	@Test(description="updating contact details such as address,phonenumber,email,deliverytime,deliverychargelimit by admin user")
	public void verifyUserIsAbleToUpdateContactDetails() throws IOException 
	{
		String username=ExcelUtilities.getStringData(1, 0, "loginpage");
		String password=ExcelUtilities.getStringData(1, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage=loginpage.enterTheUsername(username).enterPassword(password);
		//loginpage.enterPassword(password);
		homepage=loginpage.clicksignin();
		
		
		
		//ManageContactPage managecontactpage=new ManageContactPage(driver);
		String  phonenumber=ExcelUtilities.getIntegerData(1, 0, "managecontact");
		String email=ExcelUtilities.getStringData(1, 1, "managecontact");
		String address=ExcelUtilities.getStringData(1, 2, "managecontact");
		String deliverytime=ExcelUtilities.getIntegerData(1, 3, "managecontact");
		String deliverychargelimit=ExcelUtilities.getIntegerData(1, 4, "managecontact");
		managecontactpage=homepage.clickManageContactPageMoreinfo();
		managecontactpage=managecontactpage.clickEdit().updateAddress(address)
				.updatePhonenumber(phonenumber).updateEmail(email).updateDeliveryTime(deliverytime)
				.updateDeliveryChargeLimit(deliverychargelimit).clickUpdate();
		//managecontactpage.updateAddress(address);
		//managecontactpage.updatePhonenumber(phonenumber);
		//managecontactpage.updateEmail(email);
		//managecontactpage.updateDeliveryTime(deliverytime);
		//managecontactpage.updateDeliveryChargeLimit(deliverychargelimit);
		//managecontactpage.clickUpdate();
		boolean alert=managecontactpage.alertDisplayed();
		Assert.assertTrue(alert,Constant.UPDATECONTACTDETAILS);
		
		
		
		
		
		
		
		}
	

}
