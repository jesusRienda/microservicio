package es.musica.listasms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.musica.listasms.dto.ListaDTO;
import es.musica.listasms.persistence.beans.CancionBean;
import es.musica.listasms.persistence.beans.ListaBean;
import es.musica.listasms.persistence.beans.UsuarioBean;
import es.musica.listasms.persistence.daos.ListasDAO;
import es.musica.listasms.persistence.daos.UsuariosDAO;
import es.musica.listasms.service.ListasService;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class ListasServiceImpl implements ListasService{
	
	
	@Autowired
	private ListasDAO listasDao;
	
	@Autowired
	private UsuariosDAO usuariosDAO;

	@Override
	public Long saveMusicList(ListaDTO listaMusical) {
		ListaBean bean = new ListaBean();
		//Comprobamos si la lista ya existe en la base de datos para no volver a meterla
		Optional<ListaBean> existeLista = listasDao.findByPid(listaMusical.getPid());
		if (existeLista.isPresent()) {
			log.info("La lista que esta intentando crear ya existe");
		} else {
			BeanUtils.copyProperties(listaMusical, bean);
			ListaBean result = listasDao.save(bean);
			return result.getListId();
		}
		return null;
	}

	@Override
	public List<ListaDTO> findRecommendedListsUser(String userId, Integer trackContain) {
		Integer numeroCancionesACoincidir = trackContain != null ? trackContain : 2;
		List<ListaDTO> listasRecomendadas= new ArrayList<>();
		Optional<UsuarioBean> usuario = usuariosDAO.findByUserId(userId);
		if(usuario.isPresent()) {
			UsuarioBean usuarioBean = usuario.get();
			//Obtenemos las listas de reproduccion que contienen alguna cancion que ha escuchado el usuario
			List<ListaBean> listasUsuario = listasDao.findByTracksTrackUriIn(usuarioBean.getTracks().stream().map(CancionBean :: getTrackUri).collect(Collectors.toList()));
			//Nos quedamos con las listas que contienen al menos dos canciones del usuario
			for (ListaBean listaBean : listasUsuario) {
				int count = listaBean.getTracks().stream().map(CancionBean:: getTrackUri)
			    .filter(usuarioBean.getTracks().stream().map(CancionBean:: getTrackUri).collect(Collectors
					    .toSet())::contains)
			    .collect(Collectors
			    .toSet()).size();
				
				if(count>= numeroCancionesACoincidir) {
					ListaDTO lista = new ListaDTO();
					BeanUtils.copyProperties(listaBean, lista);
					listasRecomendadas.add(lista);
				}
			}
		}
		return listasRecomendadas;
	}
}
