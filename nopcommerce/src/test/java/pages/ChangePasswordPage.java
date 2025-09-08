package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangePasswordPage {
	private WebDriver driver;

    private By myAccount = By.className("ico-account"); // after register
	private By changePasswordClick = By.xpath("/html/body/div[6]/div[3]/div/div[1]/div/div[2]/ul/li[7]/a");
	private By oldPasswordField = By.id("OldPassword");
	private By newPasswordField = By.id("NewPassword");
	private By confirmNewPasswordField = By.id("ConfirmNewPassword");
	private By changePasswordBtn = By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/form/div[2]/button");
	
	public ChangePasswordPage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        Thread.sleep(2000);
    }
	
	public void clickOpenMyAccount() throws InterruptedException {
    	driver.findElement(myAccount).click();
    	Thread.sleep(5000);
    	driver.findElement(changePasswordClick).click();
    	Thread.sleep(3000);
	}
	
	public void enterOldPassword(String oldpassword) throws InterruptedException {
		driver.findElement(oldPasswordField).sendKeys("123123123");
        Thread.sleep(3000);

	}
	
	public void enterNewPassword(String oldpassword) throws InterruptedException {
		driver.findElement(newPasswordField).sendKeys("12341234");
        Thread.sleep(3000);
	}
	
	public void confirNewPassword(String oldpassword) throws InterruptedException {
		driver.findElement(confirmNewPasswordField).sendKeys("12341234");
        Thread.sleep(3000);
	}
	
	public void clickChangePassword() throws InterruptedException {
    	driver.findElement(changePasswordBtn).click();
    	Thread.sleep(5000);
	}
}
