package com.miko.eprris.domain.transaction;

import com.miko.eprris.Exception.notFound.NotFoundException;
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
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final EquipmentRepository equipmentRepository;
    private final MunicipalityRepository municipalityRepository;


    List<Transaction> findALl() {
        return transactionRepository.findAll();
    }

    /*Create or Update*/
    @Transactional
    Transaction createTransaction(Long equipmentId, Long municipalityId, Integer quantity) {
        Transaction transaction = transactionRepository.findIfExistEquipmentAndMunicipality(equipmentId, municipalityId);

        if (transaction == null) {
            Equipment equipment = equipmentRepository.findById(equipmentId)
                    .orElseThrow(() -> new NotFoundException("Equipment not found"));
            Municipality municipality = municipalityRepository
                    .findById(municipalityId).orElseThrow(() -> new NotFoundException("Municipality not found municipality"));
            /*creating new transaction to be saved in the database*/
            Transaction createTransaction =
                    new Transaction(
                            null,
                            equipment,
                            municipality,
                            FALSE,
                            quantity,
                            FALSE
                    );
            return transactionRepository.save(createTransaction);
        }
        /*updating existing data adding its quantity to the quantity send by the user*/
        transaction.setQuantity(transaction.getQuantity() + quantity);
        return transactionRepository.save(transaction);
    }
}
