package es.musica.listasms.persistence.config;

import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import lombok.Getter;
import lombok.Setter;

@Configuration
@Getter
@Setter
public class MongoDbConfig {
	// @Value("${mongodb.datasource.db-name}")
	private String dbName;

	// @Value("${mongodb.datasource.uri}")
	private String uri;

	@Bean
	public MongoDbFactory mongoDbFactory() {

		return new SimpleMongoDbFactory(new MongoClient(new MongoClientURI("mongodb://bc-listas:CGiaerIs6DsXv3cxymG4mAhX2x1zeIO3UEdHq3RqfwSSlIqRE7WUcLv0WUkF8bCOpjGP0ce24kFEWNDOGNOq4A==@bc-listas.documents.azure.com:10255/?ssl=true&replicaSet=globaldb")), "bc_listas");
	}

    public @Bean(name = "mongoTemplate") MongoTemplate getMongoTemplate() throws UnknownHostException {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
        return mongoTemplate;
    }
}
