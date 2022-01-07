package co.com.sofka.questions.service.rest.post;

import co.com.sofka.models.service.rest.post.registersuccess.RegistrerSuccessPostModel;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class RegisterSuccessPostQuestion implements Question<RegistrerSuccessPostModel> {
    @Override
    public RegistrerSuccessPostModel answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(RegistrerSuccessPostModel.class);
    }
}
