package com.example.amazingpcbackend.services;

import com.example.amazingpcbackend.dto.CompareItemsDto;
import com.example.amazingpcbackend.dto.CompareTypeDto;
import com.example.amazingpcbackend.entity.*;
import com.example.amazingpcbackend.repo.CompareItemsRepository;
import com.example.amazingpcbackend.repo.PartsRepository;
import com.example.amazingpcbackend.repo.PcRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CompareService {

    private final CompareItemsRepository compareItemsRepository;
    private final PcRepository pcRepository;
    private final PartsRepository partsRepository;

    public CompareItemsDto getCompareItems(Users user) {
        try {
            CompareItemsDto compareItemsDto = new CompareItemsDto();
            Set<CompareTypeDto> types = new HashSet<>();

            List<CompareItems> compareItems = compareItemsRepository.findByUser(user);

            for (CompareItems item : compareItems) {
                CompareTypeDto typeDto = getCompareTypeDto(item);
                types.add(typeDto);
            }
            compareItemsDto.setItems(compareItems);
            compareItemsDto.setTypes(types.stream().toList());

            return compareItemsDto;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public HttpStatus deleteItemById(String id) {
        try{
            compareItemsRepository.deleteById(id);
            return HttpStatus.OK;
        }catch (Exception e){
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    public HttpStatus addCompareItem(Users user, String productId) {
        try{
            CompareItems compareItems = new CompareItems();
            compareItems.setUser(user);
            if(pcRepository.findById(productId).isPresent()){
                compareItems.setProduct(pcRepository.findById(productId).get());
            }
            if(partsRepository.findById(productId).isPresent()){
                compareItems.setProduct(partsRepository.findById(productId).get());
            }
            compareItemsRepository.save(compareItems);
            return HttpStatus.OK;
        }catch (Exception e){
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    public HttpStatus deleteAllItems() {
        try{
            compareItemsRepository.deleteAll();
            return HttpStatus.OK;
        }catch (Exception e){
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    public int getCompareItemsCount(Users user) {
        try{
            List<CompareItems> compareItems = compareItemsRepository.findByUser(user);
            return compareItems.size();
        }catch (Exception e){
            return 0;
        }
    }

    private static CompareTypeDto getCompareTypeDto(CompareItems item) {
        CompareTypeDto typeDto = new CompareTypeDto();
        Product product = item.getProduct();
        if (product instanceof Parts) {
            Types type = ((Parts) product).getTypes();
            typeDto.setId(type.getId());
            typeDto.setLabel(type.getLabel());
            typeDto.setValue(type.getValue());
        }
        if (product instanceof Pc) {
            PcTypes type = ((Pc) product).getPcType();
            typeDto.setId(type.getId());
            typeDto.setLabel(type.getLabel());
            typeDto.setValue(type.getValue());
        }
        return typeDto;
    }

}
