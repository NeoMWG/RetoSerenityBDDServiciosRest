package co.com.sofka.stepdefinitions.service.rest.post;

import co.com.sofka.models.service.rest.post.createuserpost.CreateUserPostModel;
import co.com.sofka.stepdefinitions.ServiceSetupRest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import static co.com.sofka.task.service.rest.post.DoPost.doPost;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class CreateUserPostCucumberStepdefinition extends ServiceSetupRest {

    public static Logger LOGGER = Logger.getLogger(CreateUserPostCucumberStepdefinition.class);
    private final CreateUserPostModel createUserPostModel = new CreateUserPostModel();

    @Given("a person is on the user creation page and enters the username {string} and job {string}")
    public void aPersonIsOnTheUserCreationPageAndEntersTheUsernameAndJob(String userName, String userJob) {
        try {

            super.setupRest();
            createUserPostModel.setName(userName);
            createUserPostModel.setJob(userJob);

        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
        }
    }

    @When("this person sends the service request")
    public void thisPersonSendsTheServiceRequest() {
        try {

            actor.attemptsTo(doPost()
                    .withTheResource(RESOURCE_CREATE)
                    .andTheBodyRequest(bodyRequest()));

        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
        }
    }

    @Then("the person should be able to view a message in response")
    public void thePersonShouldBeAbleToViewAMessageInResponse() {
        try {
            actor.should(
                    seeThatResponse("El código de respuesta HTTP debe ser: ",
                            response -> response.statusCode(HttpStatus.SC_CREATED))
                    );
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
        }
    }

    private String bodyRequest() {
        return "{\n" +
                "    \"name\": \"" + createUserPostModel.getName() + "\",\n" +
                "    \"job\": \"" + createUserPostModel.getJob() + "\"\n" +
                "}";
    }
}



