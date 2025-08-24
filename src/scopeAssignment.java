import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class scopeAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("//div/div[4]/fieldset/label[2]/input")).click();
		String lab= driver.findElement(By.xpath("//div/div[4]/fieldset/label[2]")).getText();
		WebElement drop = driver.findElement(By.id("dropdown-class-example"));
		Select a = new Select(drop);
		a.selectByVisibleText(lab);
		driver.findElement(By.name("enter-name")).sendKeys(lab);
		driver.findElement(By.id("alertbtn")).click();
		String tex = driver.switchTo().alert().getText();
		if(tex.contains(lab))
		{
			System.out.println("Success");
		}
		else
			System.out.println("Error");
		
	}

}
