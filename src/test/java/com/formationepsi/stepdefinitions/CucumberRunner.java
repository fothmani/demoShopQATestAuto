package com.formationepsi.stepdefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/resources/features/searchTestCase.feature"
,glue= {"com.formationepsi.stepdefinitions"},
monochrome = true,
publish = true,
plugin = {"html:target/htmlreports.html", "json:target/jsonreports"}
)
public class CucumberRunner {
	
}
