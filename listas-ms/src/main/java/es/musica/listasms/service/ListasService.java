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
	List<ListaDTO> findMusicLists(String gender, String artist);
	
    /**
     * Guarda una lista musical en BD
     * 
     * @param 
     * @return
     */
	Long saveMusicList(ListaDTO listaMusical);
	
    /**
     * Devuelve las listas que recomienda a un usuario
     * 
     * @param
     * @return
     */
	List<ListaDTO> findRecommendedListsUser(String userId);
}
