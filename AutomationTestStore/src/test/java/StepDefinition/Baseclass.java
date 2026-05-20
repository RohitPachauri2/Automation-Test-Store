package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public WebDriver driver;
	public Actions action;
	public WebDriverWait wait;
	public SoftAssert verify;
	
	
	public void beforeclass() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		action=new Actions(driver);
		wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		verify=new SoftAssert();
		driver.manage().window().maximize();
		
	}

	
	public void afterclass() {
		driver.quit();
	}

}
