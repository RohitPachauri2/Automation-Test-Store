package StepDefinition;

import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windowspracticeagain {

	WebDriver driver;
	Actions action;
	WebDriverWait wait;
	
	@BeforeTest
	public void before() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		action=new Actions(driver);
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();
	}
	
	
	@Test(priority=1)
	public void method1() throws InterruptedException {
		System.out.println("Title is: "+driver.getTitle());
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newWindowBtn")));
		WebElement button1=driver.findElement(By.id("newWindowBtn"));
		action.scrollToElement(button1).perform();
		String parentwindow=driver.getWindowHandle();
		button1.click();
		Set<String>windowhandles= driver.getWindowHandles();
		for(String window:windowhandles) {
			if(!window.equals(parentwindow)) {
				driver.switchTo().window(window);
				driver.manage().window().maximize();
				System.out.println("Title is: "+driver.getTitle());
				System.out.println(driver.findElement(By.cssSelector("h1.post-title.entry-title")).getText());
				driver.close();
				break;
			}
		}
		
		driver.switchTo().window(parentwindow);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
		
		WebElement inputtext=driver.findElement(By.id("name"));
		inputtext.clear();
		inputtext.sendKeys("rohit");
		Thread.sleep(1000);
		
		
		
	}
	@Test(priority=2)
	public void method2() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newTabBtn")));
		WebElement button1=driver.findElement(By.id("newTabBtn"));
		action.scrollToElement(button1).perform();
		String parentwindow=driver.getWindowHandle();
		button1.click();
		Set<String>windowhandles= driver.getWindowHandles();
		for(String window:windowhandles) {
			if(!window.equals(parentwindow)) {
				driver.switchTo().window(window);
				driver.manage().window().maximize();
				System.out.println("Title is: "+driver.getTitle());
				WebElement alertbtn=driver.findElement(By.id("alertBox"));
				alertbtn.click();
				wait.until(ExpectedConditions.alertIsPresent());
				Alert alert1=driver.switchTo().alert();
				System.out.println(alert1.getText());
				alert1.accept();
				
				driver.close();
				break;
			}
		}
		
		driver.switchTo().window(parentwindow);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
		
		WebElement inputtext=driver.findElement(By.id("name"));
		inputtext.clear();
		inputtext.sendKeys("rohitagain");
		Thread.sleep(1000);
		System.out.println("Title is: "+driver.getTitle());
		
		
		
	}
	
	
	@AfterTest
	public void after() {
		
	}
}
