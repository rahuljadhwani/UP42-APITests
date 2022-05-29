package services;

import constants.APIPaths;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.TokenManager;

import static io.restassured.RestAssured.given;

public class RetrieveJobDetailsService {

    public Response retrieveJobDetails(String jobId){

        return given(BaseService.getRequestSpec(APIPaths.getRetrieveJobDetailsURI(jobId))).auth().oauth2(TokenManager.getToken())
                .when().get().then().spec(BaseService.getResponseSpec()).extract().response();
    }
}
