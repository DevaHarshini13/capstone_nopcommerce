package tests;



import core.BaseTest;
import pages.*;

import java.util.UUID;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class E2ERegisterTest extends BaseTest {

	@Test
	public void testEndToEndEcommerceFlow() throws InterruptedException {
		// Step 1: Go to Login Page
		HomePage homePage = new HomePage(driver);
		homePage.clickRegister();

		// Step 2:Registration
		RegisterPage register = new RegisterPage(driver);
		register.selectGenderMale();
		register.enterFirstName("Harshini");
		register.enterLastName("sighakolli");

		// Generate unique email to avoid duplicate
		// String email = "devaharshinisighakolli@gmail.com";
		String email = "Harshini" + UUID.randomUUID().toString().substring(0, 5) + "@gmail.com"; // New user
		register.enterEmail(email);

		register.enterPassword("Harshini@321");
		register.enterConfirmPassword("Harshini@321");
		register.clickRegister();

		Thread.sleep(2000);

		// Verify Register
		By successMsg = By.className("result");
		String message = driver.findElement(successMsg).getText();
		Assert.assertTrue(message.contains("Your registration completed"), "Registration Failed: " + message);

		System.out.println("Registration successful for: " + email);

		// Step 3: Search for a product
		ProductSearchPage searchPage = new ProductSearchPage(driver);
		searchPage.searchProduct("laptop"); // search keyword
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

		// step 5: Address details

		AddressPage address = new AddressPage(driver);
		address.selectNewCountry();
		address.selectNewState();
		address.enterNewCity("Kurnool");
		address.enterNewFirstAddress("Rajvihar Road");
		address.enterNewPostalCode("518001");
		address.enterNewPhoneNumber("7071789648");

		// complete checkout process

		CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage.proceedThroughCheckout();

		// Step 6: Assert order confirmation page
		String pageSource = driver.getPageSource();
		Assert.assertTrue(pageSource.contains("Your order"), "Order not confirmed!");
		System.out.println("Order placed successfully!");
	}
}

