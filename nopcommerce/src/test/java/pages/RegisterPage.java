package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
    private WebDriver driver;

    private By genderFeMale = By.id("gender-female");
    private By firstName = By.id("FirstName");
    private By lastName = By.id("LastName");
    private By email = By.id("Email");
    private By password = By.id("Password");
    private By confirmPassword = By.id("ConfirmPassword");
    private By registerButton = By.id("register-button");
    private By myAccount = By.className("ico-account"); // after login
    private By errorMessage = By.cssSelector("div.message-error"); // adjust according to site
    
    public RegisterPage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        Thread.sleep(2000);
    }

    public void selectGenderMale() throws InterruptedException {
        driver.findElement(genderFeMale).click();
        Thread.sleep(2000);
    }

    public void enterFirstName(String fname) throws InterruptedException {
        driver.findElement(firstName).sendKeys(fname);
        Thread.sleep(2000);
    }

    public void enterLastName(String lname) throws InterruptedException {
        driver.findElement(lastName).sendKeys(lname);
        Thread.sleep(2000);
    }

    public void enterEmail(String mail) throws InterruptedException {
        driver.findElement(email).sendKeys(mail);
        Thread.sleep(2000);
    }

    public void enterPassword(String pwd) throws InterruptedException {
        driver.findElement(password).sendKeys(pwd);
        Thread.sleep(2000);
    }

    public void enterConfirmPassword(String cpwd) throws InterruptedException {
        driver.findElement(confirmPassword).sendKeys(cpwd);
        Thread.sleep(2000);
    }

    public void clickRegister() throws InterruptedException {
        driver.findElement(registerButton).click();
        Thread.sleep(2000);
    }
    
    public boolean isRegisterSuccessful() {
        try {
            Thread.sleep(2000);  

            // Check if element is displayed
            return driver.findElement(myAccount).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

 // Get login error message if login fails
    public String getRegisterErrorMessage() {
        try {
            Thread.sleep(2000);  

            // Find the error message element
            WebElement error = driver.findElement(errorMessage);
            return error.getText().trim();
        } catch (Exception e) {
            return "Login failed"; // fallback message
        }
    }
}
