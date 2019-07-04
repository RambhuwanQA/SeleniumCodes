package pageObject;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BasicTatoc extends ReadFilee{

	/*
	 * public String clickOnBasic; public String clickOnGreen; public String frame;
	 * public String color1; public String color2;
	 */

	String url = "http://10.0.1.86/tatoc";
	WebDriver driver;

	@BeforeTest
	public void launch() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rambhuwanrajpoot\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
	}
    @Test(priority = 1)
	public void basicCourse() {
		WebElement basic = driver.findElement(By.xpath(recieve("clickOnBasic", "xpath.txt")));
		basic.click();
		System.out.println("click on basic");
	}
    @Test(priority = 2)
	public void clickOnGreen() throws InterruptedException {
		WebElement green = driver.findElement(By.xpath(recieve("clickOnGreen", "xpath.txt")));
		green.click();
		System.out.println("click on green");
		Thread.sleep(500);
		WebElement frame = driver.findElement(By.xpath(recieve("frame", "xpath.txt")));
		assertTrue(frame.isDisplayed());

	}
	
}
