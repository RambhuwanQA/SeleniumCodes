package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Guru99 {
	public static void main(String[] args) {
		String url="http://demo.guru99.com/v1/";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rambhuwanrajpoot\\Downloads\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		System.out.println("url");
		driver.manage().window().maximize();
		System.out.println("window");
		WebElement userId=driver.findElement(By.xpath("//td/input[@name=\"uid\"]"));
		System.out.println("userName");
		WebElement passWord=driver.findElement(By.xpath("//td/input[@name=\"password\"]"));
		System.out.println("passWord");
		userId.click();
		System.out.println("click on userId");
		passWord.click();
		System.out.println("click on password");
		userId.sendKeys("rambhuwan");
		passWord.sendKeys("ram123");
		
		
		driver.close();
	}

}
