package es.musica.listasms.service;

import java.util.List;

import es.musica.listasms.dto.ListaDTO;

public interface ListasService {
	
    /**
     * Devuelve las listas musicales que cumplen con los parametros de filtrado
     * 
     * @param
     * @return
     */
	List<ListaDTO> findMusicLists();
	
    /**
     * Guarda una lista musical en BD
     * 
     * @param 
     * @return
     */
	Long saveMusicList();
}
