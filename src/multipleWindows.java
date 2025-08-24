import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class multipleWindows {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        // To open new Tab
        driver.switchTo().newWindow(WindowType.TAB);
        //driver.switchTo().newWindow(WindowType.WINDOW);
        Set<String> newWindow = driver.getWindowHandles();
       Iterator<String> it =  newWindow.iterator();
       String parent = it.next();
       String child = it.next();
        driver.switchTo().window(child);
        driver.get("https://rahulshettyacademy.com/#/practice-project");
        String title = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
        driver.switchTo().window(parent);
        WebElement name = driver.findElement(By.cssSelector("[name='name']"));
        name.sendKeys(title);
        
        //Taking screenshot of a web Element only available from selenium 4
       File shot = name.getScreenshotAs(OutputType.FILE);
       FileUtils.copyFile(shot, new File("name.png"));
       
       // Get Width and height of edit box only available from selenium 4
        System.out.println(name.getRect().getDimension().getHeight());
        System.out.println(name.getRect().getDimension().getWidth());
        
	}

}
