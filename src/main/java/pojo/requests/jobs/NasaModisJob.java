package pojo.requests.jobs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class NasaModisJob extends Jobs{

    private String time;

    private int limit;

    @JsonProperty("zoom_level")
    private int zoomLevel;

    @JsonProperty("imagery_layers")
    private List<String> imageryLayers;

    private List<Double> bbox;

}
