package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class iframepractice {
WebDriver driver;
Actions action;
@BeforeClass
public void start() {
	WebDriverManager.firefoxdriver().setup();
	driver=new FirefoxDriver();
	driver.get("https://vinothqaacademy.com/iframe/");
	driver.manage().window().maximize();
	action=new Actions(driver);
}

@AfterClass
public void end() {
	driver.quit();
}
@Test(priority = 0)
	public void firstmethod() throws InterruptedException {
		
		driver.switchTo().frame(driver.findElement(By.cssSelector("div[class='iframe-container']>iframe:nth-child(1)")));
		WebElement lastelement=driver.findElement(By.cssSelector("table[id='myTable']>tbody>tr>td:nth-child(1)>input"));
		lastelement.click();
		Thread.sleep(Duration.ofSeconds(2));
		driver.switchTo().defaultContent();
	}
	@Test(priority = 1)
	public void secondmethod() throws InterruptedException {
		driver.switchTo().frame(driver.findElement(By.cssSelector("div[class='iframe-container']>iframe:nth-child(2)")));
		
		Thread.sleep(Duration.ofSeconds(2));
		driver.switchTo().defaultContent();
		
	}
	@Test(priority = 2)
	public void thirdmethod() throws InterruptedException {
		driver.switchTo().frame(driver.findElement(By.cssSelector("div[class='iframe-container']>iframe:nth-child(3)")));
		Thread.sleep(Duration.ofSeconds(2));
	}
	
	
}
