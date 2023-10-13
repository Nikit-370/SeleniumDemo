package genericsUtils;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import POM.ActitimeHomePage;
import POM.ActitimeLoginPage;

public class BaseClass {

	protected WebDriver driver;
	Utility ut;

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Data Base connectivity started");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Parrallel condition started");
	}

	@BeforeClass
	public void beforeClass() throws EncryptedDocumentException, IOException {
		System.out.println("Launch to the browser");
		System.out.println("Navigate to the URL");

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();

		ut = new Utility();
		driver.get(ut.toFetchStringDataFromExcelSheet("Actitime", 1, 1));

	}

	@BeforeMethod
	public void beforeMethod() throws EncryptedDocumentException, IOException {
		ut = new Utility();
		System.out.println("Login to the application");
		ActitimeLoginPage login = new ActitimeLoginPage(driver);
		login.loginAction(ut.toFetchStringDataFromExcelSheet("Actitime", 2, 1),
				ut.toFetchStringDataFromExcelSheet("Actitime", 3, 1));
	}

	@AfterMethod
	public void afterMethod() throws EncryptedDocumentException, IOException {
		System.out.println("Log out from the browser");
		ut = new Utility();
		ActitimeHomePage home = new ActitimeHomePage(driver);
		home.logoutAction();
		System.out.println(ut.toFetchStringDataFromExcelSheet("Actitime", 5, 1));
	}

	@AfterClass
	public void afterClass() {
		System.out.println("Close the browser");
		driver.quit();
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Parallel execution stopped");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("Data Base connectivity stoped");
	}

}
