import enums.Strength;
import org.testng.annotations.Test;
import pojo.requests.CreateRunningJobsPojo;
import pojo.requests.CreateWorkflowPojo;
import pojo.requests.TasksPojo;
import pojo.requests.jobs.NasaModisJob;
import pojo.requests.jobs.SharpeningJob;
import services.AddingWorkflowTasksService;
import services.CreateWorkflowService;
import services.CreatingRunningJobs;

public class TestOne {

    @Test
    public void testFetchAccessToken(){

        CreateWorkflowPojo createWorkflowPojo = new CreateWorkflowPojo();
        createWorkflowPojo.setName("Rahul Workflow");
        createWorkflowPojo.setDescription("QA Rahul description");
        CreateWorkflowService createWorkflowService = new CreateWorkflowService();
        String workFlowId = createWorkflowService.getWorkflowId(createWorkflowPojo);

        AddingWorkflowTasksService addingWorkflowTasksService = new AddingWorkflowTasksService();
        TasksPojo[] tasks = createDefaultTask();

        addingWorkflowTasksService.addWorkflowTasksWithDefaultData(workFlowId,tasks);

    }

    private TasksPojo[] createDefaultTask() {
        TasksPojo task1 = new TasksPojo();
        task1.setName("nasa-modis:1");
        task1.setParentName(null);
        task1.setBlockId("ef6faaf5-8182-4986-bce4-4f811d2745e5");

        TasksPojo task2 = new TasksPojo();
        task2.setName("sharpening:1");
        task2.setParentName("nasa-modis:1");
        task2.setBlockId("e374ea64-dc3b-4500-bb4b-974260fb203e");

        TasksPojo tasks[] = new TasksPojo[]{task1,task2};
        return tasks;
    }

    @Test
    public void testWorkflowCreation(){

    }

    @Test
    public void testAddingWorkflowTasks(){

    }

    @Test
    public void testRunningJobsCreation(){
        CreateRunningJobsPojo createRunningJobsPojo = new CreateRunningJobsPojo();

        CreatingRunningJobs creatingRunningJobs = new CreatingRunningJobs();

        NasaModisJob nasaModisJob = CreatingRunningJobs.createNasaModisJobWithDefaultData();

        SharpeningJob sharpeningJob = new SharpeningJob();
        sharpeningJob.setStrength(Strength.medium);
        createRunningJobsPojo.setSharpening(sharpeningJob);
        createRunningJobsPojo.setNasamodis(nasaModisJob);
        creatingRunningJobs.createJobsWithDefaultData(createRunningJobsPojo);


    }

    @Test
    public void testRetrieveJobDetails(){

    }

    @Test
    public void testDeleteWorkflow(){

    }

}
