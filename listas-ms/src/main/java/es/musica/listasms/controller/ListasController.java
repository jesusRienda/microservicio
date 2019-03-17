package es.musica.listasms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.musica.listasms.dto.ListaDTO;
import es.musica.listasms.service.ListasService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ListasController {
	
	private ListasService listasService;
	
	@Autowired
	public ListasController() {
		
	}
	
    @GetMapping
    @ApiOperation(value = "Find lists", response = List.class)
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Error no controlado del sistema") })
    public List<ListaDTO> findList(
            @ApiParam(value = "parametros de filtrado", required = true) @RequestParam String gender,
            @ApiParam(value = "parametros de filtrado", required = true) @RequestParam String artist) {

        return listasService.findMusicLists();
    }
    
    @PostMapping
    @ApiOperation(value = "Save list", response = Long.class)
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Error no controlado del sistema") })
    public Long saveList(
            @ApiParam(value = "lista musical", required = true) @RequestBody ListaDTO listaMusical) {

        return listasService.saveMusicList();

    }
}
