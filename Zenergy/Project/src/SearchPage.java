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
		// called action required for hovering over popup
		Actions action = new Actions(driver);

		// Scroll into the views of laptops
		WebElement laptop = driver.findElement(By.xpath(
				"//img[@title='HP Laptop 250 G6 (1NW57UT#ABA) Intel Core i5 7th Gen 7200U (2.50 GHz) 8 GB Memory 256 GB SSD Intel HD Graphics 620 15.6\" Windows 10 Pro 64-Bit']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", laptop);

		// Clicking and comparing two items
		WebElement compare1 = driver
				.findElement(By.xpath("//html//div[1]/div[1]/div[2]/div[1]/div[2]/label[1]/span[1]"));
		WebElement compare2 = driver
				.findElement(By.xpath("//html//div[2]/div[1]/div[2]/div[1]/div[2]/label[1]/span[1]"));
		compare1.click();
		Thread.sleep(2000);
		compare2.click();
		Thread.sleep(3000);
		WebElement we = driver.findElement(By.xpath("//html//div[2]/div[1]/div[2]/div[1]/div[2]/label[1]/span[1]"));
		action.moveToElement(we)
				.moveToElement(driver.findElement(By.xpath("//div[@class='popover-btn-area']/button[@id='gocompare']")))
				.click().build().perform();
		Thread.sleep(2500);

		// Getting the current title page
		String actTitle = driver.getTitle();
		String expTitle = "Computer Parts, PC Components, Laptop Computers, LED LCD TV, Digital Cameras and more - Newegg.com";
		// Confirming that the title page is correct and displaying a message for
		// verification
		if (actTitle.equalsIgnoreCase(expTitle)) {
			System.out.println("Title matched");
		} else {
			System.out.println("Title didn't match");
		}
	}
	
	//Module_ClickItem: This clicks the first item on a search page
	public void Module_ClickItem() {
		WebElement item = driver.findElement(By.xpath("//*[@id=\"bodyArea\"]/section/div/div/div[2]/div/div/div/div[2]/div[1]/div[2]/div[2]/div[27]/div/a"));
		item.click();

	// Module_FeaturedSellers
	public void Module_FeaturedSellers() throws InterruptedException, IOException {
		// action required for hovering
		Actions action = new Actions(driver);

		// hovering and clicking a featured seller
		WebElement featured = driver.findElement(By.xpath("//nav[@class='btn-group-cell menu-box marketplace-nav']"));
		action.moveToElement(featured).perform();
		Thread.sleep(1000);
		WebElement seller = driver.findElement(By.xpath(
				"//img[@src='//images10.newegg.com/Marketing_Place/Seller_logo/Seller_AC8W_ad73bcc8-fce7-4158-87fc-51335b3494c9.gif']"));
		action.click(seller).build().perform();

		// Getting the current title page
		String actTitle = driver.getTitle();
		String expTitle = "EK Water Blocks Store - Newegg.com";

		// Confirming that the title page is correct and displaying a message for
		// verification
		if (actTitle.equalsIgnoreCase(expTitle)) {
			System.out.println("Title matched");
		} else {
			System.out.println("Title didn't match");
		}
	}
}
