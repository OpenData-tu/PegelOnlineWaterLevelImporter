package de.tu_berlin.ise.open_data.library.service;

import de.tu_berlin.ise.open_data.library.model.Schema;
import org.springframework.batch.item.file.LineMapper;

import java.time.*;

/**
 * Created by ahmadjawid on 7/12/17.
 */
public interface ApplicationService {

    String[] getFields(Class<? extends Object> aClass);

    Double parseToDouble(String number);

    String toISODateFormat(String date) throws IllegalArgumentException;

    String toISODateFormat(String localDate, String localTime, boolean isUTC) throws IllegalArgumentException;

    String toISODateFormat(String localDate, String localTime, int zoneOffsetHours) throws IllegalArgumentException;

    String toISODateFormat(LocalDate localDate);

    String toISODateFormat(LocalDate localDate, LocalTime localTime, boolean isUTC);

    String toISODateFormat(LocalDate localDate, LocalTime localTime, ZoneOffset zoneOffset);

    String toISODateFormat(LocalDate localDate, LocalTime localTime, int zoneOffsetHours);


    String toISODateFormat(LocalDateTime localDateTime);

    LineMapper createLineMapper(Class<? extends Schema> aClass) throws IllegalAccessException, InstantiationException;


}
