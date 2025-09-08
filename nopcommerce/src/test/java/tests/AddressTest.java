package tests;



import org.testng.Assert;
import org.testng.annotations.Test;

import core.BaseTest;
import pages.AddressPage;
import pages.HomePage;
import pages.LoginPage;

public class AddressTest extends BaseTest {
	
	@Test
	public void addNewAddress() throws InterruptedException {
		// Go to login page
        HomePage home = new HomePage(driver);
        home.clickLogin();
   
        LoginPage login = new LoginPage(driver);
        login.enterEmail("devaharshinisighakolli@gmail.com");
        login.enterPassword("Harshini@321");
        login.clickLogin();
     // Verify login
        Assert.assertTrue(login.isLoginSuccessful(), "Login failed!");
        System.out.println("Login successful");
        
	// Open Address Page
    AddressPage addressPage = new AddressPage(driver);

    // Navigate to "My Account -> Addresses -> Add New"
    addressPage.clickOpenAddresses();

    // Fill Address Form
    addressPage.enterFirstName("Harshini");
    addressPage.enterLastName("Sighakolli");
    String email = "devaharshinisighakolli@gmail.com";
    addressPage.enterEmail(email);
    addressPage.selectCountry(); // Select India
    addressPage.selectState();   // Select Andhra Pradesh
    addressPage.enterCity("ongole");
    addressPage.enterFirstAddress("Gandhi Road");
    addressPage.enterPostalCode("523225");
    addressPage.enterPhoneNumber("8769335364");

    // Click Save
    addressPage.clickSave();

    // Assert Result
    if (addressPage.isAddressSaved()) {
        System.out.println("Address saved successfully!");
        Assert.assertTrue(true);
    } else {
        String error = addressPage.getAddressSaveErrorMessage();
        System.out.println("Address save failed: " + error);
        Assert.fail("Address save failed: " + error);
    }
}	
	
}
