package services;

import constants.APIPaths;
import io.restassured.http.ContentType;
import utils.TokenManager;

import static io.restassured.RestAssured.given;

public class RetrieveJobDetails {

    public void retrieveJobDetails(){

        given().auth().oauth2(TokenManager.getToken())
                .contentType(ContentType.JSON).body("").when().get(new APIPaths().getRetrieveJobDetailsURI())
                .getBody().prettyPrint();
    }
}
