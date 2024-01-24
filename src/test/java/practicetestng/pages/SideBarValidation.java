package practicetestng.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

public class SideBarValidation {
	
	private WebDriver driver;
	public SideBarValidation(WebDriver driver) {
		this.driver = driver;
	}
	
	public void sideBarValidation(JsonArray values) {
		for(JsonElement value : values) {
			assertTrue(driver.findElement(By.xpath("//span[text()='"+value.getAsString()+"']")).isDisplayed());
		}
	}

}
