package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class practice extends Pages.practice{


@Given("user is on automaation test store site")
public void user_is_on_automaation_test_store_site() {
    url();
}

@When("user clicks on login button")
public void user_clicks_on_login_button() throws InterruptedException {
	loginbtn();
}

@When("user enters username as {string} and password as {string}")
public void user_enters_username_as_and_password_as(String string, String string2)throws InterruptedException {
	login(string,string2);
}

@Then("user is successfully logged in")
public void user_is_successfully_logged_in() {
	checkloggedinornot();
}

@Given("user is logged into the site")
public void user_is_logged_into_the_site() {
	checkloggedinornot();
    
}

@When("user clicks on menssss section")
public void user_clicks_on_menssss_section() throws InterruptedException {
	clickonmenssection();
}

@Then("user is able to see mensss products")
public void user_is_able_to_see_mensss_products() {
	getnamesofmensproduct();

}

@When("user enters {string} on search section")
public void user_enters_on_search_section(String string) throws InterruptedException{
	searchonsite(string);
}

@Then("user is able to appropraite products")
public void user_is_able_to_appropraite_products() {
    getnamesofproduct();
}
	
}
