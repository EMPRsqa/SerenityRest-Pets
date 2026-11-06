package io.petstore.swagger.questions.pet;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ElCodigoDeRespuesta implements Question<Integer> {

    public static ElCodigoDeRespuesta es() {
        return new ElCodigoDeRespuesta();
    }

    @Override
    public Integer answeredBy(Actor actor) {
        return SerenityRest.lastResponse().statusCode();
    }
}