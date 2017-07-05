package de.tu_berlin.open_data.waterlevel.pegelonline.service;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import de.tu_berlin.open_data.waterlevel.pegelonline.model.Schema;
import de.tu_berlin.open_data.waterlevel.pegelonline.model.WaterLevel;
import org.springframework.stereotype.Service;

/**
 * Created by ahmadjawid on 7/2/17.
 */
@Service
public class WaterLevelJsonSchemaCreator implements JsonSchemaCreator {

    @Override
    public String create(Schema schema) {
        WaterLevel waterLevelItem = (WaterLevel) schema;

        JsonNodeFactory nodeFactory = JsonNodeFactory.instance;

        ObjectNode mainObject = nodeFactory.objectNode();

        mainObject.put("source_id", "pegelonline_wsw_de");
        mainObject.put("device", waterLevelItem.getLongname());
        mainObject.put("timestamp", waterLevelItem.getTimeseries().get(0).getCurrentMeasurement().getTimestamp());


        ObjectNode firstLevelChild = nodeFactory.objectNode();

        firstLevelChild.put("lat", waterLevelItem.getLatitude());
        firstLevelChild.put("lon", waterLevelItem.getLongitude());

        mainObject.set("location", firstLevelChild);

        mainObject.put("license", "find out");

        firstLevelChild = nodeFactory.objectNode();

        ObjectNode secondLevelChild = nodeFactory.objectNode();
        secondLevelChild.put("sensor", "");
        secondLevelChild.put("observation_value", waterLevelItem.getTimeseries().get(0).getCurrentMeasurement().getValue());
        firstLevelChild.set("waterLevel", secondLevelChild);


        mainObject.set("sensors", firstLevelChild);
        firstLevelChild = nodeFactory.objectNode();

        firstLevelChild.put("measurementUnit", waterLevelItem.getTimeseries().get(0).getUnit());
        firstLevelChild.put("equidistance", waterLevelItem.getTimeseries().get(0).getEquidistance());
        firstLevelChild.put("trend", waterLevelItem.getTimeseries().get(0).getCurrentMeasurement().getTrend());
        firstLevelChild.put("stateMnwMhw", waterLevelItem.getTimeseries().get(0).getCurrentMeasurement().getStateMnwMhw());
        firstLevelChild.put("stateNswHsw", waterLevelItem.getTimeseries().get(0).getCurrentMeasurement().getStateNswHsw());


        if (waterLevelItem.getTimeseries().get(0).getGaugeZero() != null){
            secondLevelChild = nodeFactory.objectNode();
            secondLevelChild.put("gaugeZeroUnit", waterLevelItem.getTimeseries().get(0).getGaugeZero().getUnit());
            secondLevelChild.put("gaugeZeroValue", waterLevelItem.getTimeseries().get(0).getGaugeZero().getValue());
            secondLevelChild.put("gaugeZeroValidForm", waterLevelItem.getTimeseries().get(0).getGaugeZero().getValidFrom());
            firstLevelChild.set("gaugeZero", secondLevelChild);
        }




        mainObject.set("extra", firstLevelChild);


        return mainObject.toString();
    }
}
