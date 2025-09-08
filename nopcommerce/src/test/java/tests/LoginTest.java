package tests;



import core.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

	@Test
	public void loginTestValidCredentials() throws InterruptedException {
		// Go to login page
		HomePage home = new HomePage(driver);
		home.clickLogin();

		LoginPage login = new LoginPage(driver);
		login.enterEmail("shaik123@gmail.com");
		login.enterPassword("Test@123");
		login.clickLogin();

		// Check login result
		if (login.isLoginSuccessful()) {
			System.out.println("Login successful! My Account link is visible.");
			Assert.assertTrue(true); // test passes
		} else {
			String errorMsg = login.getLoginErrorMessage();
			System.out.println("Login failed with error: " + errorMsg);
			Assert.assertFalse(true, "Login failed: " + errorMsg); // fail the test
		}
	}

	@Test
	public void loginTestInvalidEmail() throws InterruptedException {
	    // Go to login page
	    HomePage home = new HomePage(driver);
	    home.clickLogin();

	    LoginPage login = new LoginPage(driver);
	    login.enterEmail("Invalid@gmail.com");
	    login.enterPassword("wrongPassword123");
	    login.clickLogin();

	    // Check login result
	    if (!login.isLoginSuccessful()) {
	        String errorMsg = login.getLoginErrorMessage();
	        System.out.println("Login failed as expected. Error: " + errorMsg);
	        Assert.assertTrue(errorMsg.contains("Login was unsuccessful"), 
	                          "Expected login failure but got: " + errorMsg);
	    } else {
	        System.out.println("Login unexpectedly succeeded!");
	        Assert.fail("Login succeeded with invalid credentials!");
	    }
	}
	
	@Test
	public void loginTestInvalidPassword() throws InterruptedException {
	    // Go to login page
	    HomePage home = new HomePage(driver);
	    home.clickLogin();

	    LoginPage login = new LoginPage(driver);
	    login.enterEmail("shaik123@gmail.com");
	    login.enterPassword("wrongPassword123");
	    login.clickLogin();

	    // Check login result
	    if (!login.isLoginSuccessful()) {
	        String errorMsg = login.getLoginErrorMessage();
	        System.out.println("Login failed as expected. Error: " + errorMsg);
	        Assert.assertTrue(errorMsg.contains("Login was unsuccessful"), 
	                          "Expected login failure but got: " + errorMsg);
	    } else {
	        System.out.println("Login unexpectedly succeeded!");
	        Assert.fail("Login succeeded with invalid credentials!");
	    }
	}

	@Test
	public void loginTestBlankCredentials() throws InterruptedException {
	    HomePage home = new HomePage(driver);
	    home.clickLogin();

	    LoginPage login = new LoginPage(driver);
	    login.enterEmail("");   // blank
	    login.enterPassword(""); // blank
	    login.clickLogin();

	    String errorMsg = login.getLoginErrorMessage();
	    System.out.println("Error for blank login: " + errorMsg);

	    Assert.assertTrue(
	        errorMsg.contains("Please enter your email") || 
	        errorMsg.contains("Login was unsuccessful"),
	        "Expected validation for blank credentials but got: " + errorMsg
	    );
	}


}
