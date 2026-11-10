package io.petstore.swagger.stepDefinitions;

import io.petstore.swagger.models.pet.UserModel;
import io.petstore.swagger.questions.pet.ElCodigoDeRespuesta;
import io.petstore.swagger.tasks.pet.ActualizarUsuario;
import io.petstore.swagger.tasks.pet.ConsultarUsuario;
import io.petstore.swagger.tasks.pet.CrearUsuario;
import io.petstore.swagger.utils.ExcelReader;
import io.cucumber.java.Before;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Cuando;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class PetstoreStepDefinitions {

    private UserModel testUser;
    private final String baseUrl = "https://petstore.swagger.io/v2";

    @Before
    public void setTheStage() {
        // Inicializa el escenario para que Serenity reconozca los actores
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que el usuario automatizado se conecta a la API de Petstore")
    public void queElUsuarioAutomatizadoSeConectaALaApiDePetstore() {
        theActorCalled("AutomationUser").can(CallAnApi.at(baseUrl));
    }

    @Cuando("lee los datos del usuario desde el archivo Excel")
    public void leeLosDatosDelUsuarioDesdeElArchivoExcel() {
        String excelPath = "src/test/resources/data/DatosPetstore.xlsx";
        testUser = ExcelReader.getDataFromExcel(excelPath, "Usuarios");
    }

    @Cuando("realiza la solicitud para crear el usuario")
    public void realizaLaSolicitudParaCrearElUsuario() {
        theActorInTheSpotlight().attemptsTo(
                CrearUsuario.conLosDatos(testUser)
        );
    }

    @Cuando("realiza la solicitud para consultar el usuario creado")
    public void realizaLaSolicitudParaConsultarElUsuarioCreado() {
        theActorInTheSpotlight().attemptsTo(
                ConsultarUsuario.conElUsername(testUser.getUsername())
        );
    }

    @Cuando("realiza la solicitud para actualizar el usuario")
    public void realizaLaSolicitudParaActualizarElUsuario() {
        theActorInTheSpotlight().attemptsTo(
                ActualizarUsuario.conLosDatos(testUser.getUsername(), testUser)
        );
    }

    @Entonces("el código de respuesta HTTP debe ser {int}")
    public void elCodigoDeRespuestaHttpDebeSer(int statusCodeEsperado) {
        theActorInTheSpotlight().should(
                seeThat("El código de estado de la respuesta", ElCodigoDeRespuesta.es(), equalTo(statusCodeEsperado))
        );
    }
}