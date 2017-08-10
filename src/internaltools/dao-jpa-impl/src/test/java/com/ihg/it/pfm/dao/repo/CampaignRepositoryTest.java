/**
 *
 */
package com.ihg.it.pfm.dao.repo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ihg.it.pfm.dao.entity.Campaign;

/**
 * @author VarathM
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CampaignRepositoryTest {

    @Autowired
    CampaignRepository campaignRepository;

    @After
    public void after() {
        System.out.println("\n\n-------------------------CampaignRepositoryTest  End------------------------------\n");
    }

    /**
     * @param campagign
     * @param campaignFromDB
     */
    private void assertCampagin(Campaign beforeSave, Campaign afterSave) {
        assertNotNull(afterSave.getCampaignId());
        assertEquals(beforeSave.getCampaignName(), afterSave.getCampaignName());
        assertEquals(beforeSave.getStartDate(), afterSave.getStartDate());
        assertEquals(beforeSave.getEndate(), afterSave.getEndate());
        assertEquals(beforeSave.getEstimatedRevenue(), afterSave.getEstimatedRevenue());
        assertEquals(beforeSave.getVendorHasCampaign(), afterSave.getVendorHasCampaign());
        assertEquals(beforeSave.getCampaignDesc(), afterSave.getCampaignDesc());
        assertEquals(beforeSave.getExistingPixelUpdate(), afterSave.getExistingPixelUpdate());
        assertEquals(beforeSave.getRegionalDirector(), afterSave.getRegionalDirector());
        assertEquals(beforeSave.getSpecialInstructions(), afterSave.getSpecialInstructions());
        assertEquals(beforeSave.getCampaignStatus(), afterSave.getCampaignStatus());
        assertEquals(beforeSave.getDirectorComments(), afterSave.getDirectorComments());
        assertEquals(beforeSave.getAdminComments(), afterSave.getAdminComments());
        assertEquals(beforeSave.getAudit().getCreatedBy(), afterSave.getAudit().getCreatedBy());
        assertEquals(beforeSave.getAudit().getUpdatedBy(), afterSave.getAudit().getUpdatedBy());
        assertEquals(beforeSave.getAudit().getCreatedDate().getTime(), afterSave.getAudit().getCreatedDate().getTime());
        assertEquals(beforeSave.getAudit().getUpdateDate().getTime(), afterSave.getAudit().getUpdateDate().getTime());
        assertNotNull(afterSave.toString());

    }

    @Before
    public void before() {
        System.out.println("\n\n-------------------------CampaignRepositoryTest  Start------------------------------\n");

        // Delete all records from DB inserted as part of the application bootup
        this.campaignRepository.deleteAll();
    }

    @Test
    public void testSave() {

        Campaign campagign = Utils.getCampaignSample();

        this.campaignRepository.saveAndFlush(campagign);

        assertEquals(1, this.campaignRepository.count());

        // Assert for Fields
        this.campaignRepository.findAll().forEach(campaignFromDB -> {

            this.assertCampagin(campagign, campaignFromDB);

        });

        this.campaignRepository.deleteAll();
    }
}
