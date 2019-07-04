package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Launch {
	public static void main(String[] args) throws InterruptedException {
		
	
	
	String baseUrl = "https://www.google.com";
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\rambhuwanrajpoot\\Downloads\\chromedriver.exe"); 
    // String actual=driver.getTitle();
	WebDriver driver = new ChromeDriver();
	 driver.get(baseUrl);
	 
	 WebElement myinputbox  = driver.findElement(By.cssSelector((".gLFyf.gsfi")));
	 
	 
	 myinputbox.click();
	 myinputbox.sendKeys("QA INFOTECH");
	 
	 
     driver.close();

}
}
