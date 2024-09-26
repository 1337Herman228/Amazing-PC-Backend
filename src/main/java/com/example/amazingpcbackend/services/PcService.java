package com.example.amazingpcbackend.services;


import com.example.amazingpcbackend.dto.PcCatalogDto;
import com.example.amazingpcbackend.dto.PcModelGroupCatalogDto;
import com.example.amazingpcbackend.entity.Pc;
import com.example.amazingpcbackend.entity.PcCategories;
import com.example.amazingpcbackend.entity.PcModelGroups;
import com.example.amazingpcbackend.entity.PcTypes;
import com.example.amazingpcbackend.repo.PcCategoriesRepository;
import com.example.amazingpcbackend.repo.PcModelGroupsRepository;
import com.example.amazingpcbackend.repo.PcRepository;
import com.example.amazingpcbackend.repo.PcTypesRepository;
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
    private final PcCategoriesRepository pcCategoriesRepository;

    public PcCatalogDto getGamingPc() {

        Optional<PcTypes> pcTypes = pcTypesRepository.findByType("gaming-pc");

        List<PcModelGroupCatalogDto> pcModelGroupCatalogList = new ArrayList<>();
        List<PcCategories> pcCategoriesList = new ArrayList<>();

        List<PcModelGroups> pcModelGroups = pcModelGroupsRepository.findByPcTypes(pcTypes.get());

        for(PcModelGroups pcModelGroup : pcModelGroups) {
            pcCategoriesList.add(pcModelGroup.getPcCategories());

            List<Pc> pcs = pcRepository.findByPcModelGroup(pcModelGroup);

            if (!pcs.isEmpty()) {
                // Находим минимальную цену
                Pc minPricePc = pcs.stream()
                        .min(Comparator.comparing(Pc::getTotalPrice))
                        .orElse(null);

                // Получаем данные из ПК с минимальной ценой
                float minPrice = minPricePc.getTotalPrice();
                String image = minPricePc.getImage();
                int configurationsCount = pcs.size();

                PcModelGroupCatalogDto pcModelGroupCatalogDto = new PcModelGroupCatalogDto();
                pcModelGroupCatalogDto.setPcModelGroup(pcModelGroup);
                pcModelGroupCatalogDto.setConfigurationsCount(configurationsCount);
                pcModelGroupCatalogDto.setImage(image);
                pcModelGroupCatalogDto.setMinPrice(minPrice);
                pcModelGroupCatalogList.add(pcModelGroupCatalogDto);
            }

        }

        // Удаление дубликатов по имени категории
        pcCategoriesList = new ArrayList<>(pcCategoriesList.stream()
                .collect(Collectors.toMap(
                        PcCategories::getPcCategoryName, // Ключ - имя категории
                        pcCategory -> pcCategory,         // Значение - сам объект
                        (existing, replacement) -> existing // Если ключ уже существует, оставить существующий
                ))
                .values()); // Преобразование обратно в список

        PcCatalogDto pcCatalogDto = new PcCatalogDto();
        pcCatalogDto.setPcCategories(pcCategoriesList);
        pcCatalogDto.setPcModelGroupList(pcModelGroupCatalogList);
        return pcCatalogDto;
    }
}
