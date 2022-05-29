package services;

import constants.APIPaths;
import io.restassured.http.ContentType;
import utils.TokenManager;

import static io.restassured.RestAssured.given;

public class DeleteWorkflow {

    public void deleteWorkflow(){

        given().auth().oauth2(TokenManager.getToken())
                .contentType(ContentType.JSON).body("").when().delete(new APIPaths().getDeleteWorkflowURI())
                .getBody().prettyPrint();
    }

}
