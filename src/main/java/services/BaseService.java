package services;

import constants.APIPaths;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Reporter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * This class contains methods used for building Request and Response Specification.
 * They contain functionalities common to multiple APIs.
 *
 * @author Rahul Jadhwani [30/05/2022]
 */

class BaseService {
    public static RequestSpecification getRequestSpec(String basePath) {
        return new RequestSpecBuilder().
                setBaseUri(APIPaths.getBaseURI()).
                setBasePath(basePath).
                setContentType(ContentType.JSON).
                build();
    }

    public static RequestSpecification getTokenRequestSpec() {
        return new RequestSpecBuilder().
                setBaseUri(APIPaths.getFetchAccessTokenPath())
                .setBasePath("/oauth/token")
                .setContentType(ContentType.URLENC).
                build();
    }

    public static ResponseSpecification getResponseSpec() {
        return new ResponseSpecBuilder().
                log(LogDetail.ALL).
                build();
    }

    public static void schemaValidation(String filename, Response response) {
        try {
            response.then().body(JsonSchemaValidator.matchesJsonSchema(new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/JsonSchemas/" + filename + ".json")));
        } catch (FileNotFoundException f) {
            f.printStackTrace();
            Reporter.log("Schema for " + filename + " could not be validated");
        }
    }
}
