package es.musica.listasms.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {
	private Long userId;
	private String name;
	private List<CancionDTO> tracks;
}
