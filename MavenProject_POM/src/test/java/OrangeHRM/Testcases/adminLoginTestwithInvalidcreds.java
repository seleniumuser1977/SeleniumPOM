package OrangeHRM.Testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import OrangeHRM.lib.Loginpage;
import Utilities.AppUtils;

public class adminLoginTestwithInvalidcreds extends AppUtils

{
    @Test 
	public void adminloginwithinvalidcreds()
	{
		
		Loginpage lp=PageFactory.initElements(driver, Loginpage.class);
		
		lp.OrangeHRMlogin();
		boolean res=lp.isErerorMessageDispalyed();
		
		if (res)
		{
			
			Assert.assertTrue(res);
		}else
		{
			Assert.assertFalse(res);
			
		}
		
		
		
		
	}
	
	
	
}
