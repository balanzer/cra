/**
 *
 */
package com.ihg.it.pfm.api.cra;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ihg.it.pfm.cra.CampaignRequest;
import com.ihg.it.pfm.services.CampaignRequestProcess;

/**
 * @author VarathM
 *
 */
@RestController
@CrossOrigin(origins = "*") // to be removed for server deployments
@RequestMapping(value = "/crasample", name = "CRASampleController", produces = MediaType.APPLICATION_JSON_VALUE)
public class CRASampleController {

    private static final Logger LOG = LoggerFactory.getLogger(CRASampleController.class);
    @Autowired
    private CampaignRequestProcess campaignService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CampaignRequest>> getAll() {
        LOG.debug("Get all campaign records");

        final List<CampaignRequest> results = this.campaignService.getAll();

        if (results.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(results, HttpStatus.OK);
    }
}
