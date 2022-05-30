package pojo.requests.jobs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * This class contains variables required to set while creating Nasa:Modis job. Getters can be used for validations.
 * Setters and Getters are created using Lombok library to reduce boilerplate code
 *
 * @author Rahul Jadhwani [30/05/2022]
 */

@Setter
@Getter
public class NasaModisJob extends Jobs{

    private String time;


    private int limit;


    /**
     * @JsonProperty annotation is used to give this field name as it should be in payload.
     * zoomLevel will be sent as zoom_level
     *
     */
    @JsonProperty("zoom_level")
    private int zoomLevel;


    /**
     * @JsonProperty annotation is used to give this field name as it should be in payload.
     * imageryLayers will be sent as imagery_layers
     *
     */
    @JsonProperty("imagery_layers")
    private List<String> imageryLayers;


    private List<Double> bbox;

}
