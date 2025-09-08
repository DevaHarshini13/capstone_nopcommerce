package tests;


import core.BaseTest;
import pages.HomePage;
import pages.RegisterPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class RegisterTest extends BaseTest {

    @Test
    public void registerNewUser() throws InterruptedException {
        HomePage home = new HomePage(driver);
        home.clickRegister();

        //Register with valid details
        RegisterPage register = new RegisterPage(driver);
        register.selectGenderMale();
        register.enterFirstName("John");
        register.enterLastName("Doe");

        // Generate unique email to avoid duplicate
        //String email = "user25709@example.com";
        String email = "user" + UUID.randomUUID().toString().substring(0,5) + "@example.com"; // New user
        register.enterEmail(email);

        register.enterPassword("Test@123");
        register.enterConfirmPassword("Test@123");
        register.clickRegister();

        Thread.sleep(2000);  // wait 2 seconds
        
        // Check Registraion result
        if (register.isRegisterSuccessful()) {
            System.out.println("Register successful! My Account link is visible.");
            Assert.assertTrue(true); // test passes
        } else {
            String errorMsg = register.getRegisterErrorMessage();
            System.out.println("Register failed with error: " + errorMsg);
            Assert.assertFalse(true, "Register failed: " + errorMsg); // fail the test
        }


        // Assertion
        By successMsg = By.className("result");
        String message = driver.findElement(successMsg).getText();
        Assert.assertTrue(message.contains("Your registration completed"),
                          "Registration Failed: " + message);

        System.out.println("Registration successful for: " + email);
    }
}
