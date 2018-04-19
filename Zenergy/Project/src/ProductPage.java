import java.awt.AWTException;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ProductPage {
	private WebDriver driver;

	public ProductPage(WebDriver d) {
		this.driver = d;
	}

	// Module_Cart
	public void Module_Cart() throws InterruptedException, AWTException, IOException {
		
		Log.startModule("Selenium_Module_Cart");
		// creating a webElement variable by using driver to find xpath
		WebElement laptop = driver.findElement(By.xpath(
				"//img[@title='HP Laptop 250 G6 (1NW57UT#ABA) Intel Core i5 7th Gen 7200U (2.50 GHz) 8 GB Memory 256 GB SSD Intel HD Graphics 620 15.6\" Windows 10 Pro 64-Bit']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", laptop);
		Log.info("Item scrolled into view");
		laptop.click();
		Log.info("Laptop item is clicked");
	
		// Assigning the cart button to a webelement and clicking
		WebElement button = driver.findElement(By.cssSelector("button.btn.btn-primary.btn-wide"));
		button.click();
		Log.info("Cart button is clicked");
		// Waiting for page to load
		Thread.sleep(2000);
		//try/catch, If statements to close the popup if displayed
		try {
			if (driver.findElement(By.xpath("//html//div[@id='custom']//button[1]")).isDisplayed()) {
				driver.findElement(By.xpath("//html//div[@id='custom']//button[1]")).click();
				Log.info("First warranty is closed");
			}
			Thread.sleep(2000);
			if (driver.findElement(By.xpath("//div[@class='centerPopup is-current is-top']//div[@class='centerPopup-body']//a[@href='javascript:;']")).isDisplayed()) {
				driver.findElement(By.xpath("//div[@class='centerPopup is-current is-top']//div[@class='centerPopup-body']//a[@href='javascript:;']")).click();
				Log.info("Second warranty is closed");
			}
		}
		catch (Exception e) {
				
		}
			Thread.sleep(1500);
		Log.endModule("Selenium_Module_Cart");
	}

	// Module_Checkout: After adding item to your cart, this checksout
	public void Module_Checkout() throws InterruptedException, IOException, AWTException {
		
		Log.startModule("Selenium_Module_Checkout");
		// Call modules to open new egg and login, as well as carting and item search
		//Clicking checkout 
		//try/catch, if statements to checkout
		try {
			if (driver.findElement(By.xpath("//html//button[2]")).isDisplayed()) {
				driver.findElement(By.xpath("//html//button[2]")).click();
				Log.info("View Shopping Cart button is clicked");
			}
			if (driver.findElement(By.xpath("//a[@class='button button-primary has-icon-right']")).isDisplayed()) {
				driver.findElement(By.xpath("//a[@class='button button-primary has-icon-right']")).click();
				Log.info("Secured Checkout button is clicked");
			}
			Thread.sleep(2000);
		}
		catch (Exception e) {
	
		}
		Thread.sleep(2000);
		
		Log.endModule("Selenium_Module_Checkout");
	}

	// Module_AddToWishlist
	public void Module_AddToWishList() throws InterruptedException {
		
		Log.startModule("Selenium_Module_AddToWishList");
		
		// log in module must be created to run this module
		WebElement wishlist = driver.findElement(By.id("AddToWishlist"));
		wishlist.click();	
		Log.info("Wishlist is clicked");
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//span[@class='form-checkbox-title'][contains(text(),'Wishlist1')]"))).click().build().perform();
		driver.findElement(By.xpath("//button[@type='button'][contains(text(),'ADD')]")).click();
		Log.info("Item added on wishlist");
		Thread.sleep(1500);
		act.moveToElement(driver.findElement(By.xpath("//a[@href='javascript:void(0)'][contains(text(),'View My Wish Lists')]"))).click().build().perform();
		Log.info("View my wish list is clicked");
		try {
			if (driver.findElement(By.xpath("//h1[@class='page-title-text']")).isDisplayed()) {
				Log.info("WishList page is displayed");
			}
			if (!driver.findElement(By.xpath("//h1[@class='page-title-text']")).isDisplayed()) {
				Log.error("WishList page is not displayed");
			}
		}catch (Exception e) {
			Thread.sleep(2000);
		}
		
		Log.endModule("Selenium_Module_AddToWishList");
	}

	// Module_ClickSubmit
	public void ClickSubmit() {
		
		Log.startModule("Selenium_Module_ClickSubmit");
		
		// The javascript for Submit Order button:
		// javascript:Biz.GlobalShopping.CheckOut.submitOrder();
		WebElement submit = driver.findElement(By.id("submit"));
		submit.click();
		Log.info("Submit button is clicked");
		
		Log.endModule("Selenium_Module_ClickSubmit");
	}
	//Module_CheckoutasGuest: clicks on continue as a guest at the end of checkout
	public void Module_CheckoutasGuest() {
		
		Log.startModule("Selenium_Module_CheckoutasGuest");
		
		WebElement guest = driver.findElement(By.xpath("//div[@class='form-button-area text-right']//button[@type='button']"));
		guest.click();
		Log.info("Guest checkout is clicked");
		
		Log.endModule("Selenium_Module_CheckoutasGuest");
	}
	//Module_Review
		public void Module_Review() throws InterruptedException {
			
			Log.startModule("Selenium_Module_Review");
			
			try {
				if (driver.findElement(By.xpath("//a[@class='first_review']")).isDisplayed()) {
					driver.findElement(By.xpath("//a[@class='first_review']")).click();
					Log.info("Write a Review button is clicked");
				}
				if (driver.findElement(By.xpath("//a[@class='atnIcon icnWrite']")).isDisplayed()) {
					driver.findElement(By.xpath("//a[@class='atnIcon icnWrite']")).click();
					Log.info("Write a Review button is clicked");
				}
				
			}catch (Exception e){
				
			}
	
			Thread.sleep(2000);
			WebElement AddTitle = driver.findElement(By.id("addTitle"));
			AddTitle.click();
			Log.info("AddTitle is clicked");
			WebElement AddPros = driver.findElement(By.id("addTitle"));
			AddPros.click();
			Log.info("AddPros is clicked");
			WebElement AddCons = driver.findElement(By.id("addTitle"));
			AddCons.click();
			Log.info("AddCons is clicked");
			WebElement AddOther = driver.findElement(By.id("addTitle"));
			AddOther.click();
			Log.info("AddOther is clicked");
			
			AddTitle.sendKeys("hello");
			Log.info("AddTitle sent hello");
			AddPros.sendKeys("hello");
			Log.info("AddPros sent hello");
			AddCons.sendKeys("hello");
			Log.info("AddCons sent hello");
			AddOther.sendKeys("hello");
			Log.info("AddOther sent hello");
			
			Log.endModule("Selenium_Module_Review");
		}
}

