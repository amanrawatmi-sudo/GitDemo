import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// 1. Give me the count of the links present in this page
		// links always have an anchor tag "a"
		System.out.println(driver.findElements(By.tagName("a")).size());

		// 2. Give me the count of links present in footer section
           WebElement footerDriver=driver.findElement(By.id("gf-BIG")); // Limiting web driver scope
           System.out.println(footerDriver.findElements(By.tagName("a")).size());
           
        //3. Give me links that are in first column of footer section
           // Minimizing scope to column level in footer section of web page
           WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
           System.out.println(columnDriver.findElements(By.tagName("a")).size());
           
        //4. Click on each link in column and check if pages are opening and then get their title
            
           int length = columnDriver.findElements(By.tagName("a")).size();
           for(int i=1;i<length;i++)
           {
        	  String clickOnLinks =  Keys.chord(Keys.CONTROL,Keys.ENTER);
        	   columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinks);
        	   Thread.sleep(5000);
        	   
           }
           // Moving to windows by getWindowHandles to get the titles
           Set<String> a = driver.getWindowHandles();
    	   Iterator<String> it = a.iterator();
           while(it.hasNext())
    	   {
    		   driver.switchTo().window(it.next());
    		   System.out.println(driver.getTitle());
    	   }
           
	}

}
