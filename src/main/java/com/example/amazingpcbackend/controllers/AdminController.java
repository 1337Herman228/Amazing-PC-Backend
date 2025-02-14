package com.example.amazingpcbackend.controllers;

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
import com.example.amazingpcbackend.services.PartitionsService;
import com.example.amazingpcbackend.services.TypesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('admin')")
@RequiredArgsConstructor
public class AdminController {

    private final PartsRepository partsRepository;
    private final PartService partService;
    private final TypesRepository typesRepository;
    private final TypesService typesService;
    private final PartitionsRepository partitionsRepository;
    private final PartitionsService partitionsService;

    @DeleteMapping("/parts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public HttpStatus deletePart(@PathVariable String id) throws PartsException {
        try {
            return partService.deletePart(id);
        } catch (Exception e) {
            throw new PartsException("can't delete part", e);
        }
    }

    @PostMapping("/parts")
    @ResponseStatus(HttpStatus.OK)
    public HttpStatus addPart(@RequestBody Parts part) throws PartsException {
        try {
            return partService.addPart(part);
        } catch (Exception e) {
            throw new PartsException("can't add new part", e);
        }
    }


    @PutMapping("/parts")
    @ResponseStatus(HttpStatus.OK)
    public HttpStatus editPart(@RequestBody Parts part) throws PartsException {
        try {
            return partService.editPart(part);
        } catch (Exception e) {
            throw new PartsException("can't edit part", e);
        }
    }


    @PostMapping("/types")
    @ResponseStatus(HttpStatus.OK)
    public HttpStatus addType(@RequestBody Types newType) throws TypesException {
        try {
            return typesService.addType(newType);
        } catch (Exception e) {
            throw new TypesException("can't add new type", e);
        }
    }

    @DeleteMapping ("/types/{id}")
    @ResponseStatus(HttpStatus.OK)
    public HttpStatus deleteType(@PathVariable String id) throws TypesException {
        try {
            typesRepository.deleteById(id);
            return HttpStatus.OK;
        } catch (Exception e) {
            throw new TypesException("can't delete type", e);
        }
    }

    @PutMapping("/types")
    @ResponseStatus(HttpStatus.OK)
    public HttpStatus editType(@RequestBody Types editType) throws TypesException {
        try {
            return typesService.editType(editType);
        } catch (Exception e) {
            throw new TypesException("can't edit type", e);
        }
    }


    @PostMapping("/partitions")
    @ResponseStatus(HttpStatus.OK)
    public HttpStatus addPartition(@RequestBody Partitions newPartition) throws PartitionsException {
        try {
            return partitionsService.addPartitions(newPartition);
        } catch (Exception e) {
            throw new PartitionsException("can't add new partition", e);
        }
    }

    @DeleteMapping ("/partitions/{id}")
    @ResponseStatus(HttpStatus.OK)
    public HttpStatus deletePartition(@PathVariable String id) throws PartitionsException {
        try {
            partitionsRepository.deleteById(id);
            return HttpStatus.OK;
        } catch (Exception e) {
            throw new PartitionsException("can't delete partition", e);
        }
    }

    @PutMapping("/partitions")
    @ResponseStatus(HttpStatus.OK)
    public HttpStatus editPartition(@RequestBody Partitions editPartition) throws PartitionsException {
        try {
            return partitionsService.editPartition(editPartition);
        } catch (Exception e) {
            throw new PartitionsException("can't edit partition", e);
        }
    }

}
