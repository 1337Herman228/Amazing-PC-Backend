package com.example.amazingpcbackend.seeder;

import com.example.amazingpcbackend.dao.CharacteristicValue;
import com.example.amazingpcbackend.dao.PartWithQuantity;
import com.example.amazingpcbackend.entity.*;
import com.example.amazingpcbackend.repo.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DatabaseSeeder {

    @Bean
    CommandLineRunner initDatabase(RolesRepository rolesRepository, PersonRepository personRepository, UsersRepository usersRepository, CategoriesRepository categoriesRepository, PartitionsRepository partitionsRepository, TypesRepository typesRepository, PartsRepository partsRepository, PcTypesRepository pcTypesRepository, PcCategoriesRepository pcCategoriesRepository, PcModelGroupsRepository pcModelGroupsRepository, PcRepository pcRepository, PurchaseItemRepository purchaseItemRepository, PurchasesRepository purchasesRepository, CartItemsRepository cartRepository, CompareItemsRepository compareItemsRepository) {
        return args -> {
            rolesRepository.save(new Roles("role-1", "admin"));
            rolesRepository.save(new Roles("role-2", "user"));

            personRepository.save(new Person("person-1", "admin", "admin", "admin", "admin"));
            personRepository.save(new Person("person-2", "user", "user", "user", "user"));

            usersRepository.save(new Users("user-1", "admin", "adminadmin", rolesRepository.findByPosition("admin").get(), personRepository.findByEmail("admin").get()));
            usersRepository.save(new Users("user-2", "user", "useruser", rolesRepository.findByPosition("user").get(), personRepository.findByEmail("user").get()));

            categoriesRepository.save(new Categories("category-1", "components", "Комплектующие"));
            categoriesRepository.save(new Categories("category-2", "periphery", "Периферия"));

            typesRepository.save(new Types("type-1", "gpu", "Видеокарта", "/svg-icons/gpu.svg"));
            typesRepository.save(new Types("type-2", "cpu", "Процессор", "/svg-icons/cpu.svg"));
            typesRepository.save(new Types("type-3", "motherboard", "Материнская плата", "/svg-icons/motherboard.svg"));
            typesRepository.save(new Types("type-4", "cpu_fan", "Охлаждение", "/svg-icons/cpu_fan.svg"));
            typesRepository.save(new Types("type-5", "ram", "Оперативная память", "/svg-icons/ram.svg"));
            typesRepository.save(new Types("type-6", "ssd", "SSD накопитель", "/svg-icons/ssd.svg"));
            typesRepository.save(new Types("type-7", "psu", "Блок питания", "/svg-icons/psu.svg"));
            typesRepository.save(new Types("type-8", "cases", "Корпус", "/svg-icons/cases.svg"));
            typesRepository.save(new Types("type-9", "fan", "Вентиляторы", "/svg-icons/fan.svg"));
            typesRepository.save(new Types("type-10", "monitor", "Монитор", "/svg-icons/monitor.svg"));
            typesRepository.save(new Types("type-11", "mouse", "Мышь", "/svg-icons/mouse.svg"));
            typesRepository.save(new Types("type-12", "headphones", "Наушники", "/svg-icons/headphones.svg"));

            partitionsRepository.save(new Partitions("partition-1", "RTX 4060", "rtx4060"));
            partitionsRepository.save(new Partitions("partition-2", "Intel Core 12th", "intelcore12th"));
            partitionsRepository.save(new Partitions("partition-3", "Intel Core 14th", "intelcore14th"));
            partitionsRepository.save(new Partitions("partition-4", "RTX 4070", "rtx4070"));
            partitionsRepository.save(new Partitions("partition-5", "RTX 4080", "rtx4080"));
            partitionsRepository.save(new Partitions("partition-6", "Intel B760", "intelb760"));
            partitionsRepository.save(new Partitions("partition-7", "Intel Z790", "intelz790"));
            partitionsRepository.save(new Partitions("partition-8", "Deepcool", "deepcool"));
            partitionsRepository.save(new Partitions("partition-9", "Asus", "asus"));
            partitionsRepository.save(new Partitions("partition-10", "16 ГБ", "16gb"));
            partitionsRepository.save(new Partitions("partition-11", "32 ГБ", "32gb"));
            partitionsRepository.save(new Partitions("partition-12", "64 ГБ", "64gb"));
            partitionsRepository.save(new Partitions("partition-13", "512 ГБ", "512gb"));
            partitionsRepository.save(new Partitions("partition-14", "1 ТБ", "1tb"));
            partitionsRepository.save(new Partitions("partition-15", "2 ТБ", "2tb"));
            partitionsRepository.save(new Partitions("partition-16", "от 500W", "500w"));
            partitionsRepository.save(new Partitions("partition-17", "от 700W", "700w"));
            partitionsRepository.save(new Partitions("partition-18", "от 800W", "800w"));
            partitionsRepository.save(new Partitions("partition-19", "Lian Li", "lianli"));
            partitionsRepository.save(new Partitions("partition-20", "120x120 ММ", "120x120mm"));
            partitionsRepository.save(new Partitions("partition-21", "140x140 ММ", "140x140mm"));
            partitionsRepository.save(new Partitions("partition-22", "24\"", "24inch"));
            partitionsRepository.save(new Partitions("partition-23", "27\"", "27inch"));
            partitionsRepository.save(new Partitions("partition-24", "32\"", "32inch"));
            partitionsRepository.save(new Partitions("partition-25", "Razer", "razer"));

            Map<String, Object> part1config = new HashMap<>();
            part1config.put("base_frequency", new CharacteristicValue<>("Базовая частота", "2500 Мгц"));
            part1config.put("boost_frequency", new CharacteristicValue<>("Турбо частота", "4400 Мгц"));
            part1config.put("cpu_cores", new CharacteristicValue<>("Кол-во ядер", "6"));
            part1config.put("cpu_threads", new CharacteristicValue<>("Кол-во потоков", "12"));
            part1config.put("max_ram_capacity", new CharacteristicValue<>("Макс. объем оперативной памяти", "128 ГБ"));
            part1config.put("tdp", new CharacteristicValue<>("Тепловыделение", "65 Вт"));
            part1config.put("cachel1", new CharacteristicValue<>("Кэш 1-го уровня", null));
            part1config.put("cachel2", new CharacteristicValue<>("Кэш 2-го уровня", "7680 КБ"));
            part1config.put("cachel3", new CharacteristicValue<>("Кэш 3-го уровня", "18432 КБ"));
            part1config.put("socket", new CharacteristicValue<>("Сокет", "LGA 1700"));
            part1config.put("tech_process", new CharacteristicValue<>("Тех-процесс", "7 нм"));
            part1config.put("ram_type", new CharacteristicValue<>("Тех-процесс", Arrays.asList("DDR4", "DDR5")));
            partsRepository.save(new Parts("part-1","I5-12400F", "/uploads/i5-12400f.jpg", "Описание...", 350,part1config, categoriesRepository.findByCategoryValue("components").get(), partitionsRepository.findByPartitionValue("intelcore12th").get(), typesRepository.findByTypeValue("cpu").get()));

            Map<String, Object> part2config = new HashMap<>();
            part2config.put("base_frequency", new CharacteristicValue<>("Базовая частота", "2500 Мгц"));
            part2config.put("boost_frequency", new CharacteristicValue<>("Турбо частота", "4700 Мгц"));
            part2config.put("cpu_cores", new CharacteristicValue<>("Кол-во ядер", "10"));
            part2config.put("cpu_threads", new CharacteristicValue<>("Кол-во потоков", "16"));
            part2config.put("max_ram_capacity", new CharacteristicValue<>("Макс. объем оперативной памяти", "128 ГБ"));
            part2config.put("tdp", new CharacteristicValue<>("Тепловыделение", "65 Вт"));
            part2config.put("cachel1", new CharacteristicValue<>("Кэш 1-го уровня", null));
            part2config.put("cachel2", new CharacteristicValue<>("Кэш 2-го уровня", "9728 КБ"));
            part2config.put("cachel3", new CharacteristicValue<>("Кэш 3-го уровня", "20480 КБ"));
            part2config.put("socket", new CharacteristicValue<>("Сокет", "LGA 1700"));
            part2config.put("tech_process", new CharacteristicValue<>("Тех-процесс", "7 нм"));
            part2config.put("ram_type", new CharacteristicValue<>("Тип ОЗУ", Arrays.asList("DDR4", "DDR5")));
            partsRepository.save(new Parts("part-2", "I5-14400F", "/uploads/i5-14400f.jpg", "Описание...", 450,
                    part2config, categoriesRepository.findByCategoryValue("components").get(),
                    partitionsRepository.findByPartitionValue("intelcore14th").get(),
                    typesRepository.findByTypeValue("cpu").get()));

            Map<String, Object> part3config = new HashMap<>();
            part3config.put("base_frequency", new CharacteristicValue<>("Базовая частота", "2100 Мгц"));
            part3config.put("boost_frequency", new CharacteristicValue<>("Турбо частота", "5400 Мгц"));
            part3config.put("cpu_cores", new CharacteristicValue<>("Кол-во ядер", "20"));
            part3config.put("cpu_threads", new CharacteristicValue<>("Кол-во потоков", "28"));
            part3config.put("max_ram_capacity", new CharacteristicValue<>("Макс. объем оперативной памяти", "128 ГБ"));
            part3config.put("tdp", new CharacteristicValue<>("Тепловыделение", "65 Вт"));
            part3config.put("cachel1", new CharacteristicValue<>("Кэш 1-го уровня", "80 КБ"));
            part3config.put("cachel2", new CharacteristicValue<>("Кэш 2-го уровня", "20 МБ"));
            part3config.put("cachel3", new CharacteristicValue<>("Кэш 3-го уровня", "33 МБ"));
            part3config.put("socket", new CharacteristicValue<>("Сокет", "LGA 1700"));
            part3config.put("tech_process", new CharacteristicValue<>("Тех-процесс", "intel 7"));
            part3config.put("ram_type", new CharacteristicValue<>("Тип ОЗУ", Arrays.asList("DDR4", "DDR5")));
            partsRepository.save(new Parts("part-3", "I7-14700KF", "/uploads/i7-14700kf.jpg", "Описание...", 650,
                    part3config, categoriesRepository.findByCategoryValue("components").get(),
                    partitionsRepository.findByPartitionValue("intelcore14th").get(),
                    typesRepository.findByTypeValue("cpu").get()));

            Map<String, Object> part4config = new HashMap<>();
            part4config.put("base_frequency", new CharacteristicValue<>("Базовая частота", "1830 Мгц"));
            part4config.put("boost_frequency", new CharacteristicValue<>("Турбо частота", "2460 Мгц"));
            part4config.put("bus_width", new CharacteristicValue<>("Шина", "128 бит"));
            part4config.put("cuda", new CharacteristicValue<>("CUDA ядра", "3072"));
            part4config.put("display_port", new CharacteristicValue<>("DisplayPort", "3"));
            part4config.put("extension_slots", new CharacteristicValue<>("Слоты расширения", "2"));
            part4config.put("fans", new CharacteristicValue<>("Вентиляторы", "2"));
            part4config.put("hdmi", new CharacteristicValue<>("HDMI", "1"));
            part4config.put("height", new CharacteristicValue<>("Высота", "40 мм"));
            part4config.put("length", new CharacteristicValue<>("Длина", "249 мм"));
            part4config.put("max_displays_quantity", new CharacteristicValue<>("Макс. кол-во дисплеев", "4"));
            part4config.put("min_power_unit", new CharacteristicValue<>("Мин. мощность блока питания", "500 Вт"));
            part4config.put("tech_process", new CharacteristicValue<>("Тех-процесс", "5 нм"));
            part4config.put("vram_capacity", new CharacteristicValue<>("Видеопамять", "8 ГБ"));
            part4config.put("width", new CharacteristicValue<>("Ширина", "123 мм"));
            part4config.put("max_resolution", new CharacteristicValue<>("Макс. разрешение", "5120x2880"));
            part4config.put("vram_type", new CharacteristicValue<>("Тип видеопамяти", "GDDR6"));
            part4config.put("power_connector", new CharacteristicValue<>("Разъем питания", "8 pin"));
            partsRepository.save(new Parts("part-4", "PALIT GeForce RTX 4060 DUAL", "/uploads/palit-geforce-rtx-4060-dual.jpg", "Описание...", 1050,
                    part4config, categoriesRepository.findByCategoryValue("components").get(),
                    partitionsRepository.findByPartitionValue("rtx4060").get(),
                    typesRepository.findByTypeValue("gpu").get()));

            Map<String, Object> part5config = new HashMap<>();
            part5config.put("base_frequency", new CharacteristicValue<>("Базовая частота", "1980 Мгц"));
            part5config.put("boost_frequency", new CharacteristicValue<>("Турбо частота", "2640 Мгц"));
            part5config.put("bus_width", new CharacteristicValue<>("Шина", "192 бит"));
            part5config.put("cuda", new CharacteristicValue<>("CUDA ядра", "7680"));
            part5config.put("display_port", new CharacteristicValue<>("DisplayPort", "3"));
            part5config.put("extension_slots", new CharacteristicValue<>("Слоты расширения", "3.1"));
            part5config.put("fans", new CharacteristicValue<>("Вентиляторы", "3"));
            part5config.put("hdmi", new CharacteristicValue<>("HDMI", "1"));
            part5config.put("height", new CharacteristicValue<>("Высота", "63.5 мм"));
            part5config.put("length", new CharacteristicValue<>("Длина", "329 мм"));
            part5config.put("max_displays_quantity", new CharacteristicValue<>("Макс. кол-во дисплеев", "4"));
            part5config.put("min_power_unit", new CharacteristicValue<>("Мин. мощность блока питания", "700 Вт"));
            part5config.put("tech_process", new CharacteristicValue<>("Тех-процесс", "5 нм"));
            part5config.put("vram_capacity", new CharacteristicValue<>("Видеопамять", "12 ГБ"));
            part5config.put("width", new CharacteristicValue<>("Ширина", "130 мм"));
            part5config.put("max_resolution", new CharacteristicValue<>("Макс. разрешение", "7680x4320"));
            part5config.put("vram_type", new CharacteristicValue<>("Тип видеопамяти", "GDDR6X"));
            part5config.put("power_connector", new CharacteristicValue<>("Разъем питания", "8+8 pin"));
            partsRepository.save(new Parts("part-5", "Palit GeForce RTX 4070 SUPER JetStream", "/uploads/palit-geforce-rtx-4070-super-jetstream.jpg", "Описание...", 1350,
                    part5config, categoriesRepository.findByCategoryValue("components").get(),
                    partitionsRepository.findByPartitionValue("rtx4070").get(),
                    typesRepository.findByTypeValue("gpu").get()));


            Map<String, Object> part6config = new HashMap<>();
            part6config.put("base_frequency", new CharacteristicValue<>("Базовая частота", "2000 Мгц"));
            part6config.put("boost_frequency", new CharacteristicValue<>("Турбо частота", "2565 Мгц"));
            part6config.put("bus_width", new CharacteristicValue<>("Шина", "256 бит"));
            part6config.put("cuda", new CharacteristicValue<>("CUDA ядра", "10240"));
            part6config.put("display_port", new CharacteristicValue<>("DisplayPort", "2"));
            part6config.put("extension_slots", new CharacteristicValue<>("Слоты расширения", null));
            part6config.put("fans", new CharacteristicValue<>("Вентиляторы", "3"));
            part6config.put("hdmi", new CharacteristicValue<>("HDMI", "2"));
            part6config.put("height", new CharacteristicValue<>("Высота", "62 мм"));
            part6config.put("length", new CharacteristicValue<>("Длина", "322 мм"));
            part6config.put("max_displays_quantity", new CharacteristicValue<>("Макс. кол-во дисплеев", "4"));
            part6config.put("min_power_unit", new CharacteristicValue<>("Мин. мощность блока питания", "850 Вт"));
            part6config.put("tech_process", new CharacteristicValue<>("Тех-процесс", "5 нм"));
            part6config.put("vram_capacity", new CharacteristicValue<>("Видеопамять", "16 ГБ"));
            part6config.put("width", new CharacteristicValue<>("Ширина", "136 мм"));
            part6config.put("max_resolution", new CharacteristicValue<>("Макс. разрешение", "7680x4320"));
            part6config.put("vram_type", new CharacteristicValue<>("Тип видеопамяти", "GDDR6X"));
            part6config.put("power_connector", new CharacteristicValue<>("Разъем питания", "8+8 pin"));
            partsRepository.save(new Parts("part-6", "MSI GeForce RTX 4080 SUPER GAMING SLIM", "/uploads/msi-geforce-rtx-4080-super-gaming-slim.jpg", "Описание...", 1650,
                    part6config, categoriesRepository.findByCategoryValue("components").get(),
                    partitionsRepository.findByPartitionValue("rtx4080").get(),
                    typesRepository.findByTypeValue("gpu").get()));

            Map<String, Object> part7config = new HashMap<>();
            part7config.put("m2quantity", new CharacteristicValue<>("Количество M.2 слотов", "2"));
            part7config.put("max_ram_capacity", new CharacteristicValue<>("Макс. объем оперативной памяти", "128 ГБ"));
            part7config.put("pcie16quantity", new CharacteristicValue<>("Количество PCIe x16 слотов", "2"));
            part7config.put("ram_slots", new CharacteristicValue<>("Количество слотов для RAM", "4"));
            part7config.put("sata_quantity", new CharacteristicValue<>("Количество SATA портов", "4"));
            part7config.put("chipset", new CharacteristicValue<>("Чипсет", "Intel B760"));
            part7config.put("form_factor", new CharacteristicValue<>("Форм-фактор", "microATX"));
            part7config.put("ram_type", new CharacteristicValue<>("Тип RAM", "DDR4"));
            part7config.put("socket", new CharacteristicValue<>("Сокет", "LGA 1700"));
            partsRepository.save(new Parts("part-7", "MSI PRO B760M-A", "/uploads/msi-pro-b760m-a.jpg", "Описание...", 330,
                    part7config, categoriesRepository.findByCategoryValue("components").get(),
                    partitionsRepository.findByPartitionValue("intelb760").get(),
                    typesRepository.findByTypeValue("motherboard").get()));

            Map<String, Object> part8config = new HashMap<>();
            part8config.put("m2quantity", new CharacteristicValue<>("Количество M.2 слотов", "4"));
            part8config.put("max_ram_capacity", new CharacteristicValue<>("Макс. объем оперативной памяти", "128 ГБ"));
            part8config.put("pcie16quantity", new CharacteristicValue<>("Количество PCIe x16 слотов", "3"));
            part8config.put("ram_slots", new CharacteristicValue<>("Количество слотов для RAM", "4"));
            part8config.put("sata_quantity", new CharacteristicValue<>("Количество SATA портов", "6"));
            part8config.put("chipset", new CharacteristicValue<>("Чипсет", "Intel Z790"));
            part8config.put("form_factor", new CharacteristicValue<>("Форм-фактор", "ATX"));
            part8config.put("ram_type", new CharacteristicValue<>("Тип RAM", "DDR5"));
            part8config.put("socket", new CharacteristicValue<>("Сокет", "LGA 1700"));
            partsRepository.save(new Parts("part-8", "MSI PRO Z790-A MAX", "/uploads/msi-pro-z790-a-max.jpg", "Описание...", 450,
                    part8config, categoriesRepository.findByCategoryValue("components").get(),
                    partitionsRepository.findByPartitionValue("intelz790").get(),
                    typesRepository.findByTypeValue("motherboard").get()));

            Map<String, Object> part9config = new HashMap<>();
            part9config.put("air_flow", new CharacteristicValue<>("Воздушный поток", "61.25 CFM"));
            part9config.put("fans_quantity", new CharacteristicValue<>("Количество вентиляторов", "1"));
            part9config.put("height", new CharacteristicValue<>("Высота", "165 мм"));
            part9config.put("max_noise_level", new CharacteristicValue<>("Макс. уровень шума", "23.7 дБ"));
            part9config.put("tdp", new CharacteristicValue<>("TDP", "250 Вт"));
            part9config.put("backlight", new CharacteristicValue<>("Подсветка", "Отсутствует"));
            part9config.put("connector", new CharacteristicValue<>("Коннектор", "4-pin PWM"));
            part9config.put("fan_size", new CharacteristicValue<>("Размер вентилятора", "140x140x25 мм"));
            part9config.put("fan_speed", new CharacteristicValue<>("Скорость вентилятора", "500-1800 об/мин"));
            part9config.put("sockets", new CharacteristicValue<>("Сокеты", Arrays.asList("AM4", "AM5", "LGA 1150", "LGA 1151", "LGA 1155", "LGA 1200", "LGA 1700", "LGA 2011", "LGA 2011-3", "LGA 2066")));
            partsRepository.save(new Parts("part-9", "DeepCool ASSASSIN 4S", "/uploads/deepcool-assassin-4s.jpg", "Описание...", 150,
                    part9config, categoriesRepository.findByCategoryValue("components").get(),
                    partitionsRepository.findByPartitionValue("deepcool").get(),
                    typesRepository.findByTypeValue("cpu_fan").get()));


            Map<String, Object> part10config = new HashMap<>();
            part10config.put("air_flow", new CharacteristicValue<>("Воздушный поток", "70.07 CFM"));
            part10config.put("fans_quantity", new CharacteristicValue<>("Количество вентиляторов", "3"));
            part10config.put("height", new CharacteristicValue<>("Высота", "30 мм"));
            part10config.put("length", new CharacteristicValue<>("Длина", "399.5 мм"));
            part10config.put("max_noise_level", new CharacteristicValue<>("Макс. уровень шума", "36.45 дБ"));
            part10config.put("tdp", new CharacteristicValue<>("TDP", "280 Вт"));
            part10config.put("width", new CharacteristicValue<>("Ширина", "120 мм"));
            part10config.put("backlight", new CharacteristicValue<>("Подсветка", "ARGB"));
            part10config.put("connector", new CharacteristicValue<>("Коннектор", "4-pin PWM"));
            part10config.put("fan_size", new CharacteristicValue<>("Размер вентилятора", "120x120x25 мм"));
            part10config.put("fan_speed", new CharacteristicValue<>("Скорость вентилятора", "2200 +/- 300 RPM"));
            part10config.put("sockets", new CharacteristicValue<>("Сокеты", Arrays.asList("AM4", "AM5", "LGA 1150", "LGA 1151", "LGA 1155", "LGA 1200", "LGA 1700", "LGA 2011", "LGA 2011-3", "LGA 2066")));
            partsRepository.save(new Parts("part-10", "ASUS ROG RYUO III 360 White", "/uploads/asus-rog-ryuo-III-360-white.jpg", "Описание...", 460,
                    part10config, categoriesRepository.findByCategoryValue("components").get(),
                    partitionsRepository.findByPartitionValue("asus").get(),
                    typesRepository.findByTypeValue("cpu_fan").get()));

            Map<String, Object> part11config = new HashMap<>();
            part11config.put("capacity", new CharacteristicValue<>("Емкость", "16 ГБ"));
            part11config.put("frequency", new CharacteristicValue<>("Частота", "3600 МГц"));
            part11config.put("type", new CharacteristicValue<>("Тип", "DDR4"));
            partsRepository.save(new Parts("part-11", "16GB Kingston FURY Beast RGB", "/uploads/16gb-kingston-fury-beast-rgb.jpg", "Описание...", 200,
                    part11config, categoriesRepository.findByCategoryValue("components").get(),
                    partitionsRepository.findByPartitionValue("16gb").get(),
                    typesRepository.findByTypeValue("ram").get()));

            Map<String, Object> part12config = new HashMap<>();
            part12config.put("capacity", new CharacteristicValue<>("Емкость", "32 ГБ"));
            part12config.put("frequency", new CharacteristicValue<>("Частота", "3600 МГц"));
            part12config.put("type", new CharacteristicValue<>("Тип", "DDR4"));
            partsRepository.save(new Parts("part-12", "32GB Kingston FURY Beast RGB", "/uploads/32gb-kingston-fury-beast-rgb.jpg", "Описание...", 320,
                    part12config, categoriesRepository.findByCategoryValue("components").get(),
                    partitionsRepository.findByPartitionValue("32gb").get(),
                    typesRepository.findByTypeValue("ram").get()));

            Map<String, Object> part13config = new HashMap<>();
            part13config.put("capacity", new CharacteristicValue<>("Емкость", "64 ГБ"));
            part13config.put("frequency", new CharacteristicValue<>("Частота", "6000 МГц"));
            part13config.put("type", new CharacteristicValue<>("Тип", "DDR5"));
            partsRepository.save(new Parts("part-13", "64GB TEAMGROUP T-Force Delta RGB White", "/uploads/64gb-teamgroup-t-force-delta-rgb-white.jpg", "Описание...", 600,
                    part13config, categoriesRepository.findByCategoryValue("components").get(),
                    partitionsRepository.findByPartitionValue("64gb").get(),
                    typesRepository.findByTypeValue("ram").get()));

            Map<String, Object> part14config = new HashMap<>();
            part14config.put("capacity", new CharacteristicValue<>("Емкость", "512 ГБ"));
            part14config.put("flash_memory_type", new CharacteristicValue<>("Тип флеш-памяти", "3D NAND"));
            part14config.put("form_factor", new CharacteristicValue<>("Форм-фактор", "M.2 NVME"));
            part14config.put("connection_type", new CharacteristicValue<>("Тип подключения", "PCI-E 4.0 x4"));
            part14config.put("controller_type", new CharacteristicValue<>("Тип контроллера", "Silicon Motion SM2269XT"));
            part14config.put("read_velocity", new CharacteristicValue<>("Скорость чтения", "5000 МБ/с"));
            part14config.put("write_velocity", new CharacteristicValue<>("Скорость записи", "2700 МБ/с"));
            partsRepository.save(new Parts("part-14", "512GB ADATA LEGEND 850", "/uploads/512gb-adata-legend-850.jpg", "Описание...", 230,
                    part14config, categoriesRepository.findByCategoryValue("components").get(),
                    partitionsRepository.findByPartitionValue("512gb").get(),
                    typesRepository.findByTypeValue("ssd").get()));

            Map<String, Object> part15config = new HashMap<>();
            part15config.put("capacity", new CharacteristicValue<>("Емкость", "1 ТБ"));
            part15config.put("flash_memory_type", new CharacteristicValue<>("Тип флеш-памяти", "3D NAND"));
            part15config.put("form_factor", new CharacteristicValue<>("Форм-фактор", "M.2 NVME"));
            part15config.put("connection_type", new CharacteristicValue<>("Тип подключения", "PCI-E 4.0 x4"));
            part15config.put("controller_type", new CharacteristicValue<>("Тип контроллера", "Silicon Motion SM2269XT"));
            part15config.put("read_velocity", new CharacteristicValue<>("Скорость чтения", "5000 МБ/с"));
            part15config.put("write_velocity", new CharacteristicValue<>("Скорость записи", "4500 МБ/с"));
            partsRepository.save(new Parts("part-15", "1TB ADATA LEGEND 850", "/uploads/1tb-adata-legend-850.jpg", "Описание...", 380,
                    part15config, categoriesRepository.findByCategoryValue("components").get(),
                    partitionsRepository.findByPartitionValue("1tb").get(),
                    typesRepository.findByTypeValue("ssd").get()));

            Map<String, Object> part16config = new HashMap<>();
            part16config.put("capacity", new CharacteristicValue<>("Емкость", "2 ТБ"));
            part16config.put("flash_memory_type", new CharacteristicValue<>("Тип флеш-памяти", "MLC 3D NAND"));
            part16config.put("form_factor", new CharacteristicValue<>("Форм-фактор", "M.2 NVME"));
            part16config.put("read_velocity", new CharacteristicValue<>("Скорость чтения", "7450 МБ/с"));
            part16config.put("write_velocity", new CharacteristicValue<>("Скорость записи", "6900 МБ/с"));
            part16config.put("max_temperature", new CharacteristicValue<>("Макс. температура", "70 °C"));
            partsRepository.save(new Parts("part-16", "2TB Samsung 990 PRO", "/uploads/2tb-samsung-990-pro.jpg", "Описание...", 550,
                    part16config, categoriesRepository.findByCategoryValue("components").get(),
                    partitionsRepository.findByPartitionValue("2tb").get(),
                    typesRepository.findByTypeValue("ssd").get()));

            Map<String, Object> part17config = new HashMap<>();
            part17config.put("power", new CharacteristicValue<>("Мощность", "650W"));
            part17config.put("cpu4plus4quantity", new CharacteristicValue<>("Количество 4+4-pin для процессора", "1"));
            part17config.put("gpu6plus2quantity", new CharacteristicValue<>("Количество 6+2-pin для GPU", "2"));
            part17config.put("sata_quantity", new CharacteristicValue<>("Количество SATA разъемов", "5"));
            part17config.put("form_factor", new CharacteristicValue<>("Форм-фактор", "ATX"));
            part17config.put("pfc", new CharacteristicValue<>("PFC", "активный"));
            part17config.put("certificate", new CharacteristicValue<>("Сертификат", "80+ Bronze"));
            part17config.put("modular", new CharacteristicValue<>("Модульность", "Полумодульный"));
            part17config.put("cooling_system", new CharacteristicValue<>("Охлаждающая система", "1 вентилятор (120 мм)"));
            partsRepository.save(new Parts("part-17", "650W DeepCool PK650D", "/uploads/650w-deepcool-pk650d.jpg", "Описание...", 310,
                    part17config, categoriesRepository.findByCategoryValue("components").get(),
                    partitionsRepository.findByPartitionValue("500w").get(),
                    typesRepository.findByTypeValue("psu").get()));

            Map<String, Object> part18config = new HashMap<>();
            part18config.put("power", new CharacteristicValue<>("Мощность", "750W"));
            part18config.put("cpu4plus4quantity", new CharacteristicValue<>("Количество 4+4-pin для процессора", "2"));
            part18config.put("gpu6plus2quantity", new CharacteristicValue<>("Количество 6+2-pin для GPU", "4"));
            part18config.put("sata_quantity", new CharacteristicValue<>("Количество SATA разъемов", "7"));
            part18config.put("form_factor", new CharacteristicValue<>("Форм-фактор", "ATX"));
            part18config.put("pfc", new CharacteristicValue<>("PFC", "активный"));
            part18config.put("certificate", new CharacteristicValue<>("Сертификат", "80+ Bronze"));
            part18config.put("modular", new CharacteristicValue<>("Модульность", "Полумодульный"));
            part18config.put("cooling_system", new CharacteristicValue<>("Охлаждающая система", "1 вентилятор (120 мм)"));
            partsRepository.save(new Parts("part-18", "750W DeepCool PK750D", "/uploads/750w-deepcool-pk750d.jpg", "Описание...", 410,
                    part18config, categoriesRepository.findByCategoryValue("components").get(),
                    partitionsRepository.findByPartitionValue("700w").get(),
                    typesRepository.findByTypeValue("psu").get()));


            Map<String, Object> part19config = new HashMap<>();
            part19config.put("power", new CharacteristicValue<>("Мощность", "850W"));
            part19config.put("cpu4plus4quantity", new CharacteristicValue<>("Количество 4+4-pin для процессора", "2"));
            part19config.put("gpu6plus2quantity", new CharacteristicValue<>("Количество 6+2-pin для GPU", "5"));
            part19config.put("sata_quantity", new CharacteristicValue<>("Количество SATA разъемов", "8"));
            part19config.put("form_factor", new CharacteristicValue<>("Форм-фактор", "ATX12V 3.0"));
            part19config.put("pfc", new CharacteristicValue<>("PFC", "активный"));
            part19config.put("certificate", new CharacteristicValue<>("Сертификат", "80+ Gold"));
            part19config.put("modular", new CharacteristicValue<>("Модульность", "Модульный"));
            part19config.put("cooling_system", new CharacteristicValue<>("Охлаждающая система", "1 вентилятор (120 мм)"));
            partsRepository.save(new Parts("part-19", "850W MSI MAG A850GL", "/uploads/850w-msi-mag-a850gl.jpg", "Описание...", 610,
                    part19config, categoriesRepository.findByCategoryValue("components").get(),
                    partitionsRepository.findByPartitionValue("800w").get(),
                    typesRepository.findByTypeValue("psu").get()));

            Map<String, Object> part20config = new HashMap<>();
            part20config.put("extension_slots_quantity", new CharacteristicValue<>("Количество слотов расширения", "8"));
            part20config.put("hdd_slots_quantity", new CharacteristicValue<>("Количество слотов для HDD", "4"));
            part20config.put("height", new CharacteristicValue<>("Высота", "450 мм"));
            part20config.put("length", new CharacteristicValue<>("Длина", "446 мм"));
            part20config.put("max_cpu_cooler_height", new CharacteristicValue<>("Макс. высота кулера процессора", "163 мм"));
            part20config.put("max_gpu_length", new CharacteristicValue<>("Макс. длина GPU", "400 мм"));
            part20config.put("max_liquid_cooling_length", new CharacteristicValue<>("Макс. длина системы жидкостного охлаждения", "420 мм"));
            part20config.put("ssd_slots_quantity", new CharacteristicValue<>("Количество слотов для SSD", "4"));
            part20config.put("weight", new CharacteristicValue<>("Вес", "11 кг"));
            part20config.put("width", new CharacteristicValue<>("Ширина", "285 мм"));
            part20config.put("possible_form_factors", new CharacteristicValue<>("Поддерживаемые форм-факторы", Arrays.asList("micro-ATX", "mini-ATX", "ATX")));
            partsRepository.save(new Parts("part-20", "ASUS TUF GAMING GT502 White", "/uploads/asus-tuf-gaming-gt502-white.jpg", "Описание...", 380,
                    part20config, categoriesRepository.findByCategoryValue("components").get(),
                    partitionsRepository.findByPartitionValue("asus").get(),
                    typesRepository.findByTypeValue("cases").get()));

            Map<String, Object> part21config = new HashMap<>();
            part21config.put("extension_slots_quantity", new CharacteristicValue<>("Количество слотов расширения", "6"));
            part21config.put("hdd_slots_quantity", new CharacteristicValue<>("Количество слотов для HDD", "2"));
            part21config.put("height", new CharacteristicValue<>("Высота", "464 мм"));
            part21config.put("length", new CharacteristicValue<>("Длина", "480 мм"));
            part21config.put("max_cpu_cooler_height", new CharacteristicValue<>("Макс. высота кулера процессора", "174 мм"));
            part21config.put("max_gpu_length", new CharacteristicValue<>("Макс. длина GPU", "430 мм"));
            part21config.put("max_liquid_cooling_length", new CharacteristicValue<>("Макс. длина системы жидкостного охлаждения", "390 мм"));
            part21config.put("ssd_slots_quantity", new CharacteristicValue<>("Количество слотов для SSD", "5"));
            part21config.put("weight", new CharacteristicValue<>("Вес", "18 кг"));
            part21config.put("width", new CharacteristicValue<>("Ширина", "304 мм"));
            part21config.put("possible_form_factors", new CharacteristicValue<>("Поддерживаемые форм-факторы", Arrays.asList("micro-ATX", "mini-ATX", "ATX")));
            partsRepository.save(new Parts("part-21", "Lian Li O11 Vision White", "/uploads/lian-li-011-vision-white.jpg", "Описание...", 450,
                    part21config, categoriesRepository.findByCategoryValue("components").get(),
                    partitionsRepository.findByPartitionValue("lianli").get(),
                    typesRepository.findByTypeValue("cases").get()));


            Map<String, Object> part22config = new HashMap<>();
            part22config.put("extension_slots_quantity", new CharacteristicValue<>("Количество слотов расширения", "4"));
            part22config.put("hdd_slots_quantity", new CharacteristicValue<>("Количество слотов для HDD", "3"));
            part22config.put("height", new CharacteristicValue<>("Высота", "428 мм"));
            part22config.put("length", new CharacteristicValue<>("Длина", "431 мм"));
            part22config.put("max_cpu_cooler_height", new CharacteristicValue<>("Макс. высота кулера для процессора", "165 мм"));
            part22config.put("max_gpu_length", new CharacteristicValue<>("Макс. длина GPU", "320 мм"));
            part22config.put("max_liquid_cooling_length", new CharacteristicValue<>("Макс. длина жидкостного охлаждения", "270 мм"));
            part22config.put("ssd_slots_quantity", new CharacteristicValue<>("Количество слотов для SSD", "2"));
            part22config.put("weight", new CharacteristicValue<>("Вес", "6 кг"));
            part22config.put("width", new CharacteristicValue<>("Ширина", "215 мм"));
            part22config.put("possible_form_factors", new CharacteristicValue<>("Поддерживаемые форм-факторы", "micro-ATX, mini-ATX"));
            partsRepository.save(new Parts("part-22", "DeepCool CH360", "/uploads/deepcool-ch360.jpg", "Описание...", 200,
                    part22config, categoriesRepository.findByCategoryValue("components").get(),
                    partitionsRepository.findByPartitionValue("deepcool").get(),
                    typesRepository.findByTypeValue("cases").get()));

            Map<String, Object> part23config = new HashMap<>();
            part23config.put("air_flow", new CharacteristicValue<>("Воздушный поток", "59 CFM"));
            part23config.put("max_noise_level", new CharacteristicValue<>("Макс. уровень шума", "27 dB"));
            part23config.put("backlight", new CharacteristicValue<>("Подсветка", "ARGB"));
            part23config.put("fan_size", new CharacteristicValue<>("Размер вентилятора", "120x120 мм"));
            part23config.put("fan_speed", new CharacteristicValue<>("Скорость вентилятора", "800-1800 об/мин"));
            partsRepository.save(new Parts("part-23", "Montech AX 120 PWM White", "/uploads/montech-ax-120-pwm-white.jpg", "Описание...", 60,
                    part23config, categoriesRepository.findByCategoryValue("components").get(),
                    partitionsRepository.findByPartitionValue("120x120mm").get(),
                    typesRepository.findByTypeValue("fan").get()));

            Map<String, Object> part24config = new HashMap<>();
            part24config.put("air_flow", new CharacteristicValue<>("Воздушный поток", "81 CFM"));
            part24config.put("max_noise_level", new CharacteristicValue<>("Макс. уровень шума", "26.8 dB"));
            part24config.put("backlight", new CharacteristicValue<>("Подсветка", "ARGB"));
            part24config.put("fan_size", new CharacteristicValue<>("Размер вентилятора", "140x140 мм"));
            part24config.put("fan_speed", new CharacteristicValue<>("Скорость вентилятора", "250-1600 об/мин"));
            partsRepository.save(new Parts("part-24", "Lian Li UNI FAN AL V2 120 White", "/uploads/lian-li-uni-fan-al-v2-120-white.jpg", "Описание...", 70,
                    part24config, categoriesRepository.findByCategoryValue("components").get(),
                    partitionsRepository.findByPartitionValue("140x140mm").get(),
                    typesRepository.findByTypeValue("fan").get()));


            Map<String, Object> part25config = new HashMap<>();
            part25config.put("air_flow", new CharacteristicValue<>("Воздушный поток", "75 CFM"));
            part25config.put("max_noise_level", new CharacteristicValue<>("Макс. уровень шума", "26.8 dB"));
            part25config.put("backlight", new CharacteristicValue<>("Подсветка", "Отсутствует"));
            part25config.put("fan_size", new CharacteristicValue<>("Размер вентилятора", "120x120 мм"));
            part25config.put("fan_speed", new CharacteristicValue<>("Скорость вентилятора", "500-1600 об/мин"));
            partsRepository.save(new Parts("part-25", "Thermaltake TOUGHFAN 12 White", "/uploads/thermaltake-toughfan-12-white.jpg", "Описание...", 80,
                    part25config, categoriesRepository.findByCategoryValue("components").get(),
                    partitionsRepository.findByPartitionValue("120x120mm").get(),
                    typesRepository.findByTypeValue("fan").get()));

            Map<String, Object> part26config = new HashMap<>();
            part26config.put("diagonal", new CharacteristicValue<>("Диагональ", "24\""));
            part26config.put("resolution", new CharacteristicValue<>("Разрешение", "1920x1080 (16:9)"));
            part26config.put("matrix", new CharacteristicValue<>("Матрица", "IPS"));
            part26config.put("frequency", new CharacteristicValue<>("Частота обновления экрана", "144 Гц"));
            part26config.put("ports", new CharacteristicValue<>("Входы", "DisplayPort, HDMI"));
            partsRepository.save(new Parts("part-26", "LG UltraGear 24GN65R", "/uploads/lg-ultragear-24gn65r.jpg", "Описание...", 350,
                    part26config, categoriesRepository.findByCategoryValue("periphery").get(),
                    partitionsRepository.findByPartitionValue("24inch").get(),
                    typesRepository.findByTypeValue("monitor").get()));

            Map<String, Object> part27config = new HashMap<>();
            part27config.put("buttons_quantity", new CharacteristicValue<>("Количество программируемых клавиш", "5"));
            part27config.put("sensor_model", new CharacteristicValue<>("Модель сенсора", "Razer Focus Pro 30K"));
            part27config.put("sensor_resolution", new CharacteristicValue<>("Разрешение оптического сенсора", "30000 DPI"));
            part27config.put("weight", new CharacteristicValue<>("Вес", "64 г"));
            partsRepository.save(new Parts("part-27", "Razer DeathAdder V3 Pro", "/uploads/razer-deathadder-v3-pro.jpg", "Описание...", 220,
                    part27config, categoriesRepository.findByCategoryValue("periphery").get(),
                    partitionsRepository.findByPartitionValue("razer").get(),
                    typesRepository.findByTypeValue("mouse").get()));

            Map<String, Object> part28config = new HashMap<>();
            part28config.put("connection_type", new CharacteristicValue<>("Тип подключения", "с проводом"));
            part28config.put("microphone", new CharacteristicValue<>("Микрофон с шумоподавлением", "есть"));
            part28config.put("connector", new CharacteristicValue<>("Разъем", "USB"));
            part28config.put("weight", new CharacteristicValue<>("Вес", "250 г"));
            partsRepository.save(new Parts("part-28", "Razer Kraken V3", "/uploads/razer-kraken-v3.jpg", "Описание...", 300,
                    part28config, categoriesRepository.findByCategoryValue("periphery").get(),
                    partitionsRepository.findByPartitionValue("razer").get(),
                    typesRepository.findByTypeValue("headphones").get()));

            pcTypesRepository.save(new PcTypes("pc-type-1", "gaming-pc", "Игровой ПК"));
            pcTypesRepository.save(new PcTypes("pc-type-2", "notebook", "Ноутбук"));
            pcTypesRepository.save(new PcTypes("pc-type-3", "workstation", "Рабочая станция"));
            pcTypesRepository.save(new PcTypes("pc-type-4", "configuration", "Конфигурация"));

            pcCategoriesRepository.save(new PcCategories("pc-category-1", "none", "Нет категории", null));
            pcCategoriesRepository.save(new PcCategories("pc-category-2", "optimal-gaming-pc", "Оптимальные игровые компьютеры",
                    "Современные игровые компьютеры с процессорами Intel Core и видеокартами NVIDIA GeForce RTX предлагают идеальное сочетание производительности и стоимости. Максимум эффективности."));
            pcCategoriesRepository.save(new PcCategories("pc-category-3", "powerful-gaming-pc", "Мощные игровые компьютеры",
                    "Мощные игровые компьютеры для максимальных настроек графики в играх, на базе процессоров Intel Core и видеокарт NVIDIA GeForce RTX. Отлично подходят для киберспортивных игроков и геймеров, ценящих плавность игрового процесса с высоким FPS на максимальных графических настройках. Выбор чемпионов."));
            pcCategoriesRepository.save(new PcCategories("pc-category-4", "custom-gaming-pc", "Кастомные компьютеры",
                    "Эксклюзивная линейка компьютеров для тех, кто не ищет компромиссов в играх. Конфигурации на основе самых мощных процессоров Intel Core и видеокарт NVIDIA GeForce RTX обеспечивают высший уровень производительности, уникальные корпуса с RGB-подсветкой и системой водяного охлаждения. Персонализированные варианты для самых изысканных геймеров." ));
            pcCategoriesRepository.save(new PcCategories("pc-category-5", "gaming-mini-pc", "Игровые мини ПК",
                    "Добро пожаловать в эпоху компактных игровых компьютеров нового поколения! Это воплощение мощи и стиля в одном устройстве. Оформленные в современном дизайне, они скрывает в себе потрясающую производительность, способную обеспечить вас плавным геймплеем на максимальных настройках графики."));
            pcCategoriesRepository.save(new PcCategories("pc-category-6", "optimal-workstation", "Оптимальные рабочие станции",
                    "Современные рабочие компьютеры с процессорами Intel Core и видеокартами NVIDIA GeForce RTX предлагают идеальное сочетание производительности и стоимости для профессиональных задач. Они обеспечивают максимум эффективности для работы с графическими и многозадачными приложениями без лишних затрат."));


            PcTypes gamingPcType = pcTypesRepository.findById("pc-type-1").orElseThrow();
            PcTypes notebookType = pcTypesRepository.findById("pc-type-2").orElseThrow();
            PcTypes workstationType = pcTypesRepository.findById("pc-type-3").orElseThrow();

            PcCategories optimalGamingCategory = pcCategoriesRepository.findById("pc-category-2").orElseThrow();
            PcCategories powerfulGamingCategory = pcCategoriesRepository.findById("pc-category-3").orElseThrow();
            PcCategories customGamingCategory = pcCategoriesRepository.findById("pc-category-4").orElseThrow();
            PcCategories gamingMiniCategory = pcCategoriesRepository.findById("pc-category-5").orElseThrow();
            PcCategories optimalWorkstationCategory = pcCategoriesRepository.findById("pc-category-6").orElseThrow();

            pcModelGroupsRepository.save(new PcModelGroups(
                    "pc-model-group-1", gamingPcType, optimalGamingCategory,
                    "One", "Начальный игровой компьютер",
                    "Процессоры 6 и 10 ядерные Intel Core i5",
                    "Графические карты GeForce RTX 4060 и 4060 Ti",
                    "Материнские платы на чипсете Intel B760",
                    "Блок питания на 550W / 650W стандарта 80+ Bronze",
                    "Оперативная память от 16 до 32 GB DDR4 3600MHz",
                    "Накопители SSD на 512 GB / 1 TB с интерфейсом М.2",
                    "Платформа для гейминга в Full HD разрешении, созданная на базе центрального процессора Intel® Core™ i5-12400F [до 4.4GHz, 6 ядер] и видеокарты Palit GeForce RTX 4060 Ti Dual [8GB, 4352 CUDA].",
                    "/single-product/one/hyperpc-one-banner.jpg", "/single-product/one/hyperpc-one-mobile.jpg",
                    "Современный дизайн", "HYPERPC ONE разработан для тех, кто ценит не только мощность, но и эстетику. Компактный корпус сочетает в себе премиальные материалы и продуманное охлаждение, создавая идеальное сочетание функциональности и стиля.",
                    "/single-product/one/hyperpc-one-block-design.jpg",
                    "Мощность", "HYPERPC ONE оснащён современными комплектующими, которые обеспечивают отличную производительность как в играх, так и при решении творческих задач.",
                    "/single-product/one/hyperpc-one-block-performance.jpg", "/pc/performance/performance-1.2"
            ));

            pcModelGroupsRepository.save(new PcModelGroups(
                    "pc-model-group-2", gamingPcType, powerfulGamingCategory,
                    "Lumen Core", "Начальный игровой компьютер",
                    "Процессоры 6 и 10 ядерные Intel Core i5",
                    "Графические карты GeForce RTX 4060 и 4060 Ti",
                    "Материнские платы на чипсете Intel B760",
                    "Блок питания на 550W / 650W стандарта 80+ Bronze",
                    "Оперативная память от 16 до 32 GB DDR4 3600MHz",
                    "Накопители SSD на 512 GB / 1 TB с интерфейсом М.2",
                    "Платформа для гейминга в Full HD разрешении, созданная на базе центрального процессора Intel® Core™ i5-12400F [до 4.4GHz, 6 ядер] и видеокарты Palit GeForce RTX 4060 Ti Dual [8GB, 4352 CUDA].",
                    "/single-product/one/hyperpc-one-banner.jpg", "/single-product/one/hyperpc-one-mobile.jpg",
                    "Современный дизайн", "HYPERPC ONE разработан для тех, кто ценит не только мощность, но и эстетику. Компактный корпус сочетает в себе премиальные материалы и продуманное охлаждение, создавая идеальное сочетание функциональности и стиля.",
                    "/single-product/one/hyperpc-one-block-design.jpg",
                    "Мощность", "HYPERPC ONE оснащён современными комплектующими, которые обеспечивают отличную производительность как в играх, так и при решении творческих задач.",
                    "/single-product/one/hyperpc-one-block-performance.jpg", "/pc/performance/performance-1.2"
            ));

            pcModelGroupsRepository.save(new PcModelGroups(
                    "pc-model-group-3", gamingPcType, customGamingCategory,
                    "Fury", "Начальный игровой компьютер",
                    "Процессоры 6 и 10 ядерные Intel Core i5",
                    "Графические карты GeForce RTX 4060 и 4060 Ti",
                    "Материнские платы на чипсете Intel B760",
                    "Блок питания на 550W / 650W стандарта 80+ Bronze",
                    "Оперативная память от 16 до 32 GB DDR4 3600MHz",
                    "Накопители SSD на 512 GB / 1 TB с интерфейсом М.2",
                    "Платформа для гейминга в Full HD разрешении, созданная на базе центрального процессора Intel® Core™ i5-12400F [до 4.4GHz, 6 ядер] и видеокарты Palit GeForce RTX 4060 Ti Dual [8GB, 4352 CUDA].",
                    "/single-product/one/hyperpc-one-banner.jpg", "/single-product/one/hyperpc-one-mobile.jpg",
                    "Современный дизайн", "HYPERPC ONE разработан для тех, кто ценит не только мощность, но и эстетику. Компактный корпус сочетает в себе премиальные материалы и продуманное охлаждение, создавая идеальное сочетание функциональности и стиля.",
                    "/single-product/one/hyperpc-one-block-design.jpg",
                    "Мощность", "HYPERPC ONE оснащён современными комплектующими, которые обеспечивают отличную производительность как в играх, так и при решении творческих задач.",
                    "/single-product/one/hyperpc-one-block-performance.jpg", "/pc/performance/performance-1.2"
            ));

            pcModelGroupsRepository.save(new PcModelGroups(
                    "pc-model-group-4", notebookType, gamingMiniCategory,
                    "Play 17", "Игровые ноутбки HYPERPC",
                    "Процессоры 6 и 10 ядерные Intel Core i5",
                    "Графические карты GeForce RTX 4060 и 4060 Ti",
                    null, null,
                    "Оперативная память от 16 до 32 GB DDR4 3600MHz",
                    "Накопители SSD на 512 GB / 1 TB с интерфейсом М.2",
                    "Игровые ноутбуки для максимальной мобильности и производительности.",
                    "/single-product/one/hyperpc-one-banner.jpg", "/single-product/one/hyperpc-one-mobile.jpg",
                    "Современный дизайн", "Компактные и мощные, эти ноутбуки созданы для современных игр и мультимедийных задач.",
                    "/single-product/one/hyperpc-one-block-design.jpg",
                    "Мощность", "Оборудованы современными комплектующими, которые обеспечивают отличную производительность как в играх, так и при решении творческих задач.",
                    "/single-product/one/hyperpc-one-block-performance.jpg", "/pc/performance/performance-1.2"
            ));

            pcModelGroupsRepository.save(new PcModelGroups(
                    "pc-model-group-5", workstationType, optimalWorkstationCategory,
                    "G1 PRO", "Для графических дизайнеров",
                    "Процессоры 6 и 10 ядерные Intel Core i5",
                    "Графические карты GeForce RTX 4060 и 4060 Ti",
                    "Материнские платы на чипсете Intel B760",
                    "Блок питания на 550W / 650W стандарта 80+ Bronze",
                    "Оперативная память от 16 до 32 GB DDR4 3600MHz",
                    "Накопители SSD на 512 GB / 1 TB с интерфейсом М.2",
                    "Создан для графических дизайнеров, обеспечивая стабильную работу с тяжёлыми графическими приложениями.",
                    "/single-product/one/hyperpc-one-banner.jpg", "/single-product/one/hyperpc-one-mobile.jpg",
                    "Современный дизайн", "Компактный и стильный дизайн, оптимизированный для творческих профессионалов.",
                    "/single-product/one/hyperpc-one-block-design.jpg",
                    "Мощность", "Высокая производительность для работы с графикой, видео и другими ресурсозатратными задачами.",
                    "/single-product/one/hyperpc-one-block-performance.jpg", "/pc/performance/performance-1.2"
            ));

// Parts
            Parts cpuPart = partsRepository.findById("part-1").orElseThrow();
            Parts gpuPart = partsRepository.findById("part-4").orElseThrow();
            Parts cpuFan = partsRepository.findById("part-9").orElseThrow();
            Parts motherboardPart = partsRepository.findById("part-7").orElseThrow();
            Parts psuPart = partsRepository.findById("part-18").orElseThrow();
            Parts ramPart = partsRepository.findById("part-12").orElseThrow();
            Parts casePart = partsRepository.findById("part-20").orElseThrow();
            Parts ssd1 = partsRepository.findById("part-14").orElseThrow();
            Parts ssd2 = partsRepository.findById("part-15").orElseThrow();
            Parts fan1 = partsRepository.findById("part-23").orElseThrow();
            Parts fan2 = partsRepository.findById("part-24").orElseThrow();

// One Super
            Pc oneSuper = new Pc();
            oneSuper.setId("pc-1");
            oneSuper.setPcModelGroup(pcModelGroupsRepository.findById("pc-model-group-1").orElseThrow());
            oneSuper.setPcType(gamingPcType);
            oneSuper.setPcCategories(optimalGamingCategory);
            oneSuper.setName("One Super");
            oneSuper.setDescription("Платформа для гейминга в Full HD разрешении, созданная на базе центрального процессора Intel® Core™ i5-12400F [до 4.4GHz, 6 ядер] и видеокарты Palit GeForce RTX 4060 Ti Dual [8GB, 4352 CUDA].");
            oneSuper.setImage("/uploads/one.jpg");
            oneSuper.setPrice(4500);

            oneSuper.setGpu(gpuPart);
            oneSuper.setCpu(cpuPart);
            oneSuper.setMotherboard(motherboardPart);
            oneSuper.setCpuFan(cpuFan);
            oneSuper.setPsu(psuPart);
            oneSuper.setRam(ramPart);
            oneSuper.setPcCase(casePart);
            oneSuper.setSsd(List.of(new PartWithQuantity(1, ssd1), new PartWithQuantity(1, ssd2)));  // Здесь нужно добавить реальные данные
            oneSuper.setFans(List.of(new PartWithQuantity(2, fan1), new PartWithQuantity(2, fan2)));  // Здесь тоже

            pcRepository.save(oneSuper);

// One Max
            Pc oneMax = new Pc();
            oneMax.setId("pc-2");
            oneMax.setPcModelGroup(pcModelGroupsRepository.findById("pc-model-group-1").orElseThrow());
            oneMax.setPcType(gamingPcType);
            oneMax.setPcCategories(optimalGamingCategory);
            oneMax.setName("One Max");
            oneMax.setDescription("Платформа для гейминга в Full HD разрешении, созданная на базе центрального процессора Intel® Core™ i5-12400F [до 4.4GHz, 6 ядер] и видеокарты Palit GeForce RTX 4060 Ti Dual [8GB, 4352 CUDA].");
            oneMax.setImage("/uploads/one.jpg");
            oneMax.setPrice(5500);

            oneMax.setGpu(gpuPart);
            oneMax.setCpu(cpuPart);
            oneMax.setMotherboard(motherboardPart);
            oneMax.setCpuFan(cpuFan);
            oneMax.setPsu(psuPart);
            oneMax.setRam(ramPart);
            oneMax.setPcCase(casePart);
            oneMax.setSsd(List.of(new PartWithQuantity(1, ssd1), new PartWithQuantity(1, ssd2)));  // Здесь нужно добавить реальные данные
            oneMax.setFans(List.of(new PartWithQuantity(2, fan1), new PartWithQuantity(2, fan2)));  // Здесь тоже

            pcRepository.save(oneMax);

// One Ultra
            Pc oneUltra = new Pc();
            oneUltra.setId("pc-3");
            oneUltra.setPcModelGroup(pcModelGroupsRepository.findById("pc-model-group-1").orElseThrow());
            oneUltra.setPcType(gamingPcType);
            oneUltra.setPcCategories(optimalGamingCategory);
            oneUltra.setName("One Ultra");
            oneUltra.setDescription("Платформа для гейминга в Full HD разрешении, созданная на базе центрального процессора Intel® Core™ i5-12400F [до 4.4GHz, 6 ядер] и видеокарты Palit GeForce RTX 4060 Ti Dual [8GB, 4352 CUDA].");
            oneUltra.setImage("/uploads/one.jpg");
            oneUltra.setPrice(6800);

            oneUltra.setGpu(gpuPart);
            oneUltra.setCpu(cpuPart);
            oneUltra.setMotherboard(motherboardPart);
            oneUltra.setCpuFan(cpuFan);
            oneUltra.setPsu(psuPart);
            oneUltra.setRam(ramPart);
            oneUltra.setPcCase(casePart);
            oneUltra.setSsd(List.of(new PartWithQuantity(1, ssd1), new PartWithQuantity(1, ssd2)));
            oneUltra.setFans(List.of(new PartWithQuantity(2, fan1), new PartWithQuantity(2, fan2)));

            pcRepository.save(oneUltra);

// Lumen Core Super
            Pc lumenCoreSuper = new Pc();
            lumenCoreSuper.setId("pc-4");
            lumenCoreSuper.setPcModelGroup(pcModelGroupsRepository.findById("pc-model-group-2").orElseThrow());
            lumenCoreSuper.setPcType(gamingPcType);
            lumenCoreSuper.setPcCategories(optimalGamingCategory);
            lumenCoreSuper.setName("Lumen Core Super");
            lumenCoreSuper.setDescription("Платформа для гейминга в Full HD разрешении, созданная на базе центрального процессора Intel® Core™ i5-12400F [до 4.4GHz, 6 ядер] и видеокарты Palit GeForce RTX 4060 Ti Dual [8GB, 4352 CUDA].");
            lumenCoreSuper.setImage("uploads/lumen-core.jpg");
            lumenCoreSuper.setPrice(7800);

            lumenCoreSuper.setGpu(gpuPart);
            lumenCoreSuper.setCpu(cpuPart);
            lumenCoreSuper.setMotherboard(motherboardPart);
            lumenCoreSuper.setCpuFan(cpuFan);
            lumenCoreSuper.setPsu(psuPart);
            lumenCoreSuper.setRam(ramPart);
            lumenCoreSuper.setPcCase(casePart);
            lumenCoreSuper.setSsd(List.of(new PartWithQuantity(1, ssd1), new PartWithQuantity(1, ssd2)));
            lumenCoreSuper.setFans(List.of(new PartWithQuantity(2, fan1), new PartWithQuantity(2, fan2)));

            pcRepository.save(lumenCoreSuper);

// "Fury Super"
            Pc furySuper = new Pc();
            furySuper.setId("pc-5");
            furySuper.setPcModelGroup(pcModelGroupsRepository.findById("pc-model-group-3").orElseThrow());
            furySuper.setPcType(gamingPcType);
            furySuper.setPcCategories(powerfulGamingCategory);
            furySuper.setName("Fury Super");
            furySuper.setDescription("Платформа для гейминга в Full HD разрешении, созданная на базе центрального процессора Intel® Core™ i5-12400F [до 4.4GHz, 6 ядер] и видеокарты Palit GeForce RTX 4060 Ti Dual [8GB, 4352 CUDA].");
            furySuper.setImage("uploads/fury.jpg");
            furySuper.setPrice(8800);

            furySuper.setGpu(gpuPart);
            furySuper.setCpu(cpuPart);
            furySuper.setMotherboard(motherboardPart);
            furySuper.setCpuFan(cpuFan);
            furySuper.setPsu(psuPart);
            furySuper.setRam(ramPart);
            furySuper.setPcCase(casePart);
            furySuper.setSsd(List.of(new PartWithQuantity(4, ssd2), new PartWithQuantity(1, ssd1)));
            furySuper.setFans(List.of(new PartWithQuantity(3, fan2), new PartWithQuantity(2, fan1)));

            pcRepository.save(furySuper);

// "PLAY 17 M1"
            Pc play17M1 = new Pc();
            play17M1.setId("pc-6");
            play17M1.setPcModelGroup(pcModelGroupsRepository.findById("pc-model-group-4").orElseThrow());
            play17M1.setPcType(notebookType);
            play17M1.setPcCategories(optimalWorkstationCategory);
            play17M1.setName("PLAY 17 M1");
            play17M1.setDescription("Ноутбук PLAY 17 – это отличный выбор для тех, кто хочет обладать современным ноутбуком, который можно использовать для игр, работы и учёбы. Имеет установленную ОС Windows 11 Home.");
            play17M1.setImage("uploads/hyperpc-play.jpg");
            play17M1.setPrice(7400);

            play17M1.setGpu(gpuPart);
            play17M1.setCpu(cpuPart);
            play17M1.setRam(ramPart);
            play17M1.setSsd(List.of(new PartWithQuantity(4, ssd2), new PartWithQuantity(1, ssd1)));

            pcRepository.save(play17M1);

// "G1 PRO Super"
            Pc g1ProSuper = new Pc();
            g1ProSuper.setId("pc-7");
            g1ProSuper.setPcModelGroup(pcModelGroupsRepository.findById("pc-model-group-5").orElseThrow());
            g1ProSuper.setPcType(gamingPcType);
            g1ProSuper.setPcCategories(customGamingCategory);
            g1ProSuper.setName("G1 PRO Super");
            g1ProSuper.setDescription("Надежный начального уровня компьютер, оснащенный быстрым процессором и высокоскоростной памятью, предназначенный для профессиональных приложений и эффективной многозадачности.");
            g1ProSuper.setImage("uploads/pro-g1.jpg");
            g1ProSuper.setPrice(3500);

            g1ProSuper.setGpu(gpuPart);
            g1ProSuper.setCpu(cpuPart);
            g1ProSuper.setMotherboard(motherboardPart);
            g1ProSuper.setCpuFan(cpuFan);
            g1ProSuper.setPsu(psuPart);
            g1ProSuper.setRam(ramPart);
            g1ProSuper.setPcCase(casePart);
            g1ProSuper.setSsd(List.of(new PartWithQuantity(4, ssd2), new PartWithQuantity(1, ssd1)));
            g1ProSuper.setFans(List.of(new PartWithQuantity(3, fan2), new PartWithQuantity(2, fan1)));

            pcRepository.save(g1ProSuper);

// "My Configuration" (без pc_model_group)
            Pc myConfiguration = new Pc();
            myConfiguration.setId("pc-8");
            myConfiguration.setPcModelGroup(null);
            myConfiguration.setPcType(gamingPcType);
            myConfiguration.setPcCategories(customGamingCategory);
            myConfiguration.setName("My Configuration");
            myConfiguration.setDescription(null);
            myConfiguration.setImage("components/case/no-case.jpg");
            myConfiguration.setPrice(3500);

            myConfiguration.setGpu(gpuPart);
            myConfiguration.setCpu(cpuPart);
            myConfiguration.setMotherboard(motherboardPart);
            myConfiguration.setCpuFan(cpuFan);
            myConfiguration.setPsu(psuPart);
            myConfiguration.setRam(ramPart);
            myConfiguration.setPcCase(casePart);
            myConfiguration.setSsd(List.of(new PartWithQuantity(4, ssd2), new PartWithQuantity(1, ssd1)));
            myConfiguration.setFans(List.of(new PartWithQuantity(3, fan2), new PartWithQuantity(2, fan1)));

            pcRepository.save(myConfiguration);

            purchaseItemRepository.save(new PurchaseItem("purchase-item-1", 2, partsRepository.findById("part-1").get()));
            purchaseItemRepository.save(new PurchaseItem("purchase-item-2", 3, partsRepository.findById("part-6").get()));
            purchaseItemRepository.save(new PurchaseItem("purchase-item-3", 1, pcRepository.findById("pc-1").get()));
            purchaseItemRepository.save(new PurchaseItem("purchase-item-4", 1, pcRepository.findById("pc-2").get()));

            purchasesRepository.save(new Purchases("purchase-1", new Date(), "Description...", usersRepository.findById("user-2").get(), purchaseItemRepository.findAll()));

            Users user1 = usersRepository.findById("user-2").get();
            cartRepository.save(new CartItems("cart-item-1", user1, purchaseItemRepository.findById("purchase-item-1").get()));
            cartRepository.save(new CartItems("cart-item-2", user1, purchaseItemRepository.findById("purchase-item-2").get()));
            cartRepository.save(new CartItems("cart-item-3", user1, purchaseItemRepository.findById("purchase-item-3").get()));
            cartRepository.save(new CartItems("cart-item-4", user1, purchaseItemRepository.findById("purchase-item-4").get()));

            compareItemsRepository.save(new CompareItems("compare-item-1", user1, partsRepository.findById("part-1").get()));
            compareItemsRepository.save(new CompareItems("compare-item-2", user1, partsRepository.findById("part-3").get()));
            compareItemsRepository.save(new CompareItems("compare-item-3", user1, partsRepository.findById("part-4").get()));
            compareItemsRepository.save(new CompareItems("compare-item-4", user1, partsRepository.findById("part-8").get()));

        };
    }
}
