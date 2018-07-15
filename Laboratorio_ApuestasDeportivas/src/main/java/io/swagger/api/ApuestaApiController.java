package io.swagger.api;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
import io.swagger.model.Apuesta;

@Controller
public class ApuestaApiController implements ApuestaApi {

    private static final Logger log = LoggerFactory.getLogger(ApuestaApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ApuestaApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> agregarApuesta(@ApiParam(value = "id de la apuesta a buscar",required=true) @PathVariable("idApuesta") String idApuesta,@ApiParam(value = "Apuesta a agregar"  )  @Valid @RequestBody Apuesta cotejo) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Apuesta> buscarApuesta(@ApiParam(value = "id de la apuesta a buscar",required=true) @PathVariable("idApuesta") String idApuesta) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            Apuesta apuesta = new Apuesta();
			apuesta.setIdApuesta("a123");
			apuesta.setIdCotejo("c123");
			apuesta.setValor(10);
			
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.set("Apuestas", "Apuestas deportivas");
			httpHeaders.setExpires(1000);
			return new ResponseEntity<Apuesta>(apuesta,httpHeaders, HttpStatus.OK);
        }

        return new ResponseEntity<Apuesta>(HttpStatus.NOT_IMPLEMENTED);
    }

}
