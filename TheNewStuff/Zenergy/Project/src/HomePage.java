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

}
