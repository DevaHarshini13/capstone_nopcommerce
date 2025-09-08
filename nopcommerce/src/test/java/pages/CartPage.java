package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;

    // Locators
    private By openShoppingCart = By.className("cart-label");
    private By acceptTerm = By.id("termsofservice");
    private By proceedToCheckout = By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void clickOpenCart() throws InterruptedException {
    	driver.findElement(openShoppingCart).click();
    	Thread.sleep(10000);
    }

    public void clikAcceptTerm() throws InterruptedException {
    	driver.findElement(acceptTerm).click();
    	Thread.sleep(5000);

    }
    public void proceedToCheckout() throws InterruptedException {
        driver.findElement(proceedToCheckout).click();
        Thread.sleep(5000);
    }
}
