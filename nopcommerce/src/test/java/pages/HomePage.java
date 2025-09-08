package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By loginLink = By.className("ico-login");
    private By registerLink = By.className("ico-register");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogin() {
        driver.findElement(loginLink).click();
    }

    public void clickRegister() {
        driver.findElement(registerLink).click();
    }
}
