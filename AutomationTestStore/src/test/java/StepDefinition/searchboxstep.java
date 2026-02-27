package StepDefinition;

import org.openqa.selenium.WebDriver;

import Pages.searchbox;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class searchboxstep{
	WebDriver driver;
public searchbox sb=new searchbox(DriverClass.get_driver());
	@When("user enters \"(.*)\"$")
	public void user_enters(String string) {
	    sb.steps1(string);
	}

	@And("user is able to add all the elements to cart")
	public void user_is_able_to_add_all_the_elements_to_cart() {
	    sb.steps2();
	}

	@Then("user is able to see all elements in cart")
	public void user_is_able_to_see_all_elements_in_cart() throws InterruptedException {
	   sb.steps3();
	}

}
