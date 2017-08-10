package com.ihg.it.pfm.cra;

public class Campaign extends Audit {

    private Long id;
    private String name;
    private String stauts;
    private String adminComments;
    private String desc;
    private String directorComments;
    private String startDate;
    private String endDate;
    private String estimatedRevenue;
    private String anyUpdateRequired;
    private String regionalDirector;
    private String specialInstructions;
    private String vendorExists;

    /**
     *
     */
    public Campaign() {
        super();
    }

    /**
     * @return the adminComments
     */
    public String getAdminComments() {
        return this.adminComments;
    }

    /**
     * @return the anyUpdateRequired
     */
    public String getAnyUpdateRequired() {
        return this.anyUpdateRequired;
    }

    /**
     * @return the desc
     */
    public String getDesc() {
        return this.desc;
    }

    /**
     * @return the directorComments
     */
    public String getDirectorComments() {
        return this.directorComments;
    }

    /**
     * @return the endDate
     */
    public String getEndDate() {
        return this.endDate;
    }

    /**
     * @return the estimatedRevenue
     */
    public String getEstimatedRevenue() {
        return this.estimatedRevenue;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return the regionalDirector
     */
    public String getRegionalDirector() {
        return this.regionalDirector;
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
    public String getStartDate() {
        return this.startDate;
    }

    /**
     * @return the stauts
     */
    public String getStauts() {
        return this.stauts;
    }

    /**
     * @return the vendorExists
     */
    public String getVendorExists() {
        return this.vendorExists;
    }

    /**
     * @param adminComments
     *            the adminComments to set
     */
    public void setAdminComments(String adminComments) {
        this.adminComments = adminComments;
    }

    /**
     * @param anyUpdateRequired
     *            the anyUpdateRequired to set
     */
    public void setAnyUpdateRequired(String anyUpdateRequired) {
        this.anyUpdateRequired = anyUpdateRequired;
    }

    /**
     * @param desc
     *            the desc to set
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * @param directorComments
     *            the directorComments to set
     */
    public void setDirectorComments(String directorComments) {
        this.directorComments = directorComments;
    }

    /**
     * @param endDate
     *            the endDate to set
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * @param estimatedRevenue
     *            the estimatedRevenue to set
     */
    public void setEstimatedRevenue(String estimatedRevenue) {
        this.estimatedRevenue = estimatedRevenue;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param regionalDirector
     *            the regionalDirector to set
     */
    public void setRegionalDirector(String regionalDirector) {
        this.regionalDirector = regionalDirector;
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
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * @param stauts
     *            the stauts to set
     */
    public void setStauts(String stauts) {
        this.stauts = stauts;
    }

    /**
     * @param vendorExists
     *            the vendorExists to set
     */
    public void setVendorExists(String vendorExists) {
        this.vendorExists = vendorExists;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Campaign [id=" + this.id + ", name=" + this.name + ", stauts=" + this.stauts + ", adminComments=" + this.adminComments + ", desc=" + this.desc
                + ", directorComments=" + this.directorComments + ", startDate=" + this.startDate + ", endDate=" + this.endDate + ", estimatedRevenue=" + this.estimatedRevenue
                + ", anyUpdateRequired=" + this.anyUpdateRequired + ", regionalDirector=" + this.regionalDirector + ", specialInstructions=" + this.specialInstructions
                + ", vendorExists=" + this.vendorExists + "]";
    }

}
