package pages;

import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import io.qameta.allure.Allure;

public class DemoLogin 
{
	private WebDriver driver;
	private SoftAssert softAssert = new SoftAssert();
	
	// Constructor
	public DemoLogin (WebDriver driver)
	{
		this.driver = driver; 
	}
  
	By Login_button = By.xpath("//input[@type='submit' and  @value='Log In']");
	By username = By.xpath("//input[@name='username']");
	By logo_image = By.className("logo");
	By password = By.name("password");
	
	public void emptyLoginSubmission()
	{
		try 
		{
			 driver.findElement(Login_button).click();
			 Allure.step("Clicked on Login button");
			 
			 takeAndAttachScreenshot("Step 1: Initial State");//taking screenshot
			 WebElement titleElement 	= 	driver.findElement(By.xpath("//div[@id='rightPanel']/p"));
			 String actualText 			= 	titleElement.getText();
			 String expectedText 		= 	"Please enter a username and password.";
			 Assert.assertEquals(actualText, expectedText, "Text mismatch!");       
			 Allure.step("Verify the error message displayed");
			 
			 takeAndAttachScreenshot("Step 2: Final State");
			 //softAssert.assertAll();		
		} 
		catch (NoSuchElementException e) 
		{
	        Allure.addAttachment("Error", "Element not found: " + e.getMessage());
	    } 
		catch (AssertionError e) 
		{
	        Allure.addAttachment("Assertion Error", e.getMessage());
	    } 
		catch (Exception e) 
		{
	        Allure.addAttachment("Unexpected Error", e.getMessage());
	    } 
		finally 
		{
	        softAssert.assertAll();
	    }
	}
	public void invalidLoginSubmission() throws InterruptedException
	{
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
	   try 
	   {
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(logo_image)).click();
			Allure.step("Clicked on Logo image");
			
			takeAndAttachScreenshot("Step 1: Initial State");//taking screenshot
			wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys("$%%Gge");
			Allure.step("Entered invalid username");
			
			takeAndAttachScreenshot("Step 2: After Action 1");
			Allure.step("Left password field blank");
			wait.until(ExpectedConditions.elementToBeClickable(Login_button)).click(); 
			Allure.step("Clicked on Login button");
			
			takeAndAttachScreenshot("Step 3: After Action 2");
			WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='rightPanel']/p")));
			String actualText = titleElement.getText();
			String expectedText = "Please enter a username and password.";
			Assert.assertEquals(actualText, expectedText, "Text mismatch!");       
			Allure.step("Verify the validation message displayed");
			
			takeAndAttachScreenshot("Step 4: After Action 2");
	   
	   } 
	   catch (NoSuchElementException e) 
	   {
	        Allure.step("Element not found: " + e.getMessage());
	        takeAndAttachScreenshot("Error State - Element Not Found");
	     
	   } 
	   catch (Exception e) 
	   {
	        Allure.step("An error occurred: " + e.getMessage());
	        takeAndAttachScreenshot("Error State - General Exception");
	   }
	   finally 
	   {
	        softAssert.assertAll();
   		}	   
	}
   public void validLoginSubmission() throws InterruptedException
   {
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	   try
	   {
			wait.until(ExpectedConditions.elementToBeClickable(logo_image)).click();
			Allure.step("Clicked on Logo image");
			
			takeAndAttachScreenshot("Step 1: Initial State");
			wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys("Kiarats");
			Allure.step("Entered valid username");
			
			takeAndAttachScreenshot("Step 2: After Action 1");
	        wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys("Kiarats");
			Allure.step("Entered valid password");
			
			takeAndAttachScreenshot("Step 3: After Action 2");
	        wait.until(ExpectedConditions.elementToBeClickable(Login_button)).click();
			Allure.step("Clicked on Login button");
			
			takeAndAttachScreenshot("Step 4: After Action 3");
	        wait.until(ExpectedConditions.urlToBe("https://parabank.parasoft.com/parabank/overview.htm"));
			String currentUrl = driver.getCurrentUrl();
			String expectedUrl = "https://parabank.parasoft.com/parabank/overview.htm";
			Assert.assertEquals(currentUrl,expectedUrl,"The URLs do not match");
			Allure.step("Verified the home page aftter successful log in");
			
			takeAndAttachScreenshot("Step 5: After Action 6");
	   } 
	   catch (NoSuchElementException e) 
	   {
	        Allure.step("Element not found: " + e.getMessage());
	        takeAndAttachScreenshot("Error State - Element Not Found");	        
	   } 
	   catch (Exception e) 
	   {
	        Allure.step("An error occurred: " + e.getMessage());
	        takeAndAttachScreenshot("Error State - General Exception");	       
	   }
	   finally 
	   {
	        softAssert.assertAll();
	   }
	}
   
	private void takeAndAttachScreenshot(String stepName) 
	{
		// Take a screenshot
		byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		
		// Attach the screenshot to Allure report with a step name
		Allure.addAttachment(stepName, new ByteArrayInputStream(screenshot));
	}
}



