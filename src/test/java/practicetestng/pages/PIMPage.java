package practicetestng.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PIMPage {

	private final By pimButton = By.xpath("//span[text()='PIM']");
	private final By addEmployeeButton = By.xpath("//a[text()='Add Employee']");
	private final By firstname = By.xpath("//input[@name='firstName']");
	private final By lastname = By.xpath("//input[@name='lastName']");
	private final By saveButton = By.xpath("//button[text()=' Save ']");
	private final By header = By.xpath("//h6[@class='oxd-text oxd-text--h6 --strong']");
	private WebDriver driver;
	
	public PIMPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void addEmployee(String firstName,String lastName) {
		driver.findElement(pimButton).click();
		driver.findElement(addEmployeeButton).click();
		driver.findElement(firstname).sendKeys(firstName);
		driver.findElement(lastname).sendKeys(lastName);
		driver.findElement(saveButton).click();
	}
	
	public boolean isHeaderDisplayed() {
		boolean status = driver.findElement(header).isDisplayed();
		return status;
	}
}

