package com.miko.eprris.domain.equipment;

import com.miko.eprris.Exception.badRequest.BadRequestException;
import com.miko.eprris.Exception.notFound.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@AllArgsConstructor
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;

    List<Equipment> findAll(){
        return equipmentRepository.findAll();
    }

    Equipment findById(Long id){
        return equipmentRepository.findById(id).orElseThrow(()-> new NotFoundException("no such equipment exist"));
    }

    Equipment createEquipment(Equipment equipment){
        List<Equipment> exist = equipmentRepository.checkIfEquipmentExist(
                equipment.getAsset_id(),
                equipment.getModel_number(),
                equipment.getUnit(),
                equipment.getSerial_number()
        );
        if(!exist.isEmpty()){
            throw new BadRequestException("equipment already exist");
        }

        return equipmentRepository.save(equipment);
    }

    @Transactional
    Equipment updateEquipment(Equipment equipment) {
        Equipment oldEquipment = equipmentRepository.findById(equipment.getId())
                .orElseThrow(()-> new NotFoundException("no equipment found"));

        AtomicInteger quantity = new AtomicInteger(equipment.getQuantity());
        if(0 == quantity.get()){
            quantity.addAndGet(1);
        }
        int newQuantity = oldEquipment.getQuantity() + quantity.get();
        equipment.setQuantity(newQuantity);
        return equipmentRepository.save(equipment);
    }

    void deleteEquipment(Long id) throws Exception{
        boolean exist = equipmentRepository.existsById(id);
        if (!exist){
            throw new Exception("no such equipment");
        }
         equipmentRepository.deleteById(id);
    }
}
