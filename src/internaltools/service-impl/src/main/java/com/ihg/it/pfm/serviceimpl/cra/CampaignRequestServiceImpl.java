/**
 *
 */
package com.ihg.it.pfm.serviceimpl.cra;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihg.it.pfm.cra.CampaignRequest;
import com.ihg.it.pfm.dao.CampaignRequestDAO;
import com.ihg.it.pfm.dao.entity.Campaign;
import com.ihg.it.pfm.serviceimpl.cra.utils.CampaignConvertFromDB;
import com.ihg.it.pfm.serviceimpl.cra.utils.CampaignConvertToDB;
import com.ihg.it.pfm.serviceimpl.cra.utils.CampaignCopy;
import com.ihg.it.pfm.services.CampaignRequestProcess;
import com.ihg.it.pfm.services.error.ServiceException;

/**
 * @author varathm
 *
 */
@Service
public class CampaignRequestServiceImpl implements CampaignRequestProcess {

    private static final Logger LOG = LoggerFactory.getLogger(CampaignRequestServiceImpl.class);

    @Autowired
    CampaignRequestDAO dao;

    /*
     * (non-Javadoc)
     *
     * @see com.ihg.it.pfm.services.CampaignRequestProcess#create(com.ihg.it.pfm.cra.CampaignRequest)
     */
    @Override
    public Long create(CampaignRequest campaignRequest, String user) {

        boolean notExists = this.dao.isCampaignNameExists(campaignRequest.getName().toLowerCase());
        if (notExists) {
            campaignRequest.setCreatedBy(user.toLowerCase());
            campaignRequest.setUpdatedBy(user.toLowerCase());
            try {
                Campaign campaign = CampaignConvertToDB.convertForCreate(campaignRequest);

                // Set Requester for Update
                campaign.setRequester(this.dao.getRequester(campaignRequest.getRequester().getFirstName(), campaignRequest.getRequester().getLastName(),
                        campaignRequest.getRequester().getEmail(), campaignRequest.getRequester().getPhoneNumber(), user));

                return this.dao.createCampaignRequest(campaign);
            } catch (ParseException exp) {
                throw new ServiceException("Unable to create. Failed to parse start or end date.");
            }
        }

        throw new ServiceException("Unable to create. Campaign with name " + campaignRequest.getName() + " already exists.");
    }

    /*
     * (non-Javadoc)
     *
     * @see com.ihg.it.pfm.services.CampaignRequestProcess#delete(java.lang.Long)
     */
    @Override
    public void delete(Long id) throws ServiceException {

        // Get Details
        // Check record existence
        // Delete record
        Campaign campaign = this.dao.getCampaignRequest(id);

        if (null != campaign && campaign.getCampaignId() != 0l) {
            this.dao.deleteCampaignRequest(id);
            return;
        }

        throw new ServiceException("Unable to delete. Campaign with id " + id + " not found");
    }

    /*
     * (non-Javadoc)
     *
     * @see com.ihg.it.pfm.services.CampaignRequestProcess#get(java.lang.Long)
     */
    @Override
    public CampaignRequest get(Long id) throws ServiceException {

        Campaign campaign = this.dao.getCampaignRequest(id);

        return CampaignConvertFromDB.convert(campaign);
    }

    /**
     * @param campaign
     * @return
     */

    @Override
    public List<CampaignRequest> getAll() throws ServiceException {
        LOG.debug("getAll - Get all campaign records");

        List<Campaign> dbCampaignDetails = this.dao.getAllCampaignRequests();

        final List<CampaignRequest> campaignRequests = new ArrayList<>();

        if (CollectionUtils.isNotEmpty(dbCampaignDetails)) {

            dbCampaignDetails.forEach(campaign -> {
                campaignRequests.add(CampaignConvertFromDB.convert(campaign));
            });

            return campaignRequests;
        }

        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.ihg.it.pfm.services.CampaignRequestProcess#update(com.ihg.it.pfm.cra.CampaignRequest)
     */
    @Override
    public Long update(CampaignRequest campaignRequest, String user) {
        CampaignRequest dbRecordforUpdate = this.get(campaignRequest.getId());

        try {
            CampaignCopy.copy(dbRecordforUpdate, campaignRequest, user);
            Campaign campaign = CampaignConvertToDB.convertForUpdate(dbRecordforUpdate);

            // Set Requester for Update
            campaign.setRequester(this.dao.getRequester(campaignRequest.getRequester().getFirstName(), campaignRequest.getRequester().getLastName(),
                    campaignRequest.getRequester().getEmail(), campaignRequest.getRequester().getPhoneNumber(), user));

            return this.dao.updateCampaignRequest(campaign);
        } catch (ParseException exp) {
            throw new ServiceException("Unable to create. Failed to parse start or end date.");
        }

    }

}
