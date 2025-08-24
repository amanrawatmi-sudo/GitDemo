import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Javaalerts {

	public static void main(String[] args) {
		String text = "Aman";
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.id("alertbtn")).click();
		// To work on alerts use "switch" to shift from driver browser to alerts
		// To grab text on alert
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		// context is now switched to alerts

		// Now to work on alerts that have two options "OK" and "Cancel"
		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		// To cancel the pop up use "dismiss"
		// For positive response use "accept" and for Negative response use "dismiss"
		driver.switchTo().alert().dismiss();
	}

}
