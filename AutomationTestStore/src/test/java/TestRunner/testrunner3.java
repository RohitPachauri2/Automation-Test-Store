package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin= {"pretty","html:Reports/15april/report.html","json:Reports/15april/report.json"},
		glue= {"StepDefinition"},
		features= {"src/test/resources/Feature/test.feature"},
		monochrome=true,
		dryRun=true
		)

public class testrunner3 extends AbstractTestNGCucumberTests{

}
