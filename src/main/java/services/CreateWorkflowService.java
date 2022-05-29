package services;

import constants.APIPaths;
import constants.FrameworkConstants;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import pojo.requests.CreateWorkflowPojo;
import utils.TokenManager;

import static io.restassured.RestAssured.given;

public class CreateWorkflowService {

    public String getWorkflowId(CreateWorkflowPojo createWorkflowPojo){
        return createWorkflow(createWorkflowPojo).getBody().jsonPath().get("data.id");
    }
    
    public Response createWorkflow(CreateWorkflowPojo createWorkflowPojo){
        return given(BaseService.getRequestSpec(APIPaths.getCreateWorkflowPath())).auth().oauth2(TokenManager.getToken())
                .body(createWorkflowPojo).when().post().then().spec(BaseService.getResponseSpec()).extract().response();
    }
}
