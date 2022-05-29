package services;

import constants.APIPaths;
import io.restassured.http.ContentType;
import utils.TokenManager;

import static io.restassured.RestAssured.given;

public class AddingWorkflowTasks {

    public void addWorkflowTasksWithDefaultData(){

        given().auth().oauth2(TokenManager.getToken())
                .contentType(ContentType.JSON).body("").when().post(new APIPaths().getAddingWorkflowTasksURI())
                .getBody().prettyPrint();
    }
}
