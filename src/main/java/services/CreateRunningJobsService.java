package services;

import constants.APIPaths;
import enums.Strength;
import io.restassured.response.Response;
import pojo.requests.CreateRunningJobsPojo;
import pojo.requests.jobs.NasaModisJob;
import pojo.requests.jobs.SharpeningJob;
import utils.TokenManager;
import java.util.Arrays;
import static io.restassured.RestAssured.*;

/**
 * This class contains methods related to Creating Jobs API.
 *
 * @author Rahul Jadhwani [30/05/2022]
 */

public class CreateRunningJobsService {

    /**
     * This method will be used to perform POST - create Jobs with default data
     *
     */
    public Response createJobsWithDefaultData(String workflowId){

        CreateRunningJobsPojo createRunningJobsPojo = new CreateRunningJobsPojo();
        NasaModisJob nasaModisJob = createNasaModisJobWithDefaultData();

        SharpeningJob sharpeningJob = new SharpeningJob();
        sharpeningJob.setStrength(Strength.medium);

        createRunningJobsPojo.setNasamodis(nasaModisJob);
        createRunningJobsPojo.setSharpening(sharpeningJob);

        return given(BaseService.getRequestSpec(APIPaths.getCreateRunningJobsPath(workflowId))).auth().oauth2(TokenManager.getToken())
                .body(createRunningJobsPojo).when().post()
                .then().spec(BaseService.getResponseSpec()).extract().response();
    }

    /**
     * This method will be used to perform POST - create Jobs with Custom data sent from Tests
     *
     */
    public Response createJobsWithCustomData(String workflowId, CreateRunningJobsPojo createRunningJobsPojo) {
        return given(BaseService.getRequestSpec(APIPaths.getCreateRunningJobsPath(workflowId))).auth().oauth2(TokenManager.getToken())
                .body(createRunningJobsPojo).when().post()
                .then().spec(BaseService.getResponseSpec()).extract().response();
    }


    /**
     * This method will provide some default data to create Nasa:Modis job
     *
     * TO-DO: with more time, all the data in here can be modified run-time before triggering APIs
     * Such data can be sent via external sources - like Excel sheet, etc.
     *
     */
    public static NasaModisJob createNasaModisJobWithDefaultData(){
        NasaModisJob nasaModisJob = new NasaModisJob();
        nasaModisJob.setTime("2018-12-01T00:00:00+00:00/2020-12-31T23:59:59+00:00");
        nasaModisJob.setBbox(Arrays.asList(13.365373, 52.49582, 13.385796, 52.510455));
        nasaModisJob.setLimit(1);
        nasaModisJob.setImageryLayers(Arrays.asList("MODIS_Terra_CorrectedReflectance_TrueColor"));
        nasaModisJob.setZoomLevel(9);

        return nasaModisJob;
    }

}
