package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.asserts.SoftAssert;

public class BasePage {

    private static final Logger logger = LoggerFactory.getLogger(BasePage.class);

    WebDriver driver;
    Actions action;
    WebDriverWait wait;
    SoftAssert verify;

    public BasePage(WebDriver driver, Actions action, WebDriverWait wait, SoftAssert verify) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.action = action;
        this.wait = wait;
        this.verify = verify;
    }

    @FindBy(css = "button#submit")
    WebElement submit;

    @FindBy(css = "input#username")
    WebElement username;

    @FindBy(css = "input#password")
    WebElement password;

    public void mainmethod() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            logger.info("STATUS: STARTED | Method: {}", methodName);

            action.scrollToElement(submit);
            logger.info("Scrolled to submit button");

            username.sendKeys("student");
            logger.info("Entered username");

            password.sendKeys("Password123");
            logger.info("Entered password");

            submit.click();
            logger.info("Clicked submit");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#error")));
            String errorMsg = driver.findElement(By.cssSelector("div#error")).getText();

            logger.error("Login failed | Message: {}", errorMsg);

        } catch (Exception e) {
            logger.info("Exception occurred, assuming login success");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.post-title")));
            String successMsg = driver.findElement(By.cssSelector("h1.post-title")).getText();

            logger.info("Login successful | Message: {}", successMsg);
        }
    }
}