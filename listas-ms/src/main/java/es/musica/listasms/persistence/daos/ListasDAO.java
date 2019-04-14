package es.musica.listasms.persistence.daos;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.musica.listasms.persistence.beans.ListaBean;

public interface ListasDAO extends MongoRepository<ListaBean, Long> {

}
