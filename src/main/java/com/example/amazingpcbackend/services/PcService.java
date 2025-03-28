package com.example.amazingpcbackend.services;


import com.example.amazingpcbackend.dao.PartWithQuantity;
import com.example.amazingpcbackend.dto.*;
import com.example.amazingpcbackend.entity.*;
import com.example.amazingpcbackend.repo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PcService {

    private final PcTypesRepository pcTypesRepository;
    private final PcModelGroupsRepository pcModelGroupsRepository;
    private final PcRepository pcRepository;
    private final PartsRepository partsRepository;
    private final PcCategoriesRepository pcCategoriesRepository;
    private final UsersRepository usersRepository;


    public List<CatalogDto> getCatalog(PcTypes pcType) {
        List<PcModelGroups> list = pcModelGroupsRepository.findByPcTypes(pcType);
        List<CatalogDto> result = new ArrayList<>();
        for (PcModelGroups pcModelGroup : list) {
            CatalogDto catalogDto  = new CatalogDto();
            catalogDto.setConfigurationsCount(pcRepository.findByPcModelGroup(pcModelGroup).size());
            catalogDto.setMinPrice(pcRepository.findByPcModelGroup(pcModelGroup).stream().min(Comparator.comparing(Pc::getPrice)).get().getPrice());
            catalogDto.setPcModelGroup(pcModelGroup);
            catalogDto.setPc(pcRepository.findByPcModelGroup(pcModelGroup).stream().min(Comparator.comparing(Pc::getPrice)).get());
            result.add(catalogDto);
        }
        return result;
    }

    public List<PcCategories> getNonEmptyPcCategories() {
        List<PcCategories> categories = new ArrayList<>();
        List<PcCategories> allCategories = pcCategoriesRepository.findAll();
        for (PcCategories category : allCategories) {
            if (!pcModelGroupsRepository.findByPcCategories(category).isEmpty()) {
                categories.add(category);
            }
        }
        return categories;
    }

    public List<Pc> getPcsByModelGroupName(String pcModelGroupName) {
        PcModelGroups pcModelGroup = pcModelGroupsRepository.findByModelGroupName(pcModelGroupName).get();

        return pcRepository.findByPcModelGroup(pcModelGroup);
    }

    public Pc createConfiguration(Pc pc, PcConfigurationDto configuration) {

        Parts cpu = partsRepository.findById(configuration.getCpuId()).get();
        Parts gpu = partsRepository.findById(configuration.getGpuId()).get();
        Parts mb = partsRepository.findById(configuration.getMotherboardId()).get();
        Parts cpuFan = partsRepository.findById(configuration.getCpuFanId()).get();
        Parts psu = partsRepository.findById(configuration.getPsuId()).get();
        Parts ram = partsRepository.findById(configuration.getRamId()).get();

        float price = 0;

        pc.setName(configuration.getName());
        pc.setUserCreated(usersRepository.findById(configuration.getUserId()).get());
        pc.setMotherboard(mb);
        pc.setCpu(cpu);
        pc.setCpuFan(cpuFan);
        pc.setGpu(gpu);
        pc.setPsu(psu);
        pc.setRam(ram);

        price += cpu.getPrice();
        price += gpu.getPrice();
        price += mb.getPrice();
        price += cpuFan.getPrice();
        price += psu.getPrice();
        price += ram.getPrice();

        if (configuration.getPcCaseId() != null) {
            Parts pcCase = partsRepository.findById(configuration.getPcCaseId()).get();
            pc.setPcCase(pcCase);
            pc.setImage(pcCase.getImage());
            price += pcCase.getPrice();
        } else {
            pc.setImage("/components/case/no-case.jpg");
        }

        if (!configuration.getSsd().isEmpty()) {
            List<PartWithQuantity> ssd = new ArrayList<>();
            for (PartIdWithQuantity partIdWithQuantity : configuration.getSsd()) {
                Parts part = partsRepository.findById(partIdWithQuantity.getPartId()).get();
                ssd.add(new PartWithQuantity(partIdWithQuantity.getQuantity(), part));
                price += part.getPrice();
            }
            pc.setSsd(ssd);
        }

        if (!configuration.getFans().isEmpty()) {
            List<PartWithQuantity> fans = new ArrayList<>();
            for (PartIdWithQuantity partIdWithQuantity : configuration.getFans()) {
                Parts part = partsRepository.findById(partIdWithQuantity.getPartId()).get();
                fans.add(new PartWithQuantity(partIdWithQuantity.getQuantity(), part));
                price += part.getPrice();
            }
            pc.setFans(fans);
        }

        pc.setPrice(price);
        pc.setPcType(pcTypesRepository.findByValue("configuration").get());
        pcRepository.save(pc);
        return pc;
    }

    public IdDto addPcConfiguration(PcConfigurationDto configuration) {
        try {
            Pc pc = new Pc();
            pc = createConfiguration(pc,configuration);
            IdDto idDto = new IdDto();
            idDto.setId(pc.getId());
            return idDto;
        } catch (Exception e) {
            return null;
        }
    }

    public HttpStatus editPcConfiguration(PcConfigurationDto configuration) {
        try {
            Pc pc = pcRepository.findById(configuration.getId()).get();
            pc = createConfiguration(pc,configuration);
            pcRepository.save(pc);
            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    public List<Pc> getUserConfigurations(Users user) {
        try{
            return pcRepository.findByUserCreated(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public HttpStatus deleteUserConfiguration(String configurationId) {
        try{
            Pc pc = pcRepository.findById(configurationId).get();
            pcRepository.delete(pc);
            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    public Pc getConfiguration(String id) {
        return pcRepository.findById(id).get();
    }

}
