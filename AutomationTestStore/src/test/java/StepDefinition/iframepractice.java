package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class iframepractice {
WebDriver driver;
Actions action;
WebDriverWait wait;
@BeforeClass
public void start() {
	WebDriverManager.firefoxdriver().setup();
	driver=new FirefoxDriver();
	driver.get("https://vinothqaacademy.com/iframe/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
	action=new Actions(driver);
	wait=new WebDriverWait(driver, Duration.ofSeconds(4));
}

@AfterClass
public void end() {
	driver.quit();
}
@Test(priority = 0,enabled=false)
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
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("button[name='alertbox']"))));
		driver.findElement(By.cssSelector("button[name='alertbox']")).click();
		Alert alert1=driver.switchTo().alert();
		System.out.println(alert1.getText());
		
		driver.switchTo().defaultContent();
		
	}
	@Test(priority = 2,enabled=false)
	public void thirdmethod() throws InterruptedException {
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='registeruser']")));
		System.out.println(driver.findElement(By.xpath("//div[@class='copyright_text']")).getText());
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(Duration.ofSeconds(2));
	}
	
	
}
