package com.miko.eprris.domain.crossTransaction;

import com.miko.eprris.domain.equipment.Equipment;
import com.miko.eprris.domain.equipment.EquipmentRepository;
import com.miko.eprris.domain.municipality.Municipality;
import com.miko.eprris.domain.municipality.MunicipalityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.lang.Boolean.FALSE;

@Service
@AllArgsConstructor
public class CrossTransactionService {

    private final CrossTransactionRepository crossTransactionRepository;
    private final MunicipalityRepository municipalityRepository;
    private final EquipmentRepository equipmentRepository;

    List<CrossTransaction> findAll(){
        return crossTransactionRepository.findAll();
    }

    @Transactional
    CrossTransaction createCrossTransaction(Long equipmentId, Long municipalityId, Integer quantity){
        List<CrossTransaction> crossTransaction = crossTransactionRepository
                .getWhereEquipmentAndMunicipality(equipmentId, municipalityId);

        if(crossTransaction == null){
            Equipment equipment = equipmentRepository.findById(equipmentId)
                    .orElseThrow(()-> new RuntimeException("not found"));
            Municipality municipality = municipalityRepository.findById(municipalityId)
                    .orElseThrow(()-> new RuntimeException("not found"));
            CrossTransaction newCTransaction = new CrossTransaction(
                    null,
                    equipment,
                    municipality,
                    quantity,
                    FALSE,
                    FALSE,
                    FALSE
            );
            crossTransactionRepository.save(newCTransaction);
        }

        assert crossTransaction != null;
        CrossTransaction first = crossTransaction.get(0);
        first.setQuantity(first.getQuantity() + quantity);
        return crossTransactionRepository.save(first);
    }
}
