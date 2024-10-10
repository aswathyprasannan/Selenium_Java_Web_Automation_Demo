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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import pages.DemoLogin;
import pages.DemoRegister;
import utilities.BaseClass;

public class DemoLoginTest 
{
	private WebDriver driver;
	
	@BeforeTest
	public void beforetest() throws InterruptedException
	{
		BaseClass bs 	= 	new BaseClass();
		driver 			= 	bs.initialize_driver();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	@Description("Test to view validation message on submitting an empty login form")
	@Severity(SeverityLevel.NORMAL)
	public void emptyLoginSubmission() throws Exception
	{
		DemoLogin ca = new DemoLogin(driver);
		ca.emptyLoginSubmission();
	}
	
	@Test(priority=2)
	@Description("Test to view validation message on submitting the login using invalid data")
	@Severity(SeverityLevel.NORMAL)
	public void invalidLoginSubmission() throws Exception
	{
		DemoLogin ca = new DemoLogin(driver);
		ca.invalidLoginSubmission();
	}
	
	@Test(priority=3)
	@Description("Test to submit the login using valid data")
	@Severity(SeverityLevel.CRITICAL)
	public void validLoginSubmission() throws Exception
	{
		DemoLogin ca = new DemoLogin(driver);
		ca.validLoginSubmission();	
	}
	
	@AfterClass
	public void close()
	{
		driver.quit();
	}
}
