package com.miko.eprris.domain.province;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProvinceService {

    private final ProvinceRepository provinceRepository;

    List<Province> findAll(){
        return provinceRepository.findAll();
    }

    Province findById(Long id){
        return provinceRepository.findById(id).orElseThrow(()-> new RuntimeException("no province found"));
    }

    Province createProvince(Province province){
        return provinceRepository.save(province);
    }

    Province updateProvince(Province province){
        return provinceRepository.save(province);
    }

    void deleteProvince(Long id){
        boolean exist = provinceRepository.existsById(id);
        if (!exist){
            throw new IllegalStateException("nothing to delete province not found");
        }
        provinceRepository.deleteById(id);
    }
}
