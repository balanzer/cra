/**
 *
 */
package com.ihg.it.pfm.dao.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author varathm
 *
 */
@Entity
@Table(name = "CAMPAIGN")
public class Campaign {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long campaignId;

    @Column(name = "name")
    private String campaignName;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endate;

    @Column(name = "estimated_revenue")
    private String estimatedRevenue;

    @Column(name = "vendor_has_campaign")
    private String vendorHasCampaign;

    @Column(name = "desc")
    private String campaignDesc;

    @Column(name = "existing_pixel_requires_update")
    private String existingPixelUpdate;

    @Column(name = "regional_director")
    private String regionalDirector;

    @Column(name = "special_instructions")
    private String specialInstructions;

    @Column(name = "status")
    private String campaignStatus;

    @Column(name = "director_comments")
    private String directorComments;

    @Column(name = "admin_comments")
    private String adminComments;

    @Embedded
    private Audit audit;

    @ManyToOne
    private Requester requester;

    public Campaign() {

    }

    /**
     * @return the adminComments
     */
    public String getAdminComments() {
        return this.adminComments;
    }

    /**
     * @return the audit
     */
    public Audit getAudit() {
        return this.audit;
    }

    /**
     * @return the campaignDesc
     */
    public String getCampaignDesc() {
        return this.campaignDesc;
    }

    /**
     * @return the campaignId
     */
    public Long getCampaignId() {
        return this.campaignId;
    }

    /**
     * @return the campaignName
     */
    public String getCampaignName() {
        return this.campaignName;
    }

    /**
     * @return the campaign_Status
     */
    public String getCampaignStatus() {
        return this.campaignStatus;
    }

    /**
     * @return the directorComments
     */
    public String getDirectorComments() {
        return this.directorComments;
    }

    /**
     * @return the endate
     */
    public Date getEndate() {
        return this.endate;
    }

    /**
     * @return the estimatedRevenue
     */
    public String getEstimatedRevenue() {
        return this.estimatedRevenue;
    }

    /**
     * @return the existingPixelUpdate
     */
    public String getExistingPixelUpdate() {
        return this.existingPixelUpdate;
    }

    /**
     * @return the regionalDirector
     */
    public String getRegionalDirector() {
        return this.regionalDirector;
    }

    /**
     * @return the requester
     */
    public Requester getRequester() {
        return this.requester;
    }

    /**
     * @return the specialInstructions
     */
    public String getSpecialInstructions() {
        return this.specialInstructions;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return this.startDate;
    }

    /**
     * @return the vendorHasCampaign
     */
    public String getVendorHasCampaign() {
        return this.vendorHasCampaign;
    }

    /**
     * @param adminComments
     *            the adminComments to set
     */
    public void setAdminComments(String adminComments) {
        this.adminComments = adminComments;
    }

    /**
     * @param audit
     *            the audit to set
     */
    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    /**
     * @param campaignDesc
     *            the campaignDesc to set
     */
    public void setCampaignDesc(String campaignDesc) {
        this.campaignDesc = campaignDesc;
    }

    /**
     * @param campaignId
     *            the campaignId to set
     */
    public void setCampaignId(Long campaignId) {
        this.campaignId = campaignId;
    }

    /**
     * @param campaignName
     *            the campaignName to set
     */
    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    /**
     * @param campaign_Status
     *            the campaign_Status to set
     */
    public void setCampaignStatus(String campaignStatus) {
        this.campaignStatus = campaignStatus;
    }

    /**
     * @param directorComments
     *            the directorComments to set
     */
    public void setDirectorComments(String directorComments) {
        this.directorComments = directorComments;
    }

    /**
     * @param endate
     *            the endate to set
     */
    public void setEndate(Date endate) {
        this.endate = endate;
    }

    /**
     * @param estimatedRevenue
     *            the estimatedRevenue to set
     */
    public void setEstimatedRevenue(String estimatedRevenue) {
        this.estimatedRevenue = estimatedRevenue;
    }

    /**
     * @param existingPixelUpdate
     *            the existingPixelUpdate to set
     */
    public void setExistingPixelUpdate(String existingPixelUpdate) {
        this.existingPixelUpdate = existingPixelUpdate;
    }

    /**
     * @param regionalDirector
     *            the regionalDirector to set
     */
    public void setRegionalDirector(String regionalDirector) {
        this.regionalDirector = regionalDirector;
    }

    /**
     * @param requester
     *            the requester to set
     */
    public void setRequester(Requester requester) {
        this.requester = requester;
    }

    /**
     * @param specialInstructions
     *            the specialInstructions to set
     */
    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    /**
     * @param startDate
     *            the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @param vendorHasCampaign
     *            the vendorHasCampaign to set
     */
    public void setVendorHasCampaign(String vendorHasCampaign) {
        this.vendorHasCampaign = vendorHasCampaign;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Campaign [campaignId=" + this.campaignId + ", campaignName=" + this.campaignName + ", startDate=" + this.startDate + ", endate=" + this.endate
                + ", estimatedRevenue=" + this.estimatedRevenue + ", vendorHasCampaign=" + this.vendorHasCampaign + ", campaignDesc=" + this.campaignDesc + ", existingPixelUpdate="
                + this.existingPixelUpdate + ", regionalDirector=" + this.regionalDirector + ", specialInstructions=" + this.specialInstructions + ", campaignStatus="
                + this.campaignStatus + ", directorComments=" + this.directorComments + ", adminComments=" + this.adminComments + ", audit=" + this.audit + ", requester="
                + this.requester + "]";
    }

}
