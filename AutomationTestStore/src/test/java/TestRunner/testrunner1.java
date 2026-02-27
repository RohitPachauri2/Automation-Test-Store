package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin = { "pretty", "json:Reports/report.json","html:Reports/report.html" },
		glue = {"StepDefinition","StepDefinition"},
		features = {"src/test/resources/Feature"},
		monochrome = true,
		dryRun = false
		

)

public class testrunner1 extends AbstractTestNGCucumberTests {

}
