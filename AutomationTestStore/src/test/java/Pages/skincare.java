package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	@FindBy(xpath="//div[@class='pricetag jumbotron'][1]//a[@data-id=96]//i")
	WebElement addtovcartbtn1;
	@FindBy(xpath="//div[@class='pricetag jumbotron'][1]//a[@data-id=65]//i")
	WebElement addtovcartbtn2;
	@FindBy(xpath="//ul[@id='main_menu_top']//li[@data-id='menu_cart']//a")
	WebElement cart;
	@FindBy(xpath="//div[@class='container-fluid cart-info product-list']//table[@class='table table-striped table-bordered']//tbody//tr")
	List<WebElement> noofrows;
	@FindBy(css="div[class='col-md-6 cart-info totals pull-right table-responsive']>a[onclick=\"save_and_checkout('checkout/shipping'); return false;\"]")
	WebElement checkoutbtn;
	@FindBy(css="select#estimate_country")
	WebElement country;
	@FindBy(css="table#totals_table>tbody>tr:nth-child(1)>td:nth-child(1)>span")
	WebElement subtotaltext;
	@FindBy(css="table#totals_table>tbody>tr:nth-child(1)>td:nth-child(2)>span")
	WebElement subtotalcost;
	@FindBy(xpath="//ul[@Id='main_menu_top']//li[@data-id='menu_account']//a[@class='top menu_account']")
	WebElement account;
	@FindBy(xpath="//ul[@Id='main_menu_top']//li[@data-id='menu_account']//ul//li[2]//a")
	WebElement logout;
	
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
	public void step3() throws InterruptedException {
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
		Actions action=new Actions(driver);
		action.moveToElement(addtovcartbtn1).perform();;
		addtovcartbtn1.click();
		Thread.sleep(Duration.ofSeconds(2));
		addtovcartbtn2.click();
		Thread.sleep(Duration.ofSeconds(2));
		action.scrollToElement(cart);
		Thread.sleep(Duration.ofSeconds(2));
		cart.click();
		Thread.sleep(Duration.ofSeconds(2));
		System.out.println("No of rows are: "+(noofrows.size()-1));
		Assert.assertEquals(2, noofrows.size()-1);

	}
	public void step4() throws InterruptedException{
		Thread.sleep(Duration.ofSeconds(2));
		cart.click();
		Thread.sleep(Duration.ofSeconds(2));
		System.out.println("No of rows are: "+(noofrows.size()-1));
		Assert.assertEquals(2, noofrows.size()-1);
	}
	public void step5()throws InterruptedException {
		Thread.sleep(Duration.ofSeconds(2));
		Actions action=new Actions(driver);
		action.scrollToElement(checkoutbtn);
		country.click();
		country.sendKeys("ind");
		country.sendKeys(Keys.ENTER);
		Thread.sleep(Duration.ofSeconds(2));
		System.out.println(subtotaltext.getText()+" : "+subtotalcost.getText());
		Thread.sleep(Duration.ofSeconds(2));
		checkoutbtn.click();
		Thread.sleep(Duration.ofSeconds(2));
		Assert.assertTrue(driver.getCurrentUrl().contains("checkout/confirm"));
		Assert.assertEquals(driver.findElement(By.cssSelector("span.maintext")).getText(), "CHECKOUT CONFIRMATION");
		System.out.println(driver.getTitle());
		
		
	}
	public void step6() throws InterruptedException{
		Actions action=new Actions(driver);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		action.scrollToElement(account);
		action.moveToElement(account).perform();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//ul[@Id='main_menu_top']//li[@data-id='menu_account']//ul//li[2]//a"))));
		action.moveToElement(logout);
		logout.click();
		System.out.println("Title: "+driver.getTitle());
		Assert.assertTrue(driver.getCurrentUrl().contains("logout"));
		System.out.println("URL: "+driver.getCurrentUrl());
	}
	
	
}
