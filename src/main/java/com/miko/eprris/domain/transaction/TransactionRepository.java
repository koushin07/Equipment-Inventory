package com.miko.eprris.domain.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query(value = "SELECT * FROM transaction t WHERE t.equipment_id = :equipmentId AND t.municipality_id = :municipalityId", nativeQuery = true)
    Transaction findIfExistEquipmentAndMunicipality(@Param("equipmentId") Long equipmentId,
                                                          @Param("municipalityId")Long municipalityId);
}
