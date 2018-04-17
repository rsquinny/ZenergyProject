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
	// Module_SignupUserName: Finds the LoginName field and inputs the Login information
		public void Module_SignupUserName(String Login) throws InterruptedException, NoSuchElementException {
			
			Log.startModule("Selenium_Module_SignupUserName");
			
			//Tries to see if you the promo code box is present. If not inputs Login info to LoginName
			try {
				WebElement EmailField = driver.findElement(By.id("LoginName"));
				EmailField.click();
				Log.info("EmailField is clicked");
				EmailField.clear();
				Log.info("EmailField is cleared");
				EmailField.sendKeys(Login);
				EmailField.sendKeys(Keys.ENTER);
				Log.info("EmailField is filled and entered");
				// There are two of these classes, it finds the second at index 1 and checks the text there.
				if (driver.findElements(By.className("promo-code-title")).get(1).getText()
						.contains("Thank you for subscribing! Your request will be processed within the next 24 hours.")) {
					System.out.println("You have been signed up.");
					Log.info("User signed up for promos");
				} else {
					System.out.println("Signup failed.");
					Log.error("Signup failed");
				}
				
			} catch(Exception E) {
				WebElement CreateButton = driver.findElement(By.xpath("//input[@value='Create new account']"));
				CreateButton.click();
				Log.info("Create button clicked");
				WebElement EmailField = driver.findElement(By.id("LoginName"));
				WebElement EmailVField = driver.findElement(By.id("LoginName1"));
				EmailField.click();
				Log.info("EmailField clicked");
				EmailField.clear();
				Log.info("EmailField is cleared");
				EmailField.sendKeys(Login);
				Log.info("EmailField is filled");
				// If statement that makes sure email is an email
				if (Login.contains("@") && Login.contains(".")) {
					System.out.println("Email is good.");
					Log.info("Email is good");
				} else {
					System.out.println("Bad email.");
					Log.error("Bad email");
				}
				EmailVField.click();
				Log.info("EmailVField is clicked");
				EmailVField.clear();
				Log.info("EmailVField is cleared");
				EmailVField.sendKeys(Login);
				Log.info("EmailVField is filled");
			}
			
			Log.endModule("Selenium_Module_SignupUserName");
		}
		
		//Module_SignupPwd: Registers the users password with their new account
		public void Module_SignupPwd(String Pwd) throws InterruptedException {
			
			Log.startModule("Selenium_Module_SignupPwd");
			
			// These find the input elements to login with.
			WebElement PassworField = driver.findElement(By.id("Password"));
			WebElement PasswordVField = driver.findElement(By.id("Password1"));
			WebElement Newsletter = driver.findElement(By.id("newsletter"));
			// Password Creation
			PassworField.click();
			Log.info("PasswordField is clicked");
			PassworField.clear();
			Log.info("PasswordField is cleared");
			PasswordVField.click();
			Log.info("PasswordField is clicked");
			PasswordVField.clear();
			Log.info("PasswordField is cleared");
			/*
			   1. Eight (8) to thirty (30) characters long  
			   2. Three of the four below:
			   - Use upper case letters 
			   - Use lower case letters 
			   - Use at least one number 
			   - Use special characters
			 */
			int upper = 0;
			int lower = 0;
			int nums = 0;
			int special = 0;
			// Sums up Password requirements
			if (Pwd.length() < 8 || Pwd.length() > 30) {
				System.out.println("Password must be between 8 and 30 characters");
				Log.info("Password is between 8 and 30 characters");
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
				Log.info("PassworField is filled");
				PasswordVField.sendKeys(Pwd);
				Log.info("PasswordVField is filled");
			} else if (upper > 0 && lower > 0 && special > 0) {
				PassworField.sendKeys(Pwd);
				Log.info("PassworField is filled");
				PasswordVField.sendKeys(Pwd);
				Log.info("PasswordVField is filled");
			} else if (lower > 0 && special > 0 && nums > 0) {
				PassworField.sendKeys(Pwd);
				Log.info("PassworField is filled");
				PasswordVField.sendKeys(Pwd);
				Log.info("PasswordVField is filled");
			} else if (upper > 0 && special > 0 && nums > 0) {
				PassworField.sendKeys(Pwd);
				Log.info("PassworField is filled");
				PasswordVField.sendKeys(Pwd);
				Log.info("PasswordVField is filled");
			} else {
				System.out.println("Password does not meet specifications");
				Log.error("Password doesn't meet specifications");
			}
			// end of Password Verification
			Newsletter.click();
			Log.info("Newsletter is clicked");
			WebElement CreateAccount = driver.findElement(By.className("atnSecondary"));
			CreateAccount.click();
			Log.info("Create account is clicked");
			
			Log.endModule("Selenium_Module_SignupPwd");
		}
		
	}
