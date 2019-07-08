package Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumGrid {
	WebDriver driver;
	String baseURL;
	String nodeURL;

	@BeforeTest
	public void setUp() throws MalformedURLException {
		 baseURL = "https://www.google.com/";
	     nodeURL = "http://10.0.9.37:4442/wd/hub";
		 DesiredCapabilities capability = DesiredCapabilities.chrome();
		  
		 capability.setPlatform(Platform.VISTA); 
		 driver = new RemoteWebDriver(new URL(nodeURL), capability);
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	}
    @Test
	public void simpleTest() {
		driver.get(baseURL);
        WebElement google = driver.findElement(By.xpath("//input[@name=\"q\"]"));
		google.click();
		google.sendKeys("amazon");
        System.out.println("amazon");
        WebElement search=driver.findElement(By.xpath("(//input[@class=\"gNO89b\"])[2]"));
        search.click();
	}

}
