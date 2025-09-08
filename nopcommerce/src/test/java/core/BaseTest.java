package core;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class BaseTest {
    protected WebDriver driver;
    protected static ExtentReports extent;
    protected static ExtentTest test;
    
    //create HTML Report
    @BeforeSuite(alwaysRun = true)
    public void setupReport() {
        ExtentSparkReporter spark = new ExtentSparkReporter("target/extent/extent-report.html");
        spark.config().setReportName("Capstone E-Commerce Automation Report");
        spark.config().setDocumentTitle("Automation Test Results");

        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Project", "E-Commerce Capstone");
        extent.setSystemInfo("Tester", "Deva Harshini");
        extent.setSystemInfo("Browser", "Chrome");
    }

    //WebDriver Setup
    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method) {
        // Initialize WebDriver here
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.nopcommerce.com/");

        // Start Extent Report for the test
        test = extent.createTest(method.getName());
    }
    //Test Result
    @AfterMethod(alwaysRun = true)
    public void logResult(ITestResult result) {
        switch (result.getStatus()) {
            case ITestResult.SUCCESS:
                test.pass("Test Passed");
                break;
            case ITestResult.FAILURE:
                test.fail("Test Failed : " + result.getThrowable());
                break;
            case ITestResult.SKIP:
                test.skip("Test Skipped: " + result.getThrowable());
                break;
        }

        // Close the browser after each test
        if (driver != null) {
           driver.quit();
        }
    }
    //Report Finalization
    @AfterSuite(alwaysRun = true)
    public void tearDownReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
