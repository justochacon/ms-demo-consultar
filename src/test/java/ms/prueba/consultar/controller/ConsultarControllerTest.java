package ms.prueba.consultar.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import ms.prueba.consultar.model.RequestServiceReclamo;
import ms.prueba.consultar.model.ResponseServicio;
import ms.prueba.consultar.model.ResponseServicioReclamo;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@AutoConfigureWebTestClient(timeout = "20000")
@TestPropertySource(locations = { "classpath:application.properties" })
public class ConsultarControllerTest {

    @Autowired
    private WebTestClient webCliente;

    @Test
    void Test01Ok() {

        WebTestClient.ResponseSpec responseSpec = webCliente.get()
                .uri(uriBuilder -> uriBuilder.path("/demo/v1/consultar")//
                        .queryParam("tipDocumento", "DNI")//
                        .queryParam("numDocumento", "12345678")//
                        .build())
                .accept(MediaType.APPLICATION_JSON)//
                .exchange();
        responseSpec.expectStatus().isOk().expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(ResponseServicio.class);

    }

    @Test
    void Test02ok() {
        RequestServiceReclamo request = new RequestServiceReclamo();
        request.setTipoDocumento("DNI");
        request.setNumDocumento("72580356");
        request.setmReclamo("lentitud en internet");
        request.setDescripcionReclamo("cada 2 horas se va el internet");
        request.setIdProducto("PR0001");
        this.webCliente.post().uri("/demo/v1/registrarReclamo").accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(request)).exchange().expectStatus().isEqualTo(HttpStatus.CREATED)
                .expectBody(ResponseServicioReclamo.class);
    }

}
