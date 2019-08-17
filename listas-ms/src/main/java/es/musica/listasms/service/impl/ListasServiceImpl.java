package es.musica.listasms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.musica.listasms.dto.ListaDTO;
import es.musica.listasms.persistence.beans.ListaBean;
import es.musica.listasms.persistence.beans.UsuarioBean;
import es.musica.listasms.persistence.daos.ListasDAO;
import es.musica.listasms.persistence.daos.UsuariosDAO;
import es.musica.listasms.service.ListasService;
@Service
public class ListasServiceImpl implements ListasService{
	
	
	@Autowired
	private ListasDAO listasDao;
	
	@Autowired
	private UsuariosDAO usuariosDAO;
	
	@Override
	public List<ListaDTO> findMusicLists(String gender, String artist) {
		List<ListaDTO> listasMusicales= new ArrayList<>();
//		List<ListaBean> listaFiltrada = null;
//		if(gender != null && artist != null) {
//			listaFiltrada = listasDao.findByTracksGenderAndTracksArtist(gender, artist);
//		} else if(gender != null) {
//			listaFiltrada = listasDao.findByTracksGender(gender);
//		} else if (artist != null) {
//			listaFiltrada = listasDao.findByTracksArtist(artist);
//		} else {
//			listaFiltrada = listasDao.findAll();
//		}
//		for (ListaBean listaBean : listaFiltrada) {
//			ListaDTO lista = new ListaDTO();
//			BeanUtils.copyProperties(listaBean, lista);
//			listasMusicales.add(lista);
//		}
		return listasMusicales;
	}

	@Override
	public Long saveMusicList(ListaDTO listaMusical) {
		ListaBean bean = new ListaBean();
		//TODO:save all para evitar RUES cosmo
		//List<ListaBean> beans = new ArrayList<>();
		//listasDao.saveAll(beans);

        BeanUtils.copyProperties(listaMusical, bean);
		ListaBean result = listasDao.save(bean);
		return result.getListId();
	}

	@Override
	public List<ListaDTO> findRecommendedListsUser(String userId) {
		List<ListaDTO> listasRecomendadas= new ArrayList<>();
		Optional<UsuarioBean> usuario = usuariosDAO.findByUserId(userId);
		if(usuario.isPresent()) {
			//Obtenemos las listas de reproduccion que contienen alguna cancion que ha escuchado el usuario
			List<ListaBean> listasUsuario = listasDao.findByTracksIn(usuario.get().getTracks());
			//Nos quedamos con las listas que contienen al menos dos canciones del usuario
			for (ListaBean listaBean : listasUsuario) {
				int count = listaBean.getTracks().stream()
			    .filter(usuario.get().getTracks()::contains)
			    .collect(Collectors
			    .toSet()).size();
				
				if(count>1) {
					ListaDTO lista = new ListaDTO();
					BeanUtils.copyProperties(listaBean, lista);
					listasRecomendadas.add(lista);
				}
			}
		}
		
		return listasRecomendadas;
	}

}
