package StepDefinition;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class fifthmarch {

    WebDriver driver;

    @BeforeMethod
    public void beforemethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationteststore.com/");
    }

    @Test
    public void mainmethod() throws IOException, InterruptedException {

        Thread.sleep(2000);

        TakesScreenshot tk = (TakesScreenshot) driver;
        File src = tk.getScreenshotAs(OutputType.FILE);

        String time = LocalTime.now().toString().replace(":", "-");

        File folder = new File("Screenshot/fifthmarch");
        if (!folder.exists()) {
            folder.mkdirs();
        }

        File dest = new File(folder + "/screenshot_" + time + ".png");

        FileUtils.copyFile(src, dest);
    }

    @AfterMethod
    public void aftermethodd() {
        driver.close();
    }
}