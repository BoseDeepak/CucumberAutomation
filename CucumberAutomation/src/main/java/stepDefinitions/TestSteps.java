package stepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.codehaus.plexus.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjects.AddcustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;



public class TestSteps extends BaseClass {
	
	
	
	@Before
	public void setup() throws IOException {
		
		
		configProp = new Properties();
		FileInputStream configPropFile = new FileInputStream("config.properties");
		configProp.load(configPropFile);
		
		
		logger=logger.getLogger("CucumberAutomation"); //Addded Logger
		PropertyConfigurator.configure("E:\\Java\\Latest Eclipse\\Demo_Workspace\\CucumberAutomation\\ Log4j.properties");
		logger.info("******Launching Browser********");
		
		String br = configProp.getProperty("browser");
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
			driver = new ChromeDriver();
		}
		
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", configProp.getProperty("firefoxpath"));
			driver = new FirefoxDriver();
		}
		
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", configProp.getProperty("iepath"));
			driver = new InternetExplorerDriver();
		}
		
		
	}	
	
	@Given("User Launch Chrome Browser")
	public void User_Launch_Chrome_Browser()
	{
		
		lp = new LoginPage(driver);
		logger.info("*********  Launching URL*********");
		
	}
	
	
	@When("User Opens URL {string}")
	public void user_opens_URL(String URL) throws InterruptedException {
		
		logger.info("******Opening URL********");
		Thread.sleep(2000);
		driver.get(URL);
		driver.manage().window().maximize();
	}
	
	
	@When("User Enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
		logger.info("******Providing Valid User Details********");
		lp.setUserName(email);
		lp.setPassword(password);
	}
	
	
	@And("Click on Login")
	public void click_on_login() throws InterruptedException {
		
		logger.info("******Started Login********");
		lp.clickLogin();
		Thread.sleep(3000);
	}
	
	
	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) {
	    
		if(driver.getPageSource().contains("Login was unsuccessful."))
		{
			driver.close();
			logger.info("******Login passed********");
			System.out.println("Login Failed");
			Assert.assertTrue(false);
			
		}else {
			logger.info("******Login Failed********");
			Assert.assertEquals(title, driver.getTitle());
			//System.out.println("Title Verified and login successful");
		}
		
		
	 }
	
	
	@When("User click on Logout Link")
	public void user_click_on_logout_link() throws InterruptedException {
	    
		logger.info("******click on Logout Link********");
		lp.clickLogout();
		Thread.sleep(4000);
	}
	
	
	@Then("close browse")
	public void close_browse() {
		logger.info("******Closing Browser********");
		driver.quit();
	}
	
	
	// ******** Customers Feature Step Definations

	
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() throws InterruptedException {
		Thread.sleep(3000);
		addCust = new AddcustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
		
	}
	
	
	@When("User clicks on customer menu")
	public void user_clicks_on_customer_menu() throws InterruptedException {
	   
		Thread.sleep(4000);
		addCust.clickonCustomersMenu();
		
	}
	
	@When("Click on customer Menu Iteam")
	public void click_on_customer_menu_iteam() throws InterruptedException {
	   
		Thread.sleep(3000);
		addCust.clickonCustomersMenuItem();
		
	}
	
	
	@When("Click on Add new button")
	public void click_on_add_new_button() throws InterruptedException {
		Thread.sleep(3000);
		addCust.clickonAddnew();
		
	}
	
	
	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
	    
		Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
		
	}
	
	
	@When("User enter customers info")
	public void user_enter_customers_info() throws InterruptedException {
		logger.info("******Adding new customer********");
		String email = randomestring()+"@gmail.com";
		
		addCust.setEmail(email);
		addCust.setpassword("test@123");
		
		Thread.sleep(1000);
		addCust.setFirstName("Pavan1");
		Thread.sleep(1000);
		addCust.setLastName("Pandey");
		Thread.sleep(2000);
		
		addCust.setGender("Male");
		Thread.sleep(2000);
		
		addCust.setDob("7/05/1985");
		Thread.sleep(1000);
		
		addCust.setCompanyName("TCS");
		Thread.sleep(1000);
		
		//addCust.setCustomerRoles("Guest");
		//Thread.sleep(2000);
		
		addCust.setManagerOfVendor("Vendor 2");
		Thread.sleep(2000);
		
		addCust.setAdminContent("This is for Demo Testing");
		Thread.sleep(1000);
		
		
		
		
	}
	
	
	@When("click on save button")
	public void click_on_save_button() throws InterruptedException {
		logger.info("******Saving customer Data********");
		addCust.clickOnSave();
		Thread.sleep(4000);
		
	}
	
	
	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) {
	    
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully."));
		
	}
	
	
	@Then("close brower")
	public void close_brower() {
	    
		driver.quit();
	}
	
	
	
	
	//****************Steps for searching customer using email**************
	
	
	@And ("Enter customer Email")
	public void Enter_customer_Email() {
		logger.info("******Search cutomer by email id********");
		searchCust = new SearchCustomerPage(driver);
		searchCust.setEmail("victoria_victoria@nopCommerce.com");
		
	 }
	
	
	
	@When ("Click on search button")
	public void Click_on_search_button() {
		
		searchCust.ClickSearch();
		
	 }
	
	@Then ("User should found Email in the search table")
	public void User_should_found_Email_in_the_search_table() {
		
		//System.out.println(searchCust.getNoOfColumns());
		//System.out.println(searchCust.getNoOfRows());
		
		boolean status = searchCust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		Assert.assertEquals(true, status);
		
	 }
	
	
	//****************Steps for searching customer using FirstName and LastName **************
	
	
	
	
	@And ("Enter customer FirstName")
	public void Enter_customer_FirstName() {
		logger.info("******Searching customer by name********");
		searchCust = new SearchCustomerPage(driver);
		searchCust.setFirstName("Victoria");
		
	  }
	 
	@And ("Enter customer LastName")
	public void Enter_customer_LastName() {
		
		searchCust.setLastName("Terces");
		
	   }
	
	@Then ("User should found name in the search table")
	public void User_should_found_name_in_the_search_table() {
		
		boolean status = searchCust.searchCustomerByName("Victoria Terces");
		Assert.assertEquals(true, status);
		
		
	 }
	
	
	
	
	
	
	

}
