package com.miko.eprris.domain.province;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/province")
@AllArgsConstructor
public class ProvinceController {

    private final ProvinceService provinceService;

    @GetMapping
    ResponseEntity<List<Province>> findAll(){
        return ResponseEntity.ok(provinceService.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Province> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(provinceService.findById(id));
    }

    @PostMapping("/create")
    ResponseEntity<Province> createProvince(@RequestBody Province province){
        Province created =provinceService.createProvince(province);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    ResponseEntity<Province> updateProvince(@RequestBody Province province){
        Province updated = provinceService.updateProvince(province);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Province> deleteProvince(@PathVariable("id")Long id){
        provinceService.deleteProvince(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
