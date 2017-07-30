package de.tu_berlin.ise.open_data.application.waterlevel.batch;

import de.tu_berlin.ise.open_data.application.waterlevel.model.WaterLevel;
import de.tu_berlin.ise.open_data.library.service.JsonSchemaCreator;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by ahmadjawid on 7/2/17.
 * Processing includes converting Java Objects to json string objects according our defined schema
 */
public class WaterLevelItemProcessor implements ItemProcessor<WaterLevel, String> {


    @Autowired
    @Qualifier("waterLevelJsonSchemaCreator")
    private JsonSchemaCreator jsonSchemaCreator;

    @Override
    public String process(WaterLevel item) throws Exception {

        //A valid json objects is created and returned
        return jsonSchemaCreator.create(item);

    }
}
