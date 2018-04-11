import java.awt.AWTException;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ProductPage {
	private WebDriver driver;

	public ProductPage(WebDriver d) {
		this.driver = d;
	}

	//Module_Review
	public void Module_Review() throws InterruptedException {
		WebElement WriteAReview = driver.findElement(By.className("text-wrapper"));
		WriteAReview.click();
		Thread.sleep(2000);
		WebElement AddTitle = driver.findElement(By.id("addTitle"));
		AddTitle.click();
		WebElement AddPros = driver.findElement(By.id("addTitle"));
		AddPros.click();
		WebElement AddCons = driver.findElement(By.id("addTitle"));
		AddCons.click();
		WebElement AddOther = driver.findElement(By.id("addTitle"));
		AddOther.click();
		
		AddTitle.sendKeys("hello");
		AddPros.sendKeys("hello");
		AddCons.sendKeys("hello");
		AddOther.sendKeys("hello");
		
		
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
		//try/catch, If statements to close the popup if displayed
		try {
			if (driver.findElement(By.xpath("//html//div[@id='custom']//button[1]")).isDisplayed()) {
				driver.findElement(By.xpath("//html//div[@id='custom']//button[1]")).click();
			}
			Thread.sleep(2000);
			if (driver.findElement(By.xpath("//div[@class='centerPopup is-current is-top']//div[@class='centerPopup-body']//a[@href='javascript:;']")).isDisplayed()) {
				driver.findElement(By.xpath("//div[@class='centerPopup is-current is-top']//div[@class='centerPopup-body']//a[@href='javascript:;']")).click();
			}
			Thread.sleep(2000);
		}
		catch (Exception e) {
			
		}
			

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
	public void Module_AddToWishList() throws InterruptedException {
		// adds an item to the wishlist
		WebElement wishlist = driver.findElement(By.id("AddToWishlist"));
		wishlist.click();
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.moveToElement(
				driver.findElement(By.xpath("//span[@class='form-checkbox-title'][contains(text(),'Wishlist1')]")))
				.click().build().perform();
		driver.findElement(By.xpath("//button[@type='button'][contains(text(),'ADD')]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@type='button'][contains(text(),'Continue Shopping')]")).click();

		// if statement maybe in future?
		System.out.println("Item added to wishlist");
	}

	// Module_ClickSubmit
	public void ClickSubmit() {
		// The javascript for Submit Order button:
		// javascript:Biz.GlobalShopping.CheckOut.submitOrder();
		WebElement submit = driver.findElement(By.id("submit"));
		submit.click();
	}
	
}