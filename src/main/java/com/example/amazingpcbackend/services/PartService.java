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

//    public void deletePart(Parts part) throws PartsException {
//        try {
//            partsRepository.delete(part);
//
//            if (part.getCategories().getCategoryName().equals("Периферия")) {
//                peripheryRepository.delete(part.getPeriphery());
//            } else if (part.getCategories().getCategoryName().equals("Комплектующие")) {
//
//                String typeAlternativeName = part.getTypes().getTypeName();
//                switch (typeAlternativeName) {
//                    case "cpu": {
//                        cpuRepository.delete(part.getCpu());
//                        break;
//                    }
//                    case "gpu": {
//                        gpuRepository.delete(part.getGpu());
//                        break;
//                    }
//                    case "motherboard": {
//                        motherboardRepository.delete(part.getMotherboard());
//                        break;
//                    }
//                    case "cpu_fan": {
//                        if (part.getCpuAirCooling() != null) {
//                            cpuAirCoolingRepository.delete(part.getCpuAirCooling());
//                        } else if (part.getCpuLiquidCooling() != null) {
//                            cpuLiquidCoolingRepository.delete(part.getCpuLiquidCooling());
//                        }
//                        break;
//                    }
//                    case "ram": {
//                        ramRepository.delete(part.getRam());
//                        break;
//                    }
//                    case "ssd": {
//                        ssdRepository.delete(part.getSsd());
//                        break;
//                    }
//                    case "psu": {
//                        psuRepository.delete(part.getPsu());
//                        break;
//                    }
//                    case "cases": {
//                        casesRepository.delete(part.getCases());
//                        break;
//                    }
//                    case "fan": {
//                        fansRepository.delete(part.getFan());
//                        break;
//                    }
//                }
//            }
//
//        } catch (Exception e) {
//            throw new PartsException("can't delete part", e);
//        }
//    }
//
//    public void addPart(PartAddDto part) throws PartsException {
//
//        try {
//            if (part.getCategory().equals("Периферия")) {
//                Periphery newPeriphery = new Periphery();
//                Periphery periphery = getPeriphery(newPeriphery, part.getPeriphery());
//                peripheryRepository.save(periphery);
//                Parts newPart = new Parts();
//                partsRepository.save(getPart(newPart, part).setPeriphery(periphery));
//            } else if (part.getCategory().equals("Комплектующие")) {
//
//                String type = part.getType();
//
//                switch (type) {
//
//                    case "Процессор": {
//                        Cpu newCpu = new Cpu();
//                        Cpu cpu = getCpu(newCpu, part.getCpu());
//                        cpuRepository.save(cpu);
//                        Parts newPart = new Parts();
//                        partsRepository.save(getPart(newPart, part).setCpu(cpu));
//                        break;
//                    }
//                    case "Видеокарта": {
//                        Gpu newGpu = new Gpu();
//                        Gpu gpu = getGpu(newGpu, part.getGpu());
//                        gpuRepository.save(gpu);
//                        Parts newPart = new Parts();
//                        partsRepository.save(getPart(newPart, part).setGpu(gpu));
//                        break;
//                    }
//                    case "Материнская плата": {
//                        Motherboard newMotherboard = new Motherboard();
//                        Motherboard motherboard = getMotherboard(newMotherboard, part.getMotherboard());
//                        motherboardRepository.save(motherboard);
//                        Parts newPart = new Parts();
//                        partsRepository.save(getPart(newPart, part).setMotherboard(motherboard));
//                        break;
//                    }
//                    case "Охлаждение": {
//                        if (part.getCpuAirCooling() != null) {
//                            CpuAirCooling newCpuAirCooling = new CpuAirCooling();
//                            CpuAirCooling cpuAirCooling = getCpuAirCooling(newCpuAirCooling, part.getCpuAirCooling());
//                            cpuAirCoolingRepository.save(cpuAirCooling);
//                            Parts newPart = new Parts();
//                            partsRepository.save(getPart(newPart, part).setCpuAirCooling(cpuAirCooling));
//                            break;
//                        } else if (part.getCpuLiquidCooling() != null) {
//                            CpuLiquidCooling newCpuLiquidCooling = new CpuLiquidCooling();
//                            CpuLiquidCooling cpuLiquidCooling = getCpuLiquidCooling(newCpuLiquidCooling, part.getCpuLiquidCooling());
//                            cpuLiquidCoolingRepository.save(cpuLiquidCooling);
//                            Parts newPart = new Parts();
//                            partsRepository.save(getPart(newPart, part).setCpuLiquidCooling(cpuLiquidCooling));
//                            break;
//                        }
//                        break;
//                    }
//                    case "Оперативная память": {
//                        Ram newRam = new Ram();
//                        Ram ram = getRam(newRam, part.getRam());
//                        ramRepository.save(ram);
//                        Parts newPart = new Parts();
//                        partsRepository.save(getPart(newPart, part).setRam(ram));
//                        break;
//                    }
//                    case "SSD накопитель": {
//                        Ssd newSsd = new Ssd();
//                        Ssd ssd = getSsd(newSsd, part.getSsd());
//                        ssdRepository.save(ssd);
//                        Parts newPart = new Parts();
//                        partsRepository.save(getPart(newPart, part).setSsd(ssd));
//                        break;
//                    }
//                    case "Блок питания": {
//                        Psu newPsu = new Psu();
//                        Psu psu = getPsu(newPsu, part.getPsu());
//                        psuRepository.save(psu);
//                        Parts newPart = new Parts();
//                        partsRepository.save(getPart(newPart, part).setPsu(psu));
//                        break;
//                    }
//                    case "Корпус": {
//                        Cases newCases = new Cases();
//                        Cases cases = getCases(newCases, part.getCases());
//                        casesRepository.save(cases);
//                        Parts newPart = new Parts();
//                        partsRepository.save(getPart(newPart, part).setCases(cases));
//                        break;
//                    }
//                    case "Вентилятор": {
//                        Fans newFans = new Fans();
//                        Fans fans = getFans(newFans, part.getFan());
//                        fansRepository.save(fans);
//                        Parts newPart = new Parts();
//                        partsRepository.save(getPart(newPart, part).setFan(fans));
//                        break;
//                    }
//                }
//            }
//
//        } catch (Exception e) {
//            throw new PartsException("can't add new part", e);
//        }
//    }
//
//    public void editPart(PartAddDto part) throws PartsException {
//
//        try {
//            if (part.getCategory().equals("Периферия")) {
//                peripheryRepository.findById(part.getPeriphery().getPeripheryId()).ifPresent(object -> {
//                    peripheryRepository.save(getPeriphery(object, part.getPeriphery()));
//                });
//                partsRepository.findByName(part.getName()).ifPresent(object -> {
//                    partsRepository.save(getPart(object, part));
//                });
//            } else if (part.getCategory().equals("Комплектующие")) {
//
//                String type = part.getType();
//
//                switch (type) {
//                    case "Процессор": {
//                        cpuRepository.findById(part.getCpu().getCpuId()).ifPresent(object -> {
//                            cpuRepository.save(getCpu(object, part.getCpu()));
//                            cpuRepository.save(object);
//                        });
//                        updatePart(part);
//                        break;
//                    }
//                    case "Видеокарта": {
//                        gpuRepository.findById(part.getGpu().getGpuId()).ifPresent(object -> {
//                            gpuRepository.save(getGpu(object, part.getGpu()));
//                            gpuRepository.save(object);
//                        });
//                        updatePart(part);
//                        break;
//                    }
//                    case "Материнская плата": {
//                        motherboardRepository.findById(part.getMotherboard().getMotherboardId()).ifPresent(object -> {
//                            motherboardRepository.save(getMotherboard(object, part.getMotherboard()));
//                            motherboardRepository.save(object);
//                        });
//                        updatePart(part);
//                        break;
//                    }
//                    case "Охлаждение": {
//                        if (part.getCpuAirCooling() != null) {
//                            cpuAirCoolingRepository.findById(part.getCpuAirCooling().getCpuAirCoolingId()).ifPresent(object -> {
//                                cpuAirCoolingRepository.save(getCpuAirCooling(object, part.getCpuAirCooling()));
//                                cpuAirCoolingRepository.save(object);
//                            });
//                            updatePart(part);
//                            break;
//                        } else if (part.getCpuLiquidCooling() != null) {
//                            cpuLiquidCoolingRepository.findById(part.getCpuLiquidCooling().getCpuLiquidCoolingId()).ifPresent(object -> {
//                                cpuLiquidCoolingRepository.save(getCpuLiquidCooling(object, part.getCpuLiquidCooling()));
//                                cpuLiquidCoolingRepository.save(object);
//                            });
//                            updatePart(part);
//                            break;
//                        }
//                        break;
//                    }
//                    case "Оперативная память": {
//                        ramRepository.findById(part.getRam().getRamId()).ifPresent(object -> {
//                            ramRepository.save(getRam(object, part.getRam()));
//                            ramRepository.save(object);
//                        });
//                        updatePart(part);
//                        break;
//                    }
//                    case "SSD накопитель": {
//                        ssdRepository.findById(part.getSsd().getSsdId()).ifPresent(object -> {
//                            ssdRepository.save(getSsd(object, part.getSsd()));
//                            ssdRepository.save(object);
//                        });
//                        updatePart(part);
//                        break;
//                    }
//                    case "Блок питания": {
//                        psuRepository.findById(part.getPsu().getPsuId()).ifPresent(object -> {
//                            psuRepository.save(getPsu(object, part.getPsu()));
//                            psuRepository.save(object);
//                        });
//                        updatePart(part);
//                        break;
//                    }
//                    case "Корпус": {
//                        casesRepository.findById(part.getCases().getCaseId()).ifPresent(object -> {
//                            casesRepository.save(getCases(object, part.getCases()));
//                            casesRepository.save(object);
//                        });
//                        updatePart(part);
//                        break;
//                    }
//                    case "Вентилятор": {
//                        fansRepository.findById(part.getFan().getFanId()).ifPresent(object -> {
//                            fansRepository.save(getFans(object, part.getFan()));
//                            fansRepository.save(object);
//                        });
//                        updatePart(part);
//                        break;
//                    }
//                }
//            }
//
//        } catch (Exception e) {
//            throw new PartsException("can't add new part", e);
//        }
//    }

    public List<Parts> getAllParts() {
        return partsRepository.findAll();
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
