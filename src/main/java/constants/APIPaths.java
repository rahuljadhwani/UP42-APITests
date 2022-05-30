package constants;

/**
 * This class contains Base URI and endpoints to all APIs.
 * Fields like workflowId and jobId are appended to these paths at run-time
 *
 * @author Rahul Jadhwani [30/05/2022]
 */

public final class APIPaths {

    /**
     * Constructor is made private to prevent object-creation of this class, as this class contains all static methods.
     */
    private APIPaths(){

    }

    private static String baseURI = "https://api.up42.com";
    private static String fetchAccessTokenURI = "https://%s:%s@api.up42.com";
    private static String createWorkflowURI = "/projects/%s/workflows/";
    private static String addingWorkflowTasksURI = "/projects/%s/workflows/%s/tasks/";
    private static String createRunningJobsURI = "/projects/%s/workflows/%s/jobs";
    private static String retrieveJobDetailsURI = "/projects/%s/jobs/%s";
    private static String deleteWorkflowURI = "/projects/%s/workflows/%s";


    public static String getBaseURI() {
        return baseURI;
    }

    public static String getFetchAccessTokenPath() {
        return String.format(fetchAccessTokenURI, FrameworkConstants.getProjectID(),FrameworkConstants.getProjectAPIKey());
    }

    public static String getCreateWorkflowPath() {
        return String.format(createWorkflowURI,FrameworkConstants.getProjectID());
    }

    public static String getCreateWorkflowPath(String projectId) {
        return String.format(createWorkflowURI,projectId);
    }

    public static String getAddingWorkflowTasksPath(String workflowId) {
        return String.format(addingWorkflowTasksURI,FrameworkConstants.getProjectID(),workflowId);
    }

    public static String getCreateRunningJobsPath(String workflowId) {
        return String.format(createRunningJobsURI,FrameworkConstants.getProjectID(), workflowId);
    }


    public static String getRetrieveJobDetailsURI(String jobId) {
        return String.format(retrieveJobDetailsURI, FrameworkConstants.getProjectID(), jobId);
    }


    public static String getDeleteWorkflowURI(String workflowId) {
        return String.format(deleteWorkflowURI,FrameworkConstants.getProjectID(),workflowId);
    }

}
