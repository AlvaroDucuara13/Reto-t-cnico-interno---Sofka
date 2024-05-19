package com.sofka.retoTecnico.question;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class getStatus implements Question<Boolean> {

    private final int code;

    public getStatus(int code) {
        this.code = code;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                seeThatResponse("El codigo recibido es " + code, response -> response.statusCode(code))
        );
        return true;
    }
    public static getStatus code(int code) {
        return new getStatus(code);
    }

}
