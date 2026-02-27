package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class searchbox {
WebDriver driver;
WebDriverWait wait;
Actions action;
	public searchbox(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		action=new Actions(driver);
	}
	@FindBy(css="input#filter_keyword")
	WebElement searchbox;
	@FindBy(css="div[class='thumbnails grid row list-inline']>div>div:nth-child(1)>div>a")
	List<WebElement> allitems;
	@FindBy(css="div[class='pricetag jumbotron']>a[data-id='86']")
	WebElement element1;
	@FindBy(css="ul#main_menu_top>li:nth-child(3)>a")
	WebElement cart;
	
	public void steps1(String str){
		wait.until(ExpectedConditions.visibilityOf(searchbox));
		searchbox.click();
		searchbox.sendKeys(str);
		searchbox.sendKeys(Keys.ENTER);
		
	}
	public void steps2() {
		wait.until(ExpectedConditions.visibilityOf(element1));
		System.out.println("All items are:----------------------");
		for(WebElement x:allitems) {
		System.out.println(x.getText());
		}
		System.out.println("---------------------------");
		action.scrollToElement(element1);
		action.moveToElement(element1);
		element1.click();
	}
	public void steps3() throws InterruptedException {
		action.scrollToElement(cart);
		action.moveToElement(cart);
		cart.click();
		Thread.sleep(Duration.ofSeconds(2));
	}
	
	
}
