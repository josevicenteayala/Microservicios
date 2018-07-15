/**
 * NOTE: This class is auto generated by the swagger code generator program (1.0.13).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.model.Apuesta;

@Api(value = "apuesta", description = "the apuesta API")
public interface ApuestaApi {

    @ApiOperation(value = "Creación de apuestas de fútbol", nickname = "agregarApuesta", notes = "Crear una apuesta de un torneo de fútbol", tags={ "adminstradores", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "apuesta creada"),
        @ApiResponse(code = 400, message = "objeto no válido"),
        @ApiResponse(code = 409, message = "la apuesta ya existe") })
    @RequestMapping(value = "/apuesta/{idApuesta}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> agregarApuesta(@ApiParam(value = "id de la apuesta a buscar",required=true) @PathVariable("idApuesta") String idApuesta,@ApiParam(value = "Apuesta a agregar"  )  @Valid @RequestBody Apuesta cotejo);


    @ApiOperation(value = "busca una apuesta", nickname = "buscarApuesta", notes = "Encviando un ID valido devuelve la informacion de la apuesta ", response = Object.class, tags={ "apostadores", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "devuelve el resultado obtenido", response = Object.class),
        @ApiResponse(code = 400, message = "mal entrada de datos") })
    @RequestMapping(value = "/apuesta/{idApuesta}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Apuesta> buscarApuesta(@ApiParam(value = "id de la apuesta a buscar",required=true) @PathVariable("idApuesta") String idApuesta);

}
