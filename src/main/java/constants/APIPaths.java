package constants;


public class APIPaths {

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


    public static String getAddingWorkflowTasksPath(String workFlowId) {
        return String.format(addingWorkflowTasksURI,FrameworkConstants.getProjectID(),workFlowId);
    }

    public static String getCreateRunningJobsPath() {
        return createRunningJobsURI;
    }


    public static String getRetrieveJobDetailsURI() {
        return retrieveJobDetailsURI;
    }


    public static String getDeleteWorkflowURI() {
        return deleteWorkflowURI;
    }

}
