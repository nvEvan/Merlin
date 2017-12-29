package com.revature.merlin.gluecode;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="Features",
		glue="com.revature.merlin.gluecode"
		)
public class TestRunner {

}
