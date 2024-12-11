package com.example.amazingpcbackend.services;

import com.example.amazingpcbackend.dto.PartAddDto;
import com.example.amazingpcbackend.entity.*;
import com.example.amazingpcbackend.exceptions.PartsException;
import com.example.amazingpcbackend.repo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PartService {

    private final PartsRepository partsRepository;

    private final CpuRepository cpuRepository;
    private final GpuRepository gpuRepository;
    private final MotherboardRepository motherboardRepository;
    private final CpuLiquidCoolingRepository cpuLiquidCoolingRepository;
    private final CpuAirCoolingRepository cpuAirCoolingRepository;
    private final RamRepository ramRepository;
    private final SsdRepository ssdRepository;
    private final PsuRepository psuRepository;
    private final CasesRepository casesRepository;
    private final FansRepository fansRepository;
    private final PeripheryRepository peripheryRepository;

    private final CategoriesRepository categoriesRepository;
    private final TypesRepository typesRepository;
    private final PartitionsRepository partitionsRepository;

    public void deletePart(Long partId) throws PartsException {
        try {
            Parts part = partsRepository.findById(partId).get();

            if (part.getCategories().getCategoryName().equals("Периферия")) {
                peripheryRepository.deleteById(partId);
            } else if (part.getCategories().getCategoryName().equals("Комплектующие")) {

                String typeAlternativeName = part.getTypes().getTypeName();
                switch (typeAlternativeName) {
                    case "cpu": {
                        cpuRepository.deleteById(partId);
                        break;
                    }
                    case "gpu": {
                        gpuRepository.deleteById(partId);
                        break;
                    }
                    case "motherboard": {
                        motherboardRepository.deleteById(partId);
                        break;
                    }
                    case "cpu_fan": {
                        if (cpuAirCoolingRepository.findById(partId).isPresent()) {
                            cpuAirCoolingRepository.deleteById(partId);
                        } else if (cpuLiquidCoolingRepository.findById(partId).isPresent()) {
                            cpuLiquidCoolingRepository.deleteById(partId);
                        }
                        break;
                    }
                    case "ram": {
                        ramRepository.deleteById(partId);
                        break;
                    }
                    case "ssd": {
                        ssdRepository.deleteById(partId);
                        break;
                    }
                    case "psu": {
                        psuRepository.deleteById(partId);
                        break;
                    }
                    case "cases": {
                        casesRepository.deleteById(partId);
                        break;
                    }
                    case "fan": {
                        fansRepository.deleteById(partId);
                        break;
                    }
                }
            }

        } catch (Exception e) {
            throw new PartsException("can't delete part", e);
        }
    }

    public void addPart(PartAddDto part) throws PartsException {

        try {
            if (part.getCategory().equals("Периферия")) {
                Periphery newPeriphery = new Periphery();
                Periphery periphery = addPartsFields(getPeriphery(newPeriphery, part.getPeriphery()), part);
                peripheryRepository.save(periphery);
            } else if (part.getCategory().equals("Комплектующие")) {

                String type = part.getType();

                switch (type) {
                    case "Процессор": {
                        Cpu newCpu = new Cpu();
                        Cpu cpu = addPartsFields(getCpu(newCpu, part.getCpu()), part);
                        cpuRepository.save(cpu);
                        break;
                    }
                    case "Видеокарта": {
                        Gpu newGpu = new Gpu();
                        Gpu gpu = addPartsFields(getGpu(newGpu, part.getGpu()), part);
                        gpuRepository.save(gpu);
                        break;
                    }
                    case "Материнская плата": {
                        Motherboard newMotherboard = new Motherboard();
                        Motherboard motherboard = addPartsFields(getMotherboard(newMotherboard, part.getMotherboard()), part);
                        motherboardRepository.save(motherboard);
                        break;
                    }
                    case "Охлаждение": {
                        if (part.getCpuAirCooling() != null) {
                            CpuAirCooling newCpuAirCooling = new CpuAirCooling();
                            CpuAirCooling cpuAirCooling = addPartsFields(getCpuAirCooling(newCpuAirCooling, part.getCpuAirCooling()), part);
                            cpuAirCoolingRepository.save(cpuAirCooling);
                            break;
                        } else if (part.getCpuLiquidCooling() != null) {
                            CpuLiquidCooling newCpuLiquidCooling = new CpuLiquidCooling();
                            CpuLiquidCooling cpuLiquidCooling = addPartsFields(getCpuLiquidCooling(newCpuLiquidCooling, part.getCpuLiquidCooling()), part);
                            cpuLiquidCoolingRepository.save(cpuLiquidCooling);
                            break;
                        }
                        break;
                    }
                    case "Оперативная память": {
                        Ram newRam = new Ram();
                        Ram ram = addPartsFields(getRam(newRam, part.getRam()), part);
                        ramRepository.save(ram);
                        break;
                    }
                    case "SSD накопитель": {
                        Ssd newSsd = new Ssd();
                        Ssd ssd = addPartsFields(getSsd(newSsd, part.getSsd()), part);
                        ssdRepository.save(ssd);
                        break;
                    }
                    case "Блок питания": {
                        Psu newPsu = new Psu();
                        Psu psu = addPartsFields(getPsu(newPsu, part.getPsu()), part);
                        psuRepository.save(psu);
                        break;
                    }
                    case "Корпус": {
                        Cases newCases = new Cases();
                        Cases cases = addPartsFields(getCases(newCases, part.getCases()), part);
                        casesRepository.save(cases);
                        break;
                    }
                    case "Вентилятор": {
                        Fans newFans = new Fans();
                        Fans fans = addPartsFields(getFans(newFans, part.getFan()), part);
                        fansRepository.save(fans);
                        break;
                    }
                }
            }

        } catch (Exception e) {
            throw new PartsException("can't add new part", e);
        }
    }

    public void editPart(PartAddDto part) throws PartsException {

        try {
            if (part.getCategory().equals("Периферия")) {
                Periphery periphery = peripheryRepository.findById(part.getPartId()).get();
                peripheryRepository.save(addPartsFields(getPeriphery(periphery, part.getPeriphery()), part));
            } else if (part.getCategory().equals("Комплектующие")) {
                String type = part.getType();
                switch (type) {
                    case "Процессор": {
                        Cpu cpu = cpuRepository.findById(part.getPartId()).get();
                        cpuRepository.save(addPartsFields(getCpu(cpu, part.getCpu()), part));
                        break;
                    }
                    case "Видеокарта": {
                        Gpu gpu = gpuRepository.findById(part.getPartId()).get();
                        gpuRepository.save(addPartsFields(getGpu(gpu, part.getGpu()), part));
                        break;
                    }
                    case "Материнская плата": {
                        Motherboard motherboard = motherboardRepository.findById(part.getPartId()).get();
                        motherboardRepository.save(addPartsFields(getMotherboard(motherboard, part.getMotherboard()), part));
                        break;
                    }
                    case "Охлаждение": {
                        if (part.getCpuAirCooling() != null) {
                            CpuAirCooling cpuAirCooling = cpuAirCoolingRepository.findById(part.getPartId()).get();
                            cpuAirCoolingRepository.save(addPartsFields(getCpuAirCooling(cpuAirCooling, part.getCpuAirCooling()), part));
                            break;
                        } else if (part.getCpuLiquidCooling() != null) {
                            CpuLiquidCooling cpuLiquidCooling = cpuLiquidCoolingRepository.findById(part.getPartId()).get();
                            cpuLiquidCoolingRepository.save(addPartsFields(getCpuLiquidCooling(cpuLiquidCooling, part.getCpuLiquidCooling()), part));
                            break;
                        }
                        break;
                    }
                    case "Оперативная память": {
                        Ram ram = ramRepository.findById(part.getPartId()).get();
                        ramRepository.save(addPartsFields(getRam(ram, part.getRam()), part));
                        break;
                    }
                    case "SSD накопитель": {
                        Ssd ssd = ssdRepository.findById(part.getPartId()).get();
                        ssdRepository.save(addPartsFields(getSsd(ssd, part.getSsd()), part));
                        break;
                    }
                    case "Блок питания": {
                        Psu psu = psuRepository.findById(part.getPartId()).get();
                        psuRepository.save(addPartsFields(getPsu(psu, part.getPsu()), part));
                        break;
                    }
                    case "Корпус": {
                        Cases cases = casesRepository.findById(part.getPartId()).get();
                        casesRepository.save(addPartsFields(getCases(cases, part.getCases()), part));
                        break;
                    }
                    case "Вентиляторы": {
                        Fans fans = fansRepository.findById(part.getPartId()).get();
                        fansRepository.save(addPartsFields(getFans(fans, part.getFan()), part));
                        break;
                    }
                }
            }

        } catch (Exception e) {
            throw new PartsException("can't add new part", e);
        }
    }

    public List<Parts> getAllParts() {
        return partsRepository.findAll();
    }

    private <T extends Parts> T addPartsFields(T part, PartAddDto partAddDto) {
        part.setName(partAddDto.getName());
        part.setPrice(partAddDto.getPrice());
        Categories categories = categoriesRepository.findByCategoryName(partAddDto.getCategory()).get();
        part.setCategories(categories);
        Types types = typesRepository.findByAlternativeName(partAddDto.getType()).get();
        part.setTypes(types);
        Partitions partitions = partitionsRepository.findByPartitionName(partAddDto.getPartition()).get();
        part.setPartitions(partitions);
        part.setDescription(partAddDto.getDescription());
        part.setImage(partAddDto.getImage());
        part.setRemainingQuantity(partAddDto.getRemainingQuantity());
        return part;
    }

    private void updatePart(PartAddDto part) {
        partsRepository.findById(part.getPartId()).ifPresent(object -> {
            partsRepository.save(getPart(object, part));
        });
    }

    private Parts getPart(Parts newPart, PartAddDto part) {
        newPart.setName(part.getName());
        newPart.setImage(part.getImage());
        newPart.setDescription(part.getDescription());
        newPart.setPrice(part.getPrice());
        newPart.setRemainingQuantity(part.getRemainingQuantity());
        newPart.setCategories(categoriesRepository.findByCategoryName(part.getCategory()).orElse(null));
        newPart.setTypes(typesRepository.findByAlternativeName(part.getType()).orElse(null));
        newPart.setPartitions(partitionsRepository.findByPartitionName(part.getPartition()).orElse(null));
        return newPart;
    }

    private static Cpu getCpu(Cpu newCpu, Cpu cpu) {
        newCpu.setBaseFrequency(cpu.getBaseFrequency());
        newCpu.setBoostFrequency(cpu.getBoostFrequency());
        newCpu.setCpuCores(cpu.getCpuCores());
        newCpu.setCpuThreads(cpu.getCpuThreads());
        newCpu.setMaxRamCapacity(cpu.getMaxRamCapacity());
        newCpu.setTdp(cpu.getTdp());
        newCpu.setCacheL1(cpu.getCacheL1());
        newCpu.setCacheL2(cpu.getCacheL2());
        newCpu.setCacheL3(cpu.getCacheL3());
        newCpu.setSocket(cpu.getSocket());
        newCpu.setTechProcess(cpu.getTechProcess());
        newCpu.setRamType(cpu.getRamType());
        return newCpu;
    }

    private static Gpu getGpu(Gpu newGpu, Gpu gpu) {
        newGpu.setBaseFrequency(gpu.getBaseFrequency());
        newGpu.setBoostFrequency(gpu.getBoostFrequency());
        newGpu.setTechProcess(gpu.getTechProcess());
        newGpu.setMaxDisplaysQuantity(gpu.getMaxDisplaysQuantity());
        newGpu.setMaxResolution(gpu.getMaxResolution());
        newGpu.setVramCapacity(gpu.getVramCapacity());
        newGpu.setVramType(gpu.getVramType());
        newGpu.setBusWidth(gpu.getBusWidth());
        newGpu.setHdmi(gpu.getHdmi());
        newGpu.setDisplayPort(gpu.getDisplayPort());
        newGpu.setCuda(gpu.getCuda());
        newGpu.setPowerConnector(gpu.getPowerConnector());
        newGpu.setMinPowerUnit(gpu.getMinPowerUnit());
        newGpu.setFans(gpu.getFans());
        newGpu.setExtensionSlots(gpu.getExtensionSlots());
        newGpu.setLength(gpu.getLength());
        newGpu.setWidth(gpu.getWidth());
        newGpu.setHeight(gpu.getHeight());
        return newGpu;
    }

    private static Motherboard getMotherboard(Motherboard newMotherboard, Motherboard motherboard) {
        newMotherboard.setSocket(motherboard.getSocket());
        newMotherboard.setFormFactor(motherboard.getFormFactor());
        newMotherboard.setChipset(motherboard.getChipset());
        newMotherboard.setRamType(motherboard.getRamType());
        newMotherboard.setRamSlots(motherboard.getRamSlots());
        newMotherboard.setMaxRamCapacity(motherboard.getMaxRamCapacity());
        newMotherboard.setSataQuantity(motherboard.getSataQuantity());
        newMotherboard.setM2Quantity(motherboard.getM2Quantity());
        newMotherboard.setPcie16Quantity(motherboard.getPcie16Quantity());
        return newMotherboard;
    }

    private static CpuAirCooling getCpuAirCooling(CpuAirCooling newCpuAirCooling, CpuAirCooling cpuAirCooling) {
        newCpuAirCooling.setSockets(cpuAirCooling.getSockets());
        newCpuAirCooling.setFansQuantity(cpuAirCooling.getFansQuantity());
        newCpuAirCooling.setFanSize(cpuAirCooling.getFanSize());
        newCpuAirCooling.setTdp(cpuAirCooling.getTdp());
        newCpuAirCooling.setBacklight(cpuAirCooling.getBacklight());
        newCpuAirCooling.setHeight(cpuAirCooling.getHeight());
        newCpuAirCooling.setFanSpeed(cpuAirCooling.getFanSpeed());
        newCpuAirCooling.setAirFlow(cpuAirCooling.getAirFlow());
        newCpuAirCooling.setMaxNoiseLevel(cpuAirCooling.getMaxNoiseLevel());
        newCpuAirCooling.setConnector(cpuAirCooling.getConnector());
        return newCpuAirCooling;
    }

    private static CpuLiquidCooling getCpuLiquidCooling(CpuLiquidCooling newCpuLiquidCooling, CpuLiquidCooling cpuLiquidCooling) {
        newCpuLiquidCooling.setSockets(cpuLiquidCooling.getSockets());
        newCpuLiquidCooling.setFansQuantity(cpuLiquidCooling.getFansQuantity());
        newCpuLiquidCooling.setFanSize(cpuLiquidCooling.getFanSize());
        newCpuLiquidCooling.setTdp(cpuLiquidCooling.getTdp());
        newCpuLiquidCooling.setBacklight(cpuLiquidCooling.getBacklight());
        newCpuLiquidCooling.setLength(cpuLiquidCooling.getLength());
        newCpuLiquidCooling.setWidth(cpuLiquidCooling.getWidth());
        newCpuLiquidCooling.setHeight(cpuLiquidCooling.getHeight());
        newCpuLiquidCooling.setFanSpeed(cpuLiquidCooling.getFanSpeed());
        newCpuLiquidCooling.setAirFlow(cpuLiquidCooling.getAirFlow());
        newCpuLiquidCooling.setMaxNoiseLevel(cpuLiquidCooling.getMaxNoiseLevel());
        newCpuLiquidCooling.setConnector(cpuLiquidCooling.getConnector());
        return newCpuLiquidCooling;
    }

    private static Ram getRam(Ram newRam, Ram ram) {
        newRam.setType(ram.getType());
        newRam.setFrequency(ram.getFrequency());
        newRam.setCapacity(ram.getCapacity());
        return newRam;
    }

    private static Ssd getSsd(Ssd newSsd, Ssd ssd) {
        newSsd.setFormFactor(ssd.getFormFactor());
        newSsd.setCapacity(ssd.getCapacity());
        newSsd.setFlashMemoryType(ssd.getFlashMemoryType());
        newSsd.setControllerType(ssd.getControllerType());
        newSsd.setWriteVelocity(ssd.getWriteVelocity());
        newSsd.setReadVelocity(ssd.getReadVelocity());
        newSsd.setRandomWriteSpeed(ssd.getRandomWriteSpeed());
        newSsd.setConnectionType(ssd.getConnectionType());
        newSsd.setMtbfTime(ssd.getMtbfTime());
        newSsd.setMaxTemperature(ssd.getMaxTemperature());
        return newSsd;
    }

    private static Psu getPsu(Psu newPsu, Psu psu) {
        newPsu.setPower(psu.getPower());
        newPsu.setFormFactor(psu.getFormFactor());
        newPsu.setPfc(psu.getPfc());
        newPsu.setCoolingSystem(psu.getCoolingSystem());
        newPsu.setMbConnector(psu.getMbConnector());
        newPsu.setCpu4Plus4Quantity(psu.getCpu4Plus4Quantity());
        newPsu.setGpu6Plus2Quantity(psu.getGpu6Plus2Quantity());
        newPsu.setSataQuantity(psu.getSataQuantity());
        newPsu.setCertificate(psu.getCertificate());
        newPsu.setModular(psu.getModular());
        return newPsu;
    }

    private static Periphery getPeriphery(Periphery newPeriphery, Periphery periphery) {
        newPeriphery.setCharacteristics(periphery.getCharacteristics());
        return newPeriphery;
    }

    private static Cases getCases(Cases newCases, Cases cases) {
        newCases.setMaxCpuCoolerHeight(cases.getMaxCpuCoolerHeight());
        newCases.setMaxGpuLength(cases.getMaxGpuLength());
        newCases.setMaxLiquidCoolingLength(cases.getMaxLiquidCoolingLength());
        newCases.setHddSlotsQuantity(cases.getHddSlotsQuantity());
        newCases.setSsdSlotsQuantity(cases.getSsdSlotsQuantity());
        newCases.setExtensionSlotsQuantity(cases.getExtensionSlotsQuantity());
        newCases.setLength(cases.getLength());
        newCases.setWidth(cases.getWidth());
        newCases.setHeight(cases.getHeight());
        newCases.setWeight(cases.getWeight());
        newCases.setPossibleFormFactors(cases.getPossibleFormFactors());
        return newCases;
    }

    private static Fans getFans(Fans newFans, Fans fans) {
        newFans.setFanSize(fans.getFanSize());
        newFans.setBacklight(fans.getBacklight());
        newFans.setFanSpeed(fans.getFanSpeed());
        newFans.setAirFlow(fans.getAirFlow());
        newFans.setMaxNoiseLevel(fans.getMaxNoiseLevel());
        return newFans;
    }
}
