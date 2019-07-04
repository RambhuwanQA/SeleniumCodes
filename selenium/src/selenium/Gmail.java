package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Gmail {
	
	@Test
	public void sending_Email() throws InterruptedException {
		String url="https://accounts.google.com/ServiceLogin/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rambhuwanrajpoot\\Downloads\\chromedriver.exe");
		 WebDriver driver=new ChromeDriver();
		driver.get(url);
		WebElement email=driver.findElement(By.xpath("//input[@id=\"identifierId\"]"));
		email.click();
		System.out.println("click on email");
		email.sendKeys("ramqait@gmail.com");
		WebElement AfterEmailNext=driver.findElement(By.xpath("//span[@class=\"RveJvd snByac\"]"));
		AfterEmailNext.click();
		System.out.println("click on next");
		Thread.sleep(5000);
		WebElement pass=driver.findElement(By.xpath("//input[@name=\"password\"]"));

		pass.click();
		System.out.println("click on pass");
		pass.sendKeys("*******");
		WebElement AfterPassNext=driver.findElement(By.xpath("//span[@class=\"CwaK9\"]"));
		AfterPassNext.click();
		System.out.println("login successfully");
		Thread.sleep(7000);
		WebElement compose=driver.findElement(By.xpath("//div[@gh=\"cm\"]"));
		compose.click();
		System.out.println("click on compose");
		Thread.sleep(5000);
		WebElement to=driver.findElement(By.xpath("(//textarea[@name=\"to\"])[1]"));
		to.click();
		System.out.println("click on to");
		//Thread.sleep(5000);
		to.sendKeys("rambhuwan2605@gmail.com");
		Thread.sleep(4000);
		WebElement subject=driver.findElement(By.xpath("(//input[@name=\"subjectbox\"])[1]"));
		subject.click();
		System.out.println("click on subject");
		subject.sendKeys("this message send through automated");
		Thread.sleep(7000);
		WebElement send=driver.findElement(By.xpath("(//div[@role='button' and contains(text(),\"Send\")])"));
		send.click();
		System.out.println("click on send");
		System.out.println("message send successfully");
		
		
		Thread.sleep(5000);
		driver.close();
	}
	

	/**
	 * public static void implicitTime() { WebDriver driver=new ChromeDriver();
	 * driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ; }
	 */
}
	 
