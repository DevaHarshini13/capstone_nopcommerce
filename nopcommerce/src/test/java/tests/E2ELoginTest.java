package tests;



import core.BaseTest;
import pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class E2ELoginTest extends BaseTest {

    @Test
    public void testEndToEndEcommerceFlow() throws InterruptedException {
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

        // Step 3: Search for a product
        ProductSearchPage searchPage = new ProductSearchPage(driver);
        searchPage.searchProduct("laptop");   // search keyword
        searchPage.selectFirstProduct();
        searchPage.addToCart();
        searchPage.clickClose();
        System.out.println("Product added to cart");

        // Step 4: Proceed to cart
        CartPage cartPage = new CartPage(driver);
        cartPage.clickOpenCart();
        cartPage.clikAcceptTerm();
        cartPage.proceedToCheckout();
        System.out.println("Navigated to cart and proceeding to checkout");   

        //complete checkout process
        
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.proceedThroughCheckout();

        // Step 6: Assert order confirmation page
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("Your order"), "Order not confirmed!");
        System.out.println("Order placed successfully!");
    }
}
