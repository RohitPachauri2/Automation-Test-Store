package hooks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hook extends DriverClass {

	@BeforeAll
	public static void afterall(){
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		action=new Actions(driver);
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://automationexercise.com/");
	}
	
	@AfterAll
	public static void beforeall()throws InterruptedException{
		driver.close();
	}
	

}
