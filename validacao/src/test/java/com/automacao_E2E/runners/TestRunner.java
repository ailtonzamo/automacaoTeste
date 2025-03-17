package com.automacao_E2E.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/automacao_E2E/features",
        glue = "com.automacao_E2E.steps",
      //  plugin = {"html:target/cucumber-reports/index.html"}

        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class TestRunner   {


}


