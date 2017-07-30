package de.tu_berlin.ise.open_data.waterlevel.service;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import de.tu_berlin.ise.open_data.library.service.JsonStringBuilder;
import de.tu_berlin.ise.open_data.waterlevel.model.Schema;
import de.tu_berlin.ise.open_data.waterlevel.model.WaterLevel;
import org.json.JSONException;
import org.springframework.stereotype.Service;

/**
 * Created by ahmadjawid on 7/2/17.
 */
@Service
public class WaterLevelJsonSchemaCreator implements JsonSchemaCreator {

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

        jsonBuilder.setExtra(item.getTimeseries().get(0));


        return jsonBuilder.build();
    }
}
