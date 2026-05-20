package Pages;

import java.awt.List;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class pagefortwoscenarios {

    static WebDriver driver;
    static WebDriverWait wait;
    static Actions action;

    public static void init() {
        if (driver == null) {   // 🔥 only create once
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            driver.manage().window().maximize();

            wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            action = new Actions(driver);
        }
    }

    public void given1() {
        init();   // always call, but creates only once

        driver.get("https://automationteststore.com/");
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("store"));
    }

    public void when1(String val1, String val2) throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Login or register']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginFrm_loginname")))
                .sendKeys(val1);

        Thread.sleep(1000);

        driver.findElement(By.id("loginFrm_password"))
                .sendKeys(val2);

        driver.findElement(By.cssSelector("button[title='Login']"))
                .click();
    }

    public void then1() {
        WebElement welcometext = driver.findElement(By.cssSelector("a[class='top menu_account']>div"));
        Assert.assertTrue(welcometext.getText().contains("Rohit"));
    }

    public void given2() {
        init(); // 🔥 ensures driver exists but won't reopen

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("a[class='top menu_account']>div")));

        WebElement welcometext = driver.findElement(
                By.cssSelector("a[class='top menu_account']>div"));

        Assert.assertTrue(welcometext.getText().contains("Rohit"));
    }

    public void when2() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("div#topnav>ul>li:nth-child(3)>a")))
                .click();
    }

    public void then2() {
        action.scrollToElement(
                driver.findElement(By.cssSelector("a#cart_checkout1")))
                .perform();

        java.util.List<WebElement>rows=driver.findElements(By.cssSelector("div[class='container-fluid cart-info product-list']>table>tbody>tr"));
        for(WebElement row:rows) {
        	try {
        		System.out.println(row.findElement(By.cssSelector("td:nth-child(2)>a")).getText());
        	}
        	catch(Exception e) {
        		System.out.println(e.getMessage());
        	}
        	
        }
        
    }

    // 🔥 Add manual close (optional)
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}