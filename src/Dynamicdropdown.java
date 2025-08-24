import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dynamicdropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise");
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
//        driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		// This is not required as this dropdown opens by itself
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		// Without using indexes
		// Parent child relationship xpath
		// USING parent xpath to find the value of child xpath : ParentxpathChildxpath
		// div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']"))
				.click();
		// Calendar Date Selection
		driver.findElement(By.cssSelector("a[class='ui-state-default ui-state-active']")).click();
	}

}
