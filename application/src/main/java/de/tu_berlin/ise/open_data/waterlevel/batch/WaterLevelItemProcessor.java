package de.tu_berlin.ise.open_data.waterlevel.batch;

import de.tu_berlin.ise.open_data.library.service.ApplicationService;
import de.tu_berlin.ise.open_data.waterlevel.model.WaterLevel;
import de.tu_berlin.ise.open_data.waterlevel.service.JsonSchemaCreator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by ahmadjawid on 7/2/17.
 */
public class WaterLevelItemProcessor implements ItemProcessor<WaterLevel, String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(WaterLevelItemProcessor.class);

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    @Qualifier("waterLevelJsonSchemaCreator")
    private JsonSchemaCreator jsonSchemaCreator;

    @Override
    public String process(WaterLevel item) throws Exception {

       return jsonSchemaCreator.create(item);

    }
}
