package practicetestng.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {

	private final By usernameInput = By.xpath("//input[@name='username']");
	private final By passwordInput = By.xpath("//input[@name='password']");
	private final By loginButton = By.xpath("//button[text()=' Login ']");
	private final By profilePhoto = By.xpath("//img[@src='/web/index.php/pim/viewPhoto/empNumber/7']");
	private final By logoutButton = By.xpath("//a[text()='Logout']");
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isProfileDisplayed() {
		WebElement profile = driver.findElement(profilePhoto);
		return profile.isDisplayed();
	}

	public void launchApp() {
		WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}

	public void loginFunction(String username, String password) throws Exception {
		driver.findElement(usernameInput).sendKeys(username);
		driver.findElement(passwordInput).sendKeys(password);
		driver.findElement(loginButton).click();
		Thread.sleep(5000);
	}

	public void logoutFunction() {
		driver.findElement(profilePhoto).click();
		driver.findElement(logoutButton).click();
	}

}
