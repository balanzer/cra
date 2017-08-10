/**
 *
 */
package com.ihg.it.pfm.dao.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author varathm
 *
 */
@Entity
@Table(name = "REQUESTER")
public class Requester {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long requesterId;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phonenumber")
    private String phoneNumber;

    @Embedded
    private Audit audit;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "requester", cascade = CascadeType.ALL)
    private List<Campaign> campaigns = new ArrayList<>();

    /**
     *
     */
    public Requester() {
        super();
    }

    /**
     * @return the audit
     */
    public Audit getAudit() {
        return this.audit;
    }

    /**
     * @return the campaigns
     */
    public List<Campaign> getCampaigns() {
        return this.campaigns;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * @return the requesterId
     */
    public Long getRequesterId() {
        return this.requesterId;
    }

    /**
     * @param audit
     *            the audit to set
     */
    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    /**
     * @param campaigns
     *            the campaigns to set
     */
    public void setCampaigns(List<Campaign> campaigns) {
        this.campaigns = campaigns;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param firstName
     *            the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @param lastName
     *            the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @param phoneNumber
     *            the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @param requesterId
     *            the requesterId to set
     */
    public void setRequesterId(Long requesterId) {
        this.requesterId = requesterId;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Requester [requesterId=" + this.requesterId + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", email=" + this.email + ", phoneNumber="
                + this.phoneNumber + ", audit=" + this.audit + "]";
    }

}
