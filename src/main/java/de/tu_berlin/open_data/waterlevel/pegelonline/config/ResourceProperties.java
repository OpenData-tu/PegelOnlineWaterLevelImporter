package de.tu_berlin.open_data.waterlevel.pegelonline.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ahmadjawid on 6/30/17.
 */

/* for now this class is not used temporarily*/
@Configuration
@ConfigurationProperties("resource")
public class ResourceProperties {
    /**
     * Path to the resource url (url contains all the files for one specific day) - mandatory
     */
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
