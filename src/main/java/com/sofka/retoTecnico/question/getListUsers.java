package com.sofka.retoTecnico.question;

import com.sofka.retoTecnico.task.consumoApiGetUsers;
import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

import static com.sofka.retoTecnico.util.getConstant.USER;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class getListUsers implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        actor.wasAbleTo(consumoApiGetUsers.userIdApi(""));
        LastResponse.received().answeredBy(theActorInTheSpotlight()).prettyPrint();
        JsonPath idUsers = SerenityRest.lastResponse().jsonPath();
        String idUsersCode = idUsers.getString("data.find { it.id == "+theActorInTheSpotlight().recall(USER.getConstant())+"}.id");
        if (idUsersCode == null) {
            return null;

        } else {

            return idUsersCode;
        }
    }
    public static getListUsers code() {
        return new getListUsers();
    }

}
