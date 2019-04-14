package es.musica.listasms.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.musica.listasms.dto.ListaDTO;
import es.musica.listasms.persistence.beans.ListaBean;
import es.musica.listasms.persistence.daos.ListasDAO;
import es.musica.listasms.service.ListasService;
@Service
public class ListasServiceImpl implements ListasService{
	
	
	@Autowired
	private ListasDAO listasDao;
	
	@Override
	public List<ListaDTO> findMusicLists(String gender, String artist) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long saveMusicList(ListaDTO listaMusical) {
		// TODO Auto-generated method stub
		ListaBean bean = new ListaBean();
        BeanUtils.copyProperties(listaMusical, bean);
		ListaBean result = listasDao.save(bean);
		return result.getListId();
	}



}
