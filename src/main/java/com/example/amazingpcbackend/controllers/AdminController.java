package com.example.amazingpcbackend.controllers;

import com.example.amazingpcbackend.dto.CpuAddDto;
import com.example.amazingpcbackend.dto.PartAddDto;
import com.example.amazingpcbackend.entity.Partitions;
import com.example.amazingpcbackend.entity.Parts;
import com.example.amazingpcbackend.entity.Types;
import com.example.amazingpcbackend.exceptions.PartitionsException;
import com.example.amazingpcbackend.exceptions.PartsException;
import com.example.amazingpcbackend.exceptions.TypesException;
import com.example.amazingpcbackend.repo.PartitionsRepository;
import com.example.amazingpcbackend.repo.PartsRepository;
import com.example.amazingpcbackend.repo.TypesRepository;
import com.example.amazingpcbackend.services.PartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('admin')")
@RequiredArgsConstructor
public class AdminController {

    private final PartsRepository partsRepository;
    private final TypesRepository typesRepository;
    private final PartitionsRepository partitionsRepository;

    private final PartService partService;

    @GetMapping("/parts")
    public List<Parts> getProducts() {
        return partsRepository.findAll();
    }

    @GetMapping("/types")
    public List<Types> getTypes() {
        return typesRepository.findAll();
    }

    @GetMapping("/partitions")
    public List<Partitions> getPartitions() {
        return partitionsRepository.findAll();
    }

    @GetMapping("/get-type/{typeId}")
    public Types getTypeByID(@PathVariable Long typeId) {
        return typesRepository.findById(typeId).orElse(null);
    }

    @GetMapping("/get-partition/{partitionId}")
    public Partitions getPartitionByID(@PathVariable Long partitionId) {
        return partitionsRepository.findById(partitionId).orElse(null);
    }

    @GetMapping("/get-part/{partId}")
    public Parts getPartByID(@PathVariable Long partId) {
        return partsRepository.findById(partId).orElse(null);
    }

    @PostMapping("/add-type")
    @ResponseStatus(HttpStatus.CREATED)
    public HttpStatus addType(@RequestBody Types newType) throws TypesException {
        try {
            typesRepository.save(newType);
            return HttpStatus.CREATED;
        } catch (Exception e) {
            throw new TypesException("can't add new type", e);
        }
    }

    @PostMapping("/add-partition")
    @ResponseStatus(HttpStatus.CREATED)
    public HttpStatus addPartition(@RequestBody Partitions newPartition) throws PartitionsException {
        try {
            partitionsRepository.save(newPartition);
            return HttpStatus.CREATED;
        } catch (Exception e) {
            throw new PartitionsException("can't add new partition", e);
        }
    }

//    @PostMapping("/add-part")
//    @ResponseStatus(HttpStatus.CREATED)
//    public HttpStatus addPart(@RequestBody PartAddDto part) throws PartsException {
//        try {
//            partService.addPart(part);
//            return HttpStatus.CREATED;
//        } catch (Exception e) {
//            throw new PartsException("can't add new part", e);
//        }
//    }

    @PutMapping("/edit-type")
    @ResponseStatus(HttpStatus.OK)
    public HttpStatus editType(@RequestBody Types editType) throws TypesException {
        try {
            typesRepository.findById(editType.getTypeId()).ifPresent(type -> {
                type.setTypeName(editType.getTypeName());
                type.setAlternativeName(editType.getAlternativeName());
                type.setTypeImage(editType.getTypeImage());
                typesRepository.save(type);
            });
            return HttpStatus.OK;
        } catch (Exception e) {
            throw new TypesException("can't edit type", e);
        }
    }

    @PutMapping("/edit-partition")
    @ResponseStatus(HttpStatus.OK)
    public HttpStatus editPartition(@RequestBody Partitions editPartition) throws PartitionsException {
        try {
            partitionsRepository.findById(editPartition.getPartitionId()).ifPresent(partition -> {
                partition.setPartitionName(editPartition.getPartitionName());
                partitionsRepository.save(partition);
            });
            return HttpStatus.OK;
        } catch (Exception e) {
            throw new PartitionsException("can't edit partition", e);
        }
    }

//    @PostMapping("/edit-part")
//    @ResponseStatus(HttpStatus.OK)
//    public HttpStatus editPart(@RequestBody PartAddDto part) throws PartsException {
//        try {
//            partService.editPart(part);
//            return HttpStatus.OK;
//        } catch (Exception e) {
//            throw new PartsException("can't edit part", e);
//        }
//    }

    @DeleteMapping ("/delete-type/{typeId}")
    @ResponseStatus(HttpStatus.OK)
    public HttpStatus deleteType(@PathVariable Long typeId) throws TypesException {
        try {
            typesRepository.deleteById(typeId);
            return HttpStatus.OK;
        } catch (Exception e) {
            throw new TypesException("can't delete type", e);
        }
    }

    @DeleteMapping ("/delete-partition/{partitionId}")
    @ResponseStatus(HttpStatus.OK)
    public HttpStatus deletePartition(@PathVariable Long partitionId) throws PartitionsException {
        try {
            partitionsRepository.deleteById(partitionId);
            return HttpStatus.OK;
        } catch (Exception e) {
            throw new PartitionsException("can't delete partition", e);
        }
    }

//    @DeleteMapping ("/delete-part/{partId}")
//    @ResponseStatus(HttpStatus.OK)
//    public HttpStatus deletePart(@PathVariable Long partId) throws PartsException {
//        try {
//            partService.deletePart(partsRepository.findById(partId).orElse(null));
//            return HttpStatus.OK;
//        } catch (Exception e) {
//            throw new PartsException("can't delete part", e);
//        }
//    }

}
