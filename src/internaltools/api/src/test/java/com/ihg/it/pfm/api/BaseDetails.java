/**
 *
 */
package com.ihg.it.pfm.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ihg.it.pfm.ApiApplication;

/**
 * @author varathm
 *
 */
public class BaseDetails {

    protected static final Logger LOG = LoggerFactory.getLogger(ApiApplication.class);
    /**
     * Method Calls
     */
    protected static final String GET_ALL = "/cra";
    protected static final String GET_ONE = "/cra/";
    protected static final String POST_ONE = "/cra/";
    protected static final String DELETE_ONE = "/cra/";

    protected static final String ID = "id";

    /*
     * CAMPAIGN Details
     */

    protected static final String CPN_NAME = "name";
    protected static final String CPN_DESC = "desc";
    protected static final String CPN_ST_DATE = "startDate";
    protected static final String CPN_ED_DATE = "endDate";
    protected static final String CPN_EST_REV = "estimatedRevenue";
    protected static final String CPN_UP_REQ = "anyUpdateRequired";
    protected static final String CPN_REG_DIR = "regionalDirector";
    protected static final String CPN_SP_INS = "specialInstructions";
    protected static final String CPN_VNDR_EXTS = "vendorExists";

    /*
     * Requester Details
     */
    protected static final String REQ = "requester";
    protected static final String RQ_FNAME = "firstName";
    protected static final String RQ_LNAME = "lastName";
    protected static final String RQ_EMAIL = "email";
    protected static final String RQ_PHNNUMBER = "phoneNumber";

    protected static final String RES_RQ_FNAME = "requester.firstName";
    protected static final String RES_RQ_LNAME = "requester.lastName";
    protected static final String RES_RQ_EMAIL = "requester.email";
    protected static final String RES_RQ_PHNNUMBER = "requester.phoneNumber";

    /*
     * Audit Details
     */

    protected static final String AUD_CBY = "createdBy";
    protected static final String AUD_UBY = "updatedBy";
    protected static final String AUD_CDT = "updatedDate";
    protected static final String AUD_UDT = "createdDate";

}
