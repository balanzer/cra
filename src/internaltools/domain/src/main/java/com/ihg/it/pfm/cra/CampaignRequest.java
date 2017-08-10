package com.ihg.it.pfm.cra;

public class CampaignRequest extends Campaign {

    private Requester requester;

    /**
     * @return the requester
     */
    public Requester getRequester() {
        return this.requester;
    }

    /**
     * @param requester
     *            the requester to set
     */
    public void setRequester(Requester requester) {
        this.requester = requester;
    }
}
