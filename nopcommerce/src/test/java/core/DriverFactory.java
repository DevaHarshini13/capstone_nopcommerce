package core;



import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
	//managing web driver
public class DriverFactory {
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    
    //Initialize Driver
    public static WebDriver initDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        tlDriver.set(new ChromeDriver(options));
        return tlDriver.get();
    }
    //Get Driver
    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    //Quit Driver
    public static void quitDriver() {
        if (tlDriver.get() != null) {
            tlDriver.get().quit();
            tlDriver.remove();
        }
    }
}
