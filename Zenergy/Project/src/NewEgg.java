import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class NewEgg {

	static WebDriver driver = new ChromeDriver();
	static HomePage home = new HomePage(driver);
	static Searchbar bar = new Searchbar(driver);
	static SearchPage search = new SearchPage(driver);
	static LoginPage login = new LoginPage(driver);
	static ProductPage prod = new ProductPage(driver);

	public static void main(String[] args) throws IOException, InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		//provide log4j configuration settings
		DOMConfigurator.configure("log4j.xml");
		
		//1. TC_Register --- complete
		/*
					Log.startTestCase("Selenium_Test_Register");
					
					home.Module_GoToNewegg();
					Log.info("Module_GoToNewegg is successful");
					home.Module_LoginButton();
					Log.info("Module_LoginButton is successful");
					login.Module_Names("Ryan", "Happo");
					Log.info("Module_Names is successful");
					login.Module_SignupUserName("Leatherlike3Scaling@maildrop.cc");
					Log.info("Module_SignupUserName is successful");
					login.Module_SignupPwd("Zenergy20");
					Log.info("Module_SignupPwd is successful");
					home.Module_HomeButton();
					Log.info("Module_HomeButton is successful");
					
					Log.endTestCase("Selenium_Test_Register");
		*/
		//TC_Search --- complete, could add more searches just to make it special.
				/*
					Log.startTestCase("Selenium_Test_Search");
					
					Log.info("Module_GoToNewegg is successful");
					bar.Module_ItemSearch("laptop");
					Log.info("Module_ItemSearch is successful");
					home.Module_HomeButton();
					Log.info("Module_HomeButton is successful");
					
					Log.endTestCase("Selenium_Test_Search");
				*/
		//TC_AddToWishlist --- completed
				/*
				 	Log.startTestCase("Selenium_Test_AddToWishlist");

					home.Module_LoginButton();
					Log.info("Module_LoginButton is successful");
					login.Module_InputLogin("LeatherlikeScaling@maildrop.cc", "Zenergy20");
					Log.info("Module_SignupUserName is successful");
					bar.Module_ItemSearch("PS4 Systems");
					Log.info("Module_ItemSearch is successful");
					search.Module_ClickItem();
					Log.info("Module_ClickItem is successful");
					prod.Module_AddToWishList();
					Log.info("Module_AddToWishList is successful");
					home.Module_HomeButton();
					Log.info("Module_HomeButton is successful");
					
					Log.endTestCase("Selenium_Test_AddToWishlist");
				*/
					
		//TC_PromoCode --- complete
				/*
				 	Log.startTestCase("Selenium_Test_PromoCode");
				 	
					
					Log.info("Module_Go_ToNewegg is successful");
					login.Module_SignupUserName("LeatherlikeScaling@maildrop.cc");
					Log.info("Module_SignupUserName is successful");
					home.Module_HomeButton();
					Log.info("Module_HomeButton is successful");
					
					Log.endTestCase("Selenium_Test_PromoCode");
				*/
		//TC_Compare --- complete
				/*
				 	Log.startTestCase("Selenium_Test_Compare");
		
					bar.Module_ItemSearch("laptop");
					Log.info("Module_ItemSearch is successful");
					search.Module_Compare();
					Log.info("Module_Compare is successful");
					home.Module_HomeButton();
					Log.info("Module_HomeButton is successful");
					
					Log.endTestCase("Selenium_Test_Compare");
		 		*/
		//TC_FeaturedSellers --- complete
				/*
				 	Log.startTestCase("Selenium_Test_FeaturedSellers");
				 	
					Log.info("Module_GoToNewegg is successful");
					search.Module_FeaturedSellers();
					Log.info("Module_FeaturedSellers is successful");
					home.Module_HomeButton();
					Log.info("Module_HomeButton is successful");
					
					Log.endTestCase("Selenium_Test_FeaturedSellers");
		 		*/	
		//TC_Checkout as user and guest --- complete
				/*
					Log.startTestCase("Selenium_Test_Checkout");
					
					bar.Module_ItemSearch("laptop");
					Log.info("Module_ItemSearch is successful");
					prod.Module_Cart();
					Log.info("Module_Cart is successful");
					prod.Module_Checkout();
					Log.info("Module_Checkout is successful");
					login.Module_InputLogin("LeatherlikeScaling@maildrop.cc", "Zenergy20");
					Log.info("Module_InputLogin is successful");
					home.Module_HomeButton();
					Log.info("Module_HomeButton is successful");
					home.Module_Logout();
					Log.info("Module_Logout is successful");
					bar.Module_ItemSearch("laptop");
					Log.info("Module_ItemSearch is successful");
					prod.Module_Cart();
					Log.info("Module_Cart is successful");
					prod.Module_Checkout();
					Log.info("Module_Checkout is successful");
					prod.Module_CheckoutasGuest();
					Log.info("Module_CheckoutasGuest is successful");
					home.Module_HomeButton();
					Log.info("Module_HomeButton is successful");
					
					Log.endTestCase("Selenium_Test_Checkout");
				*/
				
		//TC_Sort --- complete
				/*
				 	Log.startTestCase("Selenium_Test_Sort");
				 	
					bar.Module_ItemSearch("PS4 Systems");
					Log.info("Module_ItemSearch is successful");
					search.Module_SortByLowest();
					Log.info("Module_SortByLowest is successful");
					home.Module_HomeButton();
					Log.info("Module_HomeButton is successful");
					
					Log.endTestCase("Selenium_Test_Sort");
				*/
		// Module Review
				
				/*
				 	Log.startTestCase("Selenium_Test_Review");

					home.Module_LoginButton();
					Log.info("Module_LoginButton is successful");
					login.Module_InputLogin("LeatherlikeScaling@maildrop.cc", "Zenergy20");
					Log.info("Module_InputLogin is successful");
					home.Module_GoToNewegg();
					Log.info("Module_GoToNewegg is successful");
					bar.Module_ItemSearch("PS4 Systems");
					Log.info("Module_ItemSearch is successful");
					search.Module_ClickItem();
					Log.info("Module_ClickItem is successful");
					prod.Module_Review();
					Log.info("Module_Review is successful");
					home.Module_HomeButton();
					Log.info("Module_HomeButton is successful");
					
					Log.endTestCase("Selenium_Test_Review");
				*/
		//TC_FeedBack
				/*
				 	
				 	Log.startTestCase("Selenium_Test_Feedback");
				 	
					WebElement feedback = driver.findElement(By.id("guest_feedback_from_newegg"));
					feedback.click();
					Log.info("Feedback is clicked");
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='javascript:;']")));
					Process process = Runtime.getRuntime().exec("D:\\Program Files\\eclipse\\ZenergyProject-28MarchRework\\Zenergy\\Project\\move.exe");
					Log.info("Autoit Script to fill Feedback ran successful");
					process.waitFor();
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='button']")));
					Actions act = new Actions (driver);
					act.moveToElement(driver.findElement(By.xpath("//button[@type='button']"))).click().build().perform();
					Log.info("Feedback is closed");
					home.Module_HomeButton();
					Log.info("Module_HomeButton is successful");
					
					Log.endTestCase("Selenium_Test_Feedback");
				*/
	}
		// TC_Sort --- complete
				/*
					Log.startTestCase("Selenium_Test_Sort");
					
					bar.Module_ItemSearch("PS4 Systems");
					Log.info("Module_ItemSearch is successful");
					search.Module_SortByLowest();
					Log.info("Module_SortByLowest is successful");
					
					Log.endTestCase("Selenium_Test_Sort");
				*/	
		
	
}
