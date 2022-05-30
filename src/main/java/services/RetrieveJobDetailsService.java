package services;

import constants.APIPaths;
import io.restassured.response.Response;
import utils.TokenManager;
import static io.restassured.RestAssured.given;

/**
 * This class contains methods related to Retrieve Job Details API.
 *
 * @author Rahul Jadhwani [30/05/2022]
 */

public class RetrieveJobDetailsService {

    /**
     * This method will be used to perform GET - Job Details.
     *
     */
    public Response retrieveJobDetails(String jobId){

        return given(BaseService.getRequestSpec(APIPaths.getRetrieveJobDetailsURI(jobId))).auth().oauth2(TokenManager.getToken())
                .when().get().then().spec(BaseService.getResponseSpec()).extract().response();
    }
}
