package com.example.amazingpcbackend.services;

import com.example.amazingpcbackend.entity.Parts;
import com.example.amazingpcbackend.repo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PartService {

    private final PartsRepository partsRepository;
    private final CategoriesRepository categoriesRepository;
    private final PartitionsRepository partitionsRepository;
    private final TypesRepository typesRepository;

    public HttpStatus deletePart(String id) {
        try {
            partsRepository.deleteById(id);
            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }


    public HttpStatus addPart(Parts part) {
        try {
            Parts newPart = new Parts();
            partsRepository.save(makePartFromDto(newPart, part));
            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    public HttpStatus editPart(Parts part) {
        try {
            Parts editablePart = makePartFromDto(partsRepository.findById(part.getId()).get(), part);
            partsRepository.save(editablePart);
            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    public Parts makePartFromDto (Parts editablePart, Parts part){
        editablePart.setName(part.getName());
        editablePart.setDescription(part.getDescription());
        editablePart.setImage(part.getImage());
        editablePart.setPrice(part.getPrice());
        editablePart.setCharacteristics(part.getCharacteristics());
        editablePart.setCategories(categoriesRepository.findById(part.getCategories().getId()).get());
        editablePart.setPartitions(partitionsRepository.findById(part.getPartitions().getId()).get());
        editablePart.setTypes(typesRepository.findById(part.getTypes().getId()).get());
        return editablePart;
    }


}
