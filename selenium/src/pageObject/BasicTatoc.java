package pageObject;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BasicTatoc extends ReadFilee {

	String url = "http://10.0.1.86/tatoc";
	WebDriver driver;

	@BeforeTest
	public void launch() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rambhuwanrajpoot\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void basicCourse() {
		WebElement basic = getElement(driver, "clickOnBasic", "xpath.txt");
		basic.click();
		System.out.println("click on basic");
	}
	@Test(priority = 2)
	public void clickOnGreen() {
		WebElement Green=getElement(driver, "clickOnGreen", "xpath.txt");
		Green.click();
		System.out.println("click on green");
	}
	
}
