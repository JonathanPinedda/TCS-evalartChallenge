package co.com.tcs.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features/fillform/fill_form.feature",
    glue = "co.com.tcs.stepdefinitions",
    snippets = CucumberOptions.SnippetType.CAMELCASE,
    plugin = "pretty"
)
public class FillFormRunner {
}
