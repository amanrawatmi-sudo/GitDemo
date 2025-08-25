import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.cssSelector("input[name='name']")).sendKeys("Aman");
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("amanrawatmi");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("amanrawart");
		driver.findElement(By.id("exampleCheck1")).click();
		WebElement staticDropDown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select dropdown = new Select(staticDropDown);
		dropdown.selectByVisibleText("Male");
		driver.findElement(By.id("inlineRadio2")).click();
		driver.findElement(By.cssSelector("input[name='bday']")).sendKeys("07/16/1999");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		System.out.println(
				driver.findElement(By.cssSelector("div[class='alert alert-success alert-dismissible']")).getText());
		System.out.println(
				driver.findElement(By.cssSelector("div[class='alert alert-success alert-dismissible']")).getText());
		System.out.println(
				driver.findElement(By.cssSelector("div[class='alert alert-success alert-dismissible']")).getText());
	}

}
