package es.musica.listasms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.musica.listasms.dto.CancionDTO;
import es.musica.listasms.dto.UsuarioDTO;
import es.musica.listasms.persistence.beans.CancionBean;
import es.musica.listasms.persistence.beans.UsuarioBean;
import es.musica.listasms.persistence.daos.UsuariosDAO;
import es.musica.listasms.service.UsuariosService;
@Service
public class UsuarioServiceImpl implements UsuariosService{
	
	
	@Autowired
	private UsuariosDAO usuariosDAO;

	@Override
	public List<CancionDTO> findUserTracks(Long userId) {
		List<CancionDTO> canciones = new ArrayList<>();

		Optional<UsuarioBean> usuario = usuariosDAO.findByUserId(userId);
		if (usuario.isPresent()) {
			for (CancionBean cancionBean : usuario.get().getTracks()) {
				CancionDTO cancion = new CancionDTO();
				BeanUtils.copyProperties(cancionBean, cancion);
				canciones.add(cancion);
			}
		}
		return canciones;
	}

	@Override
	public Long saveUser(UsuarioDTO usuario) {
		UsuarioBean bean = new UsuarioBean();
        BeanUtils.copyProperties(usuario, bean);
		UsuarioBean result = usuariosDAO.save(bean);
		return result.getUserId();
	}


}
