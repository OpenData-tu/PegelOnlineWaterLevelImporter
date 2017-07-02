package de.tu_berlin.open_data.waterlevel.pegelonline.batch;


import de.tu_berlin.open_data.waterlevel.pegelonline.model.WaterLevel;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by ahmadjawid on 7/2/17.
 */
@Configuration
@EnableBatchProcessing
public class BatchConfiguration {


    @Bean
    ItemReader<WaterLevel> reader(RestTemplate restTemplate) {
        return new WaterLevelCustomJsonItemReader("http://www.pegelonline.wsv.de/webservices/rest-api/v2/stations.json?includeTimeseries=true&includeCurrentMeasurement=true", restTemplate);
    }

    @Bean
    ItemProcessor<WaterLevel, String> processor() {
        return new WaterLevelItemProcessor();
    }

    @Bean
    ItemWriter<String> writer() {
        return new WaterLevelItemWriter();
    }

    @Bean
    Step step1(ItemReader<WaterLevel> reader,
               ItemProcessor processor,
               ItemWriter<String> writer,
               StepBuilderFactory stepBuilderFactory) {
        return stepBuilderFactory.get("step1")
                .<WaterLevel, WaterLevel>chunk(1)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    @Bean
    Job waterLevelJob(JobBuilderFactory jobBuilderFactory,
                      @Qualifier("step1") Step restStudentStep) {
        return jobBuilderFactory.get("waterLevelJob")
                .incrementer(new RunIdIncrementer())
                .flow(restStudentStep)
                .end()
                .build();
    }
}