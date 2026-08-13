package Freeflix.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "Freeflix.repo")
public class MongoConfig {

	private final String uri;

	public MongoConfig(@Value("${spring.data.mongodb.uri}") String uri) {
		this.uri = uri;
	}

	@Bean
	public MongoClient mongoClient() {
		ConnectionString connString = new ConnectionString(uri);
		MongoClientSettings settings = MongoClientSettings.builder()
			.applyConnectionString(connString)
			.build();
		return MongoClients.create(settings);
	}

	@Bean
	public MongoTemplate mongoTemplate(MongoClient client) {
		// database name is taken from the connection string
		String db = new ConnectionString(uri).getDatabase();
		return new MongoTemplate(client, db != null ? db : "test");
	}
}
