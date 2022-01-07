package co.com.sofka.stepdefinitions.service.rest.post;

import co.com.sofka.models.service.rest.post.registersuccess.RegistrerSuccessPostModel;
import co.com.sofka.stepdefinitions.ServiceSetupRest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import static co.com.sofka.task.service.rest.post.DoPost.doPost;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class RegisterSuccessPostCucumbertStepdefinition extends ServiceSetupRest {

    public static Logger LOGGER = Logger.getLogger(RegisterSuccessPostCucumbertStepdefinition.class);
    private final RegistrerSuccessPostModel registrerSuccessPostModel = new RegistrerSuccessPostModel();

    @Given("a person is on the user creation page and enters the username {string} and password {string}")
    public void aPersonIsOnTheUserCreationPageAndEntersTheUsernameAndPassword(String emailUser, String password) {
        try {

            super.setupRest();
            registrerSuccessPostModel.setEmail(emailUser);
            registrerSuccessPostModel.setPassword(password);

        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
        }
    }

    @When("this person sends the service new request")
    public void thisPersonSendsTheServiceNewRequest() {
        try {

            actor.attemptsTo(doPost()
                    .withTheResource(RESOURCE_REGISTER)
                    .andTheBodyRequest(bodyRequest()));

        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
        }
    }

    @Then("the administrator should be able to get the registered information")
    public void theAdministratorShouldBeAbleToGetTheRegisteredInformation() {
        try {
            actor.should(
                    seeThatResponse("El código de respuesta HTTP debe ser: ",
                            response -> response.statusCode(HttpStatus.SC_OK))
            );
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
        }
    }

    private String bodyRequest() {
        return "{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"pistol\"\n" +
                "}";
    }
}
