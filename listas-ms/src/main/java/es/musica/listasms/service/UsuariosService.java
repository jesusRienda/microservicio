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
	List<CancionDTO> findUserTracks(Long userId);
	
    /**
     * Guarda un usuario en BD
     * 
     * @param 
     * @return
     */
	Long saveUser(UsuarioDTO usuario);
}
