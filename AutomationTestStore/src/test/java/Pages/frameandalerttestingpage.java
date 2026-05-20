package Pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class frameandalerttestingpage {
	WebDriver driver;
	Actions action;
	WebDriverWait wait;
	SoftAssert verify;

	public frameandalerttestingpage(WebDriver driver, Actions action, WebDriverWait wait, SoftAssert verify) {
		this.driver = driver;
		this.action = action;
		this.wait = wait;
		this.verify = verify;
	}

	public void method1() throws InterruptedException {
		driver.get("https://practice.expandtesting.com/");
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("#examples>div:nth-child(13)>div:nth-child(1)")));
		WebElement framedialogbox = driver.findElement(By.cssSelector("#examples>div:nth-child(13)>div:nth-child(1)"));
		action.scrollToElement(framedialogbox).perform();
		Thread.sleep(Duration.ofSeconds(2));
		WebElement iframebutton = driver
				.findElement(By.cssSelector("#examples>div:nth-child(13)>div:nth-child(1)>div>div:nth-child(2)>div>a"));
		iframebutton.click();
		Thread.sleep(Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > header > nav > a")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(Duration.ofSeconds(2));
		driver.switchTo().frame(driver.findElement(By.cssSelector("#email-subscribe")));
		WebElement inputtag = driver.findElement(By.cssSelector("#email"));
		inputtag.sendKeys("rohit.pachauri@gmail.com");
		WebElement submitbutton = driver.findElement(By.cssSelector("#btn-subscribe"));
		submitbutton.click();
		Thread.sleep(Duration.ofSeconds(2));

	}

	public void method2() throws InterruptedException {
		driver.get("https://testautomationpractice.blogspot.com/");
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#header-inner > div.titlewrapper > h1")));
		WebElement btn1 = driver.findElement(By.cssSelector("#header-inner > div.titlewrapper > h1"));
		System.out.println(btn1.getAttribute("class"));
		System.out.println(btn1.getCssValue("font"));
		verify.assertTrue(btn1.getCssValue("font").equalsIgnoreCase("40px Montserrat"));
		verify.assertTrue(btn1.getAttribute("class").equalsIgnoreCase("title"));

		WebElement btn2 = driver.findElement(By.xpath("//button[@id='alertBtn']"));
		action.scrollToElement(btn2).perform();
		action.moveToElement(btn2);
		btn2.click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert1 = driver.switchTo().alert();
		System.out.println(alert1.getText());
		alert1.accept();
		WebElement btn3 = driver.findElement(By.xpath("//button[@id='confirmBtn']"));
		action.scrollToElement(btn3).perform();
		action.moveToElement(btn3);
		btn3.click();
		Alert alert2 = driver.switchTo().alert();
		System.out.println(alert2.getText());
		alert2.dismiss();

		WebElement btn4 = driver.findElement(By.xpath("//button[@id='promptBtn']"));
		action.scrollToElement(btn4).perform();
		action.moveToElement(btn4);
		btn4.click();
		try {
		Alert alert3 = driver.switchTo().alert();
		System.out.println(alert3.getText());
		alert3.sendKeys("rohitpac");
		alert3.accept();
		System.out.println(driver.findElement(By.id("demo")).getText());
		}
		catch(Exception e) {
			e.getStackTrace();
		}

		verify.assertAll();

	}

}
