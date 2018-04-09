import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.awt.AWTException;




public class NewEgg {

	static WebDriver driver = new ChromeDriver();
	static HomePage home = new HomePage(driver);
	static Searchbar bar = new Searchbar(driver);
	static SearchPage search = new SearchPage(driver);
	static LoginPage log = new LoginPage(driver);
	static ProductPage prod = new ProductPage(driver);
	
	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	
				//Test Account: "LeatherlikeScaling@maildrop.cc", "Zenergy20"
		
		//TC_Register --- complete
		/*
			home.Module_GoToNewegg();
			home.Module_LoginButton();
			log.Module_SignupUserName("LeatherlikeScaling@maildrop.cc");
			log.Module_SignupPwd("Zenergy20");*/
			
		//TC_Search --- complete, could add more searches just to make it special.
		/*
			home.Module_GoToNewegg();
			search.Module_ItemSearch("laptop");*/
		
		//TC_AddToWishlist --- completed
		/*
			home.Module_GoToNewegg();
			home.Module_LoginButton();
			log.Module_InputLogin("LeatherlikeScaling@maildrop.cc", "Zenergy20");
			home.Module_GoToNewegg();
			bar.Module_ItemSearch("PS4 Systems");
			search.Module_ClickItem();
			prod.Module_AddToWishList();*/
			
		//TC_PromoCode --- complete
		/*
			home.Module_GoToNewegg();
			log.Module_SignupUserName("LeatherlikeScaling@maildrop.cc");*/
		
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
			log.Module_InputLogin("LeatherlikeScaling@maildrop.cc", "Zenergy20");
		*/
		//TC_Checkout as guest --- complete
		/*
			home.Module_GoToNewegg();
			home.Module_LoginButton();
			log.Module_SignupUserName("LeatherlikeScaling@maildrop.cc");
			log.Module_SignupPwd("Zenergy20");
			bar.Module_ItemSearch("laptop");
			prod.Module_Cart();
			prod.Module_Checkout();
		*/
		//TC_Sort --- complete
		/*
		home.Module_GoToNewegg();
		bar.Module_ItemSearch("PS4 Systems");
		search.Module_SortByLowest();*/
	}
}

