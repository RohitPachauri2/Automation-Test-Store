package StepDefinition;

import org.openqa.selenium.WebDriver;

import Pages.skincare;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class skincare_stepdefinition {
	WebDriver driver = DriverClass.get_driver();
	skincare sc = new skincare(driver);

	@Given("User is on the home page")
	public void user_is_on_the_home_page() {
		
		sc.step1();

	}

	@When("user hovers over the skincare button and clicks eyes")
	public void user_hovers_over_the_skincare_button_and_clicks_eyes() throws InterruptedException {
		
		sc.step2();
	}

	@Then("user is navigated to eyes page")
	public void user_is_navigated_to_eyes_page() {
		
		sc.step3();
	}
}
