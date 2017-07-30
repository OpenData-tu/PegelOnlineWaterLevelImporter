package de.tu_berlin.ise.open_data.waterlevel.batch;

import de.tu_berlin.ise.open_data.waterlevel.model.WaterLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ahmadjawid on 7/2/17.
 */
class WaterLevelCustomJsonItemReader implements ItemReader<WaterLevel> {

    private static final Logger LOGGER = LoggerFactory.getLogger(WaterLevelCustomJsonItemReader.class);

    private final String apiUrl;
    private final RestTemplate restTemplate;

    private int nextWaterLevelIndex;
    private List<WaterLevel> waterLevelList;

    WaterLevelCustomJsonItemReader(String apiUrl, RestTemplate restTemplate) {
        this.apiUrl = apiUrl;
        this.restTemplate = restTemplate;
        nextWaterLevelIndex = 0;
    }

    @Override
    public WaterLevel read() throws Exception {

        if (waterLevelDataIsNotInitialized()) {
            waterLevelList = waterLevelDataFromAPI();
        }

        WaterLevel nextWaterLevel = null;

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

        ResponseEntity<WaterLevel[]> response = restTemplate.getForEntity(apiUrl, WaterLevel[].class);
        WaterLevel[] waterLevels = response.getBody();
        LOGGER.debug("Found {} items", waterLevels.length);

        return Arrays.asList(waterLevels);
    }
}
