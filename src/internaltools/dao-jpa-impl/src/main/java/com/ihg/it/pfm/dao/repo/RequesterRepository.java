/**
 *
 */
package com.ihg.it.pfm.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ihg.it.pfm.dao.entity.Requester;

/**
 * @author VarathM
 *
 */
public interface RequesterRepository extends JpaRepository<Requester, Long> {

    Requester findByEmailIgnoreCaseAndFirstNameIgnoreCaseAndLastNameIgnoreCaseAndPhoneNumberIgnoreCase(String email, String firstName, String lastName, String phoneNumber);
}
