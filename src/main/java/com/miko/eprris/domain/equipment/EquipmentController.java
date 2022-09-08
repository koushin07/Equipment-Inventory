package com.miko.eprris.domain.equipment;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/equipment")
@AllArgsConstructor
public class EquipmentController {

    private final EquipmentService equipmentService;

    @GetMapping
    ResponseEntity<List<Equipment>> findAll() {
        return ResponseEntity.ok(equipmentService.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Equipment> findById(@Validated @PathVariable("id") Long id) {
        return ResponseEntity.ok(equipmentService.findById(id));
    }

    @PostMapping("/create")
    ResponseEntity<Equipment> createEquipment(@Validated @RequestBody Equipment equipment) {
        Equipment create = equipmentService.createEquipment(equipment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    ResponseEntity<Equipment> updateEquipment(@Validated @RequestBody Equipment equipment) {
        return ResponseEntity.ok(equipmentService.updateEquipment(equipment));
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Equipment> deleteEquipment(@Validated @PathVariable("id") Long id) throws Exception {
        equipmentService.deleteEquipment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
