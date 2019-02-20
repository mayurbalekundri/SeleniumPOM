package Pages;




import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterSuite;


import org.testng.annotations.BeforeSuite;

import org.testng.annotations.Test;

public class BasePage {

	public static WebDriver driver;
	public static Logger log = LogManager.getLogger(BasePage.class.getName());
	public static String ProjectBasePath="C:\\Users\\Mayur\\SeleniumPageObjectWS\\";
	
	@Test
	public WebDriver GetBrowser() throws IOException{


		Properties prop= new Properties();
		FileInputStream fis=new FileInputStream(ProjectBasePath+"SeleniumPOM\\src\\main\\java\\TestData\\BrowserURL.properties");
		prop.load(fis);

		String Browser=prop.getProperty("BrowserName");
		String url=prop.getProperty("URL");
       
        
		if (Browser.equals("Chrome"))
		{

			System.setProperty("webdriver.chrome.driver",ProjectBasePath+"SeleniumPOM\\Driver\\chromedriver.exe");
			driver=new ChromeDriver();

		}else if(Browser.equals("Firefox"))
		{

			System.setProperty("webdriver.gecko.driver",ProjectBasePath+"SeleniumPOM\\Driver\\geckodriver.exe");
			driver=new FirefoxDriver();


		}else if(Browser.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver",ProjectBasePath+"SeleniumPOM\\Driver\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			
		}
		
		
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		log.info("Open the Browser");
		String title=driver.getTitle();
		log.info("Title of the page is "+title);
		return driver;
	}
	
	public Properties GetTestData() throws IOException{
		
		Properties p= new Properties();
		FileInputStream f=new FileInputStream(ProjectBasePath+"SeleniumPOM\\src\\main\\java\\TestData\\TestingData.properties");
		p.load(f);
		return p;
	}

	
	@BeforeSuite
	public void initdriver() throws IOException{
		
		driver=GetBrowser();
	}
	
	@AfterSuite
	public void BrowserClose(){
		
		driver.quit();
		log.info("Closing the all open windows");
	}

}
