import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private WebDriver driver;

	public LoginPage(WebDriver d) {
		this.driver = d;
	}

	// Module_InputLogin: Logs the user into their pre-existing account.
	public void Module_InputLogin(String Login, String Password) {
		
		Log.startModule("Selenium_Module_InputLogin");
		
		WebElement UserNameField = driver.findElement(By.id("UserName"));
		WebElement PasswordField = driver.findElement(By.id("UserPwd"));
		UserNameField.click();
		Log.info("UsernameField is clicked");
		UserNameField.clear();
		Log.info("UsernameField is cleared");
		UserNameField.sendKeys(Login);
		Log.info("UsernameField is filled");
		PasswordField.click();
		Log.info("PasswordField is clicked");
		PasswordField.clear();
		Log.info("PasswordField is cleared");
		PasswordField.sendKeys(Password);
		PasswordField.sendKeys(Keys.ENTER);
		Log.info("PasswordField is filled and entered");
		
		Log.endModule("Selenium_Module_InputLogin");
	}
		public void Module_Names(String First, String Last) {
		// Inputs the name of the user
		WebElement SignUpButton = driver.findElement(By.xpath("/html/body/div[3]/section/div/div[1]/div/div/span/a"));
		SignUpButton.click();
		WebElement first = driver.findElement(By.id("firstName"));
		WebElement last = driver.findElement(By.id("lastName"));
		first.click();
		first.clear();
		first.sendKeys(First);
		last.click();
		last.clear();
		last.sendKeys(Last);
	}

	// Module_SignupUserName: Finds the LoginName field and inputs the Login
	// information
	public void Module_SignupUserName(String Login) throws InterruptedException, NoSuchElementException {
		// Tries to see if the promo code box is present. If not tries to login user
		try {
			WebElement EmailField = driver.findElement(By.id("LoginName"));
			EmailField.click();
			EmailField.clear();
			EmailField.sendKeys(Login);
			EmailField.sendKeys(Keys.ENTER);
			// There are two of these classes, it finds the second at index 1 and checks the
			// text there.
			if (driver.findElements(By.className("promo-code-title")).get(1).getText()
					.contains("Thank you for subscribing! Your request will be processed within the next 24 hours.")) {
				System.out.println("You have been signed up.");
			} else {
				System.out.println("Signup failed.");
			}
		} catch (Exception E) {
			// Adds the email
			WebElement EmailField = driver.findElement(By.id("emailAddress"));
			EmailField.click();
			EmailField.clear();
			EmailField.sendKeys(Login);
			// Checks to make sure email is an email
			if (Login.contains("@") && Login.contains(".")) {
				System.out.println("Email is good.");
			} else {
				System.out.println("Bad email.");
			}
		}
	}

	// Module_SignupPwd: Registers the users password with their new account
	public void Module_SignupPwd(String Pwd) throws InterruptedException {
		// These find the input elements to login with.
		WebElement PassworField = driver.findElement(By.id("setPwd"));
		// Password Creation
		PassworField.click();
		PassworField.clear();
		PassworField.sendKeys(Pwd);
		WebElement CreateAccount = driver.findElement(By.xpath("//button[@id='submitRegistration']"));
		CreateAccount.click();
	}

}
