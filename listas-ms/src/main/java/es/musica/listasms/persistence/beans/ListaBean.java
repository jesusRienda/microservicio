package es.musica.listasms.persistence.beans;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "lists")
public class ListaBean {
	private Long listId;
	private String name;
	private Boolean collaborative;
	private Integer pid;
	private Integer modifiedAt;
	private Integer numTracks;
	private Integer numAlbums;
	private Integer numFollowers;
	private Integer numEdits;
	private Integer durationMs;
	private Integer numArtists;
	private List<CancionBean> tracks;
}
