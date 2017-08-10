/**
 *
 */
package com.ihg.it.pfm.api.cra.it;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ihg.it.pfm.api.BaseIntegration;

/**
 * @author VarathM
 *
 */
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class CRABasicPingIT extends BaseIntegration {

    /**
     * Tests basic get to see service available or not. Application GIT without ID should respond all records - Should Respond with status code 200
     */
    @Test
    public void basicPingTest200() {
        this.openService().get(GET_ALL).then().assertThat().statusCode(200);
    }

    /**
     * Tests basic get to see service return 400 bad request for invalid service path. Application GIT with ID does not exists should respond 400 bad request - Should Respond with
     * status code 400
     */

    @Test
    public void basicPingTest400() {
        this.openService().get(GET_ONE + "123").then().assertThat().statusCode(400);
    }

    /**
     * Tests basic get to see service available or not. for 1 record. Application GIT with valid ID should respond one records - Should Respond with status code 200
     */

    @Test
    public void basicPingTestGetOne200() {
        this.openService().get(GET_ONE + "1").then().assertThat().statusCode(200);
    }

}
