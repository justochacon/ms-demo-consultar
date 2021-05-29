package ms.prueba.consultar.controller;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import ms.prueba.consultar.controller.ResponseServicio;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class ConsultarControllerTest {

    @Autowired
    private WebTestClient webCliente;
    
    private static RequestServiceReclamo requestok;
    
    @BeforeAll
    public static void setUp() {
        
        ObjectMapper mapper = new ObjectMapper();
        ClassLoader classLoader = ConsultarControllerTest.class.getClassLoader();

        TypeReference<RequestServiceReclamo> Request = new TypeReference<RequestServiceReclamo>() {
        };
     try {   
        requestok =
                mapper.readValue(new File(classLoader.getResource("request/casoOK1.json").getFile()),
                        Request);
        
    } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
    }
    }

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
    void indexPostTest01() {
        this.webCliente.post()
            .uri("/demo/v1/registrarReclamo")
            .accept(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromValue(requestok))
            .exchange()
            .expectStatus().isEqualTo(HttpStatus.CREATED)
            .expectBody(ResponseServicioReclamo.class);
    }

}
