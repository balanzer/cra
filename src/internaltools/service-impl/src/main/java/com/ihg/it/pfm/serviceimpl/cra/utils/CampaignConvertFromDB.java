/**
 *
 */
package com.ihg.it.pfm.serviceimpl.cra.utils;

import com.ihg.it.pfm.cra.CampaignRequest;
import com.ihg.it.pfm.cra.Requester;
import com.ihg.it.pfm.dao.entity.Campaign;

/**
 * @author varathm
 *
 */
public class CampaignConvertFromDB {

    public static CampaignRequest convert(Campaign campaign) {
        CampaignRequest campaignRequest = new CampaignRequest();

        // Convert Audit Details
        campaignRequest.setCreatedBy(campaign.getAudit().getCreatedBy());
        campaignRequest.setUpdatedBy(campaign.getAudit().getUpdatedBy());
        campaignRequest.setCreatedDate(DateUtils.convertDate(campaign.getAudit().getCreatedDate()));
        campaignRequest.setUpdatedDate(DateUtils.convertDate(campaign.getAudit().getUpdateDate()));

        // Convert Campaign Information
        campaignRequest.setId(campaign.getCampaignId());
        campaignRequest.setName(campaign.getCampaignName());
        campaignRequest.setStauts(campaign.getCampaignStatus());
        campaignRequest.setAdminComments(campaign.getAdminComments());
        campaignRequest.setDirectorComments(campaign.getDirectorComments());
        campaignRequest.setDesc(campaign.getCampaignDesc());
        campaignRequest.setStartDate(DateUtils.convertDate(campaign.getStartDate()));
        campaignRequest.setEndDate(DateUtils.convertDate(campaign.getEndate()));
        campaignRequest.setEstimatedRevenue(campaign.getEstimatedRevenue());
        campaignRequest.setAnyUpdateRequired(campaign.getExistingPixelUpdate());
        campaignRequest.setRegionalDirector(campaign.getRegionalDirector());
        campaignRequest.setSpecialInstructions(campaign.getSpecialInstructions());
        campaignRequest.setVendorExists(campaign.getVendorHasCampaign());

        /*
         * Set Requester Information
         */

        Requester requester = new Requester();
        requester.setEmail(campaign.getRequester().getEmail());
        requester.setFirstName(campaign.getRequester().getFirstName());
        requester.setLastName(campaign.getRequester().getLastName());
        requester.setPhoneNumber(campaign.getRequester().getPhoneNumber());
        campaignRequest.setRequester(requester);

        return campaignRequest;
    }

}
