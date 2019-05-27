package es.musica.listasms.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListaDTO {
	private Long listId;
	private String name;
	private Boolean collaborative;
	private Integer pid;
	private Integer modified_at;
	private Integer num_tracks;
	private Integer num_albums;
	private Integer num_followers;
	private Integer num_edits;
	private Integer duration_ms;
	private Integer num_artists;
	private List<CancionDTO> tracks;
}
