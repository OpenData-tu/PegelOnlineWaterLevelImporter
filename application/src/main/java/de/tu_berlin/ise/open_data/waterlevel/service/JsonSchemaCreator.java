package de.tu_berlin.ise.open_data.waterlevel.service;


import de.tu_berlin.ise.open_data.waterlevel.model.Schema;
import org.json.JSONException;

/**
 * Created by ahmadjawid on 6/9/17.
 */
public interface JsonSchemaCreator {

     String create(Schema schema) throws JSONException;
}
