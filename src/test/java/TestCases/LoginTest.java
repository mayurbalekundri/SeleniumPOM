package TestCases;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Pages.BasePage;
import Pages.LoginPage;

public class LoginTest extends BasePage {
	
	/*@BeforeSuite
	public void InitDriver() throws IOException{
		
		driver=GetBrowser();
	}*/
	public static Logger log = LogManager.getLogger(LoginTest.class.getName());
	
	@Test(priority=0)
	public void login() throws IOException
	{
	//	driver=GetBrowser();
		LoginPage lp=new LoginPage(driver);
	    Properties pr=GetTestData();
	    String user= pr.getProperty("username");
	    String pass=pr.getProperty("password");
	    lp.Login(user, pass);
		log.debug("Logging Successfully");
		
	}

}
