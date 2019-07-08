package Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qait.FirstMaven.ReadFilee;

public class BasicTatocTest extends ReadFilee {

	String url = "http://10.0.1.86/tatoc";
	WebDriver driver;

	@BeforeTest
	public void launch() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rambhuwanrajpoot\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();

		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
	}
	@Test(priority = 1)
	public void clickOnBasicCourse() {
		WebElement basic =  getElement(driver, "clickOnBasic", "xpath.txt");
		basic.click();
		System.out.println("click on basic");
	   
	}
	@Test(priority = 2)
	public void clickOnGreen() {
		WebElement clickOnGreen= getElement(driver, "clickOnGreen","xpath.txt");
		clickOnGreen.click();
	}
	@Test(priority = 3)
	public void rePaint() {
		driver.switchTo().defaultContent();
		

		driver.switchTo().frame("main");
		System.out.println("Switched to Main frame");
		String color1 = getElement(driver, "color1", "xpath.txt").getCssValue("background-color");
		System.out.println("color1: " + color1);
		driver.switchTo().frame("child");
		System.out.println("switched to child frame");

		String color2 = getElement(driver, "color2", "xpath.txt").getCssValue("background-color");
		System.out.println("color2 :" + color2);
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("main");
		WebElement rePaint = getElement(driver, "rePaint", "xpath.txt");
		System.out.println("running");
		while (true) {
			System.out.println("color1: " + color1 + " color2: " + color2);
			if (color1.contentEquals(color2)) {
				System.out.println("color matched");
				break;
			} else {
				driver.switchTo().defaultContent();
				driver.switchTo().frame("main");
				rePaint.click();
				
				driver.switchTo().defaultContent();
				driver.switchTo().frame("main");
				driver.switchTo().frame("child");
				color2 = getElement(driver, "color2", "xpath.txt").getCssValue("background-color");
			}
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("main");
		WebElement proceed = getElement(driver, "proceed1", "xpath.txt");
		proceed.click();
		System.out.println("click on proceed");
	}
	@Test(priority = 4)
	public void dragMe() {
	
		WebElement dragMe =  getElement(driver, "dragMe", "xpath.txt");
		System.out.println("drag me");
		WebElement dropBox = getElement(driver, "dropBox", "xpath.txt");
		Actions action = new Actions(driver);
		Action dragAndDrop = action.clickAndHold(dragMe).moveToElement(dropBox).release(dropBox).build();
		dragAndDrop.perform();

		WebElement proceed = getElement(driver, "proCeed2", "xpath.txt");
		proceed.click();
	
		System.out.println("click on proceed");
	}
	@Test(priority = 5)
	public void popUpWindows() throws InterruptedException {
		WebElement popPup = getElement(driver, "popup", "xpath.txt");
		popPup.click();
		
		
       String parent=driver.getWindowHandle();
		Set<String> parentWindow=driver.getWindowHandles();
        System.out.println(parentWindow+"+==============");
        Iterator<String>itr=parentWindow.iterator();
        while(itr.hasNext()) {
        	String childWindow=itr.next();
        	driver.switchTo().window(childWindow);
        
        }
		WebElement message = getElement(driver, "message", "xpath.txt");
		message.click();
		message.sendKeys("Text");
		
		WebElement submit = getElement(driver, "submit", "xpath.txt");
		submit.click();
		System.out.println("click on submit");
		
		driver.switchTo().window(parent);
		System.out.println("switched or not");
		
		WebElement proceed2=getElement(driver, "proceed3", "xpath.txt");
		proceed2.click();
		
		
		WebElement Gentoken=getElement(driver, "genToken", "xpath.txt");
		Gentoken.click();
		
		String token=driver.findElement(By.xpath("//span[@id=\"token\"]")).getText().substring(7);
		System.out.println(token+" :token value");
		Cookie value=new Cookie("Token", token);
		
		driver.manage().addCookie(value);
		driver.findElement(By.xpath("//a[text()=\"Proceed\"]")).click();
		
		System.out.println(" completed");
	}
	//@AfterTest
	public void end() {
		driver.quit();
	}
	
}
