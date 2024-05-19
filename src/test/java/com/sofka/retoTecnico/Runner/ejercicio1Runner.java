package com.sofka.retoTecnico.Runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features/ejercicio1.feature"},
        glue = {"com.sofka.retoTecnico.stepdefinition"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class ejercicio1Runner {
}
