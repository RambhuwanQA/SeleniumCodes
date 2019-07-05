package com.qait.FirstMaven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BasicTatocTest  {

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
	public void clickOnBasicCourse() {
		WebElement basic =  ReadFilee.getElement(driver, "clickOnBasic", "xpath.txt");
		basic.click();
		System.out.println("click on basic");
	   
	}
	@Test(priority = 2)
	public void clickOnGreen() {
		WebElement clickOnGreen= driver.findElement(By.xpath("//div[@class=\"greenbox\"]"));
		clickOnGreen.click();
	}
	@AfterTest
	public void end() {
		driver.quit();
	}
	
}
