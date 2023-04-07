package OrangeHRM.lib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage   

{
	//Page Object Model Object Repository 
	@FindBy(id="txtUsername")
	WebElement Login_uid;
	@FindBy(name="txtPassword")
	WebElement Login_pwd;
	@FindBy(id="btnLogin")
	WebElement Login;
	@FindBy(partialLinkText ="Welcome" )
	WebElement Welcomelink;
	@FindBy(linkText="Logout")
	WebElement Logout;
	
	@FindBy(linkText="Admin")
	WebElement Admintab;
	
	@FindBy(id="spanMessage")
	WebElement Invalidcredmsg;
	
	//functions on the page
	
	

	public void OrangeHRMlogin()
	
	{
		
		Login_uid.sendKeys("Admin");
		Login_pwd.sendKeys("Qedge113!@#");
		Login.click();	
		
	}
	
	
	public void OrangeHRMlogout()
	{
		
		Welcomelink.click();
		Logout.click();
		
	}
	
	
	public boolean isAdminPageDisplayed()
	{
		
		if (Admintab.isDisplayed())
		{
			 return true;
		}
		
		else {
			
			return false;
		}
	}
	
	
	public boolean isErerorMessageDispalyed()
	
	{
		
		if ( Invalidcredmsg.getText().contains("Invalid"))
			
		{
			return true;
			
		}else
		
		 {
			return false;
		}
		
		
		
	}
	
	
}
