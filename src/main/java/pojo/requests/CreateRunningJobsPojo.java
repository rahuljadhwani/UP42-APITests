package pojo.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import pojo.requests.jobs.NasaModisJob;
import pojo.requests.jobs.SharpeningJob;

/**
 * This class contains variables required to set while creating Payload Object for Creating Jobs API. Getters can be used for validations.
 * Setters and Getters are created using Lombok library to reduce boilerplate code
 *
 * @author Rahul Jadhwani [30/05/2022]
 */

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateRunningJobsPojo {

    /**
     * @JsonProperty annotation is used to give this field name as it should be in payload.
     * nasamodis will be sent as nasa-modis:1
     *
     * TO-DO: more logic can be added in these methods, if same Job type is going to get used more than once. for example: nasa:modis:2
     *
     */
    @JsonProperty("nasa-modis:1")
    private NasaModisJob nasamodis;

    /**
     * @JsonProperty annotation is used to give this field name as it should be in payload.
     * sharpening will be sent as sharpening:1
     *
     */
    @JsonProperty("sharpening:1")
    private SharpeningJob sharpening;


}
