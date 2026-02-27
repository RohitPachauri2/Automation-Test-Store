package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class javascriptexecutor {

	
	WebDriver driver;
	
	@BeforeMethod
	public void beforemethod() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://automationteststore.com/");
	}
	@Test
	public void differentmethods() throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String title=(String) js.executeScript("return document.title");
		System.out.println(title);
		WebElement searchbox=driver.findElement(By.cssSelector("input#filter_keyword"));
		Thread.sleep(Duration.ofSeconds(2));
		js.executeScript("arguments[0].click();", searchbox);
		Thread.sleep(Duration.ofSeconds(2));
		js.executeScript("arguments[0].value='eyes';", searchbox);
		Thread.sleep(Duration.ofSeconds(2));
		WebElement promotext=driver.findElement(By.cssSelector("section[class='row promo_section']>div:nth-child(1)>div:nth-child(2)>h2"));
		String promo=(String)js.executeScript("return arguments[0].textContent;", promotext);
		js.executeScript("arguments[0].style.border='3px solid red'", promotext);
		System.out.println(promo);
		js.executeScript("history.go(0)");
		WebElement scrollelement=driver.findElement(By.cssSelector("ul[class='info_links_footer']>li:nth-child(1)"));
		js.executeScript("arguments[0].scrollIntoView(true)", scrollelement);
		Thread.sleep(Duration.ofSeconds(2));
		String url=(String)js.executeScript("return window.location.href");
		System.out.println(url);
		js.executeScript("return window.location='www.google.com'");
		
	}
	
	@AfterMethod
	public void aftermethod() {
		driver.quit();
	}
	
}
