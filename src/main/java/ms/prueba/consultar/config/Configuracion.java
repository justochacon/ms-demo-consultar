package ms.prueba.consultar.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@Component
@ConfigurationProperties
public class Configuracion {
    
    @Value("${application.status}")
    private String status;

    @Value("${application.consultar.prefijcodigoProducto}")
    private String prefijcodigoProducto;

    @Value("${application.consultar.prefijCodigoCliente}")
    private String prefijCodigoCliente;

    @Value("${application.registrar.codigoRepuesta}")
    private String codigoRepuesta;

    @Value("${application.registrar.mensajeRepuesta}")
    private String mensajeRepuesta;
    
    @Value("${application.registrar.preFijReclamo}")
    private String preFijReclamo;

    public String getStatus() {
        return status;
    }

    public String getPrefijcodigoProducto() {
        return prefijcodigoProducto;
    }

    public String getPrefijCodigoCliente() {
        return prefijCodigoCliente;
    }

    public String getCodigoRepuesta() {
        return codigoRepuesta;
    }

    public String getMensajeRepuesta() {
        return mensajeRepuesta;
    }

    public String getPreFijReclamo() {
        return preFijReclamo;
    }
    
}
