package com.sofka.retoTecnico.task;

import io.restassured.http.ContentType;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Put;
import net.thucydides.core.annotations.Step;

import java.util.Map;

import static com.sofka.retoTecnico.interaction.bodyConstructor.bodyUser;
import static com.sofka.retoTecnico.util.getConstant.BASE_ULR_USER;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class consumoApiPutUsers implements Task {

    private final Map<String, String> credenciales;

    public consumoApiPutUsers(Map<String, String> queryParameters) {
        this.credenciales = queryParameters;
    }

    @Override
    @Step("{0} realiza el consumo del servicio getUsers: #credenciales")
    public <T extends Actor> void performAs(T actor) {
        theActorInTheSpotlight().whoCan(CallAnApi.at(BASE_ULR_USER.getConstant()));
        SerenityRest.reset();
        actor.attemptsTo(
                Put.to(credenciales.get("usuario"))
                        .with(request -> request
                                .contentType(ContentType.JSON)
                                .body(bodyUser(credenciales))
                                .relaxedHTTPSValidation()
                                .log().all()
                        )
        );

    }

    public static consumoApiPutUsers userPutApi(Map<String, String> credenciales) {
        return Instrumented.instanceOf(consumoApiPutUsers.class)
                .withProperties(credenciales);
    }
}
