import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Shoppingcart {
// Synchronization in selenium is achieved by using waits . Best results whiles using both
// Explicit wait can be achieved in two ways :- 1) WebDriverWait 2) FluentWait
	// Both classes implement Wait interface
// Fluent wait checks for web element in intervals as per polling rate given
	// Fluent Wait = 10 seconds, polling 4 seconds
	// Fluent Wait example :- your card is expected (3 Sec), your oder is being (7 Sec)processed-Confirmation
	// It can not be achieved by WebDriverWait as the HTML code for whole message was same as a result it takes first text as success and it proceed further.
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		// Adding implicit wait
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//Explicit wait
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		//Disadvantage is that if we need some functionality to work under 2 seconds but we have given 5 seconds wait then it will not able to identify issues.
		String[] veggies = { "Cucumber", "Brocolli" };
		// Need to convert array into array list as it have methods called contains :
		// use ".asList"
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(3000);
		addItems(driver, veggies);
		// if we dont want to make our method static then
		// Shoppingcart obj = new Shoppingcart();
		// obj.addItems(driver, veggies);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		// Explicit wait target only specific element
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoinfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoinfo")).getText());
	}

	// Made it static as we are using this methods without using object of the
	// this method is also known as utility
	public static void addItems(WebDriver driver, String[] veggies) {
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		for (int i = 0; i < products.size(); i++) {
			List requiredProduct = Arrays.asList(veggies);
			// Neeed to split the text as ful text contains "-1kg" and it does not matches
			// out if loop condition
			String[] name = products.get(i).getText().split("-");
			// To remove whitespaces used trim
			String formatName = name[0].trim();
			int count = 0;
			if (requiredProduct.contains(formatName)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				count++;
				if (count == veggies.length)
				// For list we use ".size()" and for array we use ".length"
				{
					break;
				}
			}
		}
	}

}