package services;

import constants.APIPaths;
import io.restassured.response.Response;
import utils.TokenManager;
import static io.restassured.RestAssured.given;

/**
 * This class contains methods related to Delete Workflow API.
 *
 * @author Rahul Jadhwani [30/05/2022]
 */

public class DeleteWorkflowService {


    /**
     * This method will be used to perform DELETE Workflow.
     *
     */
    public Response deleteWorkflow(String workflowId){

       return given(BaseService.getRequestSpec(APIPaths.getDeleteWorkflowURI(workflowId))).auth().oauth2(TokenManager.getToken())
               .when().delete().then().spec(BaseService.getResponseSpec()).extract().response();
    }

}
