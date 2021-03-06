import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SearchPage {
	private WebDriver driver;

	public SearchPage(WebDriver d) {
		this.driver = d;
	}

	// Module_Compare
	public void Module_Compare() throws InterruptedException, IOException {
		
		Log.startModule("Selenium_Module_Compare");
		
		// called action required for hovering over popup
		Actions action = new Actions(driver);

		// Scroll into the views of laptops
		WebElement laptop = driver.findElement(By.xpath(
				"//div[@class='list-wrap']//div[@class='standard-box-top']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", laptop);
		Log.info("Item scrolled into view");
		
		// Clicking and comparing two items
		WebElement compare1 = driver
				.findElement(By.xpath("//html//div[1]/div[1]/div[2]/div[1]/div[2]/label[1]/span[1]"));
		WebElement compare2 = driver
				.findElement(By.xpath("//html//div[2]/div[1]/div[2]/div[1]/div[2]/label[1]/span[1]"));
		compare1.click();
		Log.info("Compare1 is clicked");
		Thread.sleep(1500);
		compare2.click();
		Log.info("Compare2 is clicked");
		Thread.sleep(1500);
		WebElement we = driver.findElement(By.xpath("//html//div[2]/div[1]/div[2]/div[1]/div[2]/label[1]/span[1]"));
		action.moveToElement(we)
				.moveToElement(driver.findElement(By.xpath("//div[@class='popover-btn-area']/button[@id='gocompare']")))
				.click().build().perform();
		Log.info("Compare button is clicked");

		// Getting the current title page
		String actTitle = driver.getTitle();
		String expTitle = "Computer Parts, PC Components, Laptop Computers, LED LCD TV, Digital Cameras and more - Newegg.com";
		// Confirming that the title page is correct and displaying a message for
		// verification
		if (actTitle.equalsIgnoreCase(expTitle)) {
			System.out.println("Title matched");
			Log.info("Title matched");
		} else {
			System.out.println("Title didn't match");
			Log.error("Title didn't match");
		}
		
		Log.endModule("Selenium_Module_Compare");
	}

	// Module_FeaturedSellers
	public void Module_FeaturedSellers() throws InterruptedException, IOException {
		
		Log.startModule("Selenium_Module_FeaturedSellers");
		
		// action required for hovering
		Actions action = new Actions(driver);

		// hovering and clicking a featured seller
		WebElement featured = driver.findElement(By.xpath("//nav[@class='btn-group-cell menu-box marketplace-nav']"));
		action.moveToElement(featured).perform();
		Log.info("Featured element is clicked");
		Thread.sleep(1000);
		WebElement seller = driver.findElement(By.xpath(
				"//img[@src='//images10.newegg.com/Marketing_Place/Seller_logo/Seller_AC8W_ad73bcc8-fce7-4158-87fc-51335b3494c9.gif']"));
		action.click(seller).build().perform();
		Log.info("Seller element is clicked");

		// Getting the current title page
		String actTitle = driver.getTitle();
		String expTitle = "EK Water Blocks Store - Newegg.com";

		// Confirming that the title page is correct and displaying a message for
		// verification
		if (actTitle.equalsIgnoreCase(expTitle)) {
			System.out.println("Title matched");
			Log.info("Title matched");
		} else {
			System.out.println("Title didn't match");
			Log.error("Title didn't match");
		}
		
		Log.endModule("Selenium_Module_FeaturedSellers");
	}
	//Module_ClickItem: This clicks the first item on a search page
	public void Module_ClickItem() {
		
		Log.startModule("Selenium_Module_ClickItem");
		
		WebElement item = driver.findElement(By.xpath("//html[1]/body[1]/div[5]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/a[1]"));
		item.click();
		Log.info("Item is clicked");
		
		Log.endModule("Selenium_Module_ClickItem");
	}
	//Module_SortByLowest
	public void Module_SortByLowest() {
		
		Log.startModule("Selenium_Module_SortByLowest");
		
		//Sorting by lowest price
		WebElement sort = driver.findElement(By.id("Order_top"));
		sort.click();
		Log.info("Sort is clicked");
		WebElement lowprice = driver.findElement(By.xpath("//*[@id=\"Order_top\"]/option[2]"));
		lowprice.click();
		Log.info("Low price is clicked");
		
		Log.endModule("Selenium_Module_SortByLowest");
	}
}
