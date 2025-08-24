import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class cookies {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
       WebDriver driver = new ChromeDriver();
       driver.manage().window().maximize();
       // Deleting cookies 
       driver.manage().deleteAllCookies();
       //driver.manage().deleteCookieNamed(null);
       driver.get("http://google.com");
       
       // How to take a screenshot
       // need to convert the webpage driver to screenshot driver 
       File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       
       // Now to copy the object from source Object to our local machine
       // Note:- Do not use C driver as in some cases you will require admin rights 
       FileUtils.copyFile(src,new File( "D:\\ScreenShots\\screenshot.png"));
       
       
       
	}

}
