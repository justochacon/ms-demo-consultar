package ms.prueba.consultar.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ms.prueba.consultar.config.Configuracion;
import ms.prueba.consultar.model.Productos;
import ms.prueba.consultar.model.RequestService;
import ms.prueba.consultar.model.RequestServiceReclamo;
import ms.prueba.consultar.model.ResponseServicio;
import ms.prueba.consultar.model.ResponseServicioReclamo;

@RestController
@RequestMapping("/demo/v1")
public class ConsultarController {
    
    @Autowired
    private Configuracion properties;
    
    @GetMapping(value = "/consultar", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseServicio consultar(RequestService request) {

        ResponseServicio response = new ResponseServicio();
        Productos producto = new Productos();
        producto.setCodProducto(properties.getPrefijcodigoProducto() + "0001");
        producto.setNomProducto("TV");
        producto.setTecnologia("satelital");
        producto.setStatus(properties.getStatus());

        Productos producto1 = new Productos();
        producto1.setCodProducto(properties.getPrefijcodigoProducto() + "0002");
        producto1.setNomProducto("INTERNET");
        producto1.setTecnologia("fibra optica");
        producto1.setStatus(properties.getStatus());

        List<Productos> productos = new ArrayList<>();
        ;
        productos.add(producto);
        productos.add(producto1);
        response.setProductos(productos);
        response.setApellidos("Justo Chacon");
        response.setNombres("Ever Alejandro");
        response.setFecha_Nacimiento("10/08/1997");
        response.setNumDocumento(request.getNumDocumento());
        response.setTipDocumento(request.getTipDocumento());
        response.setCodCliente(properties.getPrefijCodigoCliente() + "00021");

        return response;
    }

    @RequestMapping(value = "/registrarReclamo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseServicioReclamo registrar(@RequestBody RequestServiceReclamo request) {

        ResponseServicioReclamo response = new ResponseServicioReclamo();

        Integer cod = 12343;

        response.setCodRespuesta(properties.getCodigoRepuesta());
        response.setMsgRespuesta(properties.getMensajeRepuesta());
        response.setCodigoReclamo(properties.getPreFijReclamo() + ": " + request.getIdProducto() + cod.toString() + request.getNumDocumento());

        return response;
    }

}
