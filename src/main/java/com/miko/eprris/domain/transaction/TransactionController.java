package com.miko.eprris.domain.transaction;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/transaction")
@AllArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping
    ResponseEntity<List<Transaction>> findAll() {
        return ResponseEntity.ok(transactionService.findALl());
    }

    @PostMapping("/create/equipment/{equipmentId}/municipality/{municipalityId}")
    ResponseEntity<Transaction> createTransaction(@PathVariable("equipmentId") Long equipmentId,
                                                  @PathVariable("municipalityId") Long municipalityId,
                                                  @RequestBody Integer quantity
    ) {
        Transaction created = transactionService.createTransaction(equipmentId, municipalityId, quantity);
        return ResponseEntity.ok(created);
    }
}
