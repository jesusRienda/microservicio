package es.musica.listasms.persistence.beans;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "listas")
public class ListaBean {
	private Long listId;
	private String name;
	private Integer numTracks;
	private Integer numArtists;
	private Integer duration;
	private List<CancionBean> tracks;
}
