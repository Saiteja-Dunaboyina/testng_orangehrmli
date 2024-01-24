package practicetestng.sample;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.gson.JsonArray;

import practicetestng.base.Base;
import practicetestng.pages.AdminPage;
import practicetestng.pages.LoginPage;
import practicetestng.pages.PIMPage;
import practicetestng.pages.SideBarValidation;

//@Listeners({ITestListenerClass.class})
public class OrangeHrmTesting extends Base {
	private static final Logger logger = LogManager.getLogger(OrangeHrmTesting.class);
	private LoginPage loginPage;
	private AdminPage adminPage;
	private PIMPage pimPage;
	private SideBarValidation sideBarValidation;

	@BeforeTest
	public void launchApp() {
		loginPage = new LoginPage(driver);
		adminPage = new AdminPage(driver);
		pimPage = new PIMPage(driver);
		sideBarValidation = new SideBarValidation(driver);
		loginPage.launchApp();
	}

	@BeforeMethod
	public void loginApp() throws Exception {
		String username = jsonObject.get("username").getAsString();
		String password = jsonObject.get("password").getAsString();
		loginPage.loginFunction(username, password);
		Thread.sleep(5000);
		assertTrue(loginPage.isProfileDisplayed());
	}

	@Test(priority = 1)
	public void sideBarTesting() {
		logger.info("Side bar validation");
		test = extent.createTest("Side bar validation Test").assignAuthor("sai teja");
		JsonArray values = jsonObject.get("sideBar").getAsJsonArray();
		sideBarValidation.sideBarValidation(values);
	}

	@Test(priority = 2)
	public void adminPage() throws Exception {
		logger.info("Admin  Page");
		test = extent.createTest("Admin Page Test").assignAuthor("sai teja");
		String user = jsonObject.get("username").getAsString();
		adminPage.searchingFunction(user);
		String role = adminPage.getUserRole();
		Thread.sleep(5000);
		assertEquals(role, "Admin");
	}

	@Test(priority = 3)
	public void pimPage() throws Exception {
		logger.info("PIM  Page");
		test = extent.createTest("PIM Page Test").assignAuthor("sai teja");
		String firstName = jsonObject.get("firstname").getAsString();
		String lastName = jsonObject.get("lastname").getAsString();
		pimPage.addEmployee(firstName, lastName);
		Thread.sleep(5000);
		boolean status = pimPage.isHeaderDisplayed();
		assertTrue(status);
//		throw new SkipException("PIM Page Test case is Skippped");
	}

	@AfterMethod
	public void logoutApp() throws Exception {
		loginPage.logoutFunction();
		Thread.sleep(5000);

	}



}
