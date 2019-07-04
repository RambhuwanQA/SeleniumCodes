package selenium;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BasicTatocNegative {
	
	String url = "http://10.0.1.86/tatoc";
	WebDriver driver;

	@BeforeTest
	public void launch() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rambhuwanrajpoot\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
    @Test(priority = 1)
    public void basicCourse() throws InterruptedException {
    	WebElement basic = driver.findElement(By.xpath(" //a [@href=\"/tatoc/basic\"]"));
		basic.click();
		System.out.println("click on basic");
		Thread.sleep(500);
    }
    @Test(priority = 2)
    public void afterBasic() throws InterruptedException {
    	WebElement redBox=driver.findElement(By.xpath("(//div[@class=\"redbox\"])[1]"));
    	redBox.click();
    	System.out.println("errro page");
    	Thread.sleep(500);
    	WebElement error=driver.findElement(By.xpath("//h1[text()=\"Error\"]"));
    	assertEquals(error.getText(), "Error");
    	Thread.sleep(500);
    	driver.navigate().back();
    	Thread.sleep(500);
    	
    	WebElement green = driver.findElement(By.xpath("//div[@class=\"greenbox\"]"));
		green.click();
		System.out.println("click on green");
		Thread.sleep(500);
    }
    @Test(priority = 3)
    public void rePaint() throws InterruptedException {
    	driver.switchTo().defaultContent();
		Thread.sleep(200);

		driver.switchTo().frame("main");
		System.out.println("Switched to Main frame");
		String color1 = driver.findElement(By.xpath("(//div[text()=\"Box 1\"])[1]")).getCssValue("background-color");
		System.out.println("color1: " + color1);
		driver.switchTo().frame("child");
		System.out.println("switched to child frame");

		String color2 = driver.findElement(By.xpath("//div[text()=\"Box 2\"]")).getCssValue("background-color");
		System.out.println("color2 :" + color2);
		Thread.sleep(300);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("main");
		WebElement rePaint = driver.findElement(By.xpath("//a [text()=\"Repaint Box 2\"]"));
		System.out.println("running");
		while (true) {
			System.out.println("color1: " + color1 + " color2: " + color2);
			if (!(color1.contentEquals(color2))) {
				System.out.println("color matched");
				break;
			} else {
				driver.switchTo().defaultContent();
				driver.switchTo().frame("main");
				rePaint.click();
				Thread.sleep(100);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("main");
				driver.switchTo().frame("child");
				color2 = driver.findElement(By.xpath("//div[text()=\"Box 2\"]")).getCssValue("background-color");
			}
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("main");
		WebElement proceed = driver.findElement(By.xpath("//a [text()=\"Proceed\"]"));
		proceed.click();
		System.out.println("click on proceed");
		Thread.sleep(700);
		driver.navigate().back();
		
		driver.switchTo().defaultContent();
		Thread.sleep(200);

		driver.switchTo().frame("main");
		System.out.println("Switched to Main frame");
		String color3 = driver.findElement(By.xpath("(//div[text()=\"Box 1\"])[1]")).getCssValue("background-color");
		System.out.println("color1: " + color1);
		driver.switchTo().frame("child");
		System.out.println("switched to child frame");

		String color4 = driver.findElement(By.xpath("//div[text()=\"Box 2\"]")).getCssValue("background-color");
		System.out.println("color2 :" + color2);
		Thread.sleep(300);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("main");
		WebElement rePaint1 = driver.findElement(By.xpath("//a [text()=\"Repaint Box 2\"]"));
		System.out.println("running");
		while (true) {
			System.out.println("color3: " + color1 + " color2: " + color4);
			if (color3.contentEquals(color4)) {
				System.out.println("color matched");
				break;
			} else {
				driver.switchTo().defaultContent();
				driver.switchTo().frame("main");
				rePaint1.click();
				Thread.sleep(100);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("main");
				driver.switchTo().frame("child");
				color4 = driver.findElement(By.xpath("//div[text()=\"Box 2\"]")).getCssValue("background-color");
			}
		}

		driver.switchTo().defaultContent();
		driver.switchTo().frame("main");
		WebElement proceed1 = driver.findElement(By.xpath("//a [text()=\"Proceed\"]"));
		proceed1.click();
		System.out.println("click on proceed");
		Thread.sleep(700);

    }
    @Test(priority = 4)
    public void dragme() throws InterruptedException {
    	WebElement dragMe = driver.findElement(By.cssSelector(".ui-draggable"));
		System.out.println("drag me");
	
		WebElement page=driver.findElement(By.cssSelector(".page"));
		Actions action = new Actions(driver);
		Action dragAndDrop = action.clickAndHold(dragMe).moveToElement(page).release(page).build();
		dragAndDrop.perform();

		WebElement proceed = driver.findElement(By.xpath("//a[text()=\"Proceed\"]"));
		proceed.click();
		Thread.sleep(200);
		driver.navigate().back();
		WebElement dragMe1 = driver.findElement(By.cssSelector(".ui-draggable"));
		WebElement dropBox1= driver.findElement(By.xpath("//div[text()=\"DROPBOX\"]"));
		Action dragAndDrop1 = action.clickAndHold(dragMe1).moveToElement(dropBox1).release(dropBox1).build();
		dragAndDrop1.perform();
		WebElement proceed1 = driver.findElement(By.xpath("//a[text()=\"Proceed\"]"));
		proceed1.click();
		Thread.sleep(200);
    	
    	
    }
    @Test(priority = 5)
    public void launchPopup() throws InterruptedException {
    	WebElement proceed=driver.findElement(By.xpath("//a[text()=\"Proceed\"]"));
    	proceed.click();
    	Thread.sleep(500);
    	driver.navigate().back();
    	WebElement popPup = driver.findElement(By.xpath("//a[text()=\"Launch Popup Window\"]"));
		popPup.click();
		Thread.sleep(200);
		 String parent=driver.getWindowHandle();
			Set<String> parentWindow=driver.getWindowHandles();
	        System.out.println(parentWindow+"+==============");
	        Iterator<String>itr=parentWindow.iterator();
	        while(itr.hasNext()) {
	        	String childWindow=itr.next();
	        	driver.switchTo().window(childWindow);
	        
	        }
			WebElement message = driver.findElement(By.xpath("//input[@id=\"name\"]"));
			message.click();
			message.sendKeys("Text");
			Thread.sleep(200);
			WebElement submit = driver.findElement(By.xpath("//input[@id=\"submit\"]"));
			submit.click();
			System.out.println("click on submit");
			Thread.sleep(200);
			driver.switchTo().window(parent);
			System.out.println("switched or not");
			
			WebElement proceed2=driver.findElement(By.xpath("//a[text()=\"Proceed\"]"));
			proceed2.click();
			Thread.sleep(200);
			WebElement proceed3=driver.findElement(By.xpath("//a[text()=\"Proceed\"]"));
			proceed3.click();
			
			driver.navigate().back();
			WebElement Gentoken=driver.findElement(By.xpath("//a[text()=\"Generate Token\"]"));
			Gentoken.click();
			Thread.sleep(100);
			String token=driver.findElement(By.xpath("//span[@id=\"token\"]")).getText().substring(7);
			System.out.println(token+" :token value");
			Cookie value=new Cookie("Token", token);
			
			driver.manage().addCookie(value);
			driver.findElement(By.xpath("//a[text()=\"Proceed\"]")).click();
			Thread.sleep(200);
			WebElement courseFinish=driver.findElement(By.xpath("//span[@class=\"finish\"]"));
			assertTrue(courseFinish.isDisplayed());
			assertEquals(courseFinish.getText(), "Obstacle Course is Complete!");
			Thread.sleep(1000);
			System.out.println(" completed");
    }
   @AfterTest
   public void end() {
	   driver.quit();
   }
}
