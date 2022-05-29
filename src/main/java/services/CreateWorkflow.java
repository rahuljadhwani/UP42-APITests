package services;

import constants.APIPaths;
import io.restassured.http.ContentType;
import utils.TokenManager;

import static io.restassured.RestAssured.given;

public class CreateWorkflow {

    public void createWorkflowWithDefaultData(){

        given().auth().oauth2(TokenManager.getToken())
                .contentType(ContentType.JSON).body("").when().post(new APIPaths().getCreateWorkflowURI())
                .getBody().prettyPrint();
    }
}
