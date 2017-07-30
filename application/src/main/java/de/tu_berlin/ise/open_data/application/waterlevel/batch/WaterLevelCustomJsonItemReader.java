package de.tu_berlin.ise.open_data.application.waterlevel.batch;

import de.tu_berlin.ise.open_data.application.waterlevel.model.WaterLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ahmadjawid on 7/2/17.
 * Includes a read method which specifies how to read data from the api
 */
class WaterLevelCustomJsonItemReader implements ItemReader<WaterLevel> {

    private static final Logger LOGGER = LoggerFactory.getLogger(WaterLevelCustomJsonItemReader.class);

    private final String apiUrl;
    private final RestTemplate restTemplate;

    private int nextWaterLevelIndex;
    private List<WaterLevel> waterLevelList;

    //Set parameters
    WaterLevelCustomJsonItemReader(String apiUrl, RestTemplate restTemplate) {
        this.apiUrl = apiUrl;
        this.restTemplate = restTemplate;
        nextWaterLevelIndex = 0;
    }

    /**
     * Read the items one by one and return them as a list.
     * Stop when null is returned
     * @return WaterLevel
     * */
    @Override
    public WaterLevel read() throws Exception {

        if (waterLevelDataIsNotInitialized()) {
            waterLevelList = waterLevelDataFromAPI();
        }

        WaterLevel nextWaterLevel = null;

        //If next item exists get it.
        if (nextWaterLevelIndex < waterLevelList.size()) {
            nextWaterLevel = waterLevelList.get(nextWaterLevelIndex);
            nextWaterLevelIndex++;
        }

        return nextWaterLevel;
    }

    private boolean waterLevelDataIsNotInitialized() {
        return this.waterLevelList == null;
    }

    private List<WaterLevel> waterLevelDataFromAPI() {

        //Get the whole list of items using an array of WaterLevel from the apiUrl
        ResponseEntity<WaterLevel[]> response = restTemplate.getForEntity(apiUrl, WaterLevel[].class);
        //Put all items inside an array
        WaterLevel[] waterLevels = response.getBody();
        LOGGER.debug("Found {} items", waterLevels.length);

        //Return a list of items
        return Arrays.asList(waterLevels);
    }
}
