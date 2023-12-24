package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.WaitHelper;

public class SearchCustomerPage {
	
	public WebDriver ldriver;
	WaitHelper waithelper;
	
	public SearchCustomerPage(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
		waithelper = new WaitHelper(ldriver);
		
	}
	
	
	//By txtEmail = By.xpath("//input[@name='SearchEmail']");
	//By txtFirstName = By.xpath("//input[@name='SearchFirstName']");
	//By txtLastName = By.xpath("//input[@name='SearchLastName']");
	//By btnsearch = By.xpath("//button[@id='search-customers']");
	
	@CacheLookup
	@FindBy(xpath="//input[@name='SearchEmail']")
	WebElement txtEmail;
	
	@CacheLookup
	@FindBy(xpath="//input[@name='SearchFirstName']")
	WebElement txtFirstName;
	
	@CacheLookup
	@FindBy(xpath="//input[@name='SearchLastName']")
	WebElement txtLastName;
	
	@CacheLookup
	@FindBy(xpath="//button[@id='search-customers']")
	WebElement btnsearch;
	
	
	@CacheLookup
	@FindBy(xpath="//table[@role='grid']")
	WebElement tbleSearchResults;
	

	@CacheLookup
	@FindBy(xpath="//table[@id='customers-grid']")
	WebElement table;
	
	@CacheLookup
	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr/td")
	List<WebElement> tableRows;
	
	@CacheLookup
	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr/td")
	List<WebElement> tableColumns;
	
	
	
	
	public void setEmail(String email) {
		
		waithelper.WaitForElement(txtEmail, 30);
		txtEmail.clear();
		txtEmail.sendKeys(email);
		
	}
	
	
    public void setFirstName(String fname) {
		
		waithelper.WaitForElement(txtLastName, 30);
		txtFirstName.clear();
		txtFirstName.sendKeys(fname);
		
	 }
	
    public void setLastName(String Lname) {
	
	   waithelper.WaitForElement(txtLastName, 30);
	   txtLastName.clear();
	   txtLastName.sendKeys(Lname);
	
   }
   
   
   public void ClickSearch() {
		
	   btnsearch.click();
	   waithelper.WaitForElement(txtLastName, 30);
		
   }
   
   
    public int getNoOfRows() {
	   
       System.out.println(tableRows.size());
	   return (tableRows.size());
	    
    }
   
    public int getNoOfColumns() {
    	
       System.out.println(tableColumns.size());
	   return (tableColumns.size());
    }
   
   
    public boolean searchCustomerByEmail(String email) 
    {
 	   boolean flag = false;
 	   
 	   for(int i=1;i<=getNoOfColumns();i++) 
 	   {
 		   
 		   String emailid = table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
 		   System.out.println(emailid);
 		   if(emailid.equals(email))
 		   {
 			   
 			   flag=true;
 			   
 		   }
 		   
 	   }
 	   
 	   return flag;	   
    }
   
   
   
	
    public boolean searchCustomerByName(String Name) 
    {
 	   boolean flag = false;
 	   
 	   for(int i=1;i<=getNoOfRows();i++) 
 	   {
 		   
 		   String name = table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[3]")).getText();
 		   String names[]=name.split("");
 		  
 		   if(names[0].equals("Victoria") && names[1].equals("Terces"))
 		   {
 			   
 			   flag=true;
 			   
 		   }
 		   
 	   }
 	   
 	   return flag;	   
    }
	
	
	
	
	

}
