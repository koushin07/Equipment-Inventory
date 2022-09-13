package com.miko.eprris.domain.equipment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {


    @Query(value = "SELECT * FROM equipment e WHERE asset_id = :asset_id " +
            "AND model_number = :model_number AND unit = :unit AND serial_number = :serial_number", nativeQuery = true)
    List<Equipment> checkIfEquipmentExist(@Param("asset_id") Integer asset_id,
                               @Param("model_number") Integer model_number,
                               @Param("unit") Integer unit,
                               @Param("serial_number") Integer serial_number);
}
