package co.com.sofka.questions.service.rest.post;

import co.com.sofka.models.service.rest.post.createuserpost.CreateUserPostModel;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CreateUserPostQuestion implements Question<CreateUserPostModel> {
    @Override
    public CreateUserPostModel answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(CreateUserPostModel.class);
    }
}
