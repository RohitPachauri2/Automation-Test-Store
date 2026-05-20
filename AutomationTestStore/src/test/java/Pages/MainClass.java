package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainClass {

    WebDriver driver;
    WebDriverWait wait;
    Actions action;

    public MainClass(WebDriver driver, WebDriverWait wait, Actions action) {
        this.driver = driver;
        this.wait = wait;
        this.action = action;
    }

    public void step1() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Nexus 6']")));

        WebElement phoneclick = driver.findElement(By.xpath("//a[text()='Nexus 6']"));
        phoneclick.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div.col-sm-12.col-md-6.col-lg-6 > a")));

        WebElement addtocart1 = driver.findElement(
                By.cssSelector("div.col-sm-12.col-md-6.col-lg-6 > a"));
        addtocart1.click();

        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        alert.accept();

        driver.navigate().back();
        driver.navigate().back();
    }

    public void step2() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div.list-group>a:nth-child(4)")));

        WebElement catmon = driver.findElement(
                By.cssSelector("div.list-group>a:nth-child(4)"));
        catmon.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div#tbodyid>div:nth-child(2)>div>div>h4>a")));

        WebElement monitor = driver.findElement(
                By.cssSelector("div#tbodyid>div:nth-child(2)>div>div>h4>a"));
        monitor.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("a.btn.btn-success.btn-lg")));

        WebElement addtocart2 = driver.findElement(
                By.cssSelector("a.btn.btn-success.btn-lg"));
        addtocart2.click();

        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert2 = driver.switchTo().alert();
        alert2.accept();

        driver.navigate().back();
        driver.navigate().back();
    }

    public void step3() {
        WebElement cartbtn = driver.findElement(By.id("cartur"));
        action.scrollToElement(cartbtn).perform();
        cartbtn.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.cssSelector("#tbodyid>tr")));

        WebElement totalprice = driver.findElement(By.id("totalp"));
        System.out.println(totalprice.getText());
    }
}