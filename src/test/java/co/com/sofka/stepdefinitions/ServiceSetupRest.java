package co.com.sofka.stepdefinitions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;


public class ServiceSetupRest {

    protected static final String URL_BASE = "https://reqres.in";
    protected static final String RESOURCE_SINGLEUSER = "/api/users/2";
    protected static final String RESOURCE_LISTUSERS = "/api/users?page=2";
    protected static final String RESOURCE_CREATE = "/api/users";
    protected static final String RESOURCE_REGISTER = "/api/register";
    protected final Actor actor = new Actor("Miguel");

    protected void setupRest() {
        actorCan();
    }

    protected void actorCan() {
        actor.can(CallAnApi.at(URL_BASE));
    }

}



