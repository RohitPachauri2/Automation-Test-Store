package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin= {"pretty","html:Reports/21april/report.html","json:Reports/21april/report.json"},
		features= {"src/test/resources/Feature/Newtest.feature"},
		glue= {"StepDefinition"},
		dryRun=false,
		monochrome = true
		)

public class testrunner4 extends AbstractTestNGCucumberTests{


}
