import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.NoSuchElementException;

/*
 * 1.	Get Test cases working
 * 2.	Start logging with Log4j
 * 3.	Pull data like email and inputs from an external source like Excel
 */

public class NewEgg {
	public static void main(String[] args) throws IOException, InterruptedException, NoSuchElementException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		HomePage home = new HomePage(driver);
		LoginPage login = new LoginPage(driver);
		Searchbar bar = new Searchbar(driver);
		ProductPage prod = new ProductPage(driver);
		SearchPage search = new SearchPage(driver);
		DOMConfigurator.configure("log4j.xml");
		//Log.startTestCase("Selenium Test Register");
		
		//Test Account: "LeatherlikeScaling@maildrop.cc", "Zenergy20"
		
		//TC_Register --- complete
		
		home.Module_GoToNewegg();
		home.Module_LoginButton();
		login.Module_SignupUserName("LeatherlikeScaling@maildrop.cc");
		login.Module_SignupPwd("Zenergy20");
			
		//TC_Search --- complete, could add more searches just to make it special.
		/*
		home.Module_GoToNewegg();
		search.Module_ItemSearch("laptop");*/
		
		//TC_AddToWishlist --- completed
		/*
		home.Module_GoToNewegg();
		home.Module_LoginButton();
		login.Module_InputLogin("LeatherlikeScaling@maildrop.cc", "Zenergy20");
		home.Module_GoToNewegg();
		bar.Module_ItemSearch("PS4 Systems");
		search.Module_ClickItem();
		prod.Module_AddToWishList();
		*/
			
		//TC_PromoCode --- complete
		/*
		home.Module_GoToNewegg();
		login.Module_SignupUserName("LeatherlikeScaling@maildrop.cc");
		*/
		
		//TC_Sort --- complete
		/*
		home.Module_GoToNewegg();
		bar.Module_ItemSearch("PS4 Systems");
		search.Module_SortByLowest();
		*/
		
		//TC_Compare --- complete
		/*
		home.Module_GoToNewegg();
		bar.Module_ItemSearch("laptop");
		search.Module_Compare();
		*/
		
		//TC_FeaturedSellers --- complete
		/*
		home.Module_GoToNewegg();
		search.Module_FeaturedSellers();
		*/
		
		//TC_Checkout as user --- complete
		/*
		home.Module_GoToNewegg();
		bar.Module_ItemSearch("laptop");
		prod.Module_Cart();
		prod.Module_Checkout();
		login.Module_InputLogin("LeatherlikeScaling@maildrop.cc", "Zenergy20");
		*/
		
		//TC_Checkout as guest --- complete
		/*
		home.Module_GoToNewegg();
		home.Module_LoginButton();
		login.Module_SignupUserName("LeatherlikeScaling@maildrop.cc");
		login.Module_SignupPwd("Zenergy20");
		bar.Module_ItemSearch("laptop");
		prod.Module_Cart();
		prod.Module_Checkout();
		*/
		// Module Review
		/*
		home.Module_GoToNewegg();
		home.Module_LoginButton();
		login.Module_InputLogin("LeatherlikeScaling@maildrop.cc", "Zenergy20");
		home.Module_GoToNewegg();
		bar.Module_ItemSearch("PS4 Systems");
		search.Module_ClickItem();
		prod.Module_Review();
		*/
	}
}

