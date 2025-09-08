package tests;


import core.BaseTest;
import pages.ChangePasswordPage;
import pages.HomePage;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangePasswordTest extends BaseTest {

    @Test
    public void PasswordTest() throws InterruptedException {
    	 // Step 1: Go to Login Page
        HomePage homePage = new HomePage(driver);
        homePage.clickLogin();
   
        // Step 2: Login with valid credentials
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("devaharshinisighakolli@gmail.com");   // change with a valid user
        loginPage.enterPassword("Harshini@321");       // change with the right password
        loginPage.clickLogin();
        
        // Verify login
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login failed!");
        System.out.println("Login successful");

        //Change password
        
        ChangePasswordPage passpage = new ChangePasswordPage(driver);
        passpage.clickOpenMyAccount();
        passpage.enterOldPassword("Harshini@321");
        passpage.enterNewPassword("Harshini@123");
        passpage.confirNewPassword("Harshini@123");
        passpage.clickChangePassword();
        

    }
}
