package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoFb {
	public static void main(String[] args) {
		String url="http://demo.guru99.com/test/facebook.html";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rambhuwanrajpoot\\Downloads\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		System.out.println("url");
		WebElement email=driver.findElement(By.xpath("//input[@id=\"email\"]"));
		System.out.println("email");
		WebElement pass=driver.findElement(By.xpath("//input[@id=\"pass\"]"));
		System.out.println("pass");
		
		email.click();
		System.out.println("click on email");
		pass.click();
		System.out.println("click on pass");
		
		email.sendKeys("ram");
		pass.sendKeys("123");
		WebElement login=driver.findElement(By.xpath("//input[@tabindex=\"4\"]"));
		System.out.println("login");
		login.click();
		System.out.println("click on login");
		System.out.println("login succesfully");
		driver.close();
	}

}
