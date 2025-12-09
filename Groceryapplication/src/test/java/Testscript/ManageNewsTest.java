package Testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.ManageNewsPage;
import Utilities.ExcelUtilities;

public class ManageNewsTest extends Base {
	@Test
	
	public void verifyTheUserIsAbleToAddNews() throws IOException
	{
		String username=ExcelUtilities.getStringData(1, 0, "loginpage");
		String password=ExcelUtilities.getStringData(1, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUsername(username);
		loginpage.enterPassword(password);
		loginpage.clicksignin();
		
		String news=ExcelUtilities.getStringData(1, 0, "news");
		ManageNewsPage managenewspage=new ManageNewsPage(driver);
		managenewspage.clickMoreInfo();
		managenewspage.clickNewButton();
		managenewspage.enterNews(news);
		managenewspage.clickSave();
		boolean alert=managenewspage.isAlertDisplayed();
		Assert.assertTrue(alert);
		
		
	}

}
