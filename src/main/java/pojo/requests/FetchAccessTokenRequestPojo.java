package pojo.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * This class contains variables required while creating Payload Object for Fetching Access token.
 * Setters and Getters are created using Lombok library to reduce boilerplate code
 *
 * @author Rahul Jadhwani [30/05/2022]
 */

@Setter
@Getter
public class FetchAccessTokenRequestPojo {

    @JsonProperty("grant_type")
    private String grantType;

}
