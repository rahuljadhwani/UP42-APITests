

import constants.FrameworkConstants;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import services.AddingWorkflowTasksService;
import services.CreateWorkflowService;
import services.RetrieveJobDetailsService;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

/**
 * This class contains negative tests and can be scaled up with time to ensure correct implementations.
 *
 * @author Rahul Jadhwani [30/05/2022]
 */

public class TestTwo {

    @Test
    public void testWorkflowCreationWithInvalidProjectID(){
        CreateWorkflowService createWorkflowService = new CreateWorkflowService();
        Response response = createWorkflowService.createWorkflowWithCustomData(FrameworkConstants.getPropertyMap().get("InvalidProjectID"));
        assertThat(response.getStatusCode(), is(403));
    }

    @Test
    public void testAddingWorkflowTasksWithInvalidWorkflowID(){
        AddingWorkflowTasksService addingWorkflowTasksService = new AddingWorkflowTasksService();
        Response response = addingWorkflowTasksService.addWorkflowTasksWithDefaultData(FrameworkConstants.getPropertyMap().get("InvalidWorkflowID"));
        assertThat(response.getStatusCode(), is(400));
    }

    @Test
        public void testRetrieveInvalidJobDetails(){
        RetrieveJobDetailsService retrieveJobDetailsService = new RetrieveJobDetailsService();
        Response response = retrieveJobDetailsService.retrieveJobDetails(FrameworkConstants.getPropertyMap().get("InvalidJobID"));
        assertThat(response.getStatusCode(), is(400));
    }


}
