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
	
	
//Method to login OrangeHRM WebSite
	public boolean OrangeHRMlogin(String uid,String pwd)
	
	{
		
		Login_uid.sendKeys(uid);
		Login_pwd.sendKeys(pwd);
		Login.click();	
		if ( Welcomelink.getText().contains(uid))
		{
			
			return true;
		}else
		{
			return false;
			
		}				
		
	}
	
//Method to logout OrangeHRM webSite	
	public boolean OrangeHRMlogout()
	{
		
		Welcomelink.click();
		Logout.click();
		
		if ( Login.isDisplayed())
		{	
		
			return true;
		}else
			
		{
			return false;
			
		}
		
		
	}
	
//Method to check whether Admin page Displayed or not
	
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
	
//Method to check whether Login error messages  Displayed or not for invalid login	
	
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
