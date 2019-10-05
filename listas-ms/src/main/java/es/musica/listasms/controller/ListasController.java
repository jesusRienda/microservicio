package es.musica.listasms.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import es.musica.listasms.dto.ListaDTO;
import es.musica.listasms.service.ListasService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/listas", produces = MediaType.APPLICATION_JSON_VALUE)
public class ListasController {
	
	private ListasService listasService;
	
	@Autowired
	public ListasController(ListasService listasService) {
		this.listasService = listasService;
	}
    
    @PostMapping
    @ApiOperation(value = "Save list", response = Long.class)
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Error no controlado del sistema") })
    public Long saveList(
            @ApiParam(value = "lista musical", required = true) @RequestBody ListaDTO listaMusical) {

        return listasService.saveMusicList(listaMusical);

    }
    
    @PostMapping("/batch")
    @ApiOperation(value = "Save lists", response = Long.class)
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Error no controlado del sistema") })
    public void saveLists(
            @ApiParam(value = "listas musicales", required = true) @RequestBody List<ListaDTO> listasMusicales) {
    	listasMusicales.stream().forEach(list -> {
    		listasService.saveMusicList(list);
    	});
    }
    
    @RequestMapping(value = "/{userId}/{trackContain}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "Find recommended lists user", response = List.class)
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Error no controlado del sistema") })
    public List<ListaDTO> findRecommendedList(@PathVariable String userId, @PathVariable Integer trackContain) {

        return listasService.findRecommendedListsUser(userId, trackContain);
    }
}
