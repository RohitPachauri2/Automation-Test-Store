package StepDefinition;

import org.testng.annotations.Test;

import Pages.BasePage;
import io.cucumber.java.en.Given;

public class Baseclassstepdefinition extends Baseclass{

	@Test
	public void test() {
		BasePage p=new BasePage(driver,action,wait,verify);
		p.mainmethod();
	}

}
