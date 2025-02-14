package com.example.amazingpcbackend.services;

import com.example.amazingpcbackend.entity.Types;
import com.example.amazingpcbackend.repo.TypesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TypesService {

    private final TypesRepository typesRepository;

    public HttpStatus addType(Types type) {
        try {
            Types newType = new Types();
            typesRepository.save(makeTypeFromDto(newType, type));
            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    public HttpStatus editType(Types type) {
        try {
            Types editableType = makeTypeFromDto(typesRepository.findById(type.getId()).get(), type);
            typesRepository.save(editableType);
            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    public Types makeTypeFromDto(Types editableType, Types type) {
        editableType.setImage(type.getImage());
        editableType.setLabel(type.getLabel());
        editableType.setValue(type.getValue());
        return editableType;
    }

}
