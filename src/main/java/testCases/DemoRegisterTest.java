package testCases;

import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import pages.DemoRegister;
import utilities.BaseClass;

public class DemoRegisterTest 
{
	private WebDriver driver;
	
	@BeforeClass
	@Parameters("browser")
	public void setup(String browser) throws Exception 
	{
		if (browser.equalsIgnoreCase("firefox")) 
		{
			driver = new FirefoxDriver();
			driver.get("https://parabank.parasoft.com/parabank/index.htm");
		} else if (browser.equalsIgnoreCase("chrome")) 
		{
			driver = new ChromeDriver();
			driver.get("https://parabank.parasoft.com/parabank/index.htm");
		} else if (browser.equalsIgnoreCase("Edge"))
		{
			driver = new EdgeDriver();
			driver.get("https://parabank.parasoft.com/parabank/index.htm");
			
		} else 
		{
			throw new Exception("Incorrect Browser");
			
		}
		driver.manage().window().maximize();
	}
	
	@Test(priority = 1)
	@Description("Test to verify the user redirects to register page")
	@Severity(SeverityLevel.NORMAL)
	
	public void redirectToRegisterPage() throws Exception
	{
		DemoRegister ca = new DemoRegister(driver);
	    ca.redirect_to_register_page();
    }
	
	 @DataProvider(name = "registrationData")
	 public Object[][] registrationData() 
	 {
		return new Object[][] {
		    {"445656", " " ,"Address1","state1", "City1","BN2 3E4", " ","67687798", "utharit@ ","utharit", "utharit"},
		    {"Ushari", "65665" ,"Address1","state1", "City1","BN23E4", "hhhoih","67687798", "ewtyetqyhrr@","utharit", "utharit6y65y"},
		};
	 }
	 
	 @Test(priority = 2)
	 @Description("Test to verify form submission with valid data sets")
	 @Severity(SeverityLevel.CRITICAL)
	 public void fillingRegisterForm() throws Exception 
	 {
		 DemoRegister ca = new DemoRegister(driver);
		 ca.fillingRegisterFormWithValidData();
	 }
	 
	 @Test(priority = 3)
	 @Description("Test to verify form submission with empty form")
	 @Severity(SeverityLevel.NORMAL)
	 public void submitEmptyRegistration() throws Exception 
	 {
		DemoRegister ca = new DemoRegister(driver);
		ca.submitEmptyRegistration();
	 }
	 
	 @Test(priority = 4,dataProvider = "registrationData")
	 @Description("Test to verify form submission with invalid data sets")
	 @Severity(SeverityLevel.NORMAL)
	 public void invalidRegistration(String firstName, String lastName, String address, 
			 String city, String state, String zipcode, String phone, String ssn, String username, 
			 String password, String repeatpassword) throws Exception 
	 {
		DemoRegister ca = new DemoRegister(driver);
		ca.invalidRegistration(firstName, lastName, address, city, state, zipcode, phone, ssn, 
								username, password, repeatpassword);
	 }
	 
	 @AfterClass
	 public void close()
	 {
		 driver.quit();
	 }
  }
