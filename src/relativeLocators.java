import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.openqa.selenium.support.locators.RelativeLocator.*;
// Relative or friendly locators
//Above , below, toLeftOf, toRightOf
//Syntax : - driver.findElement(WithTagName("XX").above(WebElement))
public class relativeLocators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           WebDriver driver = new ChromeDriver();
           driver.get("https://rahulshettyacademy.com/angularpractice/");
         WebElement nameEditBox =  driver.findElement(By.cssSelector("[name='name']"));
         System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());
        
         WebElement dob = driver.findElement(By.cssSelector("[for='dateofBirth']"));
         // It is skipping one input tag as there relative locators does not support flex html elements
         driver.findElement(with(By.tagName("input")).below(dob)).click();
         
         WebElement checkBox = driver.findElement(By.cssSelector("[class='form-check-label']"));
         driver.findElement(with(By.tagName("input")).toLeftOf(checkBox)).click();
         
         WebElement radioButton = driver.findElement(By.id("inlineRadio1"));
         System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radioButton)).getText());
	}

}
