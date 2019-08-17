package es.musica.listasms.persistence.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.musica.listasms.persistence.beans.CancionBean;
import es.musica.listasms.persistence.beans.UsuarioBean;

public interface UsuariosDAO extends MongoRepository<UsuarioBean, Long> {
	List<CancionBean> findTracksByUserId(String userId);
	Optional<UsuarioBean> findByUserId(String userId);

	
}
