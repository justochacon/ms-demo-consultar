package ms.prueba.consultar.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseServicioReclamo {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("cod_Respuesta")
    private String codRespuesta;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("msg_Respuesta")
    private String msgRespuesta;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("codigoReclamo")
    private String codigoReclamo;

    public String getCodRespuesta() {
        return codRespuesta;
    }

    public void setCodRespuesta(String codRespuesta) {
        this.codRespuesta = codRespuesta;
    }

    public String getMsgRespuesta() {
        return msgRespuesta;
    }

    public void setMsgRespuesta(String msgRespuesta) {
        this.msgRespuesta = msgRespuesta;
    }

    public String getCodigoReclamo() {
        return codigoReclamo;
    }

    public void setCodigoReclamo(String codigoReclamo) {
        this.codigoReclamo = codigoReclamo;
    }

}
