/**
 *
 */
package com.ihg.it.pfm.dao.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author VarathM
 *
 */
@Embeddable
public class Audit {

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_date")
    private Date updateDate;

    protected Audit() {

    }

    /**
     * @param createdBy
     * @param createdDate
     * @param updatedBy
     * @param updatedate
     */
    public Audit(String createdBy, Date createdDate, String updatedBy, Date updateDate) {
        super();
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.updatedBy = updatedBy;
        this.updateDate = updateDate;
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
    public Date getCreatedDate() {
        return this.createdDate;
    }

    /**
     * @return the updatedate
     */
    public Date getUpdateDate() {
        return this.updateDate;
    }

    /**
     * @return the updatedBy
     */
    public String getUpdatedBy() {
        return this.updatedBy;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Audit [createdBy=" + this.createdBy + ", createdDate=" + this.createdDate + ", updatedBy=" + this.updatedBy + ", updateDate=" + this.updateDate + "]";
    }
}
