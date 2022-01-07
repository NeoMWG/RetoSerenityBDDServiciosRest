package co.com.sofka.runners.service.rest.post;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/service/rest/post/registersuccesspost.feature"},
        glue = {"co.com.sofka.stepdefinitions.service.rest.post"}
)
public class RegisterSuccessPostCucumberTest {
}
