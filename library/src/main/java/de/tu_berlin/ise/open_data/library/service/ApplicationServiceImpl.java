package de.tu_berlin.ise.open_data.library.service;

import de.tu_berlin.ise.open_data.library.model.Schema;
import org.joda.time.DateTime;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahmadjawid on 5/21/17.
 */

@Component
public class ApplicationServiceImpl implements ApplicationService {

    @Override
    public String[] getFields(Class<? extends Object> aClass) {

        Field[] aClassDeclaredFields = aClass.getDeclaredFields();

        List<String> fields = new ArrayList<>();

        for (Field field : aClassDeclaredFields) {

            if (Modifier.isFinal(field.getModifiers()))
                continue;

            fields.add(field.getName());
        }

        return fields.toArray(new String[fields.size()]);
    }

    @Override
    public Double parseToDouble(String number) {

        try {
            return Double.parseDouble(number);
        } catch (NumberFormatException e) {
            return null;
        }

    }

    @Override
    public String toISODateFormat(String date) {

        DateTime dateTime = new DateTime(date);

        return dateTime.toDateTimeISO().toString();
    }

    @Override
    public String toISODateFormat(String localDate, String localTime, boolean isUTC) {

//        LocalDate localDate1 = LocalDate.parse(localDate);
//        LocalTime localTime1 = LocalTime.parse(localTime);
//        LocalDateTime localDateTime = LocalDateTime.of(localDate1, localTime1);
//        DateTime dateTime = new DateTime(localDateTime);

        DateTime dateTime = new DateTime((isUTC ? localDate + "T" + localTime + "Z" : localDate + "T" + localTime));


        return dateTime.toDateTimeISO().toString();
    }

    @Override
    public String toISODateFormat(String localDate, String localTime, int zoneOffsetHours) throws IllegalArgumentException {

        DateTime dateTime = new DateTime(localDate + "T" + localTime + ZoneOffset.ofHours(zoneOffsetHours));
        return dateTime.toDateTimeISO().toString();
    }

    @Override
    public String toISODateFormat(LocalDate localDate) {

        LocalTime localTime = LocalTime.of(22, 00, 00);

        DateTime dateTime = new DateTime(localDate.toString() + "T" + localTime);

        return dateTime.toDateTimeISO().toString();
    }

    @Override
    public String toISODateFormat(LocalDate localDate, LocalTime localTime, boolean isUTC) {


        DateTime dateTime = new DateTime((isUTC ? localDate + "T" + localTime + "Z" : localDate + "T" + localTime));

        return dateTime.toDateTimeISO().toString();
    }

    @Override
    public String toISODateFormat(LocalDate localDate, LocalTime localTime, ZoneOffset zoneOffset) {


        LocalDateTime localDateTime = LocalDateTime.parse(localDate.toString() + "T" + localTime.toString() + zoneOffset.toString());

        DateTime dateTime = new DateTime(localDateTime);


        return dateTime.toDateTimeISO().toString();
    }

    @Override
    public String toISODateFormat(LocalDate localDate, LocalTime localTime, int zoneOffsetHours) {
        LocalDateTime localDateTime = LocalDateTime.parse(localDate.toString() + "T" + localTime.toString() + ZoneOffset.ofHours(zoneOffsetHours));

        DateTime dateTime = new DateTime(localDateTime);


        return dateTime.toDateTimeISO().toString();
    }

    @Override
    public String toISODateFormat(LocalDateTime localDateTime) {

        DateTime dateTime = new DateTime(localDateTime);

        return dateTime.toDateTimeISO().toString();
    }

    @Override
    public LineMapper createLineMapper(Class<? extends Schema> aClass) throws IllegalAccessException, InstantiationException {
        return new DefaultLineMapper<Schema>() {{
            setLineTokenizer(new DelimitedLineTokenizer(aClass.newInstance().getDelimiter()) {{
                setNames(getFields(aClass));
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<Schema>() {{
                setTargetType(aClass);
            }});
        }};
    }
}
