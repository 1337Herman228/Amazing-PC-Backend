package com.example.amazingpcbackend.services;

import com.example.amazingpcbackend.entity.Partitions;
import com.example.amazingpcbackend.repo.PartitionsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PartitionsService {

    private final PartitionsRepository partitionsRepository;

    public HttpStatus addPartitions(Partitions partition) {
        try {
            Partitions newPartition = new Partitions();
            partitionsRepository.save(makePartitionsFromDto(newPartition, partition));
            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    public HttpStatus editPartition(Partitions partition) {
        try {
            Partitions editablePartition = makePartitionsFromDto(partitionsRepository.findById(partition.getId()).get(), partition);
            partitionsRepository.save(editablePartition);
            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    public Partitions makePartitionsFromDto (Partitions editablePartition, Partitions partition){
        editablePartition.setValue(partition.getValue());
        editablePartition.setLabel(partition.getLabel());
        return editablePartition;
    }

}
