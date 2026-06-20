package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class practice {
public static WebDriver driver;
public static Actions action;
public static WebDriverWait wait;


public void url() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	action=new Actions(driver);
	wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	
	driver.manage().window().maximize();
	driver.get("https://automationteststore.com/");
	System.out.println(driver.getTitle());
	System.out.println(driver.getCurrentUrl());
	Assert.assertTrue(driver.getCurrentUrl().contains("automationteststore"));
	
}

public void loginbtn() throws InterruptedException {
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Login or register']")));
	WebElement loginbtn=driver.findElement(By.xpath("//a[text()='Login or register']"));
	loginbtn.click();
	Thread.sleep(500);
}
public void login(String usr,String pass) throws InterruptedException {
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='btn btn-orange pull-right']>i[class='fa fa-check fa']")));
	WebElement username=driver.findElement(By.cssSelector("input#loginFrm_loginname"));
	username.sendKeys(usr);
	WebElement password=driver.findElement(By.cssSelector("input#loginFrm_password"));
	password.sendKeys(pass);
	WebElement submitbtn=driver.findElement(By.cssSelector("button[class='btn btn-orange pull-right']>i[class='fa fa-lock']"));
	submitbtn.click();
	Thread.sleep(1000);
	
}

public void checkloggedinornot() {
	try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Welcome back Rohit']")));
		System.out.println(driver.findElement(By.xpath("//div[text()='Welcome back Rohit']")).getText());
	}
	catch (Exception e) {
		e.printStackTrace();
		System.out.println(driver.findElement(By.cssSelector("div[class='alert alert-error alert-danger']")).getText());
	}
}


public void clickonmenssection() throws InterruptedException {
	System.out.println("menssection click");
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul[class='nav-pills categorymenu']>li:nth-child(6)")));
	WebElement menssection=driver.findElement(By.cssSelector("ul[class='nav-pills categorymenu']>li:nth-child(6)"));
	menssection.click();
	Thread.sleep(1000);
	 
	
}

public void getnamesofmensproduct() {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("document.body.style.zoom='90%'");
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.contentpanel>div:nth-child(3)>div>div>div>a[class='prdocutname']")));
	List<WebElement>names=driver.findElements(By.cssSelector("div.contentpanel>div:nth-child(3)>div>div>div>a[class='prdocutname']"));
	for(WebElement name:names) {
		System.out.println(name.getText());
	}
}

public void searchonsite(String val) throws InterruptedException {
	System.out.println("search on site: "+val);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#filter_keyword")));
	WebElement search=driver.findElement(By.cssSelector("input#filter_keyword"));
	search.clear();
	search.sendKeys(val);
	Thread.sleep(500);
	action.sendKeys(Keys.ENTER).perform();
	Thread.sleep(1000);
}

public void getnamesofproduct() {
	System.out.println("name of product");
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("document.body.style.zoom='90%'");
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.contentpanel>div:nth-child(5)>div>div:nth-child(1)>div>a")));
	List<WebElement>names=driver.findElements(By.cssSelector("div.contentpanel>div:nth-child(5)>div>div:nth-child(1)>div>a"));
	for(WebElement name:names) {
		System.out.println(name.getText());
	}
}


	
	
}
