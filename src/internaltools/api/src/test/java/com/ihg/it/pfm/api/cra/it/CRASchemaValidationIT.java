/**
 *
 */
package com.ihg.it.pfm.api.cra.it;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ihg.it.pfm.api.BaseIntegration;

import io.restassured.module.jsv.JsonSchemaValidator;

/**
 * @author VarathM
 *
 */
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class CRASchemaValidationIT extends BaseIntegration {

    /**
     *
     * Validate CRA Response schema
     *
     * @throws IOException
     */
    @Test
    public void responseSchemaValidate() throws IOException {
        String schema = IOUtils.toString(Thread.currentThread().getContextClassLoader().getResourceAsStream("campaign-schema.json"));
        this.openService().get(GET_ONE + "1").then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(schema));

    }

}
