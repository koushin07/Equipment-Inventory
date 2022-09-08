package com.miko.eprris.domain.crossTransaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CrossTransactionRepository extends JpaRepository<CrossTransaction, Long> {
    @Query(value = "SELECT * FROM cross_transaction ct WHERE ct.equipment_id = ?1 AND ct.municipality_id = ?2", nativeQuery = true)
    List<CrossTransaction> getWhereEquipmentAndMunicipality(Long equipmentId,
                                                            Long municipalityId);
}
