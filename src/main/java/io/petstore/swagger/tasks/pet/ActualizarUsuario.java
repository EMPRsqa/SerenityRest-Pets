package io.petstore.swagger.tasks.pet;

import io.petstore.swagger.models.pet.UserModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Put;

public class ActualizarUsuario implements Task {
    private final String username;
    private final UserModel user;

    public ActualizarUsuario(String username, UserModel user) {
        this.username = username;
        this.user = user;
    }

    public static ActualizarUsuario ConLosDatos(String username, UserModel user) {
        return Tasks.instrumented(ActualizarUsuario.class, username, user);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to("/user/{username}")
                        .with(request -> request
                                .header("Content-Type", "application/json")
                                .pathParam("username", username)
                                .body(user))
        );
    }
}