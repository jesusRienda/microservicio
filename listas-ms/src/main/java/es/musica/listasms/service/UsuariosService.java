package es.musica.listasms.service;

import java.util.List;

import es.musica.listasms.dto.CancionDTO;
import es.musica.listasms.dto.UsuarioDTO;

public interface UsuariosService {
	
    /**
     * Devuelve las canciones que ha escuchado un usuario
     * 
     * @param
     * @return
     */
	List<CancionDTO> findUserTracks(String userId);
	
    /**
     * Guarda un usuario en BD
     * 
     * @param 
     * @return
     */
	String saveUser(UsuarioDTO usuario);
	
    /**
     * Devuelve si existe algun usuario con el id pasado por parametro
     * 
     * @param userId
     * @return
     */
	Boolean existeUser(String userId);
	
    /**
     * Devuelve todos los usuarios guardados en bbdd
     * 
     * @param
     * @return
     */
	List<UsuarioDTO> findAllUsers();

}
