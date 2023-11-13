package com.purna.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		tags = "@RegressionTest12345", 
		features = "src/test/resources/features", 
		glue = "com.purna.stepdefinitions",
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })

public class RunPurnaTest extends AbstractTestNGCucumberTests {

}
