package io.petstore.swagger.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "io.petstore.swagger.stepsDefinitions", // <-- Debe coincidir exactamente con el nombre de tu paquete
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class Runner {
}