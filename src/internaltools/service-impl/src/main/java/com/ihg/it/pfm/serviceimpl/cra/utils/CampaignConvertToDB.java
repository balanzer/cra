/**
 *
 */
package com.ihg.it.pfm.serviceimpl.cra.utils;

import java.text.ParseException;

import com.ihg.it.pfm.cra.CampaignRequest;
import com.ihg.it.pfm.dao.entity.Audit;
import com.ihg.it.pfm.dao.entity.Campaign;

/**
 * @author varathm
 *
 */
public class CampaignConvertToDB {

    /**
     * @param campaignRequest
     * @param newCampaign
     * @throws ParseException
     */
    private static void convertCommon(CampaignRequest campaignRequest, Campaign newCampaign) throws ParseException {
        newCampaign.setCampaignName(campaignRequest.getName());
        newCampaign.setStartDate(DateUtils.convertDate(campaignRequest.getStartDate()));
        newCampaign.setEndate(DateUtils.convertDate(campaignRequest.getEndDate()));
        newCampaign.setEstimatedRevenue(campaignRequest.getEstimatedRevenue());
        newCampaign.setVendorHasCampaign(campaignRequest.getVendorExists());
        newCampaign.setCampaignDesc(campaignRequest.getDesc());
        newCampaign.setExistingPixelUpdate(campaignRequest.getAnyUpdateRequired());
        newCampaign.setRegionalDirector(campaignRequest.getRegionalDirector());
        newCampaign.setSpecialInstructions(campaignRequest.getSpecialInstructions());
        newCampaign.setCampaignStatus(campaignRequest.getStauts());
        newCampaign.setDirectorComments(campaignRequest.getDirectorComments());
        newCampaign.setAdminComments(campaignRequest.getAdminComments());
    }

    /**
     * @param campaignRequest
     * @return
     * @throws ParseException
     */
    public static Campaign convertForCreate(CampaignRequest campaignRequest) throws ParseException {
        Campaign newCampaign = new Campaign();

        convertCommon(campaignRequest, newCampaign);

        Audit audit = new Audit(campaignRequest.getCreatedBy(), DateUtils.getCurrentDateTime(), null, null);
        newCampaign.setAudit(audit);

        return newCampaign;

    }

    public static Campaign convertForUpdate(CampaignRequest campaignRequest) throws ParseException {
        Campaign newCampaign = new Campaign();

        convertCommon(campaignRequest, newCampaign);

        /*
         * Set ID - this is only for update
         */

        newCampaign.setCampaignId(campaignRequest.getId());

        Audit audit = new Audit(campaignRequest.getCreatedBy(), DateUtils.convertDate(campaignRequest.getCreatedDate()), campaignRequest.getUpdatedBy(),
                DateUtils.getCurrentDateTime());

        newCampaign.setAudit(audit);

        return newCampaign;

    }

}
