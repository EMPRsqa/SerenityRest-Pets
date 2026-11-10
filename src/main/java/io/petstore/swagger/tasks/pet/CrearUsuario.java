package io.petstore.swagger.tasks.pet;

import io.petstore.swagger.models.pet.UserModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class CrearUsuario implements Task {
    private final UserModel user;

    public CrearUsuario(UserModel user) {
        this.user = user;
    }

    public static CrearUsuario ConLosDatos(UserModel user) {
        return Tasks.instrumented(CrearUsuario.class, user);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/user")
                        .with(request -> request
                                .header("Content-Type", "application/json")
                                .body(user))
        );
    }
}