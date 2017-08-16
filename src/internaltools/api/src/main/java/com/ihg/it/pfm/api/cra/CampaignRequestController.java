/**
 *
 */
package com.ihg.it.pfm.api.cra;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ihg.it.pfm.cra.CampaignRequest;
import com.ihg.it.pfm.services.CampaignRequestProcess;

@RestController
@RequestMapping(value = "/cra", name = "CampaignProcesController", produces = MediaType.APPLICATION_JSON_VALUE)
public class CampaignRequestController {

    private static final Logger LOG = LoggerFactory.getLogger(CampaignRequestController.class);

    @Autowired
    private CampaignRequestProcess campaignService;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestHeader(value = "SM_USER") String user, @RequestBody CampaignRequest campaignRequest, UriComponentsBuilder ucBuilder) {
        LOG.debug("Create campaign");
        if (CampaignRequestProcess.isValid(campaignRequest)) {
            Long id = this.campaignService.create(campaignRequest, user);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(ucBuilder.path("/cra/{id}").buildAndExpand(id).toUri());
            return new ResponseEntity<>(headers, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CampaignRequest> delete(@RequestHeader(value = "SM_USER") String user, @PathVariable("id") long id) {
        LOG.debug("Delete campaign {}", id);

        this.campaignService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CampaignRequest> get(@RequestHeader(value = "SM_USER") String user, @PathVariable("id") long id) {
        LOG.debug("Get campaign by id {}", id);

        CampaignRequest campaignRequest = this.campaignService.get(id);

        if (null == campaignRequest) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(campaignRequest, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CampaignRequest>> getAll(@RequestHeader(value = "SM_USER") String user) {
        LOG.debug("Get all campaign records");

        final List<CampaignRequest> results = this.campaignService.getAll();

        if (results.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    @RequestMapping(value = "/contains/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> isCampaignExists(@RequestHeader(value = "SM_USER") String user, @PathVariable("name") String name) {
        LOG.debug("Get campaign by name {}", name);
        return new ResponseEntity<>(this.campaignService.isNameExists(name), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CampaignRequest> update(@RequestHeader(value = "SM_USER") String user, @PathVariable("id") long id, @RequestBody CampaignRequest campaignRequest,
            UriComponentsBuilder ucBuilder) {
        LOG.debug("Update campaign {}", id);
        if (CampaignRequestProcess.isValid(campaignRequest)) {
            id = this.campaignService.update(campaignRequest, user);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(ucBuilder.path("/cra/{id}").buildAndExpand(id).toUri());
            return new ResponseEntity<>(headers, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
