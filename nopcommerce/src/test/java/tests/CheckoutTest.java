package tests;


import core.BaseTest;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void cartTest() throws InterruptedException {
    	 // Step 1: Go to Login Page
        HomePage homePage = new HomePage(driver);
        homePage.clickLogin();
   
        // Step 2: Login with valid credentials
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("devaharshinisighakolli@gmail.com");   // change with a valid user
        loginPage.enterPassword("Harshini@123");       // change with the right password
        loginPage.clickLogin();
        
        // Verify login
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login failed!");
        System.out.println("Login successful");

       //open cart page
        
        CartPage cartPage = new CartPage(driver);
        cartPage.clickOpenCart();
        cartPage.clikAcceptTerm();
        cartPage.proceedToCheckout();
        System.out.println("Navigated to cart and proceeding to checkout");    
        
        //checkout process
        
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.proceedThroughCheckout();
        
    }
}
