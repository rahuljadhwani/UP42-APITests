package services;

import constants.APIPaths;
import enums.Strength;
import io.restassured.http.ContentType;
import pojo.requests.CreateRunningJobsPojo;
import pojo.requests.jobs.NasaModisJob;
import pojo.requests.jobs.SharpeningJob;
import utils.TokenManager;

import java.util.Arrays;

import static io.restassured.RestAssured.*;

public class CreatingRunningJobs {

    public void createJobsWithDefaultData(){

        CreateRunningJobsPojo createRunningJobsPojo = new CreateRunningJobsPojo();
        NasaModisJob nasaModisJob = createNasaModisJobWithDefaultData();
        //nasaModisJob.setZoom_level(10);

        SharpeningJob sharpeningJob = new SharpeningJob();
        sharpeningJob.setStrength(Strength.medium);


        createRunningJobsPojo.setNasamodis(nasaModisJob);
        createRunningJobsPojo.setSharpening(sharpeningJob);


        given().auth().oauth2(TokenManager.getToken())
                .contentType(ContentType.JSON).body(createRunningJobsPojo).when().post(new APIPaths().getCreateRunningJobsURI())
                .getBody().prettyPrint();
    }

    private NasaModisJob createNasaModisJobWithDefaultData(){
        NasaModisJob nasaModisJob = new NasaModisJob();
        nasaModisJob.setTime("2018-12-01T00:00:00+00:00/2020-12-31T23:59:59+00:00");
        nasaModisJob.setBbox(Arrays.asList(13.365373, 52.49582, 13.385796, 52.510455));
        nasaModisJob.setLimit(1);
        nasaModisJob.setImageryLayers(Arrays.asList("MODIS_Terra_CorrectedReflectance_TrueColor"));
        nasaModisJob.setZoomLevel(9);

        return nasaModisJob;
    }

}
