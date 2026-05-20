package StepDefinition;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.MainClass;

import hooks.DriverClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class twentyoneapril {
	MainClass mc;
    
	@Test
	public void step123() {
		MainClass mc=new MainClass(driver, wait, action);
		mc.step1();
		mc.step2();
		mc.step3();
	}
//    @Given("user adds phone")
//    public void user_adds_phone() {
//        mc.step1();
//    }
//
//    @When("user adds monitor")
//    public void user_adds_monitor() {
//        mc.step2();
//    }
//
//    @Then("goes to cart page and sees the total")
//    public void goes_to_cart_page_and_sees_the_total() {
//        mc.step3();
//    }
}