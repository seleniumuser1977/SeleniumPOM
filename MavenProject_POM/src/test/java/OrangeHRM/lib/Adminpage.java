package OrangeHRM.lib;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class Adminpage
{

	@FindBy(linkText="Admin")
	WebElement Admintab;
	
	@FindBy(linkText="User Management")
	WebElement UserMgmt;
	
	@FindBy(name="btnAdd")
	WebElement AddUser;
	
	
	@FindBy(id="systemUser_userType")
	WebElement Usertype;
	@FindBy(id="systemUser_employeeName_empName")
	WebElement EmployeeName; 
	
	@FindBy(id="systemUser_userName")
	WebElement Username; 
	
	@FindBy(id="systemUser_status")
	WebElement Userstatus;
	
	@FindBy(id="systemUser_password")
	WebElement Password;
	
	@FindBy(id="systemUser_confirmPassword")
	WebElement Confirmpassword;
	
	@FindBy(name="btnSave")
	WebElement Save;
	
	@FindBy(id="searchSystemUser_userName")
	WebElement Searchuser;
	
    @FindBy(id="searchBtn")	
	WebElement Searchbtn;
	
    @FindBy(id="resultTable")
    WebElement Usertable;
	
//Method to Add User Access	
	public void Adduser(String UserRole, String empfirstname,String emplastname,String UserName,String UserStatus,String pwd)
	{
		
		String Empname=	String.join(" ",emplastname);
		
		Admintab.click();
		
		UserMgmt.click();
		
		AddUser.click();
		
		Select typeofUser=new Select(Usertype);
				
		typeofUser.selectByVisibleText(UserRole);
		
		EmployeeName.sendKeys(Empname);
		
		Username.sendKeys(UserName);
		
		Select statusofuser =new Select(Userstatus);
		
		statusofuser.deselectByVisibleText(UserStatus);
		
		Password.sendKeys(pwd);
		
		Save.click();
		
		
	}
	
//Method to search User 	
	public boolean usersearch(String UserName)
	
	{
		boolean flag=false;
		Searchuser.sendKeys(UserName);
		
		List<WebElement> Userrows= Usertable.findElements(By.tagName("tr"));
		
		for ( int i=1;i<=Userrows.size();i++)
			
		{
			
			
			List <WebElement> usercols=Userrows.get(i).findElements(By.tagName("td"));
					
				if (usercols.get(i).getText().equals(UserName))
									
				
				{
					flag=true;
					break;
					
				}
								
		}
		
		return flag;
		
		
		
	}
}
