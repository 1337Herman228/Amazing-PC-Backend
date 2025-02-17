package com.example.amazingpcbackend.seeder;

import com.example.amazingpcbackend.dao.CharacteristicItem;
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
    CommandLineRunner initDatabase(RolesRepository rolesRepository, UsersRepository usersRepository, CategoriesRepository categoriesRepository, PartitionsRepository partitionsRepository, TypesRepository typesRepository, PartsRepository partsRepository, PcTypesRepository pcTypesRepository, PcCategoriesRepository pcCategoriesRepository, PcModelGroupsRepository pcModelGroupsRepository, PcRepository pcRepository, PurchaseItemRepository purchaseItemRepository, PurchasesRepository purchasesRepository, CartItemsRepository cartRepository, CompareItemsRepository compareItemsRepository) {
        return args -> {
            rolesRepository.save(new Roles("role-1", "admin", "Администратор"));
            rolesRepository.save(new Roles("role-2", "user" , "Пользователь"));

            usersRepository.save(new Users("user-1", "admin", "$2a$10$PRS7/aqGOtIXgKIl/a/5ce9ugXrY.zi9595RTjkeSToY6/C9HGdBi", "Михаил", "Зубенко", "+375293334444", "zubmih@gmail.com", rolesRepository.findByValue("admin").get()));
            usersRepository.save(new Users("user-2", "user", "$2a$10$n.9aYpIC1sU4Snv8ovfh3.53DHqicMUrlk4F3Gt1V0CLwYaabhZ..", "Клиторчук", "КалКалыч", "375293334444", "klkal@gmail.com", rolesRepository.findByValue("user").get()));

            categoriesRepository.save(new Categories("category-1", "components", "Комплектующие"));
            categoriesRepository.save(new Categories("category-2", "periphery", "Периферия"));

            typesRepository.save(new Types("type-1", "gpu", "Видеокарта", "/svg-icons/gpu.svg"));
            typesRepository.save(new Types("type-2", "cpu", "Процессор", "/svg-icons/cpu.svg"));
            typesRepository.save(new Types("type-3", "motherboard", "Материнская плата", "/svg-icons/motherboard.svg"));
            typesRepository.save(new Types("type-4", "cpu_fan", "Охлаждение процессора", "/svg-icons/cpu_fan.svg"));
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

            List<CharacteristicItem> part1config = new ArrayList<>();
            part1config.add(new CharacteristicItem<>("base_frequency","Базовая частота", "2500 Мгц"));
            part1config.add(new CharacteristicItem<>("boost_frequency","Турбо частота", "4400 Мгц"));
            part1config.add( new CharacteristicItem<>("cpu_cores","Кол-во ядер", "6"));
            part1config.add( new CharacteristicItem<>("cpu_threads","Кол-во потоков", "12"));
            part1config.add( new CharacteristicItem<>("max_ram_capacity","Макс. объем оперативной памяти", "128 ГБ"));
            part1config.add(new CharacteristicItem<>("tdp", "Тепловыделение", "65 Вт"));
            part1config.add( new CharacteristicItem<>("cachel1","Кэш 1-го уровня", null));
            part1config.add( new CharacteristicItem<>("cachel2","Кэш 2-го уровня", "7680 КБ"));
            part1config.add( new CharacteristicItem<>("cachel3","Кэш 3-го уровня", "18432 КБ"));
            part1config.add( new CharacteristicItem<>("socket","Сокет", "LGA 1700"));
            part1config.add( new CharacteristicItem<>("tech_process","Тех-процесс", "7 нм"));
            part1config.add(new CharacteristicItem<>("ram_type", "Тип ОЗУ", Arrays.asList("DDR4", "DDR5")));
            partsRepository.save(new Parts("part-1","I5-12400F", "/uploads/i5-12400f.jpg", "Описание...", 350,part1config, categoriesRepository.findByValue("components").get(), partitionsRepository.findByValue("intelcore12th").get(), typesRepository.findByValue("cpu").get()));

            List<CharacteristicItem> part2config = new ArrayList<>();
            part2config.add(new CharacteristicItem<>("base_frequency", "Базовая частота", "2500 Мгц"));
            part2config.add(new CharacteristicItem<>("boost_frequency", "Турбо частота", "4700 Мгц"));
            part2config.add(new CharacteristicItem<>("cpu_cores", "Кол-во ядер", "10"));
            part2config.add(new CharacteristicItem<>("cpu_threads", "Кол-во потоков", "16"));
            part2config.add(new CharacteristicItem<>("max_ram_capacity", "Макс. объем оперативной памяти", "128 ГБ"));
            part2config.add(new CharacteristicItem<>("tdp", "Тепловыделение", "65 Вт"));
            part2config.add(new CharacteristicItem<>("cachel1", "Кэш 1-го уровня", null));
            part2config.add(new CharacteristicItem<>("cachel2", "Кэш 2-го уровня", "9728 КБ"));
            part2config.add(new CharacteristicItem<>("cachel3", "Кэш 3-го уровня", "20480 КБ"));
            part2config.add(new CharacteristicItem<>("socket", "Сокет", "LGA 1700"));
            part2config.add(new CharacteristicItem<>("tech_process", "Тех-процесс", "7 нм"));
            part2config.add(new CharacteristicItem<>("ram_type", "Тип ОЗУ", Arrays.asList("DDR4", "DDR5")));
            partsRepository.save(new Parts("part-2", "I5-14400F", "/uploads/i5-14400f.jpg", "Описание...", 450,
                    part2config, categoriesRepository.findByValue("components").get(),
                    partitionsRepository.findByValue("intelcore14th").get(),
                    typesRepository.findByValue("cpu").get()));

            List<CharacteristicItem> part3config = new ArrayList<>();
            part3config.add(new CharacteristicItem<>("base_frequency", "Базовая частота", "2100 Мгц"));
            part3config.add(new CharacteristicItem<>("boost_frequency", "Турбо частота", "5400 Мгц"));
            part3config.add(new CharacteristicItem<>("cpu_cores", "Кол-во ядер", "20"));
            part3config.add(new CharacteristicItem<>("cpu_threads", "Кол-во потоков", "28"));
            part3config.add(new CharacteristicItem<>("max_ram_capacity", "Макс. объем оперативной памяти", "128 ГБ"));
            part3config.add(new CharacteristicItem<>("tdp", "Тепловыделение", "65 Вт"));
            part3config.add(new CharacteristicItem<>("cachel1", "Кэш 1-го уровня", "80 КБ"));
            part3config.add(new CharacteristicItem<>("cachel2", "Кэш 2-го уровня", "20 МБ"));
            part3config.add(new CharacteristicItem<>("cachel3", "Кэш 3-го уровня", "33 МБ"));
            part3config.add(new CharacteristicItem<>("socket", "Сокет", "LGA 1700"));
            part3config.add(new CharacteristicItem<>("tech_process", "Тех-процесс", "intel 7"));
            part3config.add(new CharacteristicItem<>("ram_type", "Тип ОЗУ", Arrays.asList("DDR4", "DDR5")));
            partsRepository.save(new Parts("part-3", "I7-14700KF", "/uploads/i7-14700kf.jpg", "Описание...", 650,
                    part3config, categoriesRepository.findByValue("components").get(),
                    partitionsRepository.findByValue("intelcore14th").get(),
                    typesRepository.findByValue("cpu").get()));

            List<CharacteristicItem> part4config = new ArrayList<>();
            part4config.add(new CharacteristicItem<>("base_frequency", "Базовая частота", "1830 Мгц"));
            part4config.add(new CharacteristicItem<>("boost_frequency", "Турбо частота", "2460 Мгц"));
            part4config.add(new CharacteristicItem<>("bus_width", "Шина", "128 бит"));
            part4config.add(new CharacteristicItem<>("cuda", "CUDA ядра", "3072"));
            part4config.add(new CharacteristicItem<>("display_port", "DisplayPort", "3"));
            part4config.add(new CharacteristicItem<>("extension_slots", "Слоты расширения", "2"));
            part4config.add(new CharacteristicItem<>("fans", "Вентиляторы", "2"));
            part4config.add(new CharacteristicItem<>("hdmi", "HDMI", "1"));
            part4config.add(new CharacteristicItem<>("height", "Высота", "40 мм"));
            part4config.add(new CharacteristicItem<>("length", "Длина", "249 мм"));
            part4config.add(new CharacteristicItem<>("max_displays_quantity", "Макс. кол-во дисплеев", "4"));
            part4config.add(new CharacteristicItem<>("min_power_unit", "Мин. мощность блока питания", "500 Вт"));
            part4config.add(new CharacteristicItem<>("tech_process", "Тех-процесс", "5 нм"));
            part4config.add(new CharacteristicItem<>("vram_capacity", "Видеопамять", "8 ГБ"));
            part4config.add(new CharacteristicItem<>("width", "Ширина", "123 мм"));
            part4config.add(new CharacteristicItem<>("max_resolution", "Макс. разрешение", "5120x2880"));
            part4config.add(new CharacteristicItem<>("vram_type", "Тип видеопамяти", "GDDR6"));
            part4config.add(new CharacteristicItem<>("power_connector", "Разъем питания", "8 pin"));
            partsRepository.save(new Parts("part-4", "PALIT GeForce RTX 4060 DUAL", "/uploads/palit-geforce-rtx-4060-dual.jpg", "Описание...", 1050,
                    part4config, categoriesRepository.findByValue("components").get(),
                    partitionsRepository.findByValue("rtx4060").get(),
                    typesRepository.findByValue("gpu").get()));

            List<CharacteristicItem> part5config = new ArrayList<>();
            part5config.add(new CharacteristicItem<>("base_frequency", "Базовая частота", "1980 Мгц"));
            part5config.add(new CharacteristicItem<>("boost_frequency", "Турбо частота", "2640 Мгц"));
            part5config.add(new CharacteristicItem<>("bus_width", "Шина", "192 бит"));
            part5config.add(new CharacteristicItem<>("cuda", "CUDA ядра", "7680"));
            part5config.add(new CharacteristicItem<>("display_port", "DisplayPort", "3"));
            part5config.add(new CharacteristicItem<>("extension_slots", "Слоты расширения", "3.1"));
            part5config.add(new CharacteristicItem<>("fans", "Вентиляторы", "3"));
            part5config.add(new CharacteristicItem<>("hdmi", "HDMI", "1"));
            part5config.add(new CharacteristicItem<>("height", "Высота", "63.5 мм"));
            part5config.add(new CharacteristicItem<>("length", "Длина", "329 мм"));
            part5config.add(new CharacteristicItem<>("max_displays_quantity", "Макс. кол-во дисплеев", "4"));
            part5config.add(new CharacteristicItem<>("min_power_unit", "Мин. мощность блока питания", "700 Вт"));
            part5config.add(new CharacteristicItem<>("tech_process", "Тех-процесс", "5 нм"));
            part5config.add(new CharacteristicItem<>("vram_capacity", "Видеопамять", "12 ГБ"));
            part5config.add(new CharacteristicItem<>("width", "Ширина", "130 мм"));
            part5config.add(new CharacteristicItem<>("max_resolution", "Макс. разрешение", "7680x4320"));
            part5config.add(new CharacteristicItem<>("vram_type", "Тип видеопамяти", "GDDR6X"));
            part5config.add(new CharacteristicItem<>("power_connector", "Разъем питания", "8+8 pin"));
            partsRepository.save(new Parts("part-5", "Palit GeForce RTX 4070 SUPER JetStream", "/uploads/palit-geforce-rtx-4070-super-jetstream.jpg", "Описание...", 1350,
                    part5config, categoriesRepository.findByValue("components").get(),
                    partitionsRepository.findByValue("rtx4070").get(),
                    typesRepository.findByValue("gpu").get()));

            List<CharacteristicItem> part6config = new ArrayList<>();
            part6config.add(new CharacteristicItem<>("base_frequency", "Базовая частота", "2000 Мгц"));
            part6config.add(new CharacteristicItem<>("boost_frequency", "Турбо частота", "2565 Мгц"));
            part6config.add(new CharacteristicItem<>("bus_width", "Шина", "256 бит"));
            part6config.add(new CharacteristicItem<>("cuda", "CUDA ядра", "10240"));
            part6config.add(new CharacteristicItem<>("display_port", "DisplayPort", "2"));
            part6config.add(new CharacteristicItem<>("extension_slots", "Слоты расширения", null));
            part6config.add(new CharacteristicItem<>("fans", "Вентиляторы", "3"));
            part6config.add(new CharacteristicItem<>("hdmi", "HDMI", "2"));
            part6config.add(new CharacteristicItem<>("height", "Высота", "62 мм"));
            part6config.add(new CharacteristicItem<>("length", "Длина", "322 мм"));
            part6config.add(new CharacteristicItem<>("max_displays_quantity", "Макс. кол-во дисплеев", "4"));
            part6config.add(new CharacteristicItem<>("min_power_unit", "Мин. мощность блока питания", "850 Вт"));
            part6config.add(new CharacteristicItem<>("tech_process", "Тех-процесс", "5 нм"));
            part6config.add(new CharacteristicItem<>("vram_capacity", "Видеопамять", "16 ГБ"));
            part6config.add(new CharacteristicItem<>("width", "Ширина", "136 мм"));
            part6config.add(new CharacteristicItem<>("max_resolution", "Макс. разрешение", "7680x4320"));
            part6config.add(new CharacteristicItem<>("vram_type", "Тип видеопамяти", "GDDR6X"));
            part6config.add(new CharacteristicItem<>("power_connector", "Разъем питания", "8+8 pin"));
            partsRepository.save(new Parts("part-6", "MSI GeForce RTX 4080 SUPER GAMING SLIM", "/uploads/msi-geforce-rtx-4080-super-gaming-slim.jpg", "Описание...", 1650,
                    part6config, categoriesRepository.findByValue("components").get(),
                    partitionsRepository.findByValue("rtx4080").get(),
                    typesRepository.findByValue("gpu").get()));

            List<CharacteristicItem> part7config = new ArrayList<>();
            part7config.add(new CharacteristicItem<>("m2quantity", "Количество M.2 слотов", "2"));
            part7config.add(new CharacteristicItem<>("max_ram_capacity", "Макс. объем оперативной памяти", "128 ГБ"));
            part7config.add(new CharacteristicItem<>("pcie16quantity", "Количество PCIe x16 слотов", "2"));
            part7config.add(new CharacteristicItem<>("ram_slots", "Количество слотов для RAM", "4"));
            part7config.add(new CharacteristicItem<>("sata_quantity", "Количество SATA портов", "4"));
            part7config.add(new CharacteristicItem<>("chipset", "Чипсет", "Intel B760"));
            part7config.add(new CharacteristicItem<>("form_factor", "Форм-фактор", "microATX"));
            part7config.add(new CharacteristicItem<>("ram_type", "Тип RAM", "DDR4"));
            part7config.add(new CharacteristicItem<>("socket", "Сокет", "LGA 1700"));
            partsRepository.save(new Parts("part-7", "MSI PRO B760M-A", "/uploads/msi-pro-b760m-a.jpg", "Описание...", 330,
                    part7config, categoriesRepository.findByValue("components").get(),
                    partitionsRepository.findByValue("intelb760").get(),
                    typesRepository.findByValue("motherboard").get()));

            List<CharacteristicItem> part8config = new ArrayList<>();
            part8config.add(new CharacteristicItem<>("m2quantity", "Количество M.2 слотов", "4"));
            part8config.add(new CharacteristicItem<>("max_ram_capacity", "Макс. объем оперативной памяти", "128 ГБ"));
            part8config.add(new CharacteristicItem<>("pcie16quantity", "Количество PCIe x16 слотов", "3"));
            part8config.add(new CharacteristicItem<>("ram_slots", "Количество слотов для RAM", "4"));
            part8config.add(new CharacteristicItem<>("sata_quantity", "Количество SATA портов", "6"));
            part8config.add(new CharacteristicItem<>("chipset", "Чипсет", "Intel Z790"));
            part8config.add(new CharacteristicItem<>("form_factor", "Форм-фактор", "ATX"));
            part8config.add(new CharacteristicItem<>("ram_type", "Тип RAM", "DDR5"));
            part8config.add(new CharacteristicItem<>("socket", "Сокет", "LGA 1700"));
            partsRepository.save(new Parts("part-8", "MSI PRO Z790-A MAX", "/uploads/msi-pro-z790-a-max.jpg", "Описание...", 450,
                    part8config, categoriesRepository.findByValue("components").get(),
                    partitionsRepository.findByValue("intelz790").get(),
                    typesRepository.findByValue("motherboard").get()));

            List<CharacteristicItem> part9config = new ArrayList<>();
            part9config.add(new CharacteristicItem<>("cpu_fan_type", "Тип охлаждения", "Воздушное"));
            part9config.add(new CharacteristicItem<>("air_flow", "Воздушный поток", "61.25 CFM"));
            part9config.add(new CharacteristicItem<>("fans_quantity", "Количество вентиляторов", "1"));
            part9config.add(new CharacteristicItem<>("height", "Высота", "165 мм"));
            part9config.add(new CharacteristicItem<>("width", "Ширина", "120 мм"));
            part9config.add(new CharacteristicItem<>("length", "Длина", "122.5 мм"));
            part9config.add(new CharacteristicItem<>("max_noise_level", "Макс. уровень шума", "23.7 дБ"));
            part9config.add(new CharacteristicItem<>("tdp", "TDP", "250 Вт"));
            part9config.add(new CharacteristicItem<>("backlight", "Подсветка", "Отсутствует"));
            part9config.add(new CharacteristicItem<>("connector", "Коннектор", "4-pin PWM"));
            part9config.add(new CharacteristicItem<>("fan_size", "Размер вентилятора", "140x140x25 мм"));
            part9config.add(new CharacteristicItem<>("fan_speed", "Скорость вентилятора", "500-1800 об/мин"));
            part9config.add(new CharacteristicItem<>("sockets", "Сокеты", Arrays.asList("AM4", "AM5", "LGA 1150", "LGA 1151", "LGA 1155", "LGA 1200", "LGA 1700", "LGA 2011", "LGA 2011-3", "LGA 2066")));
            partsRepository.save(new Parts("part-9", "DeepCool ASSASSIN 4S", "/uploads/deepcool-assassin-4s.jpg", "Описание...", 150,
                    part9config, categoriesRepository.findByValue("components").get(),
                    partitionsRepository.findByValue("deepcool").get(),
                    typesRepository.findByValue("cpu_fan").get()));

            List<CharacteristicItem> part10config = new ArrayList<>();
            part10config.add(new CharacteristicItem<>("cpu_fan_type", "Тип охлаждения", "Водяное"));
            part10config.add(new CharacteristicItem<>("air_flow", "Воздушный поток", "70.07 CFM"));
            part10config.add(new CharacteristicItem<>("fans_quantity", "Количество вентиляторов", "3"));
            part10config.add(new CharacteristicItem<>("height", "Высота", "30 мм"));
            part10config.add(new CharacteristicItem<>("length", "Длина", "399.5 мм"));
            part10config.add(new CharacteristicItem<>("max_noise_level", "Макс. уровень шума", "36.45 дБ"));
            part10config.add(new CharacteristicItem<>("tdp", "TDP", "280 Вт"));
            part10config.add(new CharacteristicItem<>("width", "Ширина", "120 мм"));
            part10config.add(new CharacteristicItem<>("backlight", "Подсветка", "ARGB"));
            part10config.add(new CharacteristicItem<>("connector", "Коннектор", "4-pin PWM"));
            part10config.add(new CharacteristicItem<>("fan_size", "Размер вентилятора", "120x120x25 мм"));
            part10config.add(new CharacteristicItem<>("fan_speed", "Скорость вентилятора", "2200 +/- 300 RPM"));
            part10config.add(new CharacteristicItem<>("sockets", "Сокеты", Arrays.asList("AM4", "AM5", "LGA 1150", "LGA 1151", "LGA 1155", "LGA 1200", "LGA 1700", "LGA 2011", "LGA 2011-3", "LGA 2066")));
            partsRepository.save(new Parts("part-10", "ASUS ROG RYUO III 360 White", "/uploads/asus-rog-ryuo-III-360-white.jpg", "Описание...", 460,
                    part10config, categoriesRepository.findByValue("components").get(),
                    partitionsRepository.findByValue("asus").get(),
                    typesRepository.findByValue("cpu_fan").get()));

            List<CharacteristicItem> part11config = new ArrayList<>();
            part11config.add(new CharacteristicItem<>("capacity", "Емкость", "16 ГБ"));
            part11config.add(new CharacteristicItem<>("frequency", "Частота", "3600 МГц"));
            part11config.add(new CharacteristicItem<>("type", "Тип", "DDR4"));
            partsRepository.save(new Parts("part-11", "16GB Kingston FURY Beast RGB", "/uploads/16gb-kingston-fury-beast-rgb.jpg", "Описание...", 200,
                    part11config, categoriesRepository.findByValue("components").get(),
                    partitionsRepository.findByValue("16gb").get(),
                    typesRepository.findByValue("ram").get()));

            List<CharacteristicItem> part12config = new ArrayList<>();
            part12config.add(new CharacteristicItem<>("capacity", "Емкость", "32 ГБ"));
            part12config.add(new CharacteristicItem<>("frequency", "Частота", "3600 МГц"));
            part12config.add(new CharacteristicItem<>("type", "Тип", "DDR4"));
            partsRepository.save(new Parts("part-12", "32GB Kingston FURY Beast RGB", "/uploads/32gb-kingston-fury-beast-rgb.jpg", "Описание...", 320,
                    part12config, categoriesRepository.findByValue("components").get(),
                    partitionsRepository.findByValue("32gb").get(),
                    typesRepository.findByValue("ram").get()));

            List<CharacteristicItem> part13config = new ArrayList<>();
            part13config.add(new CharacteristicItem<>("capacity", "Емкость", "64 ГБ"));
            part13config.add(new CharacteristicItem<>("frequency", "Частота", "6000 МГц"));
            part13config.add(new CharacteristicItem<>("type", "Тип", "DDR5"));
            partsRepository.save(new Parts("part-13", "64GB TEAMGROUP T-Force Delta RGB White", "/uploads/64gb-teamgroup-t-force-delta-rgb-white.jpg", "Описание...", 600,
                    part13config, categoriesRepository.findByValue("components").get(),
                    partitionsRepository.findByValue("64gb").get(),
                    typesRepository.findByValue("ram").get()));

            List<CharacteristicItem> part14config = new ArrayList<>();
            part14config.add(new CharacteristicItem<>("capacity", "Емкость", "512 ГБ"));
            part14config.add(new CharacteristicItem<>("flash_memory_type", "Тип флеш-памяти", "3D NAND"));
            part14config.add(new CharacteristicItem<>("form_factor", "Форм-фактор", "M.2 NVME"));
            part14config.add(new CharacteristicItem<>("connection_type", "Тип подключения", "PCI-E 4.0 x4"));
            part14config.add(new CharacteristicItem<>("controller_type", "Тип контроллера", "Silicon Motion SM2269XT"));
            part14config.add(new CharacteristicItem<>("read_velocity", "Скорость чтения", "5000 МБ/с"));
            part14config.add(new CharacteristicItem<>("write_velocity", "Скорость записи", "2700 МБ/с"));
            partsRepository.save(new Parts("part-14", "512GB ADATA LEGEND 850", "/uploads/512gb-adata-legend-850.jpg", "Описание...", 230,
                    part14config, categoriesRepository.findByValue("components").get(),
                    partitionsRepository.findByValue("512gb").get(),
                    typesRepository.findByValue("ssd").get()));

            List<CharacteristicItem> part15config = new ArrayList<>();
            part15config.add(new CharacteristicItem<>("capacity", "Емкость", "1 ТБ"));
            part15config.add(new CharacteristicItem<>("flash_memory_type", "Тип флеш-памяти", "3D NAND"));
            part15config.add(new CharacteristicItem<>("form_factor", "Форм-фактор", "M.2 NVME"));
            part15config.add(new CharacteristicItem<>("connection_type", "Тип подключения", "PCI-E 4.0 x4"));
            part15config.add(new CharacteristicItem<>("controller_type", "Тип контроллера", "Silicon Motion SM2269XT"));
            part15config.add(new CharacteristicItem<>("read_velocity", "Скорость чтения", "5000 МБ/с"));
            part15config.add(new CharacteristicItem<>("write_velocity", "Скорость записи", "4500 МБ/с"));
            partsRepository.save(new Parts("part-15", "1TB ADATA LEGEND 850", "/uploads/1tb-adata-legend-850.jpg", "Описание...", 380,
                    part15config, categoriesRepository.findByValue("components").get(),
                    partitionsRepository.findByValue("1tb").get(),
                    typesRepository.findByValue("ssd").get()));

            List<CharacteristicItem> part16config = new ArrayList<>();
            part16config.add(new CharacteristicItem<>("capacity", "Емкость", "2 ТБ"));
            part16config.add(new CharacteristicItem<>("flash_memory_type", "Тип флеш-памяти", "MLC 3D NAND"));
            part16config.add(new CharacteristicItem<>("form_factor", "Форм-фактор", "M.2 NVME"));
            part16config.add(new CharacteristicItem<>("read_velocity", "Скорость чтения", "7450 МБ/с"));
            part16config.add(new CharacteristicItem<>("write_velocity", "Скорость записи", "6900 МБ/с"));
            part16config.add(new CharacteristicItem<>("max_temperature", "Макс. температура", "70 °C"));
            partsRepository.save(new Parts("part-16", "2TB Samsung 990 PRO", "/uploads/2tb-samsung-990-pro.jpg", "Описание...", 550,
                    part16config, categoriesRepository.findByValue("components").get(),
                    partitionsRepository.findByValue("2tb").get(),
                    typesRepository.findByValue("ssd").get()));

            List<CharacteristicItem> part17config = new ArrayList<>();
            part17config.add(new CharacteristicItem<>("power", "Мощность", "650W"));
            part17config.add(new CharacteristicItem<>("cpu4plus4quantity", "Количество 4+4-pin для процессора", "1"));
            part17config.add(new CharacteristicItem<>("gpu6plus2quantity", "Количество 6+2-pin для GPU", "2"));
            part17config.add(new CharacteristicItem<>("sata_quantity", "Количество SATA разъемов", "5"));
            part17config.add(new CharacteristicItem<>("form_factor", "Форм-фактор", "ATX"));
            part17config.add(new CharacteristicItem<>("pfc", "PFC", "активный"));
            part17config.add(new CharacteristicItem<>("certificate", "Сертификат", "80+ Bronze"));
            part17config.add(new CharacteristicItem<>("modular", "Модульность", "Полумодульный"));
            part17config.add(new CharacteristicItem<>("cooling_system", "Охлаждающая система", "1 вентилятор (120 мм)"));
            partsRepository.save(new Parts("part-17", "650W DeepCool PK650D", "/uploads/650w-deepcool-pk650d.jpg", "Описание...", 310,
                    part17config, categoriesRepository.findByValue("components").get(),
                    partitionsRepository.findByValue("500w").get(),
                    typesRepository.findByValue("psu").get()));

            List<CharacteristicItem> part18config = new ArrayList<>();
            part18config.add(new CharacteristicItem<>("power", "Мощность", "750W"));
            part18config.add(new CharacteristicItem<>("cpu4plus4quantity", "Количество 4+4-pin для процессора", "2"));
            part18config.add(new CharacteristicItem<>("gpu6plus2quantity", "Количество 6+2-pin для GPU", "4"));
            part18config.add(new CharacteristicItem<>("sata_quantity", "Количество SATA разъемов", "7"));
            part18config.add(new CharacteristicItem<>("form_factor", "Форм-фактор", "ATX"));
            part18config.add(new CharacteristicItem<>("pfc", "PFC", "активный"));
            part18config.add(new CharacteristicItem<>("certificate", "Сертификат", "80+ Bronze"));
            part18config.add(new CharacteristicItem<>("modular", "Модульность", "Полумодульный"));
            part18config.add(new CharacteristicItem<>("cooling_system", "Охлаждающая система", "1 вентилятор (120 мм)"));
            partsRepository.save(new Parts("part-18", "750W DeepCool PK750D", "/uploads/750w-deepcool-pk750d.jpg", "Описание...", 410,
                    part18config, categoriesRepository.findByValue("components").get(),
                    partitionsRepository.findByValue("700w").get(),
                    typesRepository.findByValue("psu").get()));

            List<CharacteristicItem> part19config = new ArrayList<>();
            part19config.add(new CharacteristicItem<>("power", "Мощность", "850W"));
            part19config.add(new CharacteristicItem<>("cpu4plus4quantity", "Количество 4+4-pin для процессора", "2"));
            part19config.add(new CharacteristicItem<>("gpu6plus2quantity", "Количество 6+2-pin для GPU", "5"));
            part19config.add(new CharacteristicItem<>("sata_quantity", "Количество SATA разъемов", "8"));
            part19config.add(new CharacteristicItem<>("form_factor", "Форм-фактор", "ATX12V 3.0"));
            part19config.add(new CharacteristicItem<>("pfc", "PFC", "активный"));
            part19config.add(new CharacteristicItem<>("certificate", "Сертификат", "80+ Gold"));
            part19config.add(new CharacteristicItem<>("modular", "Модульность", "Модульный"));
            part19config.add(new CharacteristicItem<>("cooling_system", "Охлаждающая система", "1 вентилятор (120 мм)"));
            partsRepository.save(new Parts("part-19", "850W MSI MAG A850GL", "/uploads/850w-msi-mag-a850gl.jpg", "Описание...", 610,
                    part19config, categoriesRepository.findByValue("components").get(),
                    partitionsRepository.findByValue("800w").get(),
                    typesRepository.findByValue("psu").get()));

            List<CharacteristicItem> part20config = new ArrayList<>();
            part20config.add(new CharacteristicItem<>("extension_slots_quantity", "Количество слотов расширения", "8"));
            part20config.add(new CharacteristicItem<>("hdd_slots_quantity", "Количество слотов для HDD", "4"));
            part20config.add(new CharacteristicItem<>("height", "Высота", "450 мм"));
            part20config.add(new CharacteristicItem<>("length", "Длина", "446 мм"));
            part20config.add(new CharacteristicItem<>("max_cpu_cooler_height", "Макс. высота кулера процессора", "163 мм"));
            part20config.add(new CharacteristicItem<>("max_gpu_length", "Макс. длина GPU", "400 мм"));
            part20config.add(new CharacteristicItem<>("max_liquid_cooling_length", "Макс. длина системы жидкостного охлаждения", "420 мм"));
            part20config.add(new CharacteristicItem<>("ssd_slots_quantity", "Количество слотов для SSD", "4"));
            part20config.add(new CharacteristicItem<>("weight", "Вес", "11 кг"));
            part20config.add(new CharacteristicItem<>("width", "Ширина", "285 мм"));
            part20config.add(new CharacteristicItem<>("possible_form_factors", "Поддерживаемые форм-факторы", Arrays.asList("micro-ATX", "mini-ATX", "ATX")));
            partsRepository.save(new Parts("part-20", "ASUS TUF GAMING GT502 White", "/uploads/asus-tuf-gaming-gt502-white.jpg", "Описание...", 380,
                    part20config, categoriesRepository.findByValue("components").get(),
                    partitionsRepository.findByValue("asus").get(),
                    typesRepository.findByValue("cases").get()));

            List<CharacteristicItem> part21config = new ArrayList<>();
            part21config.add(new CharacteristicItem<>("extension_slots_quantity", "Количество слотов расширения", "6"));
            part21config.add(new CharacteristicItem<>("hdd_slots_quantity", "Количество слотов для HDD", "2"));
            part21config.add(new CharacteristicItem<>("height", "Высота", "464 мм"));
            part21config.add(new CharacteristicItem<>("length", "Длина", "480 мм"));
            part21config.add(new CharacteristicItem<>("max_cpu_cooler_height", "Макс. высота кулера процессора", "174 мм"));
            part21config.add(new CharacteristicItem<>("max_gpu_length", "Макс. длина GPU", "430 мм"));
            part21config.add(new CharacteristicItem<>("max_liquid_cooling_length", "Макс. длина системы жидкостного охлаждения", "390 мм"));
            part21config.add(new CharacteristicItem<>("ssd_slots_quantity", "Количество слотов для SSD", "5"));
            part21config.add(new CharacteristicItem<>("weight", "Вес", "18 кг"));
            part21config.add(new CharacteristicItem<>("width", "Ширина", "304 мм"));
            part21config.add(new CharacteristicItem<>("possible_form_factors", "Поддерживаемые форм-факторы", Arrays.asList("micro-ATX", "mini-ATX", "ATX")));
            partsRepository.save(new Parts("part-21", "Lian Li O11 Vision White", "/uploads/lian-li-011-vision-white.jpg", "Описание...", 450,
                    part21config, categoriesRepository.findByValue("components").get(),
                    partitionsRepository.findByValue("lianli").get(),
                    typesRepository.findByValue("cases").get()));

            List<CharacteristicItem> part22config = new ArrayList<>();
            part22config.add(new CharacteristicItem<>("extension_slots_quantity", "Количество слотов расширения", "4"));
            part22config.add(new CharacteristicItem<>("hdd_slots_quantity", "Количество слотов для HDD", "3"));
            part22config.add(new CharacteristicItem<>("height", "Высота", "428 мм"));
            part22config.add(new CharacteristicItem<>("length", "Длина", "431 мм"));
            part22config.add(new CharacteristicItem<>("max_cpu_cooler_height", "Макс. высота кулера для процессора", "165 мм"));
            part22config.add(new CharacteristicItem<>("max_gpu_length", "Макс. длина GPU", "320 мм"));
            part22config.add(new CharacteristicItem<>("max_liquid_cooling_length", "Макс. длина жидкостного охлаждения", "270 мм"));
            part22config.add(new CharacteristicItem<>("ssd_slots_quantity", "Количество слотов для SSD", "2"));
            part22config.add(new CharacteristicItem<>("weight", "Вес", "6 кг"));
            part22config.add(new CharacteristicItem<>("width", "Ширина", "215 мм"));
            part22config.add(new CharacteristicItem<>("possible_form_factors", "Поддерживаемые форм-факторы", "micro-ATX, mini-ATX"));
            partsRepository.save(new Parts("part-22", "DeepCool CH360", "/uploads/deepcool-ch360.jpg", "Описание...", 200,
                    part22config, categoriesRepository.findByValue("components").get(),
                    partitionsRepository.findByValue("deepcool").get(),
                    typesRepository.findByValue("cases").get()));

            List<CharacteristicItem> part23config = new ArrayList<>();
            part23config.add(new CharacteristicItem<>("air_flow", "Воздушный поток", "59 CFM"));
            part23config.add(new CharacteristicItem<>("max_noise_level", "Макс. уровень шума", "27 dB"));
            part23config.add(new CharacteristicItem<>("backlight", "Подсветка", "ARGB"));
            part23config.add(new CharacteristicItem<>("fan_size", "Размер вентилятора", "120x120 мм"));
            part23config.add(new CharacteristicItem<>("fan_speed", "Скорость вентилятора", "800-1800 об/мин"));
            partsRepository.save(new Parts("part-23", "Montech AX 120 PWM White", "/uploads/montech-ax-120-pwm-white.jpg", "Описание...", 60,
                    part23config, categoriesRepository.findByValue("components").get(),
                    partitionsRepository.findByValue("120x120mm").get(),
                    typesRepository.findByValue("fan").get()));

            List<CharacteristicItem> part24config = new ArrayList<>();
            part24config.add(new CharacteristicItem<>("air_flow", "Воздушный поток", "81 CFM"));
            part24config.add(new CharacteristicItem<>("max_noise_level", "Макс. уровень шума", "26.8 dB"));
            part24config.add(new CharacteristicItem<>("backlight", "Подсветка", "ARGB"));
            part24config.add(new CharacteristicItem<>("fan_size", "Размер вентилятора", "140x140 мм"));
            part24config.add(new CharacteristicItem<>("fan_speed", "Скорость вентилятора", "250-1600 об/мин"));
            partsRepository.save(new Parts("part-24", "Lian Li UNI FAN AL V2 120 White", "/uploads/lian-li-uni-fan-al-v2-120-white.jpg", "Описание...", 70,
                    part24config, categoriesRepository.findByValue("components").get(),
                    partitionsRepository.findByValue("140x140mm").get(),
                    typesRepository.findByValue("fan").get()));

            List<CharacteristicItem> part25config = new ArrayList<>();
            part25config.add(new CharacteristicItem<>("air_flow", "Воздушный поток", "75 CFM"));
            part25config.add(new CharacteristicItem<>("max_noise_level", "Макс. уровень шума", "26.8 dB"));
            part25config.add(new CharacteristicItem<>("backlight", "Подсветка", "Отсутствует"));
            part25config.add(new CharacteristicItem<>("fan_size", "Размер вентилятора", "120x120 мм"));
            part25config.add(new CharacteristicItem<>("fan_speed", "Скорость вентилятора", "500-1600 об/мин"));
            partsRepository.save(new Parts("part-25", "Thermaltake TOUGHFAN 12 White", "/uploads/thermaltake-toughfan-12-white.jpg", "Описание...", 80,
                    part25config, categoriesRepository.findByValue("components").get(),
                    partitionsRepository.findByValue("120x120mm").get(),
                    typesRepository.findByValue("fan").get()));

            List<CharacteristicItem> part26config = new ArrayList<>();
            part26config.add(new CharacteristicItem<>("diagonal", "Диагональ", "24\""));
            part26config.add(new CharacteristicItem<>("resolution", "Разрешение", "1920x1080 (16:9)"));
            part26config.add(new CharacteristicItem<>("matrix", "Матрица", "IPS"));
            part26config.add(new CharacteristicItem<>("frequency", "Частота обновления экрана", "144 Гц"));
            part26config.add(new CharacteristicItem<>("ports", "Входы", "DisplayPort, HDMI"));
            partsRepository.save(new Parts("part-26", "LG UltraGear 24GN65R", "/uploads/lg-ultragear-24gn65r.jpg", "Описание...", 350,
                    part26config, categoriesRepository.findByValue("periphery").get(),
                    partitionsRepository.findByValue("24inch").get(),
                    typesRepository.findByValue("monitor").get()));

            List<CharacteristicItem> part27config = new ArrayList<>();
            part27config.add(new CharacteristicItem<>("buttons_quantity", "Количество программируемых клавиш", "5"));
            part27config.add(new CharacteristicItem<>("sensor_model", "Модель сенсора", "Razer Focus Pro 30K"));
            part27config.add(new CharacteristicItem<>("sensor_resolution", "Разрешение оптического сенсора", "30000 DPI"));
            part27config.add(new CharacteristicItem<>("weight", "Вес", "64 г"));
            partsRepository.save(new Parts("part-27", "Razer DeathAdder V3 Pro", "/uploads/razer-deathadder-v3-pro.jpg", "Описание...", 220,
                    part27config, categoriesRepository.findByValue("periphery").get(),
                    partitionsRepository.findByValue("razer").get(),
                    typesRepository.findByValue("mouse").get()));

            List<CharacteristicItem> part28config = new ArrayList<>();
            part28config.add(new CharacteristicItem<>("connection_type", "Тип подключения", "с проводом"));
            part28config.add(new CharacteristicItem<>("microphone", "Микрофон с шумоподавлением", "есть"));
            part28config.add(new CharacteristicItem<>("connector", "Разъем", "USB"));
            part28config.add(new CharacteristicItem<>("weight", "Вес", "250 г"));
            partsRepository.save(new Parts("part-28", "Razer Kraken V3", "/uploads/razer-kraken-v3.jpg", "Описание...", 300,
                    part28config, categoriesRepository.findByValue("periphery").get(),
                    partitionsRepository.findByValue("razer").get(),
                    typesRepository.findByValue("headphones").get()));


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
