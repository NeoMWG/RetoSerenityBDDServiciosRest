package co.com.sofka.stepdefinitions.service.rest.get;

import co.com.sofka.questions.ResponseCode;
import co.com.sofka.stepdefinitions.ServiceSetupRest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import static co.com.sofka.task.service.rest.get.DoGet.doGet;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class SingleUserGetCucumberStepdefinition extends ServiceSetupRest {

    public static Logger LOGGER = Logger.getLogger(SingleUserGetCucumberStepdefinition.class);

    @Given("someone has pre-registered")
    public void someoneHasPreRegistered() {
        try {
            super.setupRest();
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
        }
    }

    @When("this person sends the request")
    public void thisPersonSendsTheRequest() {

        try {
            actor.attemptsTo(
                    doGet()
                            .withTheResource(RESOURCE_SINGLEUSER)
            );

        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
        }
    }

    @Then("the person should be able to get the registered information")
    public void thePersonShouldBeAbleToGetTheRegisteredInformation() {


        try {
            actor.should(
                    seeThat("El codigo de respuesta",
                            ResponseCode
                                    .was(), equalTo(HttpStatus.SC_OK))
                    );

        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
        }
    }

}
