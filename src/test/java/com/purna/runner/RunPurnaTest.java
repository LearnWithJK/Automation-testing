package com.purna.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		tags = "@RegressionTest", 
		features = "src/test/resources/features", 
		glue = "com.purna.stepdefinitions",
//		dryRun=true,
		monochrome = true,
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })

public class RunPurnaTest extends AbstractTestNGCucumberTests {
	   @Override
	   @DataProvider(parallel = true)
	   public Object[][] scenarios() {
	   return super.scenarios();
}
}