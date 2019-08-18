package es.musica.listasms.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import es.musica.listasms.dto.CancionDTO;
import es.musica.listasms.dto.UsuarioDTO;
import es.musica.listasms.exception.ListasException;
import es.musica.listasms.service.UsuariosService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
	
	private UsuariosService usuariosService;
	
	@Autowired
	public UserController(UsuariosService usuariosService) {
		this.usuariosService = usuariosService;
	}
	
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "Find tracks", response = List.class)
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Error no controlado del sistema") })
    public List<CancionDTO> findUserTracks(@PathVariable String userId) {

        return usuariosService.findUserTracks(userId);
    }
    
    @PutMapping
    @ApiOperation(value = "Save user", response = String.class)
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Error no controlado del sistema") })
    public String saveUser(
            @ApiParam(value = "usuario", required = true) @RequestBody UsuarioDTO usuario) {
    	if(!usuariosService.existeUser(usuario.getUserId())) {
            return usuariosService.saveUser(usuario);
    	} else {
    		throw new ListasException("400","El usuario que intenta crear ya existe");
    	}
    }
    
    @GetMapping
    @ApiOperation(value = "Get all users", response = List.class)
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Error no controlado del sistema") })
	public List<UsuarioDTO> getAllUsers() {
		return usuariosService.findAllUsers();

	}

}
