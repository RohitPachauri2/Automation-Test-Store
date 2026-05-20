package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import hooks.DriverClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepdefinition1 extends DriverClass{

	
	@Given("user is on the  homepage of the website automation")
	public void user_is_on_the_homepage_of_the_website_automation() throws InterruptedException {
		System.out.println(driver.getCurrentUrl());
		
	    Thread.sleep(1000);
	    
	}
	@When("user clicks on products link")
	public void user_clicks_on_products_link() throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement productbtn=driver.findElement(By.xpath("//a[text()=' Products']"));
	    action.moveToElement(productbtn).perform();
	    productbtn.click();
	    Thread.sleep(1000);
	    
	}

	@When("selects two products and add them to cart")
	public void selects_two_products_and_add_them_to_cart() throws InterruptedException {

		WebElement product1=driver.findElement(By.cssSelector("div.features_items>div:nth-child(10)>div>div:nth-child(2)>ul>li>a"));
		action.scrollToElement(product1).perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.features_items>div:nth-child(10)>div>div:nth-child(2)>ul>li>a")));
		product1.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.product-information>span>button")));
		WebElement addtocartbtn1=driver.findElement(By.cssSelector("div.product-information>span>button"));
		addtocartbtn1.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Continue Shopping']")));
		WebElement contshopp=driver.findElement(By.cssSelector("//button[text()='Continue Shopping']"));
		contshopp.click();
//		WebElement productbtn=driver.findElement(By.xpath("//a[text()=' Products']"));
//		action.scrollToElement(productbtn).perform();
//		action.moveToElement(productbtn).perform();
//	    productbtn.click();
//	    Thread.sleep(1000);
//	    
//	    WebElement product2=driver.findElement(By.cssSelector("div.features_items>div:nth-child(12)>div>div:nth-child(2)>ul>li>a"));
//		action.scrollToElement(product1).perform();
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.features_items>div:nth-child(12)>div>div:nth-child(2)>ul>li>a")));
//		product2.click();
//		WebElement addtocartbtn2=driver.findElement(By.cssSelector("div.product-information>span>button"));
//		addtocartbtn2.click();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Continue Shopping']")));
//		
//		contshopp.click();
		
	    
	}

	@Then("user is able to see the products in cart")
	public void user_is_able_to_see_the_products_in_cart() throws InterruptedException {
		WebElement cartbtn=driver.findElement(By.xpath(" //a[text()=' Cart']"));
		action.scrollToElement(cartbtn).perform();
		cartbtn.click();
		Thread.sleep(5000);
	    
	}

	@When("user searchs for a {string} in product page")
	public void user_searchs_for_a_in_product_page(String string) {
		System.out.println(string);
	    
	}

	@Then("user is able to add product in the cart of that category")
	public void user_is_able_to_add_product_in_the_cart_of_that_category() {
	    
	}



}
