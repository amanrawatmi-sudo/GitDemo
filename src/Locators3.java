import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chorme.driver", "C:/Tools/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// siblings and parent traverse
		// Absolute xpath :- we give locator starting from main parent tag then we start
		// with single slash
		// relative path we can start from anywhere
		// we can move from sibling to sibling :-
		// //header/div/button[1]/following-sibling::button[1]
		System.out
				.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
		// Traverse from child to parent :-
		// //header/div/button[1]/parent::div/parent::header
		// if we now to more again from header parent to child then :-
		// //header/div/button[1]/parent::div/parent::header/a
		// This traverse is not possible in CSS
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());
	}

}
