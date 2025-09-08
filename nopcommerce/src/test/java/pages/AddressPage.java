package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddressPage {

	private WebDriver driver;
	
	//Locators
    private By myAccount = By.className("ico-account"); // after register
	private By openAddresses = By.xpath("/html/body/div[6]/div[3]/div/div[1]/div/div[2]/ul/li[2]/a");
    private By addNewBtn = By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[2]/button");
    private By firstNameField = By.id("Address_FirstName");
    private By lastNameField  = By.id("Address_LastName");
    private By emailField = By.id("Address_Email");
    private By countryDropdown = By.id("Address_CountryId");
    private By stateDropdown = By.id("Address_StateProvinceId");
    private By cityField = By.id("Address_City");
    private By firstAddressField = By.id("Address_Address1");
    private By postalCodeField = By.id("Address_ZipPostalCode");
    private By phoneNumberField = By.id("Address_PhoneNumber");
    private By saveBtn = By.xpath("/html/body/div[6]/div[3]/div/div[2]/form/div/div[2]/div[2]/button");
    private By notificationPopUp = By.xpath("/html/body/div[5]/div");
    private By errorMessage = By.xpath("/html/body/div[6]/div[3]/div/div[2]/form/div/div[2]/div[1]/div[1]/span[2]");
    
    
    //locators while registering Billing Address
    private By newCountryDropdown = By.id("BillingNewAddress_CountryId");
    private By newStateDropdown = By.id("BillingNewAddress_StateProvinceId");
    private By newCityField = By.id("BillingNewAddress_City");
    private By newFirstAddressField = By.id("BillingNewAddress_Address1");
    private By newPostalCodeField = By.id("BillingNewAddress_ZipPostalCode");
    private By newPhoneNumberField = By.id("BillingNewAddress_PhoneNumber");
    
    
    public AddressPage(WebDriver driver) throws InterruptedException {
    	this.driver = driver;
        Thread.sleep(5000);
    }

    public void clickOpenAddresses() throws InterruptedException {
    	driver.findElement(myAccount).click();
    	Thread.sleep(5000);
    	driver.findElement(openAddresses).click();
    	Thread.sleep(3000);
    	driver.findElement(addNewBtn).click();
    	Thread.sleep(10000);
    }
    
   public void enterFirstName(String fname) throws InterruptedException {
	   driver.findElement(firstNameField).sendKeys(fname);
	   Thread.sleep(2000);
   }
   
   public void enterLastName(String lname) throws InterruptedException {
	   driver.findElement(lastNameField).sendKeys(lname);
	   Thread.sleep(2000);
   }
   
   public void enterEmail(String mail) throws InterruptedException {
	   driver.findElement(emailField).sendKeys(mail);
	   Thread.sleep(2000);
   }
   
   public void selectCountry() throws InterruptedException {
	   WebElement countryElement = driver.findElement(countryDropdown);
	// Create Select object
	   Select select = new Select(countryElement);
	   select.selectByVisibleText("India");
       Thread.sleep(5000);
   }
   
   public void selectState() throws InterruptedException {
	   WebElement countryElement = driver.findElement(stateDropdown);
	// Create Select object
	   Select select = new Select(countryElement);
	   select.selectByVisibleText("Andhra Pradesh");
       Thread.sleep(2000);
   }
   
   public void enterCity(String city) throws InterruptedException {
	   driver.findElement(cityField).sendKeys(city);
	   Thread.sleep(2000);
   }
   
   public void enterFirstAddress(String address1) throws InterruptedException {
	   driver.findElement(firstAddressField).sendKeys(address1);
	   Thread.sleep(2000);
   }
   
   public void enterPostalCode(String code) throws InterruptedException {
	   driver.findElement(postalCodeField).sendKeys(code);
	   Thread.sleep(2000);
   }
   
   public void enterPhoneNumber(String number) throws InterruptedException {
	   driver.findElement(phoneNumberField).sendKeys(number);
	   Thread.sleep(2000);
   }
   
   public void clickSave() throws InterruptedException {
	   driver.findElement(saveBtn).click();
	   Thread.sleep(5000);
   }
   
   public boolean isAddressSaved() {
       try {
           Thread.sleep(2000);  

           // Check if element is displayed
           return driver.findElement(notificationPopUp).isDisplayed();
       } catch (Exception e) {
           return false;
       }
   }
   
   // Get error message if Address Save fails
   public String getAddressSaveErrorMessage() {
       try {
           Thread.sleep(2000);  

           // Find the error message element
           WebElement error = driver.findElement(errorMessage);
           return error.getText().trim();
       } catch (Exception e) {
           return "Fill required details"; // fallback message
       }
   }
   
   
   //Billing Address----------------------------------------------------
   
   public void selectNewCountry() throws InterruptedException {
	   WebElement countryElement = driver.findElement(newCountryDropdown);
	// Create Select object
	   Select select = new Select(countryElement);
	   select.selectByVisibleText("India");
       Thread.sleep(5000);
   }
   
   public void selectNewState() throws InterruptedException {
	   WebElement countryElement = driver.findElement(newStateDropdown);
	// Create Select object
	   Select select = new Select(countryElement);
	   select.selectByVisibleText("Andhra Pradesh");
       Thread.sleep(2000);
   }
   
   public void enterNewCity(String city) throws InterruptedException {
	   driver.findElement(newCityField).sendKeys(city);
	   Thread.sleep(2000);
   }
   
   public void enterNewFirstAddress(String address1) throws InterruptedException {
	   driver.findElement(newFirstAddressField).sendKeys(address1);
	   Thread.sleep(2000);
   }
   
   public void enterNewPostalCode(String code) throws InterruptedException {
	   driver.findElement(newPostalCodeField).sendKeys(code);
	   Thread.sleep(2000);
   }
   
   public void enterNewPhoneNumber(String number) throws InterruptedException {
	   driver.findElement(newPhoneNumberField).sendKeys(number);
	   Thread.sleep(2000);
   }   
  
}
