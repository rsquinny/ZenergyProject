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
		WebElement UserNameField = driver.findElement(By.id("UserName"));
		WebElement PasswordField = driver.findElement(By.id("UserPwd"));
		UserNameField.click();
		UserNameField.clear();
		UserNameField.sendKeys(Login);
		PasswordField.click();
		PasswordField.clear();
		PasswordField.sendKeys(Password);
		PasswordField.sendKeys(Keys.ENTER);
	}

	// Module_Signup: Creates an account for the user.
	public void Module_Signup(String Login, String Pwd) {
		WebElement CreateButton = driver.findElement(By.xpath("//input[@value='Create new account']"));
		CreateButton.click();
		// These find the input elements to login with.
		WebElement EmailField = driver.findElement(By.id("LoginName"));
		WebElement EmailVField = driver.findElement(By.id("LoginName1"));
		WebElement PassworField = driver.findElement(By.id("Password"));
		WebElement PasswordVField = driver.findElement(By.id("Password1"));
		WebElement Newsletter = driver.findElement(By.id("newsletter"));
		EmailField.click();
		EmailField.clear();
		EmailField.sendKeys(Login);
		// If statement that makes sure email is an email
		if (Login.contains("@") && Login.contains(".")) {
			System.out.println("Email is good.");
		} else {
			System.out.println("Bad email.");
		}
		EmailVField.click();
		EmailVField.clear();
		EmailVField.sendKeys(Login);
		// Password Creation
		PassworField.click();
		PassworField.clear();
		PasswordVField.click();
		PasswordVField.clear();
		/*
		 * 1. Eight (8) to thirty (30) characters long 2. Three of the four below: - Use
		 * upper case letters - Use lower case letters - Use at least one number - Use
		 * special characters
		 */
		int upper = 0;
		int lower = 0;
		int nums = 0;
		int special = 0;
		// Sums up Password requirements
		if (Pwd.length() < 8 || Pwd.length() > 30) {
			System.out.println("Password must be between 8 and 30 characters");
		} else {
			// Checks if Password has any upper case values
			for (int i = 0; i < Pwd.length(); i++) {
				// grabs each Char and checks it
				char c = Pwd.charAt(i);
				if (Character.isUpperCase(c)) {
					upper++;
				}
			}
			/*
			 * Only needed for testing System.out.println("There are " + upper +
			 * "upper case characters, in the password.");
			 */

			// Checks if Password has any lower case values
			for (int i = 0; i < Pwd.length(); i++) {
				// grabs each Char and checks it
				char c = Pwd.charAt(i);
				if (Character.isLowerCase(c)) {
					lower++;
				}
			}
			/*
			 * Only needed for testing System.out.println("There are " + lower +
			 * "lower case characters, in the password.");
			 */
			// Checks if Password has any numeric values
			for (int i = 0; i < Pwd.length(); i++) {
				// grabs each Char and checks it
				char c = Pwd.charAt(i);
				if (Character.isDigit(c)) {
					nums++;
				}
			}
			/*
			 * Only needed for testing System.out.println("There are " + nums +
			 * "numbers, in the password.");
			 */
			// Checks if Password has any special values
			for (int i = 0; i < Pwd.length(); i++) {
				// checks for special characters
				char c = Pwd.charAt(i);
				if (!Character.isLetterOrDigit(c)) {
					special++;
				}
			}
			/*
			 * Only needed for testing System.out.println("There are " + special +
			 * "special characters, in the password.");
			 */
		}
		// makes sure password requirements are met and submits password
		if (upper > 0 && lower > 0 && nums > 0) {
			PassworField.sendKeys(Pwd);
			PasswordVField.sendKeys(Pwd);
		} else if (upper > 0 && lower > 0 && special > 0) {
			PassworField.sendKeys(Pwd);
			PasswordVField.sendKeys(Pwd);
		} else if (lower > 0 && special > 0 && nums > 0) {
			PassworField.sendKeys(Pwd);
			PasswordVField.sendKeys(Pwd);
		} else if (upper > 0 && special > 0 && nums > 0) {
			PassworField.sendKeys(Pwd);
			PasswordVField.sendKeys(Pwd);
		} else {
			System.out.println("Password does not meet specifications");
		}
		// end of Password Verification
		Newsletter.click();
		WebElement CreateAccount = driver.findElement(By.className("atnSecondary"));
		CreateAccount.click();
	}
}
