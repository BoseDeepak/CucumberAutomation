package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddcustomerPage {
	
	
public WebDriver ldriver;
   
	
	public AddcustomerPage(WebDriver rdriver) {
	
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	
	By lnkCustomers_menu = By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	By lnkCustomers_menuitem = By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");
	
	By btnAddnew = By.xpath("//i[@class='fas fa-plus-square']");
	
	By txtemail = By.xpath("//input[@name='Email']");
	By txtpassword = By.xpath("//input[@name='Password']");
	
	By txtCustomerRoles = By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
	
	By lstitemAdministrators  = By.xpath("//li[contains(text(),'Administrators')]");
	By lstitemRegistered = By.xpath("//li[contains(text(),'Registered')]");
	By lstitemGuest = By.xpath("//li[contains(text(),'Guests')]");
	By lstitemVendors = By.xpath("//li[contains(text(),'Vendors')]");
	
	By drpmgrOfVendor = By.xpath("//select[@id='VendorId']");
	By rdMaleGender = By.xpath("//input[@id='Gender_Male']");
	By rdFemaleGender = By.xpath("//input[@id='Gender_Male']");
	
	
	By txtFirstName = By.xpath("//input[@name='FirstName']");
	By txtLastName = By.xpath("//input[@name='LastName']");
	
	By txtDob = By.xpath("//input[@id='DateOfBirth']");
	
	By txtCompanyName = By.xpath("//input[@name='Company']");
	
	By txtAdminContent = By.xpath("//textarea[@name='AdminComment']");
	By btnSave = By.xpath("//button[@name='save']");
	
	
	
	
	
	By company = By.xpath("//input[@name='Company']");
	By Istaxextempt = By.xpath("//label[text()='Is tax exempt']");
	
	
	By comment = By.xpath("//textarea[@name='AdminComment']");
	
	
	//******** Action methods ************
	
	
	
 public String getPageTitle() {
		
		return ldriver.getTitle();
		
	}
	
	
  public void clickonCustomersMenu() {
		
		ldriver.findElement(lnkCustomers_menu).click();
		
	}
	
   public void clickonCustomersMenuItem() {
		
		ldriver.findElement(lnkCustomers_menuitem).click();
		
	}
   
   public void clickonAddnew() {
		
		ldriver.findElement(btnAddnew).click();
		
	}
   
   
   public void setEmail(String email) {
	   
	   ldriver.findElement(txtemail).sendKeys(email);
		
	}
   
    public void setpassword(String password) {
	   
	   ldriver.findElement(txtpassword).sendKeys(password);
		
	}
    
    
    public void setFirstName(String FirstName) {
 	   
 	   ldriver.findElement(txtFirstName).sendKeys(FirstName);
 		
 	}
    
    
    public void setLastName(String LastName) {
  	   
  	   ldriver.findElement(txtLastName).sendKeys(LastName);
  		
  	}
    
    public void setCompanyName(String CompanyName) {
   	   
   	   ldriver.findElement(txtCompanyName).sendKeys(CompanyName);
   		
   	}
    
    public void setAdminContent(String AdminContent) {
    	   
    	   ldriver.findElement(txtAdminContent).sendKeys(AdminContent);
    		
    }
    
    public void setDob(String dob) {
 	   
 	   ldriver.findElement(txtDob).sendKeys(dob);

    }
    
    
    
    public void setCustomerRoles(String role) throws InterruptedException {
 	   
    	JavascriptExecutor js = (JavascriptExecutor)ldriver;
   	    js.executeScript("window.scrollBy(0,2000)");
    	
 	   
    	if(!role.equals("Vendors"))
    	{
    		ldriver.findElement(By.xpath(""));
    		
    	}
    	
    	ldriver.findElement(txtCustomerRoles).click();
    	
    	WebElement listitem;
    	
    	Thread.sleep(3000);
    	
    	if(role.equals("Administrators")) 
    	{
    		listitem = ldriver.findElement(lstitemAdministrators);
    		
    	}
    	
    	else if(role.equals("Guest")) 
    	{
    		listitem = ldriver.findElement(lstitemGuest);
    		
    	}
    	
    	else if(role.equals("Registered")) 
    	{
    		listitem = ldriver.findElement(lstitemRegistered);
    		
    	}
    	
    	else if(role.equals("Vendors")) 
    	{
    		listitem = ldriver.findElement(lstitemVendors);
    		
    	}
    	
    	else
    	{
    		listitem = ldriver.findElement(lstitemGuest);
    	}
    	
    	listitem.click();
    	
    	//JavascriptExecutor js = (JavascriptExecutor)ldriver;
    	//js.executeScript("arguments[0].click()", "listitem");
 		
 	}
    
   public void setManagerOfVendor(String Value) {
	   
	   
	   Select drp = new Select(ldriver.findElement(drpmgrOfVendor));
	   drp.selectByVisibleText(Value);  
	   
     }
     
   
   public void setGender(String gender) {
	   
	   if(gender.equals("Male")) 
	   {
		   ldriver.findElement(rdMaleGender).click();
		   
	   }else if(gender.equals("Female"))
	   {
		   ldriver.findElement(rdFemaleGender).click();
	   }
	   
	   else 
	   {
		   ldriver.findElement(rdMaleGender).click();
	   }
	   
	   
     }
   
    public void clickOnSave() {
		
		ldriver.findElement(btnSave).click();
		
	 }
    
    
    
    
    
    
   
   
    
   
   
	
	
	
	
	
	
	
	
}
