package com.sofka.retoTecnico.stepdefinition;

import com.sofka.retoTecnico.question.getListUsers;
import com.sofka.retoTecnico.question.getStatus;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

import java.util.Map;

import static com.sofka.retoTecnico.task.consumoApiDeleteUsers.userDeleteApi;
import static com.sofka.retoTecnico.task.consumoApiGetUsers.userIdApi;
import static com.sofka.retoTecnico.task.consumoApiPutUsers.userPutApi;
import static com.sofka.retoTecnico.util.getConstant.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.*;

public class ejercicio1Step {

    /**Metodo get**/

    @Dado("que el analista de calidad desea consultar el usuario {}")
    public void queElAnalistaDeCalidadDeseaConsultarElUsuario(String usuario) {
        theActorInTheSpotlight().remember((USER.getConstant()), usuario);

    }

    @Cuando("el analista de calidad consume el servicio de get_user")
    public void elAnalistaDeCalidadConsumeElServicioDeGet_user() {
        theActorInTheSpotlight().attemptsTo(
                userIdApi(theActorInTheSpotlight().recall(USER.getConstant()))
        );
    }

    @Entonces("el analista de calidad podrá visualizar los datos del usuario con codigo de respuesta {}")
    public void elAnalistaDeCalidadPodráVisualizarLosDatosDelUsuario(int code) {
        LastResponse.received().answeredBy(theActorInTheSpotlight()).prettyPrint();
        theActorInTheSpotlight().should(seeThat("El codigo de respuesta entregado por la API es el correcto", getStatus.code(code)));


    }

    /**Metodo put**/

    @Dado("que el analista de calidad desea actualizar los datos del usuario:")
    public void queElAnalistaDeCalidadDeseaActualizarLosDatosDelUsuario(Map<String, String> queryParameters) {
        theActorInTheSpotlight().remember(QUERY_PARAMETERS.getConstant(), queryParameters);

    }

    @Cuando("el analista de calidad consume el servicio para actualizar los datos del usuario")
    public void elAnalistaDeCalidadConsumeElServicioParaActualizarLosDatosDelUsuario() {
        theActorInTheSpotlight().attemptsTo(
                userPutApi(theActorInTheSpotlight().recall(QUERY_PARAMETERS.getConstant()))
        );
    }

    @Entonces("el analista de calidad podrá visualizar los datos del usuario actualizados con codigo de respuesta {}")
    public void elAnalistaDeCalidadPodráVisualizarLosDatosDelUsuarioActualizadosConCodigoDeRespuesta(int code) {
        LastResponse.received().answeredBy(theActorInTheSpotlight()).prettyPrint();
        theActorInTheSpotlight().should(seeThat("El codigo de respuesta entregado por la API es el correcto", getStatus.code(code)));


    }

    /**Metodo Delete**/

    @Dado("que el analista de calidad desea eliminar el usuario {}")
    public void queElAnalistaDeCalidadDeseaEliminarElUsuario(String id) {
        theActorInTheSpotlight().remember((USER.getConstant()), id);

    }

    @Cuando("el analista de calidad consume el servicio para eliminar al usuario del sistema")
    public void elAnalistaDeCalidadConsumeElServicioParaEliminarAlUsuarioDelSistema() {
        theActorInTheSpotlight().attemptsTo(
                userDeleteApi(theActorInTheSpotlight().recall(USER.getConstant()))
        );
    }

    @Entonces("el analista de calidad podrá visualizar el codigo de respuesta {}")
    public void elAnalistaDeCalidadPodráVisualizarElCodigoDeRespuesta(int code) {
        theActorInTheSpotlight().should(seeThat("El codigo de respuesta entregado por la API es el correcto", getStatus.code(code)));
    }

    @Y("el analista de calidad debera validar que el usuario no exista en la lista de usuarios")
    public void elAnalistaDeCalidadDeberaValidarQueElUsuarioNoExistaEnLaListaDeUsuarios() {
        theActorInTheSpotlight().should(
                seeThat ("el usuario fue correctamente eliminado: ",
                        getListUsers.code(), isEmptyOrNullString())
        );
    }
}
