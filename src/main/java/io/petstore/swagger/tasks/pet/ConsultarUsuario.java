package io.petstore.swagger.tasks.pet;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class ConsultarUsuario implements Task {
    private final String username;

    public ConsultarUsuario(String username) {
        this.username = username;
    }

    public static ConsultarUsuario ConElUsername(String username) {
        return Tasks.instrumented(ConsultarUsuario.class, username);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/user/{username}")
                        .with(request -> request.pathParam("username", username))
        );
    }
}