package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		
		monochrome=true,
		plugin= {"pretty","html:Reports/4june.html","json:Reports/4june.json"},
		features= {"src/test/resources/Feature/practice.feature"},
		glue= {"StepDefinition"},
		dryRun=false
		
		)

public class practice extends AbstractTestNGCucumberTests{

	
	
}
