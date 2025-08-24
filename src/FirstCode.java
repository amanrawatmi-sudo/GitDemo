import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;

public class FirstCode {

	public static void main(String[] args) {
		// Invoking Browser
		// chrome - ChromeDriver ->Methods
		// ChromeDriver driver=new ChromeDriver();

		// chromedriver.exe -> Chrome Browser
		// step to invoke chrome browser
		// Selenium manager : It checks if chorme driver files is present if not then
		// put it in place
		// If invoke manually
		System.setProperty("webdriver.chorme.driver", "C:/Tools/chromedriver.exe");
		WebDriver driver1 = new ChromeDriver();
		driver1.get("https://rahulshettyacademy.com/");
		System.out.println(driver1.getTitle());
		System.out.println(driver1.getCurrentUrl());
		driver1.close();
		driver1.quit();
		// FireFox Launch
		// geckodriver
		// webdriver.gecko.driver
//           System.setProperty("webdriver.gecko.driver", "C:/Tools/geckodriver.exe");
//           WebDriver driver2 = new FirefoxDriver();
//           driver2.get("https://rahulshettyacademy.com/");
//           System.out.println(driver2.getTitle());
//           System.out.println(driver2.getCurrentUrl());
//           driver2.close();
//           driver2.quit();
		// Microsoft Edge Launch
		// msedgedriver
		System.setProperty("webdriver.edge.driver", "C:/Tools/msedgedriver.exe");
		WebDriver driver3 = new EdgeDriver();
		driver3.get("https://rahulshettyacademy.com/");
		System.out.println(driver3.getTitle());
		System.out.println(driver3.getCurrentUrl());
		driver3.close();
		driver3.quit();
	}

}
