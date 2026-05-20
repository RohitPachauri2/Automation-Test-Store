package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		
		glue= {"hooks","StepDefinition"},
		plugin= {"pretty","html:Reports/15may/report.html","json:Reports/15may/report.json"},
		features= {"src/test/resources/Feature/function.feature"},
		monochrome = true,
		dryRun=false
		
		)

public class testrunner6 extends AbstractTestNGCucumberTests{

	
}
