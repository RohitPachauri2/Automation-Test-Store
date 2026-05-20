package StepDefinition;

import java.awt.List;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class iframeandalerts {
	WebDriver driver;
	Actions action;
	WebDriverWait wait;
	
	public iframeandalerts() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		action=new Actions(driver);
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://vinothqaacademy.com/iframe/");
		
	}
	@Test(priority = 1)
	public void iframemethod() throws InterruptedException {
		System.out.println("Frame1 with table------------------------------------");
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.iframe-container>iframe:nth-child(1)")));
		driver.switchTo().frame(driver.findElement(By.cssSelector("div.iframe-container>iframe:nth-child(1)")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("table#myTable>tbody>tr")));
		java.util.List<WebElement>rows=driver.findElements(By.cssSelector("table#myTable>tbody>tr"));
		for(WebElement row:rows) {
			if(row.findElement(By.cssSelector("td:nth-child(2)")).getText().equalsIgnoreCase("Jane Smith")) {
				action.scrollToElement(row.findElement(By.cssSelector("td:nth-child(1) input")));
				row.findElement(By.cssSelector("td:nth-child(1) input")).click();
				System.out.println("Role is: "+row.findElement(By.cssSelector("td:nth-child(3)")).getText());
				System.out.println("Email is: "+row.findElement(By.cssSelector("td:nth-child(4)")).getText());
				break;
			}
		}
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		driver.switchTo().parentFrame();
		
		
		
	}
	@Test(priority = 2)
	public void iframewithalerts() throws InterruptedException {
		System.out.println("Frame with alert--------------------------------------");
		Thread.sleep(500);
		driver.switchTo().frame(driver.findElement(By.cssSelector("div.iframe-container>iframe:nth-child(2)")));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		WebElement alertbox=driver.findElement(By.name("alertbox"));
		alertbox.click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert1=driver.switchTo().alert();
		System.out.println(alert1.getText());
		alert1.accept();
		WebElement confirmalertbox=driver.findElement(By.name("confirmalertbox"));
		confirmalertbox.click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert2=driver.switchTo().alert();
		System.out.println(alert2.getText());
		alert2.accept();
		
		WebElement promptalertbox1234=driver.findElement(By.name("promptalertbox1234"));
		promptalertbox1234.click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert3=driver.switchTo().alert();
		System.out.println(alert3.getText());
		alert3.sendKeys("hello");
		alert3.accept();
		Thread.sleep(Duration.ofSeconds(5));
		driver.switchTo().parentFrame();
		
		
	}
	@Test(priority=3)
	public void iframewithcaptcha()throws InterruptedException{
		System.out.println("Frame with captcha like practice-------------------------");
		driver.switchTo().frame(driver.findElement(By.cssSelector("div.iframe-container>iframe:nth-child(3)")));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		WebElement inputtxt=driver.findElement(By.id("vfb-3"));
		String visibletext=driver.findElement(By.cssSelector("fieldset#item-vfb-2>ul>li>span>label")).getText();
		int initialvalue=0;
		for(char c:visibletext.toCharArray()) {
			if(Character.isDigit(c)) {
				initialvalue=initialvalue*10+(c-'0');
			}
		}
		System.out.println(initialvalue);
		inputtxt.sendKeys(initialvalue+"");
		WebElement submitbtn=driver.findElement(By.cssSelector("input[name='vfb-submit']"));
		
		
		driver.switchTo().parentFrame();
		
	}
	
	
	
	

}
