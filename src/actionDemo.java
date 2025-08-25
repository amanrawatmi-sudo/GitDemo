import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class actionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           WebDriver driver = new ChromeDriver();
           driver.manage().window().maximize();
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
           driver.get("https://www.amazon.com/");
           driver.findElement(By.cssSelector("button[alt='Continue shopping']")).click();
           WebElement move = driver.findElement(By.cssSelector("div[id='nav-link-accountList']"));
           Actions a = new Actions(driver);
           //Typing capital letters in search box
           a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
           //Moves to specific element
           // With the help of context click we can use right click
           a.moveToElement(move).contextClick().build().perform();
           a.moveToElement(move).contextClick().build().perform();
           a.moveToElement(move).contextClick().build().perform();
	}

}
