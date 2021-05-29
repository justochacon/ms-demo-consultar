package ms.prueba.consultar.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestServiceReclamo {
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("tipoDocumento")
    private String tipoDocumento;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("numDocumento")
    private String numDocumento;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("mReclamo")
    private String mReclamo;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("descripcionReclamo")
    private String descripcionReclamo;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("idProducto")
    private String idProducto;

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getmReclamo() {
        return mReclamo;
    }

    public void setmReclamo(String mReclamo) {
        this.mReclamo = mReclamo;
    }

    public String getDescripcionReclamo() {
        return descripcionReclamo;
    }

    public void setDescripcionReclamo(String descripcionReclamo) {
        this.descripcionReclamo = descripcionReclamo;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }
    
    
}
