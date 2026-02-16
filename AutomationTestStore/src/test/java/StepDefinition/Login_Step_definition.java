package StepDefinition;

import org.openqa.selenium.WebDriver;

import Pages.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_Step_definition{

	Login lp=new Login(DriverClass.get_driver());
	
	@Given("user is navigated to home page")
	public void user_is_navigated_to_home_page() throws InterruptedException {
		lp.step1();
	}

	@When("^user enters \"(.*)\" and \"(.*)\" and clicks login$")
	public void user_enters_username_and_password_and_clicks_login(String part1,String part2) throws InterruptedException {
		lp.step2(part1,part2);
	}

	@Then("user is logged in")
	public void user_is_logged_in() throws InterruptedException {
		lp.step3();
	}

}
