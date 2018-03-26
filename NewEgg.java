import java.awt.AWTException;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class NewEgg {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Module_goToNewegg(driver);
		Module_LoginButton(driver);
		Module_Signup(driver, "LeatherlikeScaling@maildrop.cc", "Zenergy20");
	}

	// Module_GoToNewegg: Directs browser to Newegg home page.
	public static void Module_goToNewegg(WebDriver driver) {
		driver.get("https://www.newegg.com");
		// Verifies that the title works
		if (driver.getTitle().equals("Computer Parts, Laptops, Electronics, and More - Newegg.com")) {
			System.out.println("Newegg Opened");
		} else {
			System.out.println("Newegg not reached");
		}
	}

	// Module_LoginButton:This module logs the user into their account.
	public static void Module_LoginButton(WebDriver driver) {
		WebElement LoginButton = driver.findElement(By.id("usaSite"));
		LoginButton.click();
	}

	// Module_InputLogin: Logs the user into their pre-existing account.
	public static void Module_InputLogin(WebDriver driver, String Login, String Password) {
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
	public static void Module_Signup(WebDriver driver, String Login, String Pwd) {
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
		//If statement that makes sure email is an email
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
		//CreateAccount.click();
	}
	
//Fue!!!
	public static void itemsearch (WebDriver driver) throws InterruptedException {
		
		//System.setProperty("webdriver.chrome.driver", "D:\\Program Files\\eclipse\\ZenergyProject\\chromedriver.exe");
		
		//Waiting for certain elements to load before continuation and searching for laptops
		driver.findElement(By.id("haQuickSearchBox")).sendKeys("laptop");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button.btn.btn-primary.btn-mini.search-bar-btn")).click();
			
	}
	
	public static void cart (WebDriver driver) throws InterruptedException, AWTException, IOException {
		
		//System.setProperty("webdriver.chrome.driver", "D:\\Program Files\\eclipse\\ZenergyProject\\chromedriver.exe");
		
		//creating a webElement variable by using driver to find xpath
		WebElement laptop = driver.findElement(By.xpath("//img[@title='HP Laptop 250 G6 (1NW57UT#ABA) Intel Core i5 7th Gen 7200U (2.50 GHz) 8 GB Memory 256 GB SSD Intel HD Graphics 620 15.6\" Windows 10 Pro 64-Bit']"));
		((JavascriptExecutor)driver)
		.executeScript("arguments[0].scrollIntoView(true);", laptop);
		laptop.click();
		
		//Assigning the cart button to a webelement and clicking
		WebElement button = driver.findElement(By.cssSelector("button.btn.btn-primary.btn-wide"));
		button.click();
		//Waiting for page to load
		Thread.sleep(2000);
		//Execute autoit script to close popup
		//for the file path, you may want to change it to your own personal file path
		Runtime.getRuntime().exec("D:\\Fue\\Documents\\Classes\\ISM 435\\move.exe");
		Thread.sleep(5000);
		Runtime.getRuntime().exec("D:\\Fue\\Documents\\Classes\\ISM 435\\move.exe");
		Thread.sleep(3000);

	}
	
	public static void compare (WebDriver driver) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\Program Files\\eclipse\\ZenergyProject\\chromedriver.exe");
		//called action required for hovering over popup
		Actions action = new Actions(driver);
		//call item search to search for items
		itemsearch(driver);
		
		//Scroll into the views of laptops
		WebElement laptop = driver.findElement(By.xpath("//img[@title='HP Laptop 250 G6 (1NW57UT#ABA) Intel Core i5 7th Gen 7200U (2.50 GHz) 8 GB Memory 256 GB SSD Intel HD Graphics 620 15.6\" Windows 10 Pro 64-Bit']"));
		((JavascriptExecutor)driver)
		.executeScript("arguments[0].scrollIntoView(true);", laptop);
		
		//Clicking and comparing two items
		WebElement compare1 = driver.findElement(By.xpath("//span[@class='form-checkbox-title']"));
		WebElement compare2 = driver.findElement(By.xpath("//span[@class='form-checkbox']"));
		compare1.click();
		Thread.sleep(2000);
		compare2.click();
		Thread.sleep(3000);
		WebElement we = driver.findElement(By.className("form-checkbox-title"));
		action.moveToElement(we).moveToElement(driver.findElement(By.className("popover left popover-compare"))).click().build().perform();
}
	public static void searchtestcase (WebDriver driver) throws InterruptedException, IOException {
		//opening new egg and item search 
		Module_goToNewegg(driver);
		itemsearch(driver);
	}
	public static void checkout (WebDriver driver) throws InterruptedException, IOException, AWTException {
		System.setProperty("webdriver.chrome.driver", "D:\\Program Files\\eclipse\\ZenergyProject\\chromedriver.exe");
		//Call modules to open new egg and login, as well as carting and item search
		Module_goToNewegg(driver);
		Module_InputLogin(driver, "LeatherlikeScaling@maildrop.cc", "Zenergy20");
		itemsearch(driver);
		cart(driver);
		//Clicking checkout 
		driver.findElement(By.className("btn btn-primary")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("button button-primary has-icon-right")).click();
		Thread.sleep(2000);
		
	}
	public static void featuredsellers (WebDriver driver) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\Program Files\\eclipse\\ZenergyProject\\chromedriver.exe");
		//action required for hovering 
		Actions action = new Actions(driver);
		//call gotoNewEgg method to go to newegg
		Module_goToNewegg(driver);
		
		//hovering and clicking a featured seller
		WebElement featured = driver.findElement(By.xpath("//nav[@class='btn-group-cell menu-box marketplace-nav']"));
		action.moveToElement(featured).perform();
		Thread.sleep(1000);
		WebElement seller = driver.findElement(By.xpath("//img[@src='//images10.newegg.com/Marketing_Place/Seller_logo/Seller_AC8W_ad73bcc8-fce7-4158-87fc-51335b3494c9.gif']"));
		action.click(seller).build().perform();
		
		//Getting the current title page
		driver.getTitle().equals("EK Water Blocks Store - Newegg.com");
		String actTitle = driver.getTitle();
		String expTitle = "EK Water Blocks Store - Newegg.com";
		
		//Confirming that the title page is correct and displaying a message for verification 
		if(actTitle.equalsIgnoreCase(expTitle)) {
			System.out.println("Title matched");
		}
		else {
			System.out.println("Title didn't match");
		}
	}
	
//Ariel!!!
		public static void AddToWishList(WebDriver driver) {
			//log in module must be created to run this module
			WebElement searchBar = driver.findElement(By.id("haQuickSearchBox"));
			searchBar.click();
			driver.findElement(By.id("haQuickSearchBox")).sendKeys("PS4 Systems" + Keys.ENTER);
			WebElement Skyrim = driver.findElement(By.className("item-title"));
			Skyrim.click();
			WebElement wishlist = driver.findElement(By.id("AddToWishlist"));
			wishlist.click();
			WebElement username = driver.findElement(By.id("UserName"));
			username.click();
			//Scanner usrname = new Scanner(System.in);
			//WebElement password = driver.findElement(By.id("UserPwd"));
			//Scanner pword = new Scanner(System.in);
			//WebElement submit = driver.findElement(By.id("submit"));
			//if(username.isDisplayed()) {
			//	password.click();
			//}
			//if (password.isDisplayed()) {
			//	submit.click();
			//}
			System.out.println("");
			
		}

		public static void ClickSubmit(WebDriver driver) {
			//The javascript for Submit Order button: javascript:Biz.GlobalShopping.CheckOut.submitOrder();
			WebElement submit = driver.findElement(By.id("submit"));
			submit.click();
		}
		
	}
