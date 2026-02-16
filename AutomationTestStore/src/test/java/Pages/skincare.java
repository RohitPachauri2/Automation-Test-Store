package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class skincare {
	WebDriver driver;
	Actions action;
	public skincare(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "ul[class='nav-pills categorymenu']>li:nth-child(4)>a")
	WebElement skicarebutton;
	@FindBy(css="#categorymenu > nav > ul > li:nth-child(4) > div > ul:nth-child(1) > li:nth-child(1) > a")
	WebElement eyssubcat;
	@FindBy(css="h1.heading1>span")
	WebElement textofpage;
	@FindBy(css="div[class='col-md-3 col-sm-6 col-xs-12']>div:nth-child(2)>div[class='pricetag jumbotron']>div>div")
	List<WebElement> pricesofelements;
	public void step1() {
		System.out.println("STEP1:--------------------");
		driver.get("https://automationteststore.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Assert.assertTrue(driver.getCurrentUrl().contentEquals("https://automationteststore.com/"));

	}
	public void step2() throws InterruptedException {
		System.out.println("STEP2:--------------------");
		action=new Actions(driver);
		action.moveToElement(skicarebutton).build().perform();
		Thread.sleep(Duration.ofSeconds(4));
		action.moveToElement(eyssubcat).build().perform();
		Thread.sleep(Duration.ofSeconds(4));
		eyssubcat.click();
		Thread.sleep(Duration.ofSeconds(4));
		

	}
	public void step3() {
		System.out.println("STEP3:--------------------");
		System.out.println(driver.getTitle());
		Assert.assertTrue(driver.getTitle().contentEquals("Eyes"));
		System.out.println(textofpage.getText());
		Assert.assertTrue(textofpage.getText().contentEquals("EYES"));
		System.out.println("No of Elements in this page are: "+pricesofelements.size());
		System.out.println("The Prices of these elements are: ");
		for(WebElement x:pricesofelements) {
			System.out.println(x.getText());
		}
		
		

	}
}
