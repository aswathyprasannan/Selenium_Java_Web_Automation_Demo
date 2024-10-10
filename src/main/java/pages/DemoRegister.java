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
	        driver.findElement(usernameField).sendKeys("Kiarats");
	        Allure.step("Entered usernameField");
	        
	        takeAndAttachScreenshot("Step 9: After Action 8");
	        driver.findElement(passwordField).sendKeys("Kiarats");
	        Allure.step("Entered passwordField");
	        
	        takeAndAttachScreenshot("Step 10: After Action 9");
	        driver.findElement(repeatedPasswordField).sendKeys("Kiarats");
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
//	public void invalidRegistration(String firstName, String lastName, String address, String city, String state, String zipcode, String phone, String ssn, String username, String password, String repeatpassword ) throws Exception 
//	{
		
//	  WebElement firstNameInput = driver.findElement(firstNameField);
//      WebElement lastNameInput = driver.findElement(lastNameField);
//      WebElement addressInput = driver.findElement(addressField);
//      WebElement cityInput = driver.findElement(cityField);
//      WebElement stateInput = driver.findElement(stateField);
//      WebElement zipcodeInput = driver.findElement(zipcodeField);
//      WebElement phoneFieldInput = driver.findElement(phoneField);
//      WebElement ssnInput=driver.findElement(ssnField);
//      WebElement usernameFieldInput=driver.findElement(usernameField);
//      WebElement passwordFieldInput=driver.findElement(passwordField);
//      WebElement repeatedPasswordFieldInput=driver.findElement(repeatedPasswordField);
//      WebElement registerInput=driver.findElement(regsiterbutton);
//      Thread.sleep(4000);
//      firstNameInput.clear();
//      firstNameInput.sendKeys(firstName);
//      Allure.step("Entered firstname");
//	  takeAndAttachScreenshot("Step 1: Initial State");//taking screenshot
//
//      lastNameInput.clear();
//      lastNameInput.sendKeys(lastName);
//      Allure.step("Entered lastName");
//	  takeAndAttachScreenshot("Step 2: After Action 1");//taking screenshot
//
//      addressInput.clear();
//      addressInput.sendKeys(address);
//      Allure.step("Entered address");
//	  takeAndAttachScreenshot("Step 3: After Action 2");//taking screenshot
//
//      cityInput.clear();
//      cityInput.sendKeys(city);
//      Allure.step("Entered city");
//	  takeAndAttachScreenshot("Step 4: After Action 3");//taking screenshot
//
//      stateInput.clear();
//      stateInput.sendKeys(state);
//      Allure.step("Entered state");
//	  takeAndAttachScreenshot("Step 5: After Action 4");//taking screenshot
//
//      zipcodeInput.clear();
//      zipcodeInput.sendKeys(zipcode);
//      Allure.step("Entered zipcode");
//	  takeAndAttachScreenshot("Step 6: After Action 5");//taking screenshot
//
//      phoneFieldInput.clear();
//      phoneFieldInput.sendKeys(phone);
//      Allure.step("Entered phone");
//	  takeAndAttachScreenshot("Step 7: After Action 6");//taking screenshot
//
//      ssnInput.clear();
//      ssnInput.sendKeys(ssn);
//      Allure.step("Entered ssn");
//	  takeAndAttachScreenshot("Step 8: After Action 7");//taking screenshot
//
//      usernameFieldInput.clear();
//      usernameFieldInput.sendKeys(username);
//      Allure.step("Entered username");
//	  takeAndAttachScreenshot("Step 9: After Action 8");//taking screenshot
//
//      passwordFieldInput.clear();
//      passwordFieldInput.sendKeys(password);
//      Allure.step("Entered password");
//	  takeAndAttachScreenshot("Step 10: After Action 9");//taking screenshot
//
//      repeatedPasswordFieldInput.clear();
//      repeatedPasswordFieldInput.sendKeys(repeatpassword);
//      Allure.step("Entered confirm password");
//	  takeAndAttachScreenshot("Step 11: After Action 10");//taking screenshot
//
//      registerInput.click();
//      Allure.step("Clicked Register");
//      Thread.sleep(4000);
	 
   
//      if (firstName.isEmpty()) {
//          WebElement firstNameError = driver.findElement(firstnameerror); 
//          Assert.assertTrue(firstNameError.isDisplayed(), "First name is required.");
//          Assert.assertEquals(firstNameError.getText(), "First Name is required.", "Unexpected first name error message.");
//          takeAndAttachScreenshot("Step 12: Empty First Name Error");
//         
//      }
//      if (lastName.isEmpty()) {
//          WebElement lastNameError = driver.findElement(lastNameerror); 
//          Assert.assertTrue(lastNameError.isDisplayed(), "Last name is required.");
//          Assert.assertEquals(lastNameError.getText(), "Last name is required.", "Unexpected first name error message.");
//          takeAndAttachScreenshot("Step 12: Empty First Name Error");
//          
//
//      }
//      if (address.isEmpty()) {
//    	    WebElement addressError = driver.findElement(addresserror); 
//    	    Assert.assertTrue(addressError.isDisplayed(), "Address is required.");
//    	    Assert.assertEquals(addressError.getText(), "Address is required.", "Unexpected address error message.");
//    	    takeAndAttachScreenshot("Step 13: Empty Address Error");
//    	}
//
//    	if (city.isEmpty()) {
//    	    WebElement cityError = driver.findElement(cityerror); 
//    	    Assert.assertTrue(cityError.isDisplayed(), "City is required.");
//    	    Assert.assertEquals(cityError.getText(), "City is required.", "Unexpected city error message.");
//    	    takeAndAttachScreenshot("Step 14: Empty City Error");
//    	}
//
//    	if (state.isEmpty()) {
//    	    WebElement stateError = driver.findElement(stateerror); 
//    	    Assert.assertTrue(stateError.isDisplayed(), "State is required.");
//    	    Assert.assertEquals(stateError.getText(), "State is required.", "Unexpected state error message.");
//    	    takeAndAttachScreenshot("Step 15: Empty State Error");
//    	}
//
//    	if (zipcode.isEmpty()) {
//    	    WebElement zipcodeError = driver.findElement(zipcodeerror); 
//    	    Assert.assertTrue(zipcodeError.isDisplayed(), "Zipcode is required.");
//    	    Assert.assertEquals(zipcodeError.getText(), "Zip Code is required.", "Unexpected zipcode error message.");
//    	    takeAndAttachScreenshot("Step 16: Empty Zip Code Error");
//    	}
//
//    	if (phone.isEmpty()) {
//    	    WebElement phoneError = driver.findElement(phoneField); 
//    	    Assert.assertTrue(phoneError.isDisplayed(), "Phone number is required.");
//    	    Assert.assertEquals(phoneError.getText(), "Phone number is required.", "Unexpected phone error message.");
//    	    takeAndAttachScreenshot("Step 17: Empty Phone Number Error");
//    	}
//
//    	if (ssn.isEmpty()) {
//    	    WebElement ssnError = driver.findElement(ssnerror); 
//    	    Assert.assertTrue(ssnError.isDisplayed(), "SSN is required.");
//    	    Assert.assertEquals(ssnError.getText(), "SSN is required.", "Unexpected SSN error message.");
//    	    takeAndAttachScreenshot("Step 18: Empty SSN Error");
//    	}
//
//    	if (username.isEmpty()) {
//    	    WebElement usernameError = driver.findElement(usernameerror); 
//    	    Assert.assertTrue(usernameError.isDisplayed(), "Username is required.");
//    	    Assert.assertEquals(usernameError.getText(), "Username is required.", "Unexpected username error message.");
//    	    takeAndAttachScreenshot("Step 19: Empty Username Error");
//    	}
//
//      if (password.isEmpty()) {
//          WebElement passwordError = driver.findElement(passworderror); 
//          Assert.assertTrue(passwordError.isDisplayed(), "Password error message is not displayed.");
//          Assert.assertEquals(passwordError.getText(), "Password is required.", "Unexpected password error message.");
//          takeAndAttachScreenshot("Step 15: Empty Password Error");
//      }
//      if (repeatpassword.isEmpty()) {
//          WebElement passwordconfrError = driver.findElement(repeatpassworderror); 
//          Assert.assertTrue(passwordconfrError.isDisplayed(), "Password confirmation is required.");
//          Assert.assertEquals(passwordconfrError.getText(), "Password confirmation is required.", "Unexpected confirm password error message.");
//          takeAndAttachScreenshot("Step 15: Empty Password Error");
//      }
//      if (!password.equals(repeatpassword)) {
//          WebElement passwordError = driver.findElement(repeatpassworderror); 
//          Assert.assertTrue(passwordError.isDisplayed(), "Passwords did not match.");
//          Assert.assertEquals(passwordError.getText(), "Passwords did not match.", "Unexpected password mismatch error message.");
//          takeAndAttachScreenshot("Step 12: Mismatched Password Error");
//      }
	       
	
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

