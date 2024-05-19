package com.sofka.retoTecnico.util;

import static com.sofka.retoTecnico.util.Constant.*;

public enum getConstant {

    ACTOR_NAME(ANALISTA),
    USER(ID_USER),
    QUERY_PARAMETERS(PARAMETERS),
    BASE_ULR_USER(URL_GETUSERS);

    private String constant;
    getConstant(String constant) {
        this.constant = constant;
    }
    public String getConstant() {
        return constant;
    }


}
