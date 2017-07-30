package de.tu_berlin.ise.open_data.application.waterlevel.model;

/**
 * Created by ahmadjawid on 7/2/17.
 * Used to parse data from the source
 */
public class Measurement {

    private String timestamp;
    private float value;
    private int trend;
    private String stateMnwMhw;
    private String stateNswHsw;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public int getTrend() {
        return trend;
    }

    public void setTrend(int trend) {
        this.trend = trend;
    }

    public String getStateMnwMhw() {
        return stateMnwMhw;
    }

    public void setStateMnwMhw(String stateMnwMhw) {
        this.stateMnwMhw = stateMnwMhw;
    }

    public String getStateNswHsw() {
        return stateNswHsw;
    }

    public void setStateNswHsw(String stateNswHsw) {
        this.stateNswHsw = stateNswHsw;
    }
}
