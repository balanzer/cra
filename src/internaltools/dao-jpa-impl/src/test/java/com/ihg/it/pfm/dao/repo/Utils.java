/**
 *
 */
package com.ihg.it.pfm.dao.repo;

import java.util.Calendar;
import java.util.Date;

import com.ihg.it.pfm.dao.entity.Audit;
import com.ihg.it.pfm.dao.entity.Campaign;
import com.ihg.it.pfm.dao.entity.Requester;

/**
 * @author VarathM
 *
 */
public class Utils {

    /**
     * @return
     */
    public static Campaign getCampaignSample() {

        Calendar startDateCal = Calendar.getInstance();
        startDateCal.add(Calendar.DAY_OF_YEAR, 1);
        Calendar endDateCal = Calendar.getInstance();
        endDateCal.add(Calendar.YEAR, 1);
        Calendar today = Calendar.getInstance();

        // Set Campaign name
        String campaignName = "Facebook Global";

        // Start and End Date
        Date startDate = startDateCal.getTime();
        Date endate = endDateCal.getTime();

        // Other Campaign related parameters
        String estimatedRevenue = "$1,400,000";
        String vendorHasCampaign = "N";
        String campaignDesc = "This campaign captures all navigational information about user shopping experience";

        String existingPixelUpdate = "N";
        String regionalDirector = "muralitharan.varatharajan@ihg.com";
        String specialInstructions = "Send all date in format in yyyy=MM-dd";
        String campaignStatus = "Active";
        String directorComments = "Director Approved this request";
        String adminComments = "Admin approved this request";

        Audit audit = new Audit("varathm", today.getTime(), "varathm", today.getTime());

        Campaign campagign = new Campaign();

        campagign.setCampaignName(campaignName);
        campagign.setStartDate(startDate);
        campagign.setEndate(endate);
        campagign.setEstimatedRevenue(estimatedRevenue);
        campagign.setVendorHasCampaign(vendorHasCampaign);
        campagign.setCampaignDesc(campaignDesc);
        campagign.setExistingPixelUpdate(existingPixelUpdate);
        campagign.setRegionalDirector(regionalDirector);
        campagign.setSpecialInstructions(specialInstructions);
        campagign.setCampaignStatus(campaignStatus);
        campagign.setDirectorComments(directorComments);
        campagign.setAdminComments(adminComments);

        campagign.setAudit(audit);

        return campagign;
    }

    /**
     * @return
     */
    public static Requester getRequesterSample() {
        Calendar today = Calendar.getInstance();
        Requester requester = new Requester();
        Audit audit = new Audit("varathm", today.getTime(), "varathm", today.getTime());

        requester.setAudit(audit);
        requester.setEmail("m.v@ihg.com");
        requester.setFirstName("murali");
        requester.setLastName("varath");
        requester.setPhoneNumber("123-456-7890");

        return requester;
    }
}
