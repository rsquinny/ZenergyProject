import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class NewEgg {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//Test Account: "LeatherlikeScaling@maildrop.cc", "Zenergy20"
		//test.tester();
		
		//TC_Register
		/*
		HomePage home = new HomePage(driver);
			home.Module_GoToNewegg();
			home.Module_LoginButton();
		LoginPage log = new LoginPage(driver);
			log.Module_Signup("LeatherlikeScaling@maildrop.cc", "Zenergy20");*/
			
		//TC_Search
		HomePage home = new HomePage(driver);
			home.Module_GoToNewegg();
		Searchbar search = new Searchbar(driver);
			search.Module_ItemSearch("laptop");
		
		//TC_PromoCode
		/*HomePage home = new HomePage(driver);
			home.Module_GoToNewegg();
		LoginPage log = new LoginPage(driver);
			log.Module_SignupUserName("LeatherlikeScaling@maildrop.cc");*/
	}
}

