/**
 *
 */
package com.ihg.it.pfm.serviceimpl.cra.utils;

import java.text.ParseException;

import com.ihg.it.pfm.cra.CampaignRequest;

/**
 * @author varathm
 *
 */
public class CampaignCopy {

    public static void copy(CampaignRequest origObj, CampaignRequest newObj, String user) throws ParseException {

        // Do not reset Create Date and Created by

        // Update Audit Details
        origObj.setUpdatedBy(user.toLowerCase());
        origObj.setUpdatedDate(DateUtils.convertDate(DateUtils.getCurrentDateTime()));

        // Convert Campaign Information

        // DO not reset ID - Update fails
        origObj.setId(newObj.getId());
        origObj.setName(newObj.getName());
        origObj.setStauts(newObj.getStauts());
        origObj.setAdminComments(newObj.getAdminComments());
        origObj.setDirectorComments(newObj.getDirectorComments());
        origObj.setDesc(newObj.getDesc());
        origObj.setStartDate(newObj.getStartDate());
        origObj.setEndDate(newObj.getEndDate());
        origObj.setEstimatedRevenue(newObj.getEstimatedRevenue());
        origObj.setAnyUpdateRequired(newObj.getAnyUpdateRequired());
        origObj.setRegionalDirector(newObj.getRegionalDirector());
        origObj.setSpecialInstructions(newObj.getSpecialInstructions());
        origObj.setVendorExists(newObj.getVendorExists());

    }
}
