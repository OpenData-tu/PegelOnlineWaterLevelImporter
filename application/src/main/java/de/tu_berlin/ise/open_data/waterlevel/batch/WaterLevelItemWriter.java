package de.tu_berlin.ise.open_data.waterlevel.batch;

import de.tu_berlin.ise.open_data.waterlevel.service.KafkaServiceRecordProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by ahmadjawid on 7/2/17.
 */
public class WaterLevelItemWriter implements ItemWriter<String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(WaterLevelItemWriter.class);
    @Autowired
    KafkaServiceRecordProducer kafkaServiceRecordProducer;


    @Override
    public void write(List<? extends String> items) throws Exception {

        for (String jsonObject : items){
            kafkaServiceRecordProducer.produce(jsonObject);
        }

    }
}
