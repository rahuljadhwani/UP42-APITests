package services;

import constants.APIPaths;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
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

    public Response fetchAccessTokenResponse(){

        return given(BaseService.getTokenRequestSpec())
                .formParam("grant_type","client_credentials")
                .post().then().spec(BaseService.getResponseSpec()).extract().response();
    }


}
