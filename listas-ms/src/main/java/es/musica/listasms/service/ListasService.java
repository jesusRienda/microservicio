package es.musica.listasms.service;

import java.util.List;

import es.musica.listasms.dto.ListaDTO;

public interface ListasService {
	
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
	List<ListaDTO> findRecommendedListsUser(String userI, Integer trackContain);
}
