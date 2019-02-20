package TestCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.BasePage;
import Pages.HomePage;

public class HomePageTest extends BasePage {
	public static Logger log = LogManager.getLogger(HomePageTest.class.getName());
	
	@Test(priority=0)
	public void ValidateTabs() throws IOException, InterruptedException{
		
	//	driver=GetBrowser();
		Actions act=new Actions(driver);
		HomePage hpt=new HomePage(driver);
		WebElement TMenu=hpt.MouseMoveToTab();
		act.moveToElement(TMenu).build().perform();
		Thread.sleep(4000);
		String ab[]={"Admin","PIM","Leave","Time","Recruitment","Performance","Help"};
		log.debug("Navigate to Home Page");
		
		List<WebElement>tabnames=hpt.GetTabName();
		int tabcount=tabnames.size();
		for(int i=0;i<tabcount;i++)
		{
			
			System.out.println(ab[i]+","+tabnames.get(i).getText());
			Assert.assertEquals(tabnames.get(i).getText(),ab[i]);
		}
		
	   log.error("Validating the Tab Names");
		
		
		
	}

}
