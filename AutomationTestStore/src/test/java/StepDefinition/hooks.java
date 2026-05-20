package StepDefinition;

import java.io.File;
import java.io.IOException;import java.sql.Date;
import java.sql.Driver;
import java.sql.Time;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.reporter.FileUtil;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class hooks {
public WebDriver driver;
public DriverClass dc;
	@Before
	public void initializedriver() {
		dc=new DriverClass();
		driver=dc.init_driver("Chrome");
		
	}
	@After
	public void closingdrver(Scenario sc) {
if(!sc.isFailed()) {
			
			TakesScreenshot tk=(TakesScreenshot)driver;
			File srcfile=tk.getScreenshotAs(OutputType.FILE);
			try {
				File dest=new File("Screenshot/14thmarch/"+sc.getStatus()+(sc.getName().replace(" ","_"))+".png");
				FileUtils.copyFile(srcfile, dest);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		if(sc.isFailed()) {
			
			TakesScreenshot tk=(TakesScreenshot)driver;
			File srcfile=tk.getScreenshotAs(OutputType.FILE);
			try {
				File dest=new File("Screenshot/14thmarch/"+sc.getStatus()+(sc.getName().toString().replace(" ","_"))+".png");
				FileUtils.copyFile(srcfile, dest);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		driver.quit();
	}
}
