package io.petstore.swagger.questions.pet;
/*
 * @(#) ResponseServerCode.java 11.0
 * Copyright 2023 SQA. Todos los derechos reservados.
 */

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

/**
 * @autor Rafael Chica
 * @Fecha: --o--
 */
public class ResponseServerCode implements Question {

    @Override
    public Object answeredBy(Actor actor) {
        return SerenityRest.lastResponse().statusCode();
    }

    public static Question was(){
        return  new ResponseServerCode();
    }
}
