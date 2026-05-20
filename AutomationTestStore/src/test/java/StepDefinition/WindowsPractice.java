package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsPractice {
	WebDriver driver;
	WebDriverWait wait;
	@BeforeMethod
	public void beforemthod() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");
		
	}
	@AfterMethod
	public void aftermethod() {
		driver.quit();
	}	
@Test
	public void firstmethod() {
		WebElement btn1=driver.findElement(By.id("tabButton"));
		WebElement btn2=driver.findElement(By.id("windowButton"));
		WebElement btn3=driver.findElement(By.id("messageWindowButton"));
		String urloriginal=driver.getCurrentUrl();
		String titleoriginal=driver.getTitle();
		System.out.println(urloriginal);
		System.out.println(titleoriginal);
		btn1.click();
		String parentwindow=driver.getWindowHandle();
		for(String x:driver.getWindowHandles()) {
			if(!x.equals(parentwindow)) {
				driver.switchTo().window(x);
				System.out.println("URL:-After clicking btn1: "+driver.getCurrentUrl());
				System.out.println("Title:-After clicking btn1: "+driver.getTitle());
				driver.close();
				driver.switchTo().window(parentwindow);	
			}
		}
		
		btn2.click();
		for(String x:driver.getWindowHandles()) {
			if(!x.equals(parentwindow)) {
				driver.switchTo().window(x);
				System.out.println("URL:-After clicking btn2: "+driver.getCurrentUrl());
				System.out.println("Title:-After clicking btn2: "+driver.getTitle());
				System.out.println("message inside: "+driver.findElement(By.cssSelector("h1#sampleHeading")).getText());
				driver.close();
				driver.switchTo().window(parentwindow);			}
		}
		btn3.click();
		for(String x:driver.getWindowHandles()) {
			if(!x.equals(parentwindow)) {
				driver.switchTo().window(x);
				System.out.println("URL:-After clicking btn3: "+driver.getCurrentUrl());
				System.out.println("Title:-After clicking btn3: "+driver.getTitle());
				System.out.println("message inside: "+driver.findElement(By.cssSelector("html>body")).getText());
				driver.close();
				driver.switchTo().window(parentwindow);	
			}
		}
		
		
		
		
	}


}
