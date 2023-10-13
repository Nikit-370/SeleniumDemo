package HomePage_Module;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericsUtils.BaseClass;
import genericsUtils.Utility;

public class ActitimeHomePageTest extends BaseClass {

	@Test
	public void demoTest() throws IOException, InterruptedException {

		Utility ut = new Utility();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.titleContains(ut.toFetchStringDataFromExcelSheet("Actitime", 4, 1)));

		Assert.assertTrue(driver.getTitle().contains(ut.toFetchStringDataFromExcelSheet("Actitime", 4, 1)));

		System.out.println("Pass: Home Page Verified");
	}

}
