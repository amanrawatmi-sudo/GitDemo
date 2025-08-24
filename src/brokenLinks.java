import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class brokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
        WebDriver driver = new ChromeDriver();
        // Creating object for soft assert class
        SoftAssert a = new SoftAssert();
        // broken links are broken urls
        //Step1: To get all urls tied up to the links using selenium
        // Java methods will we used to get the status codes for the links
        // If status code is greater than 400 then that links which is tied to url is broken
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement>links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        for(WebElement link: links) {
        	//now to get the complete url of the link will use get attriburte 
            String url = link.getAttribute("href");
            // Now we are using openConnection method from url class
            // Through is openConnection we can send the url to the network to get the response
            HttpURLConnection net = (HttpURLConnection)new URL(url).openConnection();
            net.setRequestMethod("HEAD");
            net.connect();
            int response = net.getResponseCode();
            System.out.println(response);
            // using object a instead of Assert is soft assertion in this way it wll not fail the execution immediately it will only catch the response 
            a.assertTrue(response<400, "This link: "+link.getText()+"with Response code"+response);
            
        }
        // In soft assert AssertAll is required to report the failures.
        //If we face any broken links after the execuiton of all the links then it will fail it else pass
        a.assertAll();
        
	}

}
