package ms.prueba.consultar.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo/v1")
public class ConsultarController {

    @GetMapping(value = "/consultar", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseServicio consultar(RequestService request) {

        ResponseServicio response = new ResponseServicio();
        Productos producto = new Productos();
        producto.setCodProducto("PRO0001");
        producto.setNomProducto("TV");
        producto.setTecnologia("satelital");

        Productos producto1 = new Productos();
        producto1.setCodProducto("PRO0002");
        producto1.setNomProducto("INTERNET");
        producto1.setTecnologia("fibra optica");

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
        response.setCodCliente("C00021");

        return response;
    }

    @RequestMapping(value = "/registrarReclamo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseServicioReclamo registrar(@RequestBody RequestServiceReclamo request) {

        ResponseServicioReclamo response = new ResponseServicioReclamo();

        Integer cod = 12343;

        response.setCodRespuesta("0000");
        response.setMsgRespuesta("procesos exitoso");
        response.setCodigoReclamo(request.getIdProducto() + cod.toString() + request.getNumDocumento());

        return response;
    }

}
