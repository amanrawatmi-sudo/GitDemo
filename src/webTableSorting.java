import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class webTableSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        
        // To DO 
        // Click on the column
        driver.findElement(By.cssSelector("th[aria-label*='Veg/fruit name']")).click();
     // Capture all the web elements for that into a list
        List<WebElement>veggies = driver.findElements(By.xpath("//tr/td[1]"));
        // Use get Text to capture text of all web elements
        List<String> newList = veggies.stream().map(s->s.getText()).collect(Collectors.toList());
        // Use sort on original list , as it is already sorted then there should be now change while comparing
        List<String> sortedList = newList.stream().sorted().collect(Collectors.toList());
        // compare original and sorted list
        Assert.assertTrue(sortedList.equals(newList));
        System.out.println(sortedList);
        
        //Scan the name column with get Text , if Text is 'Beans' then print its price
        // Pagination is the process of dividing content into discrete, numbered pages, commonly used to manage and navigate large amounts of information
        List<String> veggiePrice;
        do {
        	
        	List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
        veggiePrice = rows.stream().filter(s->s.getText().contains("Rice")).map(s->getVeggiePrice(s)).collect(Collectors.toList());
       veggiePrice.forEach(s->System.out.println(s));
       // What if the required element is not present in the front page . It is present in the other pages of the website
       if(veggiePrice.size()<1)
       {
    	   driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
    	   
       }
        }while(veggiePrice.size()<1);
	}

	private static String getVeggiePrice(WebElement s) {
		// TODO Auto-generated method stub
		String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}

}
