package services;

import constants.APIPaths;
import io.restassured.http.ContentType;
import pojo.requests.FetchAccessTokenRequestPojo;
import utils.TokenManager;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class FetchAccessToken {

    //POST for fetching access token and logic to verify its validity

    FetchAccessTokenRequestPojo fetchAccessTokenRequestPojo = new FetchAccessTokenRequestPojo();
    Map<String, Object> requestMap = new LinkedHashMap<>();

    public String fetchAccessToken(){

        return given(BaseService.getTokenRequestSpec())
                .formParam("grant_type","client_credentials")
                .post()
                .getBody().jsonPath().get("data.accessToken");
    }


}
