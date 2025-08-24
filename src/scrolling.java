import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class scrolling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
         WebDriver driver = new ChromeDriver();
         driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    
        // To use Java script  use JavaScriptExecutor
         JavascriptExecutor js = (JavascriptExecutor)driver;
         // To use scroll in window use:- window.scrollBy(0,500)
         js.executeScript("window.scrollBy(0,500)");
         Thread.sleep(3000);
         // To use scroll in particular element in window use : document.querySelector("elementpath").scrollTop =500
         //scrollTop is used to scroll down
         js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
          List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
         int sum=0;
          for(int i =0; i<values.size();i++)
          {
        	  sum = sum+ Integer.parseInt(values.get(i).getText());
        	  
          }
          System.out.println(sum);
          int num = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(" ")[3]);
          System.out.println(num);
          // Testng is used for assertions
          Assert.assertEquals(num, sum);
          
          // Assignment get total sum of second table
          List<WebElement>newNum = driver.findElements(By.cssSelector("table.table-display td:nth-child(3)"));
          int newSum = 0;
          for(int j=0;j<newNum.size();j++)
          {
        	  newSum = newSum+Integer.parseInt(newNum.get(j).getText());
          }
          System.out.println(newSum);
          
	}

}
