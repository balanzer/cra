/**
 *
 */
package com.ihg.it.pfm.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ihg.it.pfm.dao.entity.Audit;
import com.ihg.it.pfm.dao.entity.Campaign;
import com.ihg.it.pfm.dao.entity.Requester;
import com.ihg.it.pfm.dao.repo.CampaignRepository;
import com.ihg.it.pfm.dao.repo.RequesterRepository;

/**
 * @author varathm
 *
 */
@Repository
public class CampaignRequestDAO {

    private static final Logger LOG = LoggerFactory.getLogger(CampaignRequestDAO.class);

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    RequesterRepository requesterRepository;

    /**
     * @param campaign
     * @return
     */
    public Long createCampaignRequest(Campaign campaign) {
        return this.campaignRepository.saveAndFlush(campaign).getCampaignId();
    }

    public void deleteCampaignRequest(Long id) {
        this.campaignRepository.delete(id);
    }

    public List<Campaign> getAllCampaignRequests() {
        return this.campaignRepository.findAll();
    }

    public Campaign getCampaignRequest(Long id) {
        return this.campaignRepository.getOne(id);
    }

    public Requester getRequester(String firstName, String lastName, String email, String phoneNumber, String auditUserName) {
        Requester dbRecord = this.requesterRepository.findByEmailIgnoreCaseAndFirstNameIgnoreCaseAndLastNameIgnoreCaseAndPhoneNumberIgnoreCase(email, firstName, lastName,
                phoneNumber);
        if (null == dbRecord) {
            Requester requester = new Requester();
            Date createdDate = Calendar.getInstance().getTime();
            Audit audit = new Audit(auditUserName, createdDate, null, null);
            requester.setAudit(audit);

            requester.setEmail(email);
            requester.setFirstName(firstName);
            requester.setLastName(lastName);
            requester.setPhoneNumber(phoneNumber);

            /*
             * Create and Return requester
             */
            return this.requesterRepository.saveAndFlush(requester);
        }
        return dbRecord;
    }

    /**
     * @param name
     * @return
     */
    public boolean isCampaignNameExists(String name) {
        return (this.campaignRepository.findByCampaignNameIgnoreCase(name).isEmpty()) ? true : false;
    }

    /**
     * @param campaign
     * @return
     */
    public Long updateCampaignRequest(Campaign campaign) {
        LOG.debug("updateCampaignRequest id {} ", campaign.getCampaignId());
        return this.campaignRepository.saveAndFlush(campaign).getCampaignId();
    }
}
