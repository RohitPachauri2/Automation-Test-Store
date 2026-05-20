package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollPractice {
	
WebDriver driver;
Actions action;
SoftAssert sa=new SoftAssert();
WebDriverWait wait;
	public ScrollPractice() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		action=new Actions(driver);
		wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
	}
	@Test
	public void sscrollingpractice()throws InterruptedException{
		driver.get("https://practice.expandtesting.com/scrollbars");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.container>div.row:nth-child(3)>div>div")));
		WebElement scrolldiv=driver.findElement(By.cssSelector("div.container>div.row:nth-child(3)>div>div"));
		action.scrollToElement(scrolldiv).perform();
		Thread.sleep(1000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollBy({top:200,left:0,behavior:'smooth'})",scrolldiv);
		js.executeScript("arguments[0].scrollBy({top:0,left:200,behavior:'smooth'})",scrolldiv);
		Thread.sleep(1000);
		String val=(String)js.executeScript("return window.location.href");
		System.out.println(val);
	}
	@AfterMethod
	public void wrapingup() {
		driver.quit();
	}

}
