package de.tu_berlin.ise.open_data.waterlevel.model;

import java.util.List;

/**
 * Created by ahmadjawid on 7/2/17.
 */

public class WaterLevel extends Schema {

    private String uuid;
    private String number;
    private String shortname;
    private String longname;
    private float km;
    private String agency;
    private double longitude;
    private double latitude;
    private Water water;
    private List<TimeSeriesObject> timeseries;


    private final String sourceId = "luftdaten_brandenburg_de";
    private final String license = "find out";


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getLongname() {
        return longname;
    }

    public void setLongname(String longname) {
        this.longname = longname;
    }

    public float getKm() {
        return km;
    }

    public void setKm(float km) {
        this.km = km;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Water getWater() {
        return water;
    }

    public void setWater(Water water) {
        this.water = water;
    }

    public List<TimeSeriesObject> getTimeseries() {
        return timeseries;
    }

    public void setTimeseries(List<TimeSeriesObject> timeseries) {
        this.timeseries = timeseries;
    }

    public String getSourceId() {
        return sourceId;
    }

    public String getLicense() {
        return license;
    }

    @Override
    public String getDelimiter() {
        return null;
    }
}
