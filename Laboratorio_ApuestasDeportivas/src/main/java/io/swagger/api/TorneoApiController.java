package io.swagger.api;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
import io.swagger.configuration.Utiles;
import io.swagger.model.Cotejo;
import io.swagger.model.Torneo;

@Controller
public class TorneoApiController implements TorneoApi {

	private static final Logger log = LoggerFactory.getLogger(TorneoApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;
	private Utiles utiles = new Utiles();

	@org.springframework.beans.factory.annotation.Autowired
	public TorneoApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<Void> agregarTorneo(
			@ApiParam(value = "id del torneo a buscar", required = true) @PathVariable("idTorneo") String idTorneo,
			@ApiParam(value = "Torneo a agregar") @Valid @RequestBody Torneo torneo) {
		String accept = request.getHeader("Accept");
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Torneo> buscarTorneo(
			@ApiParam(value = "id del torneo a buscar", required = true) @PathVariable("idTorneo") String idTorneo) {
		Torneo torneo = new Torneo();
		torneo.setFechaTorneo("2018-07-07T15:23:23.282Z");
		torneo.setIdTorneo("t123");
		torneo.setNombre("Mundial de Fútbol");
		torneo.add(linkTo(TorneoApi.class).slash(torneo.getIdTorneo()).withSelfRel());

		List<Cotejo> linkBuilder = methodOn(TorneoApiController.class).listarCotejos(torneo.getIdTorneo());
		Link cotejosLink = linkTo(linkBuilder).withRel("todos los torneos");
		torneo.add(cotejosLink);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setExpires(1000);
		httpHeaders.set("Mi_header", "valor x");

		return new ResponseEntity<Torneo>(torneo, httpHeaders, HttpStatus.OK);
	}

	@Override
	public List<Cotejo> listarCotejos(@PathVariable("idTorneo") String idTorneo) {
		List<Cotejo> responseList = utiles.listaCotejos();
		for (Cotejo cotejo: responseList) {
			Link cotejoLink = linkTo(CotejoApi.class).slash(cotejo.getIdCotejo()).withSelfRel();
			cotejo.add(cotejoLink);
		}
		
		return responseList;
	}

}
