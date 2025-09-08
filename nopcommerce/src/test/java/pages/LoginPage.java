package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    // Locators
    private By emailField = By.id("Email");
    private By passwordField = By.id("Password");
    private By loginButton = By.xpath("//button[contains(text(),'Log in')]");
    private By myAccount = By.className("ico-account"); // after login

    // Error locators
    private By emailError = By.id("Email-error");  // appears if email is blank
    private By summaryError = By.cssSelector(".validation-summary-errors"); // general login errors

    public LoginPage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        Thread.sleep(1000);
    }

    public void enterEmail(String email) throws InterruptedException {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
        Thread.sleep(1000);
    }

    public void enterPassword(String password) throws InterruptedException {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
        Thread.sleep(1000);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    // Check if My account link is visible
    public boolean isLoginSuccessful() {
        try {
            Thread.sleep(1000);
            return driver.findElement(myAccount).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Get login error message (works for invalid or blank)
    public String getLoginErrorMessage() {
        try {
            //Thread.sleep(1000);
            if (driver.findElements(emailError).size() > 0) {
                return driver.findElement(emailError).getText().trim();
            } else if (driver.findElements(summaryError).size() > 0) {
                return driver.findElement(summaryError).getText().trim();
            } else {
                return "No error message displayed";
            }
        } catch (Exception e) {
            return "Login failed"; // fallback message
        }
    }
}
