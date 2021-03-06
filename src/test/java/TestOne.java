import constants.FrameworkConstants;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import services.*;

import java.io.FileNotFoundException;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

/**
 * This class contains basic tests(and related assertions) from generating token, creating workflow, tasks, jobs and finally deleting the workflow.
 *
 * @author Rahul Jadhwani [30/05/2022]
 */

public class TestOne extends BaseTest{

    String workflowId;
    String jobId;

    @Test(priority = 0)
    public void testFetchAccessToken(){
        FetchAccessToken fetchAccessToken = new FetchAccessToken();
        Response response = fetchAccessToken.fetchAccessTokenResponse();
        assertThat(response.getStatusCode(), is(200));

        //Schema Validation
        fetchAccessToken.validateFetchAccessTokenResponseSchema(response);

        assertThat(response.jsonPath().get("data.accessToken"), not(blankString()));
    }

    @Test(dependsOnMethods = "testFetchAccessToken", priority = 1)
    public void testWorkflowCreation(){

        CreateWorkflowService createWorkflowService = new CreateWorkflowService();
        Response response = createWorkflowService.createWorkflowWithDefaultData();



        assertThat(response.getStatusCode(), is(200));
        assertThat(response.getHeader("Content-Type"), is("application/json"));

        //Schema Validation
        createWorkflowService.validateCreateWorkflowResponseSchema(response);

        assertThat(response.jsonPath().get("data.id"), not(blankString()));
        workflowId = response.jsonPath().get("data.id").toString();
        assertThat(response.jsonPath().get("data.name").toString(), is(FrameworkConstants.getPropertyMap().get("workflowName")));
        Assert.assertNull(response.jsonPath().get("error"));

        logData("Workflow successfully created. ID: "+workflowId);

    }

    @Test(enabled = true, dependsOnMethods = "testWorkflowCreation", priority = 2)
    public void testAddingWorkflowTasks() throws FileNotFoundException {
        AddingWorkflowTasksService addingWorkflowTasksService = new AddingWorkflowTasksService();
        Response response = addingWorkflowTasksService.addWorkflowTasksWithDefaultData(workflowId);

        assertThat(response.getStatusCode(), is(200));
        assertThat(response.getHeader("Content-Type"), is("application/json"));

        //Schema Validation
        addingWorkflowTasksService.validateAddWorkflowTasksResponseSchema(response);

        assertThat(response.jsonPath().get("data[0].id"), not(blankString()));
        assertThat(response.jsonPath().get("data[0].updatedBy.id").toString(), is(FrameworkConstants.getProjectID()));
        assertThat(response.jsonPath().get("data[1].updatedBy.id").toString(), is(FrameworkConstants.getProjectID()));
        assertThat(response.jsonPath().getList("data.id").size(), greaterThanOrEqualTo(1));
        assertThat(response.jsonPath().get("data[0].block.id").toString(), oneOf(FrameworkConstants.getPropertyMap().get("nasaModiBlockId"),FrameworkConstants.getPropertyMap().get("sharpeningBlockId")));
        assertThat(response.jsonPath().get("data[1].block.id").toString(), oneOf(FrameworkConstants.getPropertyMap().get("nasaModiBlockId"),FrameworkConstants.getPropertyMap().get("sharpeningBlockId")));
        Assert.assertNull(response.jsonPath().get("error"));

        logData("Tasks successfully added to Workflow ID "+workflowId);

    }

    @Test(enabled = true, dependsOnMethods = "testAddingWorkflowTasks", priority = 3)
    public void testRunningJobsCreation(){
        CreateRunningJobsService createRunningJobsService = new CreateRunningJobsService();
        Response response = createRunningJobsService.createJobsWithDefaultData(workflowId);
        jobId = response.getBody().jsonPath().get("data.id");

        assertThat(response.statusCode(), is(200));
        assertThat(response.getHeader("Content-Type"), is("application/json"));

        //Schema Validation
        createRunningJobsService.validateCreateRunningJobsResponseSchema(response);

        assertThat(response.jsonPath().get("data.id"), not(blankString()));
        assertThat(response.jsonPath().get("data.createdBy.id").toString(), is(FrameworkConstants.getProjectID()));
        assertThat(response.jsonPath().get("data.createdBy.type").toString(), is("API_KEY"));
        Assert.assertNull(response.jsonPath().get("error"));

        logData("Jobs successfully created. Job ID: "+jobId);

    }

    @Test(enabled = true, dependsOnMethods = "testRunningJobsCreation", priority = 4)
    public void testRetrieveJobDetails(){
        RetrieveJobDetailsService retrieveJobDetailsService = new RetrieveJobDetailsService();
        Response response = retrieveJobDetailsService.retrieveJobDetails(jobId);

        assertThat(response.statusCode(), is(200));
        assertThat(response.getHeader("Content-Type"), is("application/json"));

        //Schema Validation
        retrieveJobDetailsService.validateRetrieveJobDetailsResponseSchema(response);

        assertThat(response.jsonPath().get("data.id").toString(), is(jobId));
        Assert.assertNull(response.jsonPath().get("error"));

    }

    @Test(enabled = true, dependsOnMethods = "testWorkflowCreation", priority = 5)
    public void testDeleteWorkflow(){
        DeleteWorkflowService deleteWorkflowService = new DeleteWorkflowService();
        Response response = deleteWorkflowService.deleteWorkflow(workflowId);

        assertThat(response.getStatusCode(), is(204));

        logData("Workflow ID "+workflowId+" successfully deleted");
    }

}
