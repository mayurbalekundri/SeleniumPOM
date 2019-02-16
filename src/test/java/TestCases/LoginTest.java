package TestCases;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Pages.BasePage;
import Pages.LoginPage;

public class LoginTest extends BasePage {
	
	/*@BeforeSuite
	public void InitDriver() throws IOException{
		
		driver=GetBrowser();
	}*/
	
	
	@Test(priority=0)
	public void login() throws IOException
	{
	//	driver=GetBrowser();
		LoginPage lp=new LoginPage(driver);
	    Properties pr=GetTestData();
	    String user= pr.getProperty("username");
	    String pass=pr.getProperty("password");
	    lp.Login(user, pass);
		
		
	}

}
