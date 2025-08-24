import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class sslClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Chrome option class is used to set the behaviour of the browser
		ChromeOptions options = new ChromeOptions();
		// To set proxy we use proxy class
//		Proxy proxy = new Proxy();
//		proxy.setHttpProxy("ipaddress:4444");
//		options.setCapability("proxy", proxy);
		//FirefoxOptions options = new FirefoxOptions();
		//EdgeOptions options = new EdgeOptions();
		options.setAcceptInsecureCerts(true);
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://expired.badssl.com/");
        System.out.println(driver.getTitle());
        
	}

}
