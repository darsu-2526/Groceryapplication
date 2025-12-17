package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtilities;

public class ManageNewsTest extends Base {
	HomePage homepage;
	ManageNewsPage managenewspage;
	@Test(description="adding new news by the user")
	
	public void verifyTheUserIsAbleToAddNews() throws IOException
	{
		String username=ExcelUtilities.getStringData(1, 0, "loginpage");
		String password=ExcelUtilities.getStringData(1, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage=loginpage.enterTheUsername(username).enterPassword(password);
		//loginpage.enterPassword(password);
		homepage=loginpage.clicksignin();
		
		String news=ExcelUtilities.getStringData(1, 0, "news");
		//ManageNewsPage managenewspage=new ManageNewsPage(driver);
		managenewspage=homepage.clickMoreInfoManageNews();
		managenewspage=managenewspage.clickNewButton().enterNews(news).clickSave();
		//managenewspage.enterNews(news);
		//managenewspage.clickSave();
		boolean alert=managenewspage.isAlertDisplayed();
		Assert.assertTrue(alert,Constant.ADDINGNEWS);
		
		
	}

}
