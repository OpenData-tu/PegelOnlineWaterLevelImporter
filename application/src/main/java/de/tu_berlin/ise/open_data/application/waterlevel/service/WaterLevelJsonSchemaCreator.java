package de.tu_berlin.ise.open_data.application.waterlevel.service;

import de.tu_berlin.ise.open_data.library.model.Schema;
import de.tu_berlin.ise.open_data.library.service.JsonStringBuilder;
import de.tu_berlin.ise.open_data.application.waterlevel.model.WaterLevel;
import org.json.JSONException;
import org.springframework.stereotype.Service;

import de.tu_berlin.ise.open_data.library.service.JsonSchemaCreator;

/**
 * Created by ahmadjawid on 7/2/17.
 * * Implementation of {@link JsonSchemaCreator}
 */
@Service
public class WaterLevelJsonSchemaCreator implements JsonSchemaCreator {


    /**
     * Get an objects which is extended from {@link de.tu_berlin.ise.open_data.library.model.Schema} class
     * and converts it to json
     * @param schema
     * @return String
     * */
    @Override
    public String create(Schema schema) throws JSONException {
        WaterLevel item = (WaterLevel) schema;

        JsonStringBuilder jsonBuilder = new JsonStringBuilder();

        jsonBuilder.setSourceId(item.getSourceId());
        jsonBuilder.setDevice(item.getLongname());
        jsonBuilder.setTimestamp(item.getTimeseries().get(0).getCurrentMeasurement().getTimestamp());
        jsonBuilder.setLocation(item.getLatitude() + "", item.getLongitude() + "");
        jsonBuilder.setLicense(item.getLicense());

        jsonBuilder.setSensor("waterLevel", "unknown", item.getTimeseries().get(0).getCurrentMeasurement().getValue() + "");

        //A java object can be passed as the extra field of to be created json object.
        //This object is automatically parsed to json and is appended to the main json object
        jsonBuilder.setExtra(item.getTimeseries().get(0));


        return jsonBuilder.build();
    }
}
