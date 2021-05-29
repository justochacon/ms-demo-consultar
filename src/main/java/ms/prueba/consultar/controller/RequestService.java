package ms.prueba.consultar.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestService {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("tipDocumento")
    private String tipDocumento;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("numDocumento")
    private String numDocumento;

    public String getTipDocumento() {
        return tipDocumento;
    }

    public void setTipDocumento(String tipDocumento) {
        this.tipDocumento = tipDocumento;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

}
