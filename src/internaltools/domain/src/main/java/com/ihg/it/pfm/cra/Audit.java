package com.ihg.it.pfm.cra;

public class Audit {

    private String createdBy;
    private String updatedBy;
    private String updatedDate;

    private String createdDate;

    /**
     *
     */
    public Audit() {
        super();
    }

    /**
     * @return the createdBy
     */
    public String getCreatedBy() {
        return this.createdBy;
    }

    /**
     * @return the createdDate
     */
    public String getCreatedDate() {
        return this.createdDate;
    }

    /**
     * @return the updatedBy
     */
    public String getUpdatedBy() {
        return this.updatedBy;
    }

    /**
     * @return the updatedDate
     */
    public String getUpdatedDate() {
        return this.updatedDate;
    }

    /**
     * @param createdBy
     *            the createdBy to set
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @param createdDate
     *            the createdDate to set
     */
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @param updatedBy
     *            the updatedBy to set
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * @param updatedDate
     *            the updatedDate to set
     */
    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Audit [createdBy=" + this.createdBy + ", updatedBy=" + this.updatedBy + ", updatedDate=" + this.updatedDate + ", createdDate=" + this.createdDate + "]";
    }

}
