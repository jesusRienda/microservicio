package es.musica.listasms.persistence.beans;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "usuarios")
public class UsuarioBean {
	private Long userId;
	private String name;
	private List<CancionBean> tracks;
}
