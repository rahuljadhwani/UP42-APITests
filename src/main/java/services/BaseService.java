package services;

import constants.APIPaths;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

/**
 * This class contains methods used for building Request and Response Specification.
 * They contain functionalities common to multiple APIs.
 *
 * @author Rahul Jadhwani [30/05/2022]
 */

public class BaseService {
    public static RequestSpecification getRequestSpec(String basePath){
        return new RequestSpecBuilder().
                setBaseUri(APIPaths.getBaseURI()).
                setBasePath(basePath).
                setContentType(ContentType.JSON).
                build();
    }

    public static RequestSpecification getTokenRequestSpec(){
        return new RequestSpecBuilder().
                setBaseUri(APIPaths.getFetchAccessTokenPath())
                .setBasePath("/oauth/token")
                .setContentType(ContentType.URLENC).
                log(LogDetail.ALL).
                build();
    }

    public static ResponseSpecification getResponseSpec(){
        return new ResponseSpecBuilder().
                log(LogDetail.ALL).
                build();
    }
}
