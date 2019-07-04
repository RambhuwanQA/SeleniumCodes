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

public class BasicTatoc {

	String url = "http://10.0.1.86/tatoc";
	WebDriver driver;

	@BeforeTest
	public void launch() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rambhuwanrajpoot\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void basicCourse() throws InterruptedException {
		WebElement basic = driver.findElement(By.xpath(""));
		basic.click();
		System.out.println("click on basic");
		Thread.sleep(500);
	}

	@Test(priority = 2)
	public void clickOnGreen() throws InterruptedException {
		WebElement green = driver.findElement(By.xpath(""));
		green.click();
		System.out.println("click on green");
		Thread.sleep(500);
		WebElement frame = driver.findElement(By.xpath(""));
		assertTrue(frame.isDisplayed());

	}

	@Test(priority = 3)
	public void rePaint() throws InterruptedException {

		driver.switchTo().defaultContent();
		Thread.sleep(200);

		driver.switchTo().frame("main");
		System.out.println("Switched to Main frame");
		String color1 = driver.findElement(By.xpath("")).getCssValue("background-color");
		System.out.println("color1: " + color1);
		driver.switchTo().frame("child");
		System.out.println("switched to child frame");

		String color2 = driver.findElement(By.xpath("")).getCssValue("background-color");
		System.out.println("color2 :" + color2);
		Thread.sleep(300);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("main");
		WebElement rePaint = driver.findElement(By.xpath("//a [text()=\"Repaint Box 2\"]"));
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
		WebElement dragAround = driver.findElement(By.xpath("//h1[text()='Drag Around']"));
		assertTrue(dragAround.isDisplayed());
	}

	@Test(priority = 4)
	public void dragMe() throws InterruptedException {
		Thread.sleep(300);
		WebElement dragMe = driver.findElement(By.cssSelector(".ui-draggable"));
		System.out.println("drag me");
		WebElement dropBox = driver.findElement(By.xpath("//div[text()=\"DROPBOX\"]"));
		Actions action = new Actions(driver);
		Action dragAndDrop = action.clickAndHold(dragMe).moveToElement(dropBox).release(dropBox).build();
		dragAndDrop.perform();

		WebElement proceed = driver.findElement(By.xpath("//a[text()=\"Proceed\"]"));
		proceed.click();
		Thread.sleep(200);
		System.out.println("click on proceed");
		WebElement popUp = driver.findElement(By.xpath("//h1[text()=\"Popup Windows\"]"));
		assertTrue(popUp.isDisplayed());
	}

	@Test(priority = 5)
	public void popUpWindows() throws InterruptedException {
		WebElement popPup = driver.findElement(By.xpath("//a[text()=\"Launch Popup Window\"]"));
		popPup.click();
		Thread.sleep(200);
		//System.out.println("number of windows " + driver.getWindowHandles().size());
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
	

	//@AfterTest
	public void end() {
		driver.quit();
	}

}
