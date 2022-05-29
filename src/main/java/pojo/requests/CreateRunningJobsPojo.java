package pojo.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import pojo.requests.jobs.NasaModisJob;
import pojo.requests.jobs.SharpeningJob;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateRunningJobsPojo {

    @JsonProperty("nasa-modis:1")
    private NasaModisJob nasamodis;

    @JsonProperty("sharpening:1")
    private SharpeningJob sharpening;


}
