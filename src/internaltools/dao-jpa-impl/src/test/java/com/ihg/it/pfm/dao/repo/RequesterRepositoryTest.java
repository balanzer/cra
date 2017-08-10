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

import com.ihg.it.pfm.dao.entity.Requester;

/**
 * @author VarathM
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RequesterRepositoryTest {

    @Autowired
    RequesterRepository requesterRepository;

    @After
    public void after() {
        System.out.println("\n\n-------------------------RequesterRepositoryTest  End------------------------------\n");
    }

    @Before
    public void before() {
        System.out.println("\n\n-------------------------RequesterRepositoryTest  Start------------------------------\n");

        // Delete all records from DB inserted as part of the application bootup
        this.requesterRepository.deleteAll();
    }

    @Test
    public void testFindBy() {

        Requester input = Utils.getRequesterSample();

        this.requesterRepository.saveAndFlush(input);

        Requester output = this.requesterRepository.findByEmailIgnoreCaseAndFirstNameIgnoreCaseAndLastNameIgnoreCaseAndPhoneNumberIgnoreCase(input.getEmail(), input.getFirstName(),
                input.getLastName(), input.getPhoneNumber());

        assertNotNull(output);

    }

    @Test
    public void testSave() {

        this.requesterRepository.saveAndFlush(Utils.getRequesterSample());

        assertEquals(1, this.requesterRepository.count());

    }
}
