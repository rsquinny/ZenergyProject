import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Searchbar {
	private WebDriver driver;

	public Searchbar(WebDriver d) {
		this.driver = d;
	}

	// Module_ItemSearch
	public void Module_ItemSearch(String Object) throws InterruptedException {
		// Waiting for certain elements to load before continuation and searching for
		// laptops
		driver.findElement(By.id("haQuickSearchBox")).sendKeys(Object);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button.btn.btn-primary.btn-mini.search-bar-btn")).click();

	}

}
