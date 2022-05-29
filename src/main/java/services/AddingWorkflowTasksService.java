package services;

import constants.APIPaths;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import pojo.requests.TasksPojo;
import utils.TokenManager;

import static io.restassured.RestAssured.given;

public class AddingWorkflowTasksService {

    public Response addWorkflowTasksWithDefaultData(String workflowId, TasksPojo tasks[]){

        return given(BaseService.getRequestSpec(APIPaths.getAddingWorkflowTasksPath(workflowId))).auth().oauth2(TokenManager.getToken())
                .body(tasks).when().post().then().spec(BaseService.getResponseSpec()).extract().response();
    }

}
