package de.tu_berlin.ise.open_data.waterlevel.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ahmadjawid on 6/30/17.
 */

@Configuration
@ConfigurationProperties("resource")
public class ResourceProperties {

    private String url = "https://www.pegelonline.wsv.de/webservices/rest-api/v2/stations.json?" +
            "timeseries=W&includeTimeseries=true&includeCurrentMeasurement=true";

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
