import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.aut.edu/");
		driver.findElement(By.name("searchword")).sendKeys("Handbook" + Keys.ENTER);
	//WebDriver Exercise 3
		driver.get("https://www.newegg.com");
		String winHandleBefore = driver.getWindowHandle();
		driver.findElement(By.className("fa-facebook")).click();
		for(String winHandle : driver.getWindowHandles()){
		driver.switchTo().window(winHandle);
			}
		driver.close();
		driver.switchTo().window(winHandleBefore);
	}
}
