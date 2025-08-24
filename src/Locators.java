import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chorme.driver", "C:/Tools/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// implicit wait- 5 seconds timeout
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("aman");
		driver.findElement(By.name("inputPassword")).sendKeys("Password");
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		// css selector can be created in two ways :- classname -> tagname.classname
		// No spaces should be present between text replace it with "."
		// id-> tagname#id
		// second method is :- <input type= "text" placeholder="username">
		// then css selector will be:- input[placeholder='username']
		// 'a' stands for anchor which is manadatory for link text
		driver.findElement(By.linkText("Forgot your password?")).click();
		// Thread.sleep(1000); It is for adding delays 1000 mili seconds equals 1 second
		Thread.sleep(1000);
		// To create X path -> //tagname[@attirbute='value'] make sure attribute should
		// be unique
		// //input[@placeholder='username']
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("aman");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("amamrawatmi@gmail.com");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
		// To create X path -> //tagname[@attirbute='value'][index value] with index
		// value
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("amshyrawat12@gmail.com");
		// driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("amshyrawat12@gmail.com");
		// To create Css -> tagname[attirbute='value']:nth-child(index value) with index
		// value
		// To only use tags :- //tagname/child tagname ->single slash is used for child
		// tagnames else it will not recorgnise
		// To only use tags with similar name :- //tagname/child tagname [index value]
		// when no attributes are present for my element then only tags names are used
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("8384849614");
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		// for css only tags :- parenttagname childtagname
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("aman");
		// tag name[attribute*='value'] * is used if we want to find element with
		// partial text
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxOne")).click();
		// For using partail text in xpath :- ("//tagname[contains(@class,'submit')]")
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

	}

}
