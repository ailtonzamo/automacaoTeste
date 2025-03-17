package com.automacao_api.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/automacao_api/features",
        glue = "com.automacao_api.steps",
      //  plugin = {"html:target/cucumber-reports/index.html"}

        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class TestRunner   {


}


