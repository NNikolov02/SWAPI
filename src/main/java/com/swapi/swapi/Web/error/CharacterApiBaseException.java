package com.swapi.swapi.Web.error;

import java.util.UUID;

public class CharacterApiBaseException extends RuntimeException {
    private final UUID errorid;
    public CharacterApiBaseException(String massage){
        super(massage);
        this.errorid = UUID.randomUUID();


    }

    public UUID getErrorId() {
        return errorid;
    }
}