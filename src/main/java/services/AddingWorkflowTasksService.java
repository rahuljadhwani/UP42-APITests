package services;

import constants.APIPaths;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import pojo.requests.TasksPojo;
import utils.PropertyReaderUtil;
import utils.TokenManager;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;


/**
 * This class contains (and will contain more acc to requirements) all methods related to Adding Workflow Tasks.
 *
 * @author Rahul Jadhwani [30/05/2022]
 */

public class AddingWorkflowTasksService {


    /**
     * This method will be used to perform POST - create Jobs with default data
     *
     */
    public Response addWorkflowTasksWithDefaultData(String workflowId){

        return given(BaseService.getRequestSpec(APIPaths.getAddingWorkflowTasksPath(workflowId))).auth().oauth2(TokenManager.getToken())
                .body(createTasksWithDefaultData()).when().post().then().spec(BaseService.getResponseSpec()).extract().response();
    }


    /**
     * This method will be used to perform POST - create Jobs with Custom data sent from Tests
     *
     */
    public Response addWorkflowTasksWithCustomData(String workflowId, TasksPojo[] tasks){

        return given(BaseService.getRequestSpec(APIPaths.getAddingWorkflowTasksPath(workflowId))).auth().oauth2(TokenManager.getToken())
                .body(tasks).when().post().then().spec(BaseService.getResponseSpec()).extract().response();
    }



    /**
     * This method will be used to create Tasks with data from Property files.
     *
     * TO-DO: All hard coding can be removed and data can be sent according to tests
     *
     */
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


        public void validateAddWorkflowTasksResponseSchema(Response response) {
            BaseService.schemaValidation("AddingWorkflowTasksSchema", response);
        }
    }


