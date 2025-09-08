package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private WebDriver driver;

    // Locators
    private By addressBiilingBtn = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[1]/div[2]/div/button[2]");
    private By shippingMethodBtn = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[3]/div[2]/form/div[2]/button");
    private By paymentMethodBtn = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[4]/div[2]/div/button");
    private By paymentInfoBtn = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[5]/div[2]/div/button");
    private By ConfirmOrderBtn = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[6]/div[2]/div[2]/button");
    //private By OderDetailsBtn  = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[2]/div[2]/a");
    

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void proceedThroughCheckout() throws InterruptedException {
        driver.findElement(addressBiilingBtn).click();
        Thread.sleep(5000);

        driver.findElement(shippingMethodBtn).click();
        Thread.sleep(5000);
        
        driver.findElement(paymentMethodBtn).click();
        Thread.sleep(5000);

        driver.findElement(paymentInfoBtn).click();
        Thread.sleep(5000);

        driver.findElement(ConfirmOrderBtn).click();
        Thread.sleep(5000);
        
    }
}
