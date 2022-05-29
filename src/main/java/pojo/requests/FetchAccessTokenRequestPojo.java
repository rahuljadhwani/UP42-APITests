package pojo.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FetchAccessTokenRequestPojo {

    @JsonProperty("grant_type")
    private String grantType;

}
