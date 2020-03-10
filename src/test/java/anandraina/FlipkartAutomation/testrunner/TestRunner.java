package anandraina.FlipkartAutomation.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\main\\java\\anandraina\\FlipkartAutomation\\featurefile\\OrderLifeCycleFeature.feature", glue = {
		"anandraina.FlipkartAutomation.stepdefinition" }, plugin = { "pretty",
				"html:test-output" }, strict = true, monochrome = true, dryRun = false)

public class TestRunner {
}