import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
	private WebDriver driver;

	public HomePage(WebDriver d) {
		this.driver = d;
	}

	// Module_GoToNewegg: Directs browser to Newegg home page.
	public void Module_GoToNewegg() {
		
		Log.startModule("Selenium_Module_GoToNewegg");
		//Maximizes and goes to newegg.com
	   	driver.manage().window().maximize();
		driver.get("https://www.newegg.com");
	   	Log.info("Newegg.com is opened and browser is maximized");
		
		// Verifies that the title works
		if (driver.getTitle().equals("Computer Parts, Laptops, Electronics, and More - Newegg.com")) {
			System.out.println("Newegg Opened");
			Log.info("Newegg is opened");
		} else {
			System.out.println("Newegg not reached");
			Log.error("Newegg is not reached");
		}
		Log.endModule("Selenium_Module_GoToNewegg");
	}

	// Module_LoginButton:This module logs the user into their account.
	public void Module_LoginButton() {
		Log.startModule("Selenium_Module_LoginButton");
		WebElement LoginButton = driver.findElement(By.id("usaSite"));
		LoginButton.click();
		Log.info("Login button is clicked");
		Log.endModule("Selenium_Module_LoginButton");
	}
	//Module_Logout: Module logs user out
	public void Module_Logout() throws InterruptedException {
		Log.startModule("Selenium_Module_Logout");
		//action to click and move to logout
		Actions action = new Actions(driver);
		WebElement myaccount = driver.findElement(By.xpath("//ins[contains(text(),'My Account')]"));
		action.moveToElement(myaccount).perform();
		Log.info("My account is clicked");
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("//a[@href='https://secure.newegg.com/NewMyAccount/AccountLogout.aspx']"))).click().build().perform();
		Log.info("Logout button is clicked");
		Log.endModule("Selenium_Module_Logout");
			}
	//Module_HomeButton: Module clicks on the home button in any page
	public void Module_HomeButton () {
		Log.startModule("Selenium_Module_HomeButton");
		//Finding home button and clicking
		driver.findElement(By.xpath("//img[@src='//c1.neweggimages.com/WebResource/Themes/2005/Nest/logo_424x210.png']")).click();
		Log.info("Home button is clicked");
		Log.endModule("Selenium_Module_HomeButton");
			}
}
