package com.ihg.it.pfm.services;

import java.util.List;

import org.springframework.util.StringUtils;

import com.ihg.it.pfm.cra.CampaignRequest;
import com.ihg.it.pfm.services.error.ServiceException;

public interface CampaignRequestProcess {

    static boolean isValid(CampaignRequest campaignRequest) {

        if (null == campaignRequest) {
            return false;
        }

        if (StringUtils.isEmpty(StringUtils.trimAllWhitespace(campaignRequest.getName()))) {
            return false;
        }

        // Do more required validation here

        // Do all basic validation
        return true;
    }

    /**
     * @param campaignRequest
     * @param string
     * @return
     */
    public Long create(CampaignRequest campaignRequest, String user);

    public void delete(Long id) throws ServiceException;

    public CampaignRequest get(Long id) throws ServiceException;

    public List<CampaignRequest> getAll() throws ServiceException;

    public boolean isNameExists(String name) throws ServiceException;

    /**
     * @param campaignRequest
     */
    public Long update(CampaignRequest campaignRequest, String user);
}
