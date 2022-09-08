package com.miko.eprris.domain.crossTransaction;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
public class CrossTransactionController {

    private final CrossTransactionService crossTransactionService;

    @GetMapping
    ResponseEntity<List<CrossTransaction>> findAll(){
        return ResponseEntity.ok( crossTransactionService.findAll());
    }

    @PostMapping("/equipment/{equipmentId}/municipality/{municipalityId}")
    ResponseEntity<CrossTransaction> createTransaction(@PathVariable("equipmentId") Long equipmentId,
                                                       @PathVariable("municipalityId") Long municipalityId,
                                                       @RequestBody Integer quantity){
        CrossTransaction created = crossTransactionService.createCrossTransaction(equipmentId, municipalityId, quantity);

        return new  ResponseEntity<>(created, HttpStatus.CREATED);
    }
}
