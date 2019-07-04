package selenium;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GmailTest {
	public String url = "https://gmail.com";

	WebDriver driver;

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rambhuwanrajpoot\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
	}

	@Test(priority = 1)
	public void inValidCrendtial() throws InterruptedException {
		WebElement email = driver.findElement(By.xpath("//input[@ type=\"email\"]"));
		email.click();
		System.out.println("sending emailid");
		email.clear();
		email.sendKeys("ramqait@gmail.com");
		WebElement emailNext = driver.findElement(By.xpath("//span[text()=\"Next\"]"));
		emailNext.click();
		Thread.sleep(3000);
		WebElement passWord = driver.findElement(By.xpath("(//input[@class=\"whsOnd zHQkBf\"])[1]"));
		passWord.click();
		passWord.sendKeys("**************");
		WebElement passNext = driver.findElement(By.xpath("//span[text()=\"Next\"]"));
		passNext.click();
		Thread.sleep(2000);
		WebElement wrongPassText = driver.findElement(By.xpath("//span[contains(text(),\"Wrong password\")]"));
		assertTrue(wrongPassText.isDisplayed());

	}

	@Test(priority = 2)
	public void validCrendtial() throws InterruptedException {
//		WebElement email = driver.findElement(By.xpath("//input[@ type=\"email\"]"));
//		email.click();
//		email.sendKeys("ramqait@gmail.com");
//		WebElement emailNext = driver.findElement(By.xpath("//span[text()=\"Next\"]"));
//		emailNext.click();
//		System.out.println("click on next");

		WebElement passWord = driver.findElement(By.xpath("(//input[@class=\"whsOnd zHQkBf\"])[1]"));
		passWord.click();
		passWord.sendKeys("***********");
		WebElement passNext = driver.findElement(By.xpath("//span[text()=\"Next\"]"));
		passNext.click();

		System.out.println("click on next");

		System.out.println("login successfully");
		WebElement Gmail=driver.findElement(By.xpath("(//a[@title=\"Gmail\"])[2]"));
		assertTrue(Gmail.isDisplayed());
		System.out.println("Gmail page is displayeed");
		
	}

	@Test(priority = 3)
	public void compose() throws InterruptedException {
		WebElement compose = driver.findElement(By.xpath("//div[@gh=\"cm\"]"));
		compose.click();
		System.out.println("click on compose");
		Thread.sleep(10000);
		
		 WebElement inbox=driver.findElement(By.xpath("(//div[@class=\"aYF\"])[1]"));
		 assertTrue(inbox.isDisplayed());
		 System.out.println("inbox is displayed");
		 
	}

	@Test(priority = 4)
	public void to() throws InterruptedException {
        WebElement to=driver.findElement(By.xpath("(//textarea[@tabindex=\"1\"])[1]"));
        to.click();
        System.out.println("click on to");
        to.sendKeys("rambhuwananr@gmail.com");
        Thread.sleep(5000);
        WebElement subject=driver.findElement(By.xpath("//input[@class=\"aoT\"]"));
		subject.click();
		System.out.println("click on to subject");
		subject.sendKeys("this message is send through automated");
		Thread.sleep(5000);
		WebElement send=driver.findElement(By.xpath("(//div[@class=\"T-I J-J5-Ji aoO v7 T-I-atl L3\"])[1]"));
    	send.click();
    	System.out.println("click on send");
    	Thread.sleep(5000);
    	
    	WebElement messageSent=driver.findElement(By.xpath("(//div[@class=\"vh\"])[1]"));
    	assertTrue(messageSent.isDisplayed());

    		
	}
	@AfterTest
	public void end() {
		driver.close();
	}

}
