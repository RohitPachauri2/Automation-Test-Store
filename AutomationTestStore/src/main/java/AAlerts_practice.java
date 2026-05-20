

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AAlerts_practice {
	WebDriver driver;
	WebDriverWait wait;
@Test
	public void firstmethod() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		
		//first alert
		WebElement alert1=driver.findElement(By.cssSelector("button#alertButton"));
		wait.until(ExpectedConditions.visibilityOf(alert1));
		alert1.click();
		Alert alert=driver.switchTo().alert();
		String text1=alert.getText();
		System.out.println(text1);
		alert.accept();
		
		//second alert
		WebElement alert2=driver.findElement(By.id("timerAlertButton"));
		wait.until(ExpectedConditions.visibilityOf(alert2));
		alert2.click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alertnew=driver.switchTo().alert();
		String text2=alertnew.getText();
		System.out.println(text2);
		alertnew.accept();
		
		//third alert
		
		//fourth alert
		
		driver.quit();
	}
}
