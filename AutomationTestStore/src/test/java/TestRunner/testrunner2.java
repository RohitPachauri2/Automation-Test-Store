package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin= {"pretty","html:Reports/testrunner2.html"},
		glue= {"StepDefinition","hooks"},
		features= {"src/test/resources/Feature/Searchbox.feature"},
		dryRun=false,
		monochrome=true
		
		)

public class testrunner2 extends AbstractTestNGCucumberTests {

	
}
