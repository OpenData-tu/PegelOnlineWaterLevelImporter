package de.tu_berlin.ise.open_data.waterlevel.service;

import de.tu_berlin.ise.open_data.waterlevel.model.Schema;
import org.springframework.batch.item.file.LineMapper;

/**
 * Created by ahmadjawid on 6/10/17.
 */
public interface ApplicationService {
    String [] getFields(Class<? extends Object> weatherDataClass);
    float parseToFloat(String number);
    String toISODateFormat(String date);

    LineMapper createLineMapper(Class<? extends Schema> aClass, Schema userModelInstance);
}
