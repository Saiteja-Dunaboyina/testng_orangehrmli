package practicetestng.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage {

	private final By adminButton = By.xpath("//span[text()='Admin']");
	private final By searchBar = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
	private final By searchButton = By.xpath("//button[text()=' Search ']");
	private final By userRole = By.xpath("(//div[text()='Admin'])[2]");
	private WebDriver driver;

	public AdminPage(WebDriver driver) {
		this.driver = driver;
	}

	public void searchingFunction(String user) throws Exception {
		Thread.sleep(5000);
		driver.findElement(adminButton).click();
		driver.findElement(searchBar).sendKeys(user);
		driver.findElement(searchButton).click();
	}

	public String getUserRole() {
		String data = driver.findElement(userRole).getText();
		return data;
	}

}
