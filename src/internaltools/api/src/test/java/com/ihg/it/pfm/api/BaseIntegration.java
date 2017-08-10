/**
 *
 */
package com.ihg.it.pfm.api;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;

import java.util.Map;

import org.junit.BeforeClass;

import com.google.gson.Gson;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

/**
 * @author VarathM
 *
 */
public class BaseIntegration extends BaseDetails {

    @BeforeClass
    public static void setup() {
        String port = System.getProperty("server.port");
        if (port == null) {
            RestAssured.port = Integer.valueOf(8081);
        } else {
            RestAssured.port = Integer.valueOf(port);
        }

        String basePath = System.getProperty("server.base");
        if (basePath == null) {
            // May be we have to add /api if its for QAP or pass /api in server.base
            basePath = "";
        }
        RestAssured.basePath = basePath;

        String baseHost = System.getProperty("server.host");
        if (baseHost == null) {
            baseHost = "http://localhost";
        }
        RestAssured.baseURI = baseHost;

        LOG.info("Service URL : " + RestAssured.baseURI + " - port : " + RestAssured.port);

    }

    protected Map covertToMap(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Map.class);
    }

    /**
     * @param requestJson
     * @return
     */
    protected Integer createCampaign(String requestJson) {

        // Status should be 201 for created
        Response response = given().contentType("application/json").header("SM_USER", "e2etesting").body(requestJson).when().post(POST_ONE);
        response.then().assertThat().statusCode(201);

        String newRequestLocation = response.header("Location");
        // LOG.info("New Record location {} ", newRequestLocation);

        String[] vals = newRequestLocation.split("/");
        Integer getID = Integer.parseInt(vals[vals.length - 1]);
        return getID;
    }

    /**
     * @param getID
     */
    protected void deleteAfterTesting(Integer id) {
        given().pathParam("ID", id).header("SM_USER", "e2etesting").when().delete(DELETE_ONE + "{ID}").then().assertThat().statusCode(204);

    }

    /**
     * Get Campaign Request
     *
     * @return
     */

    public Response getCampaignRequest(Integer id) {
        Response response = this.openService().get("/cra/" + id);

        response.then().assertThat().body(ID, notNullValue()).statusCode(200);

        return response;
    }

    /**
     * @return
     */
    protected RequestSpecification openService() {
        return given().header("SM_USER", "e2etesting").when();
    }
}
