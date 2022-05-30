package services;

import constants.APIPaths;
import io.restassured.response.Response;
import pojo.requests.CreateWorkflowPojo;
import utils.PropertyReaderUtil;
import utils.TokenManager;

import static io.restassured.RestAssured.given;

public class CreateWorkflowService {

    public CreateWorkflowPojo setupWorkflowPojoWithDefaultData(){
        CreateWorkflowPojo createWorkflowPojo = new CreateWorkflowPojo();
        createWorkflowPojo.setName(PropertyReaderUtil.readPropertyFileAsMap("src/main/resources/GenericData/WorkflowDefaultData.properties").get("workflowName"));
        createWorkflowPojo.setDescription(PropertyReaderUtil.readPropertyFileAsMap("src/main/resources/GenericData/WorkflowDefaultData.properties").get("workflowDescription"));
        return createWorkflowPojo;
    }

    public String getWorkflowId(){
        return createWorkflowWithDefaultData().getBody().jsonPath().get("data.id");
    }
    
    public Response createWorkflowWithDefaultData(){
        return given(BaseService.getRequestSpec(APIPaths.getCreateWorkflowPath())).auth().oauth2(TokenManager.getToken())
                .body(setupWorkflowPojoWithDefaultData()).when().post().then().spec(BaseService.getResponseSpec()).extract().response();
    }
}
