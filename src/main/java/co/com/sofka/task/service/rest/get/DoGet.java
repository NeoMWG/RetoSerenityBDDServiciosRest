package co.com.sofka.task.service.rest.get;

import co.com.sofka.integrations.service.rest.get.Get;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;


public class DoGet implements Task {

    private String resource;

    public DoGet withTheResource(String resource) {
        this.resource = resource;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(resource)
                .with(
                        requestSpecification
                                -> requestSpecification
                                .contentType(ContentType.JSON)
                                .relaxedHTTPSValidation())
        );
    }

    public static DoGet doGet(){
        return new DoGet();
    }

}
