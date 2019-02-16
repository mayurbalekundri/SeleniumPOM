package Pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BasePage {

	public static WebDriver driver;

	@Test
	public WebDriver GetBrowser() throws IOException{


		Properties prop= new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\vineet\\SeleniumPOMWS\\SeleniumPOM\\src\\main\\java\\TestData\\BrowserURL.properties");
		prop.load(fis);

		String Browser=prop.getProperty("BrowserName");
		String url=prop.getProperty("URL");


		if (Browser.equals("Chrome"))
		{

			System.setProperty("webdriver.chrome.driver","C:\\Users\\vineet\\SeleniumPOMWS\\SeleniumPOM\\Driver\\chromedriver.exe");
			driver=new ChromeDriver();

		}else if(Browser.equals("Firefox"))
		{

			System.setProperty("webdriver.gecko.driver","C:\\Users\\vineet\\SeleniumPOMWS\\SeleniumPOM\\Driver\\geckodriver.exe");
			driver=new FirefoxDriver();


		}else if(Browser.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver","C:\\Users\\vineet\\SeleniumPOMWS\\SeleniumPOM\\Driver\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			
		}
		
		
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		return driver;
	}
	
	public Properties GetTestData() throws IOException{
		
		Properties p= new Properties();
		FileInputStream f=new FileInputStream("C:\\Users\\vineet\\SeleniumPOMWS\\SeleniumPOM\\src\\main\\java\\TestData\\TestingData.properties");
		p.load(f);
		return p;
	}
	
	@BeforeTest
	public void initdriver() throws IOException{
		
		driver=GetBrowser();
	}
	
	@AfterSuite
	public void BrowserClose(){
		
		driver.quit();
	}

}
