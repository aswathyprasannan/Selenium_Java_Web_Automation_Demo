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

public class DemoRegister 
{
	private WebDriver driver;
	private SoftAssert softAssert = new SoftAssert();
	
	// Constructor
	public  DemoRegister (WebDriver driver)
	{
		this.driver = driver; 
	}
	
	By Register 					= 		By.xpath("//*[@id=\"loginPanel\"]/p[2]/a");
	By firstNameField 				= 		By.id("customer.firstName");
	By lastNameField  				= 		By.id("customer.lastName");
	By addressField  				= 		By.id("customer.address.street");
	By cityField  					= 		By.id("customer.address.city");
	By stateField 					= 		By.id("customer.address.state");
	By zipcodeField 				= 		By.id("customer.address.zipCode");
	By phoneField 					= 		By.id("customer.phoneNumber");
	By ssnField 					= 		By.id("customer.ssn");
	By usernameField 				= 		By.id("customer.username");
	By passwordField 				= 		By.id("customer.password");
	By repeatedPasswordField 		= 		By.id("repeatedPassword");
	By regsiterbutton 				= 		By.xpath("//input[@type='submit' and  @value='Register']");
	By loginsuccess 				= 		By.tagName("p"); 
	By logout 						= 		By.linkText("Log Out");
	By firstnameerror 				= 		By.id("customer.firstName.errors");
	By lastNameerror 				= 		By.id("customer.lastName.errors");
	By addresserror 				= 		By.id("customer.address.street.errors");
	By cityerror 					= 		By.id("customer.address.city.errors");
	By stateerror 					= 		By.id("customer.address.state.errors");
	By zipcodeerror 				= 		By.id("customer.address.zipCode.errors");
	By ssnerror 					= 		By.id("customer.ssn.errors");
	By usernameerror 				= 		By.id("customer.username.errors");
	By passworderror 				= 		By.id("customer.password.errors");
	By repeatpassworderror 			= 		By.id("repeatedPassword.errors");

	public void redirect_to_register_page() throws Exception
	{
		System.out.println("1");
		driver.findElement(Register).click();
		Allure.step("Clicked on Register");
		
		takeAndAttachScreenshot("Step 1: Initial State");//taking screenshot
		System.out.println("2");
        String currentUrl 			= 	driver.getCurrentUrl();
        String expectedPartialUrl 	= 	"https://parabank.parasoft.com/parabank/register.htm";
        Assert.assertTrue(currentUrl.contains(expectedPartialUrl), "The partial URL does not match!");
        Allure.step("Verify the url is as expected");
        WebElement titleElement 	= 	driver.findElement(By.cssSelector("h1.title"));
        String actualText 			= 	titleElement.getText();
        String expectedText 		= 	"Signing up is easy!";
        Assert.assertEquals(actualText, expectedText, "Text mismatch!");       
        Allure.step("Verify the 'Signing up is easy' is present on the page ");
        
        takeAndAttachScreenshot("Step 2: Final State");
        softAssert.assertAll();        
	}
	
	public void fillingRegisterFormWithValidData() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		try 
		{
		    wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys("Kiara");
			//driver.findElement(firstNameField).sendKeys("Kiara");
	        Allure.step("Entered firstname");
	        
	        takeAndAttachScreenshot("Step 1: Initial State");
	        driver.findElement(lastNameField).sendKeys("TK");
	        Allure.step("Entered lastNameField");
	        
	        takeAndAttachScreenshot("Step 2: After Action 1");
	        driver.findElement(addressField).sendKeys("Address Kiara");
	        Allure.step("Entered addressField");
	        
	        takeAndAttachScreenshot("Step 3: After Action 2");
	        driver.findElement(cityField).sendKeys("Manchester");
	        Allure.step("Entered cityField");
	        
	        takeAndAttachScreenshot("Step 4: After Action 3");
	        driver.findElement(stateField).sendKeys("Test state");
	        Allure.step("Entered stateField");
	        
	        takeAndAttachScreenshot("Step 5: After Action 4");
	        driver.findElement(zipcodeField).sendKeys("M12 345");
	        Allure.step("Entered zipcodeField");
	        
	        takeAndAttachScreenshot("Step 6: After Action 5");
	        driver.findElement(phoneField).sendKeys("07865 123456");
	        Allure.step("Entered phoneField");
	        
	        takeAndAttachScreenshot("Step 7: After Action 6");
	        driver.findElement(ssnField).sendKeys("45455656");
	        Allure.step("Entered ssnField");
	        
	        takeAndAttachScreenshot("Step 8: After Action 7");
	        driver.findElement(usernameField).sendKeys("Kiaratb");
	        Allure.step("Entered usernameField");
	        
	        takeAndAttachScreenshot("Step 9: After Action 8");
	        driver.findElement(passwordField).sendKeys("Kiaratb");
	        Allure.step("Entered passwordField");
	        
	        takeAndAttachScreenshot("Step 10: After Action 9");
	        driver.findElement(repeatedPasswordField).sendKeys("Kiaratb");
	        Allure.step("Entered repeatedPasswordField");
	        
	        takeAndAttachScreenshot("Step 11: After Action 10");
	        driver.findElement(regsiterbutton).click();
	        Allure.step("Click register button");
	        
	        takeAndAttachScreenshot("Step 12: After Action 11");
	        driver.findElement(logout).click();
	        Allure.step("Clicked Logout"); 
	        
	        takeAndAttachScreenshot("Step 13: Final State");
		} 
		catch (Exception e) 
		{
	        Allure.step("An error occurred: " + e.getMessage());
	        takeAndAttachScreenshot("Error State - General Exception");
	    }
	}
	
	public void testLogout() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		 try		 
		 {
		    driver.findElement(logout).click();
		    takeAndAttachScreenshot("Step 1: initial state");
		    Allure.step("Clicked Logout");
		 } 
		 catch (Exception e) 
		 {
		    Allure.step("An error occurred during logout: " + e.getMessage());
		    takeAndAttachScreenshot("Error State - General Exception");
		 }        
	}
	public void submitEmptyRegistration() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		try 
		{
			driver.findElement(Register).click();
	        Allure.step("Clicked Regiser");
	        
	        takeAndAttachScreenshot("Step 1: Initial state");
			driver.findElement(regsiterbutton).click();
	        Allure.step("Clicked Register button with leaving all form fields blank");
	        
	        takeAndAttachScreenshot("Step 2: After Action 1");
			WebElement errormsgfirstname 	= 	driver.findElement(By.id("customer.firstName.errors"));
	        String actualfirstname 			= 	errormsgfirstname.getText();
	        String expectedconfirmpassword 	= 	"First name is required.";
	        Assert.assertEquals(actualfirstname, expectedconfirmpassword, "First name is required.");
		} 
		catch (Exception e) 
		{
	        Allure.step("An error occurred during registration: " + e.getMessage());
	        takeAndAttachScreenshot("Error State - General Exception");
	    }
	}
     
	public void invalidRegistration(String firstName, String lastName, String address, String city, 
									String state, String zipcode, String phone, String ssn, String username, 
									String password, String repeatpassword) throws Exception 
	{        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try 
        {
            // Find the elements
            WebElement firstNameInput 		= wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
            WebElement lastNameInput 		= wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField));
            WebElement addressInput 		= wait.until(ExpectedConditions.visibilityOfElementLocated(addressField));
            WebElement cityInput 			= wait.until(ExpectedConditions.visibilityOfElementLocated(cityField));
            WebElement stateInput 			= wait.until(ExpectedConditions.visibilityOfElementLocated(stateField));
            WebElement zipcodeInput 		= wait.until(ExpectedConditions.visibilityOfElementLocated(zipcodeField));
            WebElement phoneFieldInput		= wait.until(ExpectedConditions.visibilityOfElementLocated(phoneField));
            WebElement ssnInput 			= wait.until(ExpectedConditions.visibilityOfElementLocated(ssnField));
            WebElement usernameFieldInput 	= wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
            WebElement passwordFieldInput 	= wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
            WebElement repeatedPasswordFieldInput = wait.until(ExpectedConditions.visibilityOfElementLocated(repeatedPasswordField));
            WebElement registerInput 		= wait.until(ExpectedConditions.elementToBeClickable(regsiterbutton));

            // Fill the form
            fillInputField(firstNameInput, 		firstName, 		"Step 1: Initial State", "Entered first name");
            fillInputField(lastNameInput, 		lastName, 		"Step 2: After Action 1", "Entered last name");
            fillInputField(addressInput, 		address, 		"Step 3: After Action 2", "Entered address");
            fillInputField(cityInput, 			city, 			"Step 4: After Action 3", "Entered city");
            fillInputField(stateInput, 			state, 			"Step 5: After Action 4", "Entered state");
            fillInputField(zipcodeInput, 		zipcode, 		"Step 6: After Action 5", "Entered zipcode");
            fillInputField(phoneFieldInput, 	phone, 			"Step 7: After Action 6", "Entered phone");
            fillInputField(ssnInput, 			ssn, 			"Step 8: After Action 7", "Entered SSN");
            fillInputField(usernameFieldInput, 	username, 		"Step 9: After Action 8", "Entered username");
            fillInputField(passwordFieldInput, 	password, 		"Step 10: After Action 9", "Entered password");
            fillInputField(repeatedPasswordFieldInput, repeatpassword, "Step 11: After Action 10", "Entered confirm password");

            // Click the register button
            registerInput.click();
            Allure.step("Clicked Register");

            // Validate error messages for each field
            validateFieldError(firstName, 	firstnameerror, 	"First Name is required.", 	"Step 12: Empty First Name Error");
            validateFieldError(lastName, 	lastNameerror, 		"Last name is required.", 	"Step 13: Empty Last Name Error");
            validateFieldError(address, 	addresserror, 		"Address is required.", 	"Step 14: Empty Address Error");
            validateFieldError(city, 		cityerror, 			"City is required.", 		"Step 15: Empty City Error");
            validateFieldError(state, 		stateerror, 		"State is required.", 		"Step 16: Empty State Error");
            validateFieldError(zipcode, 	zipcodeerror, 		"Zip Code is required.", 	"Step 17: Empty Zip Code Error");
            validateFieldError(phone, 		phoneField, 		"Phone number is required.", "Step 18: Empty Phone Number Error");
            validateFieldError(ssn, 		ssnerror, 			"SSN is required.", 		"Step 19: Empty SSN Error");
            validateFieldError(username, 	usernameerror, 		"Username is required.", 	"Step 20: Empty Username Error");
            validateFieldError(password, passworderror, 		"Password is required.", 	"Step 21: Empty Password Error");
            validateFieldError(repeatpassword, repeatpassworderror, "Password confirmation is required.", "Step 22: Empty Password Confirmation Error");

            // Check if passwords match
            if (!password.equals(repeatpassword)) 
            {
                WebElement passwordError = wait.until(ExpectedConditions.visibilityOfElementLocated(repeatpassworderror));
                Assert.assertTrue(passwordError.isDisplayed(), "Passwords did not match.");
                Assert.assertEquals(passwordError.getText(), "Passwords did not match.", "Unexpected password mismatch error message.");
                takeAndAttachScreenshot("Step 23: Mismatched Password Error");
            }

        } 
        catch (Exception e) 
        {
            // Handle exceptions and take a screenshot
            takeAndAttachScreenshot("Step X: Exception Occurred");
            System.err.println("An error occurred during registration: " + e.getMessage());
            throw e; // Rethrow the exception if needed
        }
    }

    // Helper method to fill input fields
    private void fillInputField(WebElement element, String value, String screenshotStep, 
    							String stepDescription) 
    {
        element.clear();
        element.sendKeys(value);
        Allure.step(stepDescription);
        takeAndAttachScreenshot(screenshotStep);
    }

    // Unified validation method for all fields
    private void validateFieldError(String input, By errorLocator, String expectedErrorMessage, 
    								String screenshotStep) 
    {
        if (input.isEmpty()) 
        {
            WebElement errorElement = driver.findElement(errorLocator);
            Assert.assertTrue(errorElement.isDisplayed(), expectedErrorMessage);
            Assert.assertEquals(errorElement.getText(), expectedErrorMessage, "Unexpected error message.");
            takeAndAttachScreenshot(screenshotStep);
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

