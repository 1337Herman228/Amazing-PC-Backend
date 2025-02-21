package com.example.amazingpcbackend.services;


import com.example.amazingpcbackend.dto.*;
import com.example.amazingpcbackend.entity.*;
import com.example.amazingpcbackend.repo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PcService {

    private final PcTypesRepository pcTypesRepository;
    private final PcModelGroupsRepository pcModelGroupsRepository;
    private final PcRepository pcRepository;
    private final PartsRepository partsRepository;
    private final PcCategoriesRepository pcCategoriesRepository;

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

//    public PcCatalogDto getPcCatalog( String pcType) {
//
//        Optional<PcTypes> pcTypes = pcTypesRepository.findByType(pcType);
//
//        List<PcModelGroupCatalogDto> pcModelGroupCatalogList = new ArrayList<>();
//        List<PcCategories> pcCategoriesList = new ArrayList<>();
//
//        List<PcModelGroups> pcModelGroups = pcModelGroupsRepository.findByPcTypes(pcTypes.get());
//
//        for(PcModelGroups pcModelGroup : pcModelGroups) {
//            pcCategoriesList.add(pcModelGroup.getPcCategories());
//
//            List<Pc> pcs = pcRepository.findByPcModelGroup(pcModelGroup);
//
//            if (!pcs.isEmpty()) {
//                // Находим минимальную цену
//                Pc minPricePc = pcs.stream()
//                        .min(Comparator.comparing(Pc::getTotalPrice))
//                        .orElse(null);
//
//                // Получаем данные из ПК с минимальной ценой
//                PcModelGroupCatalogDto pcModelGroupCatalogDto = getPcModelGroupCatalogDto(pcModelGroup, minPricePc, pcs);
//                pcModelGroupCatalogList.add(pcModelGroupCatalogDto);
//            }
//
//        }
//
//        // Удаление дубликатов по имени категории
//        pcCategoriesList = new ArrayList<>(pcCategoriesList.stream()
//                .collect(Collectors.toMap(
//                        PcCategories::getPcCategoryName, // Ключ - имя категории
//                        pcCategory -> pcCategory,         // Значение - сам объект
//                        (existing, replacement) -> existing // Если ключ уже существует, оставить существующий
//                ))
//                .values()); // Преобразование обратно в список
//
//        PcCatalogDto pcCatalogDto = new PcCatalogDto();
//        pcCatalogDto.setPcCategories(pcCategoriesList);
//        pcCatalogDto.setPcModelGroupList(pcModelGroupCatalogList);
//        return pcCatalogDto;
//    }
//

//
//    private static PcModelGroupCatalogDto getPcModelGroupCatalogDto(PcModelGroups pcModelGroup, Pc minPricePc, List<Pc> pcs) {
//        float minPrice = minPricePc.getTotalPrice();
//        String image = minPricePc.getImage();
//        int configurationsCount = pcs.size();
//
//        PcModelGroupCatalogDto pcModelGroupCatalogDto = new PcModelGroupCatalogDto();
//        pcModelGroupCatalogDto.setPcModelGroup(pcModelGroup);
//        pcModelGroupCatalogDto.setConfigurationsCount(configurationsCount);
//        pcModelGroupCatalogDto.setImage(image);
//        pcModelGroupCatalogDto.setMinPrice(minPrice);
//        return pcModelGroupCatalogDto;
//    }
//
//    public PcDto mapToDto(Pc pc) {
//        if (pc == null) {
//            return null;
//        }
//
//        PcDto pcDto = new PcDto();
//        pcDto.setPcId(pc.getPcId());
//        pcDto.setPcModelGroup(pc.getPcModelGroup() != null ? pc.getPcModelGroup() : null);
//        pcDto.setPcType(pc.getPcType());
//        pcDto.setPcCategories(pc.getPcCategories());
//        pcDto.setName(pc.getName());
//        pcDto.setDescription(pc.getDescription());
//        pcDto.setImage(pc.getImage());
//        pcDto.setTotalPrice(pc.getTotalPrice());
//        pcDto.setGpu(pc.getGpu());
//        pcDto.setCpu(pc.getCpu());
//        pcDto.setMotherboard(pc.getMotherboard());
//        pcDto.setCpuFan(pc.getCpuFan());
//        pcDto.setRam(pc.getRam());
//        pcDto.setPsu(pc.getPsu());
//        pcDto.setPcCase(pc.getPcCase());
//
//        return pcDto;
//    }

}
