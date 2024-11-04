package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/test/resources/FeatureFiles",
				glue = "stepDefinitions",
				plugin = {"pretty",
						"html:target/HTML/report.html",
						"junit:target/JUNIT/report.xml",
						"json:target/JSON/report.json"},
				tags = "(@smoke and @regression) or @functional")
public class TestRunner3 {

}
