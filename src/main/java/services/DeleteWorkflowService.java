package services;

import constants.APIPaths;
import io.restassured.response.Response;
import utils.TokenManager;

import static io.restassured.RestAssured.given;

public class DeleteWorkflowService {

    public Response deleteWorkflow(String workflowId){

       return given(BaseService.getRequestSpec(APIPaths.getDeleteWorkflowURI(workflowId))).auth().oauth2(TokenManager.getToken())
               .when().delete().then().spec(BaseService.getResponseSpec()).extract().response();
    }

}
