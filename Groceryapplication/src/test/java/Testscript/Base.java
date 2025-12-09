package Testscript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Constant.Constant;
import Utilities.ScreenshotUtilities;

public class Base {
	public WebDriver driver; 
	public FileInputStream fileinputstream;
	public Properties properties;
	@BeforeMethod(alwaysRun=true)
	@Parameters("browser")
	public void browserInitialisation(String browser) throws Exception 
	{
		try {
			properties=new Properties();
			fileinputstream=new FileInputStream(Constant.CONFIGFILE);
			properties.load(fileinputstream);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			throw new Exception("invalid");
		}
		driver=new ChromeDriver();
		driver.get("https://groceryapp.uniqassosiates.com/admin");
		driver.get(properties.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
	}
	@AfterMethod(alwaysRun=true)
	public void browserQuitAndClose(ITestResult iTestResult) throws IOException {
	
		if(iTestResult.getStatus()==ITestResult.FAILURE);
		{
		ScreenshotUtilities screenshotutilities=new ScreenshotUtilities();
		screenshotutilities.getScreenShot(driver,iTestResult.getName());
		//driver.close();
		//driver.quit();
		
	}
	}
	}




