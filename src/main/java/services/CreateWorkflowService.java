package services;

import constants.APIPaths;
import io.restassured.response.Response;
import pojo.requests.CreateWorkflowPojo;
import utils.PropertyReaderUtil;
import utils.TokenManager;
import static io.restassured.RestAssured.given;

/**
 * This class contains methods related to Creating Workflows API.
 *
 * @author Rahul Jadhwani [30/05/2022]
 */

public class CreateWorkflowService {

    /**
     * This method will be used create Payload object(POJO) based on values from Property files.
     *
     */

    public CreateWorkflowPojo setupWorkflowPojoWithDefaultData(){
        CreateWorkflowPojo createWorkflowPojo = new CreateWorkflowPojo();
        createWorkflowPojo.setName(PropertyReaderUtil.readPropertyFileAsMap("src/main/resources/GenericData/WorkflowDefaultData.properties").get("workflowName"));
        createWorkflowPojo.setDescription(PropertyReaderUtil.readPropertyFileAsMap("src/main/resources/GenericData/WorkflowDefaultData.properties").get("workflowDescription"));
        return createWorkflowPojo;
    }

    public String getWorkflowId(){
        return createWorkflowWithDefaultData().getBody().jsonPath().get("data.id");
    }

    /**
     * This method will be used to perform POST - create Jobs with data sent via Pojo builder from setupWorkflowPojoWithDefaultData()
     *
     */
    public Response createWorkflowWithDefaultData(){
        return given(BaseService.getRequestSpec(APIPaths.getCreateWorkflowPath())).auth().oauth2(TokenManager.getToken())
                .body(setupWorkflowPojoWithDefaultData()).when().post().then().spec(BaseService.getResponseSpec()).extract().response();
    }
}
