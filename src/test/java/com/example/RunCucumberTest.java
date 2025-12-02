package com.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * Runner dos cenários Cucumber usando JUnit 4.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.example",
        plugin = {"pretty"},
        monochrome = true
)
public class RunCucumberTest {
    // Classe usada apenas como runner dos cenários BDD.
}
