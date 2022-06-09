package services;


import io.restassured.response.Response;
import pojo.requests.FetchAccessTokenRequestPojo;

import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;

/**
 * This class contains methods related to Fetch Access Token API.
 *
 * @author Rahul Jadhwani [30/05/2022]
 */

public class FetchAccessToken {


    /**
     * This method will be used to perform POST - and fetch an Access Token.
     *
     */
    public String fetchAccessToken(){

        return given(BaseService.getTokenRequestSpec())
                .formParam("grant_type","client_credentials")
                .post()
                .getBody().jsonPath().get("data.accessToken");
    }


    /**
     * This method will be used to perform POST - and fetch an Access Token along with its Response details.
     *
     */
    public Response fetchAccessTokenResponse(){

        return given(BaseService.getTokenRequestSpec())
                .formParam("grant_type","client_credentials")
                .post().then().spec(BaseService.getResponseSpec()).extract().response();
    }

    public void validateFetchAccessTokenResponseSchema(Response response) {
        BaseService.schemaValidation("FetchAccessTokenSchema", response);
    }

}
