package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="txtUsername")
	WebElement username;
	
	@FindBy(id="txtPassword")
	WebElement password;
	
	@FindBy(name="Submit")
	WebElement login;
	
	@FindBy(name="preview-frame")
	WebElement LoginFrame;
	
	public void Login(String UserName,String Password){
		
		driver.switchTo().frame(LoginFrame);
		username.sendKeys(UserName);
		password.sendKeys(Password);
		login.click();

		
	}
	
}
