package co.com.sofka.task.service.rest.post;


import co.com.sofka.integrations.service.rest.post.Post;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;



public class DoPost implements Task {

    private String resource;
    private String bodyRequest;

    public DoPost withTheResource(String resource) {
        this.resource = resource;
        return this;
    }


    public DoPost andTheBodyRequest(String bodyRequest) {
        this.bodyRequest = bodyRequest;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(resource)
                        .with(
                                requestSpecification -> requestSpecification.contentType(ContentType.JSON)
                                        .body(bodyRequest)
                        )
        );

    }

    public static DoPost doPost(){
        return new DoPost();
    }
}


