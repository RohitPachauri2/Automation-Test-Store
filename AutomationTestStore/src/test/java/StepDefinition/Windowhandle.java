package StepDefinition;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Windowhandle {
	WebDriver driver;
@Test
public void newmethod() throws InterruptedException{
	WebDriverManager.chromedriver().setup();
	driver=new FirefoxDriver();
	driver.get("https://practice.expandtesting.com/");
	driver.manage().window().maximize();
	Actions action=new Actions(driver);
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(4));
	WebElement windowswitch=driver.findElement(By.xpath(
			"/html/body/main/div[3]/div[2]/div/div/div[3]/section[1]/div[12]/div[2]/div/div[2]/div/a"));
	
	action.scrollToElement(driver.findElement(By.xpath("/html/body/main/div[3]/div[2]/div/div/div[3]/section[1]/div[12]/div[2]/div/div[2]/div/a")));
	Thread.sleep(Duration.ofSeconds(5));
	
	windowswitch.click();
	Thread.sleep(Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.row:nth-child(3) > a:nth-child(1)")));
	Thread.sleep(Duration.ofSeconds(5));
	WebElement newwindow=driver.findElement(By.cssSelector("div.row:nth-child(3) > a:nth-child(1)"));
	newwindow.click();
	Thread.sleep(Duration.ofSeconds(5));
	Set<String>windowhandles=driver.getWindowHandles();
	String parentWindow = driver.getWindowHandle();

	for (String handle : windowhandles) {
	    if (!handle.equals(parentWindow)) {
	        driver.switchTo().window(handle);
	        break;
	    }
	}
	Thread.sleep(Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='example']>h1")));
	WebElement texttoassert=driver.findElement(By.cssSelector("div[class='example']>h1"));
	String val=texttoassert.getText();
	Assert.assertEquals(val, "Example of a new window page for Automation Testing Practice");
	driver.quit();
	
	
	
	
}
}
