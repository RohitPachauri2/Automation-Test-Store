package Pages;

import java.io.InterruptedIOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Login {
WebDriver driver;
	public Login(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ul[@id='customer_menu_top']//li//a")
	WebElement loginbtn;
	@FindBy(id="loginFrm_loginname")
	WebElement username;
	@FindBy(id="loginFrm_password")
	WebElement password;
	@FindBy(xpath="//button[@class='btn btn-orange pull-right' and @title='Login' ]")
	WebElement Loginbtnpart1;
	
	public void step1() throws InterruptedException{
		System.out.println("Step1:------");
		System.out.println("Current URL:---- "+driver.getCurrentUrl());
		System.out.println("Current Title:--- "+driver.getTitle());
		driver.get("https://automationteststore.com/");
		Thread.sleep(Duration.ofSeconds(2));
		
		
	}
public void step2(String st1,String st2) throws InterruptedException{
	System.out.println("Step2:------");
	System.out.println("Current URL:---- "+driver.getCurrentUrl());
	System.out.println("Current Title:--- "+driver.getTitle());
	loginbtn.click();
	Thread.sleep(Duration.ofSeconds(2));
	username.sendKeys(st1);
	password.sendKeys(st2);
	Loginbtnpart1.click();
	Thread.sleep(Duration.ofSeconds(2));
	}
	
public void step3() throws InterruptedException{
	System.out.println("Step3:------");
	System.out.println("Current URL:---- "+driver.getCurrentUrl());
	System.out.println("Current Title:--- "+driver.getTitle());
	Thread.sleep(Duration.ofSeconds(2));
	WebElement asserttext=driver.findElement(By.className("menu_text"));
	System.out.println(asserttext.getText());
	Assert.assertTrue(asserttext.getText().contains("Rohit"));
}

	
}
