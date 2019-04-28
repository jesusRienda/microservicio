package es.musica.listasms.persistence.daos;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.musica.listasms.persistence.beans.ListaBean;

public interface ListasDAO extends MongoRepository<ListaBean, Long> {
	List<ListaBean> findByTracksGender(String gender);
	List<ListaBean> findByTracksArtist(String artist);
	List<ListaBean> findByTracksGenderAndTracksArtist(String gender, String artist);


}
