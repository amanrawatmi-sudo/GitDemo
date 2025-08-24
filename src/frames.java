import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame(0);
		//driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
		driver.findElement(By.id("draggable")).click();
		//Frames are independent html codes seprated from the other elements
		//Frames:- placing containers in the box
		// Frames are the part of web page or window which displays content
		// The HTML or elements that go in frame may not come from the same website it can be of outside website
		// we can switch to frame either by string , frameId or webelement
		Actions a = new Actions(driver);
		//drag and drop element
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement destination = driver.findElement(By.id("droppable"));
		a.dragAndDrop(source, destination).build().perform();
		
		//Now to move from frame to default window 
		driver.switchTo().defaultContent();
	}

}
