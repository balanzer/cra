/**
 *
 */
package com.ihg.it.pfm.dao.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ihg.it.pfm.dao.entity.Campaign;

/**
 * @author VarathM
 *
 */
public interface CampaignRepository extends JpaRepository<Campaign, Long> {

    List<Campaign> findByCampaignNameIgnoreCase(String name);
}
