import java.awt.AWTException;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
	private WebDriver driver;

	public ProductPage(WebDriver d) {
		this.driver = d;
	}

	// Module_Cart
	public void Module_Cart() throws InterruptedException, AWTException, IOException {
		// creating a webElement variable by using driver to find xpath
		WebElement laptop = driver.findElement(By.xpath(
				"//img[@title='HP Laptop 250 G6 (1NW57UT#ABA) Intel Core i5 7th Gen 7200U (2.50 GHz) 8 GB Memory 256 GB SSD Intel HD Graphics 620 15.6\" Windows 10 Pro 64-Bit']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", laptop);
		laptop.click();

		// Assigning the cart button to a webelement and clicking
		WebElement button = driver.findElement(By.cssSelector("button.btn.btn-primary.btn-wide"));
		button.click();
		// Waiting for page to load
		Thread.sleep(2000);

		// Closes warranty popups
		driver.findElement(By.xpath("//html//div[@id='custom']//button[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//div[@class='centerPopup is-current is-top']//div[@class='centerPopup-body']//a[@href='javascript:;']"))
				.click();
		Thread.sleep(2000);
	}

	// Module_Checkout: After adding item to your cart, this checksout
	public void Module_Checkout() throws InterruptedException, IOException, AWTException {
		// Call modules to open new egg and login, as well as carting and item search
		// Clicking checkout
		driver.findElement(By.className("btn btn-primary")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("button button-primary has-icon-right")).click();
		Thread.sleep(2000);

	}

	// Module_AddToWishlist
	public void Module_AddToWishList() {
		// log in module must be created to run this module
		WebElement searchBar = driver.findElement(By.id("haQuickSearchBox"));
		searchBar.click();
		driver.findElement(By.id("haQuickSearchBox")).sendKeys("PS4 Systems" + Keys.ENTER);
		WebElement Skyrim = driver.findElement(By.className("item-title"));
		Skyrim.click();
		WebElement wishlist = driver.findElement(By.id("AddToWishlist"));
		wishlist.click();
		WebElement username = driver.findElement(By.id("UserName"));
		username.click();

		System.out.println("");

	}

	// Module_ClickSubmit
	public void ClickSubmit() {
		// The javascript for Submit Order button:
		// javascript:Biz.GlobalShopping.CheckOut.submitOrder();
		WebElement submit = driver.findElement(By.id("submit"));
		submit.click();
	}
}
