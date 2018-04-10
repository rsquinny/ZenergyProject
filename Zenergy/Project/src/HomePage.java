import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	private WebDriver driver;

	public HomePage(WebDriver d) {
		this.driver = d;
	}

	// Module_GoToNewegg: Directs browser to Newegg home page.
	public void Module_GoToNewegg() {
		
		//Maximizes and goes to newegg.com
	   	driver.manage().window().maximize();
		driver.get("https://www.newegg.com");
		// Verifies that the title works
		if (driver.getTitle().equals("Computer Parts, Laptops, Electronics, and More - Newegg.com")) {
			System.out.println("Newegg Opened");
		} else {
			System.out.println("Newegg not reached");
		}
	}

	// Module_LoginButton:This module logs the user into their account.
	public void Module_LoginButton() {
		WebElement LoginButton = driver.findElement(By.id("usaSite"));
		LoginButton.click();
	}
	//Module_Logout: Module logs user out
	public void Module_Logout() throws InterruptedException {
		//action to click and move to logout
		Actions action = new Actions(driver);
		driver.findElement(By.xpath("//ins[contains(text(),'My Account')]")).click();
		WebElement myaccount = driver.findElement(By.xpath("//ins[contains(text(),'My Account')]"));
		action.moveToElement(myaccount).perform();
		Thread.sleep(1000);
		action.moveToElement(driver.findElement(By.xpath("//a[@href='https://secure.newegg.com/NewMyAccount/AccountLogout.aspx']"))).click().build().perform();
	
	}
	//Module_HomeButton: Module clicks on the home button in any page
	public void Module_HomeButton () {
		driver.findElement(By.xpath("//img[@src='//c1.neweggimages.com/WebResource/Themes/2005/Nest/logo_424x210.png']")).click();
	}
}
