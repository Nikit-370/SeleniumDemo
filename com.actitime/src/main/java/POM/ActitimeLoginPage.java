package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActitimeLoginPage {

	public ActitimeLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	private WebElement uname;

	@FindBy(name = "pwd")
	private WebElement passwd;

	@FindBy(id = "loginButton")
	private WebElement loginBtn;

	public void loginAction(String username, String pass) {
		uname.sendKeys(username);
		passwd.sendKeys(pass);
		loginBtn.click();
	}
}
