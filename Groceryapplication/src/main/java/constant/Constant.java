package constant;

public class Constant {
	//path of the resources
	public static final String TESTDATAFILE=System.getProperty("user.dir")+"\\src\\test\\resources\\testdata.xlsx";//single slash to double slash;
	public static final String TESTIMAGE=System.getProperty("user.dir")+"\\src\\test\\resources\\image1.jpg";
	public static final String CONFIGFILE=System.getProperty("user.dir")+"\\src\\main\\resources\\resources\\config.properties";
	
	//error messages
	public static final String ADDINGNEWADMINUSER="success message not displayed after adding new admin user";
	public static final String LOGINWITHVALIDCREDENTIALS="home page not loaded while trying to login with  valid credentials";
	public static final String LOGINWITHVALIDUSERNAMEANDINVALIDPASSWORD="home page loaded while trying to login with valid username and invalid password";
	public static final String LOGINWITHINVALIDUSERNAMEANDVALIDPASSWORD="home page loaded while trying to login with invalid username and valid password";
	public static final String LOGINWITHINVALIDUSERNAMEANDINVALIDPASSWORD="home page loaded while tryimg to login with invalid username and invalid password";
	public static final String LOGOUTFROMTHESYSTEM="not redirected to loginpage after logout";
	public static final String ADDINGNEWCATEGORY="success message not displayed after adding new category";
	public static final String UPDATECONTACTDETAILS="success message not displayed after updating contact details";
	public static final String UPDATEFOOTERTEXTINFORMATION="success message not displayed after updating the footertext informations";
	public static final String ADDINGNEWS="success message not displayed after adding new news";
	
}

