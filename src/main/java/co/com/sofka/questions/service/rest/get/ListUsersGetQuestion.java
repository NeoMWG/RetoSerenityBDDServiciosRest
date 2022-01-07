package co.com.sofka.questions.service.rest.get;

import co.com.sofka.models.service.rest.get.listusers.ListUsersGetModel;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ListUsersGetQuestion implements Question<ListUsersGetModel> {
    @Override
    public ListUsersGetModel answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(ListUsersGetModel.class);
    }
}
