package com.sofka.retoTecnico.task;

import io.restassured.http.ContentType;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

import static com.sofka.retoTecnico.util.getConstant.BASE_ULR_USER;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class consumoApiGetUsers implements Task {

    private final String credenciales;

    public consumoApiGetUsers(String queryParameters) {
        this.credenciales = queryParameters;
    }

    @Override
    @Step("{0} realiza el consumo del servicio getUsers: #credenciales")
    public <T extends Actor> void performAs(T actor) {
        theActorInTheSpotlight().whoCan(CallAnApi.at(BASE_ULR_USER.getConstant()));
        SerenityRest.reset();
        actor.attemptsTo(
                Get.resource(credenciales)
                        .with(request -> request
                                .contentType(ContentType.JSON)
                                .relaxedHTTPSValidation()
                                .log().all()
                        )
        );

    }

    public static consumoApiGetUsers userIdApi(String credenciales) {
        return Instrumented.instanceOf(consumoApiGetUsers.class)
                .withProperties(credenciales);
    }
}
