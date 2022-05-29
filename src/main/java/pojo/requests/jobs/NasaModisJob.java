package pojo.requests.jobs;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class NasaModisJob extends Jobs{

    private String time;
    private int limit;
    private int zoom_level;
    private List<String> imagery_layers;
    private List<Double> bbox;

}
