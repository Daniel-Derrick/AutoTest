package StepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",glue= {"StepDefinitions"},
monochrome = true,
plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","html:target/HTMLReports/Report",
		           "json:target/jsonReports/Report",
		           "junit:target/JunitReports/Report"},
					tags= ("@SmokeTest"))
public class TestRunner {

	
}
