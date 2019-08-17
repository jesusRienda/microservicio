package es.musica.listasms.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {
	private String userId;
	private String name;
	private List<CancionDTO> tracks;
}
