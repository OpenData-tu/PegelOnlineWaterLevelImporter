package de.tu_berlin.open_data.waterlevel.pegelonline.batch;

import de.tu_berlin.open_data.waterlevel.pegelonline.service.ApplicationService;
import de.tu_berlin.open_data.waterlevel.pegelonline.service.JsonSchemaCreator;
import de.tu_berlin.open_data.waterlevel.pegelonline.model.WaterLevel;
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
        item.getTimeseries().get(0).getCurrentMeasurement().setTimestamp(applicationService.toISODateFormat(item.getTimeseries().get(0).getCurrentMeasurement().getTimestamp()));
       return jsonSchemaCreator.create(item);

    }
}
