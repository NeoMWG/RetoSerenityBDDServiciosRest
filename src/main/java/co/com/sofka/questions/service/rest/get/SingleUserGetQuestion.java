package co.com.sofka.questions.service.rest.get;

import co.com.sofka.models.service.rest.get.singleuseerget.SingleUserGetModel;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class SingleUserGetQuestion implements Question<SingleUserGetModel> {
    @Override
    public SingleUserGetModel answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(SingleUserGetModel.class);
    }
}
