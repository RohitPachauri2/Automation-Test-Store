package StepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverClass {

	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	/**
	 * to initialize the threadlocal driver based on the browser
	 * 
	 * @param browser
	 * @return
	 */
	public WebDriver init_driver(String browser) {
		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());

		} else if (browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		} else {
			WebDriverManager.safaridriver().setup();
			driver.set(new SafariDriver());
		}
		get_driver().manage().deleteAllCookies();
		get_driver().manage().window().maximize();
		return get_driver();
	}

	/**
	 * To get the driver with threadlocal
	 * 
	 * @return
	 */
	public static synchronized WebDriver get_driver() {
		return driver.get();
	}
}
