package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgDemo {
	
	public String url="https://www.toolsqa.com/selenium-webdriver/testng-prioritizing-sequencing/";
    WebDriver driver;
    @BeforeTest
    public void beforeTest() {
    	driver=new ChromeDriver();
    	driver.get(url);
    }
	
	@ Test(priority = 2)
    public void test1() {
    	System.out.println("this is test case one");
    }
	@Test (priority = 1)
	public void test2() {
		System.out.println("this is test case two");
	}
	@Test(priority = 3)
	public void test3() {
		System.out.println("this is test case three");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
