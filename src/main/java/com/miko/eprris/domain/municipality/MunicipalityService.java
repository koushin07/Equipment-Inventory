package com.miko.eprris.domain.municipality;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @AllArgsConstructor
public class MunicipalityService {

    private final MunicipalityRepository municipalityRepository;

    List<Municipality> findAll(){
        return municipalityRepository.findAll();
    }

    Municipality findById(Long id){
        return municipalityRepository.findById(id).orElseThrow(()-> new RuntimeException("Municipality doesn't Exist"));
    }

    Municipality createMunicipality(Municipality municipality){
        return municipalityRepository.save(municipality);
    }

    Municipality updateMunicipality(Municipality municipality){
        return municipalityRepository.save(municipality);
    }

    void deleteMunicipality(Long id) throws Exception {
        boolean exist = municipalityRepository.existsById(id);
        if(exist){
            throw new Exception("nothing to delete");
        }
        municipalityRepository.deleteById(id);
    }
}
