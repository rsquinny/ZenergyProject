import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class NewEgg {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
				//Test Account: "LeatherlikeScaling@maildrop.cc", "Zenergy20"
		
		//TC_Register --- complete
		/*
		HomePage home = new HomePage(driver);
			home.Module_GoToNewegg();
			home.Module_LoginButton();
		LoginPage log = new LoginPage(driver);
			log.Module_SignupUserName("LeatherlikeScaling@maildrop.cc");
			log.Module_SignupPwd("Zenergy20");*/
			
		//TC_Search --- complete, could add more searches just to make it special.
		/*
		HomePage home = new HomePage(driver);
			home.Module_GoToNewegg();
		Searchbar search = new Searchbar(driver);
			search.Module_ItemSearch("laptop");*/
		
		//TC_AddToWishlist --- completed
		/*
		HomePage home = new HomePage(driver);
			home.Module_GoToNewegg();
			home.Module_LoginButton();
		LoginPage log = new LoginPage(driver);
			log.Module_InputLogin("LeatherlikeScaling@maildrop.cc", "Zenergy20");
			home.Module_GoToNewegg();
		Searchbar bar = new Searchbar(driver);
			bar.Module_ItemSearch("PS4 Systems");
		SearchPage search = new SearchPage(driver);
			search.Module_ClickItem();
		ProductPage prod = new ProductPage(driver);
			prod.Module_AddToWishList();*/
			
		//TC_PromoCode --- complete
		/*
		HomePage home = new HomePage(driver);
			home.Module_GoToNewegg();
		LoginPage log = new LoginPage(driver);
			log.Module_SignupUserName("LeatherlikeScaling@maildrop.cc");*/
	}
}

