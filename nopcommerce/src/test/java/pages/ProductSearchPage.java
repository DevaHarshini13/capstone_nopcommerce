package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductSearchPage {
    private WebDriver driver;

    // Locators
    private By searchBox = By.id("small-searchterms");
    private By searchButton = By.xpath("/html/body/div[6]/div[1]/div[2]/div[2]/form/button");
    private By firstProduct = By.cssSelector("#main > div > div.center-2 > div > div.page-body > div.search-results > div > div.products-wrapper > div > div > div:nth-child(1) > div > div.picture > a > img");
    private By addToCartBtn = By.id("add-to-cart-button-5");
    private By clickCloseMsg = By.className("close");

    public ProductSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchProduct(String productName) throws InterruptedException {
        driver.findElement(searchBox).sendKeys(productName);
        driver.findElement(searchButton).click();
        Thread.sleep(2000);
    }

    public void selectFirstProduct() throws InterruptedException {
        driver.findElement(firstProduct).click();
        Thread.sleep(2000);
    }

    public void addToCart() throws InterruptedException {
        driver.findElement(addToCartBtn).click();
        Thread.sleep(3000);
    }
    
    public void clickClose() {
    	driver.findElement(clickCloseMsg).click();
    }
}
