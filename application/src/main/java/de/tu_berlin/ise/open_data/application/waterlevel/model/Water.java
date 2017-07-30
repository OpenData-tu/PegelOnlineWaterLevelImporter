package de.tu_berlin.ise.open_data.application.waterlevel.model;

/**
 * Created by ahmadjawid on 7/2/17.
 * Used to parse data from the source
 */
public class Water {

    private String shortname;
    private String longname;

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
}
