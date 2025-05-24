package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Bagage;
import com.example.demo.repository.BagageRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BagageService {

    @Autowired
    private BagageRepository bagageRepository;

    public List<Bagage> getAllBagages() {
        return bagageRepository.findAll();
    }

    // public Optional<Bagage> getBagageById(Long id) {
    //     return bagageRepository.findById(id);
    // }

    public Bagage createBagage(Bagage bagage) {
        return bagageRepository.save(bagage);
    }

    // public Bagage updateBagage(Long id, Bagage bagage) {
    //     if (bagageRepository.existsById(id)) {
    //         bagage.setIdBagage(id);
    //         return bagageRepository.save(bagage);
    //     }
    //     return null;
    // }

    // public void deleteBagage(Long id) {
    //     bagageRepository.deleteById(id);
    // }
}
