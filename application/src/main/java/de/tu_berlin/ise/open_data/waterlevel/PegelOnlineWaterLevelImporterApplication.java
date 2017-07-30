package de.tu_berlin.ise.open_data.waterlevel;

import de.tu_berlin.ise.open_data.library.config.ServiceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableTask
@Import(ServiceConfiguration.class)
public class PegelOnlineWaterLevelImporterApplication {

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(PegelOnlineWaterLevelImporterApplication.class, args);
	}
}
