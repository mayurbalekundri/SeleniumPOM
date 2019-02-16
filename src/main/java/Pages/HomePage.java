package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;
	public HomePage(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li[@class='l1']/a/span")
	List<WebElement> Tabs;
	
	@FindBy(xpath="//span[.='PIM']")
	WebElement TabMenu;
	
	public List<WebElement> GetTabName(){
		
		return Tabs;
	}
	
	public WebElement MouseMoveToTab(){
		
		return TabMenu;
		
	}

}
