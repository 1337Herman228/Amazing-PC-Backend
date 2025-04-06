package com.example.amazingpcbackend.controllers;

import com.example.amazingpcbackend.dto.AddPcCategoryDto;
import com.example.amazingpcbackend.dto.AddPcModelGroupDto;
import com.example.amazingpcbackend.dto.AddPcTypeDto;
import com.example.amazingpcbackend.dto.NewUserDto;
import com.example.amazingpcbackend.entity.*;
import com.example.amazingpcbackend.exceptions.PartitionsException;
import com.example.amazingpcbackend.exceptions.PartsException;
import com.example.amazingpcbackend.exceptions.TypesException;
import com.example.amazingpcbackend.repo.*;
import com.example.amazingpcbackend.services.*;
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
    private final PartService partService;
    private final TypesRepository typesRepository;
    private final TypesService typesService;
    private final PartitionsRepository partitionsRepository;
    private final PartitionsService partitionsService;
    private final UsersRepository usersRepository;
    private final RolesRepository rolesRepository;
    private final UserService userService;
    private final PcCategoriesRepository pcCategoriesRepository;
    private final PcService pcService;
    private final PcTypesRepository pcTypesRepository;
    private final PcModelGroupsRepository pcModelGroupsRepository;

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

    @DeleteMapping("/types/{id}")
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

    @DeleteMapping("/partitions/{id}")
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

    @GetMapping("/users")
    public List<Users> getUsers() {
        return usersRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public Users getUsersByID(@PathVariable String id) {
        return usersRepository.findById(id).orElse(null);
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public HttpStatus addUser(@RequestBody NewUserDto user) throws Exception {
        try {
            return userService.addUser(user);
        } catch (Exception e) {
            throw new Exception("can't add new user", e);
        }
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public HttpStatus deleteUser(@PathVariable String id) throws Exception {
        try {
            return userService.deleteUser(id);
        } catch (Exception e) {
            throw new Exception("can't delete user", e);
        }
    }

    @PutMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public HttpStatus editUser(@RequestBody NewUserDto newUserDto) throws Exception {
        try {
            return userService.editUser(newUserDto);
        } catch (Exception e) {
            throw new Exception("can't edit user", e);
        }
    }

    @GetMapping("/roles")
    public List<Roles> getRoles() {
        return rolesRepository.findAll();
    }

    @GetMapping("/pc-category/{id}")
    public PcCategories getPcCategoryById(@PathVariable String id) {
        return pcCategoriesRepository.findById(id).get();
    }

    @DeleteMapping("/pc-category/{id}")
    @ResponseStatus(HttpStatus.OK)
    public HttpStatus deletePcCategory(@PathVariable String id) {
        try {
            pcCategoriesRepository.deleteById(id);
            return HttpStatus.OK;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @PostMapping("/pc-category")
    @ResponseStatus(HttpStatus.OK)
    public HttpStatus addPcCategory(@RequestBody AddPcCategoryDto pcCategoryDto) {
        return pcService.addPcCategory(pcCategoryDto);
    }


    @PutMapping("/pc-category")
    @ResponseStatus(HttpStatus.OK)
    public HttpStatus editPcCategory(@RequestBody PcCategories pcCategories) {
        return pcService.editPcCategory(pcCategories);
    }

    @GetMapping("/pc-types/{id}")
    public PcTypes getPcTypeById(@PathVariable String id) {
        return pcTypesRepository.findById(id).get();
    }

    @DeleteMapping("/pc-types/{id}")
    @ResponseStatus(HttpStatus.OK)
    public HttpStatus deletePcType(@PathVariable String id) {
        try {
            pcTypesRepository.deleteById(id);
            return HttpStatus.OK;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @PostMapping("/pc-types")
    @ResponseStatus(HttpStatus.OK)
    public HttpStatus addPcType(@RequestBody AddPcTypeDto pcTypeDto) {
        return pcService.addPcType(pcTypeDto);
    }


    @PutMapping("/pc-types")
    @ResponseStatus(HttpStatus.OK)
    public HttpStatus editPcType(@RequestBody PcTypes pcTypes) {
        return pcService.editPcType(pcTypes);
    }

    @DeleteMapping("/pc-model-groups/{id}")
    @ResponseStatus(HttpStatus.OK)
    public HttpStatus deletePcModelGroup(@PathVariable String id) {
        try {
            pcModelGroupsRepository.deleteById(id);
            return HttpStatus.OK;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @PostMapping("/pc-model-groups")
    @ResponseStatus(HttpStatus.OK)
    public HttpStatus addPcModelGroup(@RequestBody AddPcModelGroupDto pcModelGroupDto) {
        return pcService.addPcModelGroup(pcModelGroupDto);
    }

    @PutMapping("/pc-model-groups")
    @ResponseStatus(HttpStatus.OK)
    public HttpStatus editPcModelGroup(@RequestBody AddPcModelGroupDto pcModelGroupDto) {
        return pcService.editPcModelGroup(pcModelGroupDto);
    }



}
