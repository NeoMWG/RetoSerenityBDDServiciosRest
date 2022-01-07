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

public class ListUsersGetCucumberStepdefinition extends ServiceSetupRest {

    public static Logger LOGGER = Logger.getLogger(SingleUserGetCucumberStepdefinition.class);

    @Given("several users have been registered on the platform")
    public void severalUsersHaveBeenRegisteredOnThePlatform() {

        try {
            super.setupRest();
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
        }
    }

    @When("the information request is sent")
    public void theInformationRequestIsSent() {
        try {
            actor.attemptsTo(
                    doGet()
                            .withTheResource(RESOURCE_LISTUSERS)
            );

        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
        }
    }

    @Then("the administrator should be able to get the registered information")
    public void theAdministratorShouldBeAbleToGetTheRegisteredInformation() {
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
