package StepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.pagefortwoscenarios;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class fourthmay2026 {

    pagefortwoscenarios pfts=new pagefortwoscenarios();
   

    @Given("user is on web site xyz")
    public void user_is_on_web_site() {
        
        pfts.given1();
    }

    @When("user enter {string} and {string}")
    public void user_enter_and(String string, String string2) throws InterruptedException {
        
        pfts.when1(string, string2);
    }

    @Then("user is successfully logged in xyz")
    public void user_is_successfully_logged_in() {
       
        pfts.then1();
    }

    @Given("user is already logged in and is on home page")
    public void user_is_already_logged_in_and_is_on_home_page() {
     
        pfts.given2();
    }

    @When("user clicks on the cart button")
    public void user_clicks_on_the_cart_button() {
      
        pfts.when2();
    }

    @Then("user can see previously saved options")
    public void user_can_see_previously_saved_options() {
       
        pfts.then2();
    }
}