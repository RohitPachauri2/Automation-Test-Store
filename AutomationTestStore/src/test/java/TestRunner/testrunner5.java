package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		plugin= {"pretty","html:Reports/4may/rohit.html","json:Reports/4may/rohit.json"},
		features= {"src/test/resources/Feature/4may2026.feature"},
		glue= {"StepDefinition"},
		monochrome=true,
		dryRun = false
		
		
		)

public class testrunner5 extends AbstractTestNGCucumberTests{

	
}
