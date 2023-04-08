package OrangeHRM.lib;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Emplyoeepage

{

	@FindBy(linkText="PID")
	WebElement PIMlink;
	
	@FindBy(id="menu_pim_addEmployee")
	WebElement AddEmployee;
	
	@FindBy(name="firstName")
	WebElement Firstname;
	
	@FindBy(name="middleName")
	WebElement Middlename;
	
	@FindBy(name="lastName")
	WebElement Lastanme;
	
	@FindBy(name="employeeId")
	WebElement EmployeeId;
	@FindBy(id="btnSave")
	WebElement Save;
	
	@FindBy(linkText="Employee List")
	WebElement Emplist;
	
	@FindBy (id="empsearch_id")
	WebElement EmpsearchId;
	
	@FindBy ( id="searchBtn")
	WebElement Search;
	
	@FindBy(id="resultTable")
	WebElement EmpresultTable;
	
	@FindBy(className="head")
	WebElement PersonalDetails;
	String EmpId;
	
	@FindBy(id="ui-datepicker-div")
	WebElement datepicker;
	
	@FindBy(className="ui-datepicker-calendar")
	WebElement uidatepickercalendar;
	
	@FindBy(className="ui-datepicker-year")
	WebElement datepickeryear;
	
	@FindBy(className="ui-datepicker-month")
	WebElement datepickermonth;
	
	@FindBy(id="personal_optGender_1")
	WebElement genderM;
	
	@FindBy(id="personal_optGender_2")
	WebElement genderF;
	
	@FindBy(id="personal_cmbMarital")
	WebElement Maritalstatusoption;
	
	@FindBy(id="personal_cmbNation")
	WebElement Nationalitylist;
	
	@FindBy(id="personal_DOB")
	WebElement empDOB;
	
	//method to Add Employee
	public String AddEmplyee( String empfirstname,String emplastname)
	{
	
	    
		PIMlink.click();
		AddEmployee.click();
		
		Firstname.sendKeys(empfirstname);
		Lastanme.sendKeys(emplastname);		
	    EmpId=EmployeeId.getAttribute("Value");
		Save.click();
		
		return EmpId;
	}
	
	//method to search Employee
	
	public boolean verifyEmployee( String EmpId)
	
	{
	
		Emplist.click();
		EmpsearchId.sendKeys(EmpId);
		Search.click();
		
		List<WebElement> Emprows= EmpresultTable.findElements(By.tagName("tr"));
		
        boolean flag=false;
		for (int i=1;i<=Emprows.size();i++)
        	
        {
		
        	List<WebElement> Empcols=Emprows.get(i).findElements(By.tagName("td"));
        	
               	        	
        	if ( Empcols.get(i).getText().equals(EmpId))
        		
        	{
        		flag=true;
        		return flag;
        		
        	}		
        
         }
		
		return flag;
       
	}
			
//Method to add Employee Personal details	
public void Addemployeepersonaldetails(String EmpId,String Licensedate,String Gender,String Mstatus,String Nstatus,String DOB)
{
		boolean flag =false;
		Emplist.click();
		EmpsearchId.sendKeys(EmpId);
		Search.click();
		
		List<WebElement> Emprows= EmpresultTable.findElements(By.tagName("tr"));
		
       
  try {
			
		
		for (int i=1;i<=Emprows.size();i++)
        	
        {
		
        	List<WebElement> Empcols=Emprows.get(i).findElements(By.tagName("td"));
        	
               	        	
        	if ( Empcols.get(i).getText().equals(EmpId))
        		
        	{
        		Empcols.get(i).click();
        		break;
        		
        	}		
        
         }

		
		
		if (PersonalDetails.getText().equalsIgnoreCase("Personal Details"))
			
		{
			
			
			Save.click();
			datepicker.click();
							
			String[] licdate= Licensedate.split("-");
			
			String licdt=licdate[0];
			String licmonth=licdate[1];
			String licyear=licdate[2];
			
		        			
			Select licenseyear= new Select(datepickeryear);
			licenseyear.selectByVisibleText(licyear);
			
			Select licensemonth=new Select(datepickermonth);
			licensemonth.selectByVisibleText(licmonth);
			
			
			//Working with selecting a date on the table rows
			
			List<WebElement> daterows= uidatepickercalendar.findElements(By.tagName("tr"));
				
				for (int i=1;i<=daterows.size();i++)
				
				{
				
				List<WebElement> datecols= daterows.get(i).findElements(By.tagName("td"));
							
					
					for ( WebElement element:datecols)
				
					{
						if (element.getText().equalsIgnoreCase(licdt) )
						
						{
						  element.click();
						  break;
					
					     }
				
					
				     }	
		         }
				
				
		    	if ( Gender.equalsIgnoreCase("Male"))
				
				{
				genderM.click();	
				}
		    	else
		    	{
		    		genderF.click();
		    		
		    	}
				
				
			Select MartialStatus= new Select(Maritalstatusoption);
			MartialStatus.selectByVisibleText(Mstatus);
			
			Select Nationality= new Select(Nationalitylist);
			Nationality.selectByVisibleText(Nstatus);
			
			
			empDOB.sendKeys(DOB);
			
			Save.click();
				
		  }			

	}catch (Exception e)	
		{
			
			Assert.assertFalse(flag);
		}
			
		
  }		



}	
	

	
	
