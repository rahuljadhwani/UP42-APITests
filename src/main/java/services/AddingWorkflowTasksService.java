package services;

import constants.APIPaths;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import pojo.requests.TasksPojo;
import utils.PropertyReaderUtil;
import utils.TokenManager;

import static io.restassured.RestAssured.given;

public class AddingWorkflowTasksService {

    public Response addWorkflowTasksWithDefaultData(String workflowId){

        return given(BaseService.getRequestSpec(APIPaths.getAddingWorkflowTasksPath(workflowId))).auth().oauth2(TokenManager.getToken())
                .body(createTasksWithDefaultData()).when().post().then().spec(BaseService.getResponseSpec()).extract().response();
    }

    public Response addWorkflowTasksWithCustomData(String workflowId, TasksPojo[] tasks){

        return given(BaseService.getRequestSpec(APIPaths.getAddingWorkflowTasksPath(workflowId))).auth().oauth2(TokenManager.getToken())
                .body(tasks).when().post().then().spec(BaseService.getResponseSpec()).extract().response();
    }

    public TasksPojo[] createTasksWithDefaultData(){
            TasksPojo task1 = new TasksPojo();
            task1.setName("nasa-modis:1");
            task1.setParentName(null);
            task1.setBlockId(PropertyReaderUtil.readPropertyFileAsMap("src/main/resources/GenericData/TaskaData.properties")
                    .get("nasaModiBlockId"));

            TasksPojo task2 = new TasksPojo();
            task2.setName("sharpening:1");
            task2.setParentName("nasa-modis:1");
            task2.setBlockId(PropertyReaderUtil.readPropertyFileAsMap("src/main/resources/GenericData/TaskaData.properties")
                    .get("sharpeningBlockId"));

            TasksPojo tasks[] = new TasksPojo[]{task1,task2};
            return tasks;
        }
    }


