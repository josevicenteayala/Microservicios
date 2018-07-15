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
import io.swagger.model.Cotejo;

@Controller
public class CotejoApiController implements CotejoApi {

    private static final Logger log = LoggerFactory.getLogger(CotejoApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public CotejoApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> agregarCotejo(@ApiParam(value = "id del cotejo a buscar",required=true) @PathVariable("idCotejo") String idCotejo,@ApiParam(value = "Cotejo a agregar"  )  @Valid @RequestBody Cotejo cotejo) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Cotejo> buscarCotejo(@ApiParam(value = "id del cotejo a buscar",required=true) @PathVariable("idCotejo") String idCotejo) {
        String accept = request.getHeader("Accept");
            Cotejo cotejo = new Cotejo("c123","t123","Colombia","Francia");
			cotejo.setEquipo1("Colombia");
			cotejo.setEquipo2("Francia");
			cotejo.setIdCotejo("c123");
			cotejo.setIdTorneo("t123");
			cotejo.setNombre("Cotejo inicial");
			
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.set("Apuestas", "Apuestas deportivas");
			httpHeaders.setExpires(1000);
			
			return new ResponseEntity<Cotejo>(cotejo,httpHeaders, HttpStatus.OK);
    }

}
