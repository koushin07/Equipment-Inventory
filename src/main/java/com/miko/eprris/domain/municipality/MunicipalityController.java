package com.miko.eprris.domain.municipality;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/municipality")
@AllArgsConstructor
public class MunicipalityController {

    private final MunicipalityService municipalityService;

    @GetMapping
    ResponseEntity<List<Municipality>> findAll() {
        return ResponseEntity.ok(municipalityService.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Municipality> findById(@Validated @PathVariable("id") Long id) {
        return ResponseEntity.ok(municipalityService.findById(id));
    }

    @PostMapping("create")
    ResponseEntity<Municipality> createMunicipality(@Validated @RequestBody Municipality municipality) {
        Municipality created = municipalityService.createMunicipality(municipality);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<Municipality> updateMunicipality(@RequestBody Municipality municipality){
        Municipality updated = municipalityService.updateMunicipality(municipality);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Municipality> deleteMunicipality(@PathVariable("id")Long id) throws Exception {
        municipalityService.deleteMunicipality(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
