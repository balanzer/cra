/**
 *
 */
package com.ihg.it.pfm.api.cra.it;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ihg.it.pfm.api.BaseIntegration;
import com.jayway.restassured.response.Response;

/**
 * @author VarathM
 *
 */
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class DeleteCampaignRequestIT extends BaseIntegration {

    /**
     * Validate Delete flow. Create a record and delete and assert delete response status code
     *
     *
     * @throws IOException
     */
    @Test
    public void testDelete() throws IOException {
        String newRequest = IOUtils.toString(Thread.currentThread().getContextClassLoader().getResourceAsStream("campaign-request-post-and-delete.json"));
        LOG.info("posting camapign json {} ", newRequest);
        Response response = given().contentType("application/json").header("SM_USER", "e2etesting").body(newRequest).when().post(POST_ONE);
        // Status should be 201 for created
        response.then().assertThat().statusCode(201);

        String newRequestLocation = response.header("Location");
        LOG.info("New Record location {} ", newRequestLocation);
        // Expect Value like http://localhost:8081/cra/5 - use this to delete created record.
        assertNotNull(newRequestLocation);

        String[] vals = newRequestLocation.split("/");
        Integer deleteId = Integer.parseInt(vals[vals.length - 1]);
        LOG.info("deleteId {} ", deleteId);

        given().pathParam("ID", deleteId).header("SM_USER", "e2etesting").when().delete(DELETE_ONE + "{ID}").then().assertThat().statusCode(204);
    }
}
