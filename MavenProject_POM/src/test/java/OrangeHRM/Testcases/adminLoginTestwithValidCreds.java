package OrangeHRM.Testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import OrangeHRM.lib.Loginpage;
import Utilities.AppUtils;

public class adminLoginTestwithValidCreds extends AppUtils 

{
    @Test
	public void LoginTest()
	{
		
		Loginpage lp= PageFactory.initElements(driver, Loginpage.class) ;
		
		lp.OrangeHRMlogin();
		
		boolean res=lp.isAdminPageDisplayed();
		if (res)
		{
			
			Assert.assertTrue(res);
			
		}else
		{
			Assert.assertFalse(res);
			
		}
		
		lp.OrangeHRMlogout();
		
	}
	
    
    
	
}
