package com.sofka.retoTecnico.stepdefinition.hook;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static com.sofka.retoTecnico.util.getConstant.ACTOR_NAME;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class Hook {

    @Before
    public void setUpConfigurationsFront() {
        setTheStage(new OnlineCast());
        theActorCalled(ACTOR_NAME.getConstant());
    }

}
