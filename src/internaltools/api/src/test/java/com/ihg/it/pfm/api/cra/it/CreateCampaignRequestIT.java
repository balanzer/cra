/**
 *
 */
package com.ihg.it.pfm.api.cra.it;

import static org.hamcrest.CoreMatchers.equalTo;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ihg.it.pfm.api.BaseIntegration;
import com.jayway.restassured.response.Response;

/**
 * Create - POST Response validation.
 *
 * @author varathm
 *
 */
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class CreateCampaignRequestIT extends BaseIntegration {

    /**
     * @param response
     * @param requestJsonMap
     */
    private void assertCampaignRequest(Response response, Map requestJsonMap) {
        this.validateResponse(response, CPN_NAME, String.valueOf(requestJsonMap.get(CPN_NAME)));
        this.validateResponse(response, CPN_DESC, String.valueOf(requestJsonMap.get(CPN_DESC)));
        this.validateResponse(response, CPN_ST_DATE, String.valueOf(requestJsonMap.get(CPN_ST_DATE)));
        this.validateResponse(response, CPN_ED_DATE, String.valueOf(requestJsonMap.get(CPN_ED_DATE)));
        this.validateResponse(response, CPN_EST_REV, String.valueOf(requestJsonMap.get(CPN_EST_REV)));
        this.validateResponse(response, CPN_UP_REQ, String.valueOf(requestJsonMap.get(CPN_UP_REQ)));
        this.validateResponse(response, CPN_REG_DIR, String.valueOf(requestJsonMap.get(CPN_REG_DIR)));
        this.validateResponse(response, CPN_SP_INS, String.valueOf(requestJsonMap.get(CPN_SP_INS)));
        this.validateResponse(response, CPN_VNDR_EXTS, String.valueOf(requestJsonMap.get(CPN_VNDR_EXTS)));

        /*
         * Validate Audit Details
         *
         * Since its create, Createby and Created date should be not null and valid. But Updated by and Updated Date should be null
         */

        this.validateResponse(response, AUD_CBY, "e2etesting");
        this.validateResponse(response, AUD_UBY, null);

        /*
         * validate requester information
         *
         */
        Map requester = (Map) requestJsonMap.get(REQ);
        this.validateResponse(response, RES_RQ_FNAME, String.valueOf(requester.get(RQ_FNAME)));
        this.validateResponse(response, RES_RQ_LNAME, String.valueOf(requester.get(RQ_LNAME)));
        this.validateResponse(response, RES_RQ_EMAIL, String.valueOf(requester.get(RQ_EMAIL)));
        this.validateResponse(response, RES_RQ_PHNNUMBER, String.valueOf(requester.get(RQ_PHNNUMBER)));

    }

    @SuppressWarnings("unchecked")
    @Test
    public void testCreate() throws IOException {
        String requestJson = IOUtils.toString(Thread.currentThread().getContextClassLoader().getResourceAsStream("campaign-request-create.json"));
        LOG.info("create new record {} ", requestJson);

        Map requestJsonMap = this.covertToMap(requestJson);

        Integer getID = this.createCampaign(requestJson);
        // Get Response and Validate with requestJsonMap;
        Response response = this.getCampaignRequest(getID);

        this.assertCampaignRequest(response, requestJsonMap);

        // Delete After testing
        this.deleteAfterTesting(getID);
    }

    /**
     * @param response
     * @param cpnName
     * @return
     */
    private void validateResponse(Response response, String key, String expectedValue) {

        response.then().assertThat().body(key, equalTo(expectedValue));

    }

}
