package es.musica.listasms.persistence.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.musica.listasms.persistence.beans.ListaBean;

public interface ListasDAO extends MongoRepository<ListaBean, Long> {
	List<ListaBean> findByTracksTrackUriIn(List<String> trackUris);
	Optional<ListaBean> findByPid(Integer pid);

}
