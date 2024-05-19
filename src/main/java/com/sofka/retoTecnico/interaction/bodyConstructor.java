package com.sofka.retoTecnico.interaction;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sofka.retoTecnico.models.Data;
import lombok.SneakyThrows;

import java.util.Map;

public class bodyConstructor {


    @SneakyThrows
    public static String bodyUser(Map<String, String> queryParameters) {

        Data body = Data.builder()
                   .id(Integer.parseInt(queryParameters.get("usuario")))
                    .email(queryParameters.get("email"))
                    .firstName(queryParameters.get("first_name"))
                    .lastName(queryParameters.get("last_name"))
                    .avatar(queryParameters.get("avatar"))
                    .build();


        return new ObjectMapper().writeValueAsString(body);

    }

}
