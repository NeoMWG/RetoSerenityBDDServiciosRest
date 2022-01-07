package co.com.sofka.runners.service.rest.get;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/service/rest/get/singleuserget.feature"},
        glue = {"co.com.sofka.stepdefinitions.service.rest.get"}
)

public class SingleUserGetCucumberTest {
}
