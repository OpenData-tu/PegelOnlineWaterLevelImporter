package de.tu_berlin.ise.open_data.waterlevel.model;

/**
 * Created by ahmadjawid on 7/2/17.
 */
public class GaugeZero {

    private String unit;
    private float value;
    private String validFrom;

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(String validFrom) {
        this.validFrom = validFrom;
    }
}
