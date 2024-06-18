package com.urbanladder.runner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		dryRun = !true,
		features = {"src/test/resources/features"},
		glue = "com.urbanladder.definitions",
		plugin = {"html:Reports/myreport.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		monochrome = true,
		publish = true
		)
public class UrbanTestRunner{
}