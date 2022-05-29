package constants;


import utils.PropertyReaderUtil;

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

    public static String getFetchAccessTokenURI() {
        return String.format(fetchAccessTokenURI, FrameworkConstants.getProjectID(),FrameworkConstants.getProjectAPIKey());
    }

    public static String getCreateWorkflowURI() {
        return createWorkflowURI;
    }


    public static String getAddingWorkflowTasksURI() {
        return addingWorkflowTasksURI;
    }

    public static String getCreateRunningJobsURI() {
        return createRunningJobsURI;
    }


    public static String getRetrieveJobDetailsURI() {
        return retrieveJobDetailsURI;
    }


    public static String getDeleteWorkflowURI() {
        return deleteWorkflowURI;
    }

}
