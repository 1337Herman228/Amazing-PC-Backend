//package com.example.amazingpcbackend.services;
//
//import com.example.amazingpcbackend.entity.Cases;
//import com.example.amazingpcbackend.entity.Fans;
//import com.example.amazingpcbackend.entity.Parts;
//import com.example.amazingpcbackend.repo.CasesRepository;
//import com.example.amazingpcbackend.repo.FansRepository;
//import com.example.amazingpcbackend.repo.PartsRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import java.util.Optional;
//
//@Service
//public class PartsService {
//
//    @Autowired
//    private PartsRepository partsRepository;
//
//    @Autowired
//    private FansRepository fansRepository;
//
//    @Autowired
//    private CasesRepository casesRepository;
//
//    @Transactional
//    public Parts createPartWithFan(Long fanId, String name, Double price) {
//        Fans fan = fansRepository.findById(fanId)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid fan ID"));
//
//        Parts part = new Parts()
//                .setSubjectId(fanId)
//                .setName(name)
//                .setPrice(price)
//                .setFan(fan);
//
//        return partsRepository.save(part);
//    }
//
//    @Transactional
//    public Parts createPartWithCase(Long caseId, String name, Double price) {
//        Cases cases = casesRepository.findById(caseId)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid case ID"));
//
//        Parts part = new Parts()
//                .setSubjectId(caseId)
//                .setName(name)
//                .setPrice(price)
//                .setCases(cases);
//
//        return partsRepository.save(part);
//    }
//
//    public Optional<Parts> getPartById(Long partId) {
//        return partsRepository.findById(partId);
//    }
//}