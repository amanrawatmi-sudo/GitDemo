import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class calendars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         WebDriver driver = new ChromeDriver();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
         driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
         String month = "7";
         String date = "16";
         String year = "1999";
         String[] expectedList = {month,date,year};
         driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
         driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
         driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
         driver.findElement(By.cssSelector(".react-calendar__navigation__prev-button")).click();
         driver.findElement(By.cssSelector(".react-calendar__navigation__prev-button")).click();
         driver.findElement(By.cssSelector(".react-calendar__navigation__prev-button")).click();
         driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
         //converted String to integer as get only works with int
         driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(month)-1).click();
         driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();
         
         // Print the selected calendar date in output
         List<WebElement> bday = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
         for(int i =0;i<bday.size();i++)
         {
        	 System.out.println(bday.get(i).getAttribute("value"));
        	 Assert.assertEquals(bday.get(i).getAttribute("value"), expectedList[i]);
         }
         driver.close();
	}

}
