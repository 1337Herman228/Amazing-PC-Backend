---------------------- Cpu ----------------------
-- I5-12400F
INSERT INTO public.cpu (base_frequency, boost_frequency, cpu_cores, cpu_threads, max_ram_capacity, tdp, cpu_id, cashl1,
                        cashl2, cashl3, socket, tech_process, ram_type)
VALUES (2500, 4400, 6, 12, 128, 65, 1, null, '7680 КБ', '18432 КБ', 'LGA 1700', 'intel 7',
        '{"ramType": ["DDR4","DDR5"]}');

-- I5-14400F
INSERT INTO public.cpu (base_frequency, boost_frequency, cpu_cores, cpu_threads, max_ram_capacity, tdp, cpu_id, cashl1,
                        cashl2, cashl3, socket, tech_process, ram_type)
VALUES (2500, 4700, 10, 16, 128, 65, 2, null, '9728 КБ', '20480 КБ', 'LGA 1700', '7 нм',
        '{"ramType": ["DDR4","DDR5"]}');

-- I7-14700KF
INSERT INTO public.cpu (base_frequency, boost_frequency, cpu_cores, cpu_threads, max_ram_capacity, tdp, cpu_id, cashl1,
                        cashl2, cashl3, socket, tech_process, ram_type)
VALUES (2100, 5400, 20, 28, 128, 65, 3, '80 КБ', '20 MБ', '33 MБ', 'LGA 1700', 'intel 7',
        '{"ramType": ["DDR4","DDR5"]}');


---------------------- Gpu ----------------------
-- PALIT GeForce RTX 4060 DUAL
INSERT INTO public.gpu (base_frequency, boost_frequency, bus_width, cuda, display_port, extension_slots, fans, hdmi,
                        height, length, max_displays_quantity, min_power_unit, tech_process, vram_capacity, width,
                        gpu_id, max_resolution, vram_type, power_connector)
VALUES (1830, 2460, 128, 3072, 3, 2, 2, 1, 40, 249, 4, 500, 5, 8, 123, 1, '5120x2880', 'GDDR6', '8 pin');

-- Palit GeForce RTX 4070 SUPER JetStream
INSERT INTO public.gpu (base_frequency, boost_frequency, bus_width, cuda, display_port, extension_slots, fans, hdmi,
                        height, length, max_displays_quantity, min_power_unit, tech_process, vram_capacity, width,
                        gpu_id, max_resolution, vram_type, power_connector)
VALUES (1980, 2640, 192, 7680, 3, 3.1, 3, 1, 63.5, 329, 4, 700, 5, 12, 130, 2, '7680x4320', 'GDDR6X', '8+8 pin');

-- MSI GeForce RTX 4080 SUPER GAMING SLIM
INSERT INTO public.gpu (base_frequency, boost_frequency, bus_width, cuda, display_port, extension_slots, fans, hdmi,
                        height, length, max_displays_quantity, min_power_unit, tech_process, vram_capacity, width,
                        gpu_id, max_resolution, vram_type, power_connector)
VALUES (2000, 2565, 256, 10240, 2, null, 3, 2, 62, 322, 4, 850, 5, 16, 136, 3, '7680x4320', 'GDDR6X', '8+8 pin');


---------------------- Motherboard ----------------------
-- MSI PRO B760M-A
INSERT INTO public.motherboard (m2quantity, max_ram_capacity, pcie16quantity, ram_slots, sata_quantity, motherboard_id,
                                chipset, form_factor, ram_type, socket)
VALUES (2, 128, 2, 4, 4, 1, 'Intel B760', 'microATX', 'DDR4', 'LGA 1700');

-- MSI PRO Z790-A MAX
INSERT INTO public.motherboard (m2quantity, max_ram_capacity, pcie16quantity, ram_slots, sata_quantity, motherboard_id,
                                chipset, form_factor, ram_type, socket)
VALUES (4, 128, 3, 4, 6, 2, 'Intel Z790', 'ATX', 'DDR5', 'LGA 1700');


---------------------- Cpu_Air_Cooling ----------------------
-- DeepCool ASSASSIN 4S
INSERT INTO public.cpu_air_cooling (air_flow, fans_quantity, height, max_noise_level, tdp, cpu_air_cooling_id,
                                    backlight, connector, fan_size, fan_speed, sockets)
VALUES (61.25, 1, 165, 23.7, 250, 1, 'Отсутствует', '4-pin PWM', '140x140x25 мм', '500-1800 об/мин',
        '{"sockets": ["AM4", "AM5", "LGA 1150", "LGA 1151", "LGA 1155", "LGA 1200", "LGA 1700", "LGA 2011", "LGA 2011-3", "LGA 2066"]}');

---------------------- Cpu_Liquid_Cooling ----------------------
-- ASUS ROG RYUO III 360 White
INSERT INTO public.cpu_liquid_cooling (air_flow, fans_quantity, height, length, max_noise_level, tdp, width,
                                       cpu_liquid_cooling_id, backlight, connector, fan_size, fan_speed, sockets)
VALUES (70.07, 3, 30, 399.5, 36.45, 280, 120, 1, 'ARGB', '4-pin PWM', '120x120x25 мм', '2200 +/- 300 RPM', '{"sockets": ["AM4", "AM5", "LGA 1150", "LGA 1151", "LGA 1155", "LGA 1200", "LGA 1700", "LGA 2011", "LGA 2011-3", "LGA 2066"]}');


---------------------- Ram ----------------------
-- 16GB Kingston FURY Beast RGB
INSERT INTO public.ram (capacity, frequency, ram_id, type)
VALUES (16, 3600, 1, 'DDR4');

-- 32GB Kingston FURY Beast RGB
INSERT INTO public.ram (capacity, frequency, ram_id, type)
VALUES (32, 3600, 2, 'DDR4');

-- 64GB TEAMGROUP T-Force Delta RGB White
INSERT INTO public.ram (capacity, frequency, ram_id, type)
VALUES (64, 6000, 3, 'DDR5');


---------------------- Ssd ----------------------
-- 512GB ADATA LEGEND 850
INSERT INTO public.ssd (max_temperature, mtbf_time, random_write_speed, read_velocity, write_velocity, ssd_id, capacity,
                        flash_memory_type, form_factor, connection_type, controller_type)
VALUES (null, null, 530000, 5000, 2700, 1, '512 ГБ', '3D NAND', 'M.2 NVME', 'PCI-E 4.0 x4', 'Silicon Motion SM2269XT');

-- 1TB ADATA LEGEND 850
INSERT INTO public.ssd (max_temperature, mtbf_time, random_write_speed, read_velocity, write_velocity, ssd_id, capacity,
                        flash_memory_type, form_factor, connection_type, controller_type)
VALUES (null, null, 530000, 5000, 4500, 2, '1 TБ', '3D NAND', 'M.2 NVME', 'PCI-E 4.0 x4', 'Silicon Motion SM2269XT');

-- 2TB Samsung 990 PRO
INSERT INTO public.ssd (max_temperature, mtbf_time, random_write_speed, read_velocity, write_velocity, ssd_id, capacity,
                        flash_memory_type, form_factor, connection_type, controller_type)
VALUES ('70 °C', null, 1550000, 7450, 6900, 3, '2 TБ', 'MLC 3D NAND', 'M.2 NVME', null, null);


---------------------- Psu ----------------------
-- 650W DeepCool PK650D
INSERT INTO public.psu (cpu4plus4quantity, gpu6plus2quantity, power, sata_quantity, psu_id, form_factor, mb_connector,
                        pfc, certificate, modular, cooling_system)
VALUES (1, 2, 650, 5, 1, 'ATX', '20+4 pin', 'активный', '80+ Bronze', 'Полумодульный', '1 вентилятор (120 мм)');

-- 750W DeepCool PK750D
INSERT INTO public.psu (cpu4plus4quantity, gpu6plus2quantity, power, sata_quantity, psu_id, form_factor, mb_connector,
                        pfc, certificate, modular, cooling_system)
VALUES (2, 4, 750, 7, 2, 'ATX', '20+4 pin', 'активный', '80+ Bronze', 'Полумодульный', '1 вентилятор (120 мм)');

-- 850W MSI MAG A850GL
INSERT INTO public.psu (cpu4plus4quantity, gpu6plus2quantity, power, sata_quantity, psu_id, form_factor, mb_connector,
                        pfc, certificate, modular, cooling_system)
VALUES (2, 5, 850, 8, 3, 'ATX12V 3.0', '20+4 pin', 'активный', '80+ Gold', 'Модульный', '1 вентилятор (120 мм)');


---------------------- Cases ----------------------
-- ASUS TUF GAMING GT502 White
INSERT INTO public.cases (extension_slots_quantity, hdd_slots_quantity, height, length, max_cpu_cooler_height,
                          max_gpu_length, max_liquid_cooling_length, ssd_slots_quantity, weight, width, case_id,
                          possible_form_factors)
VALUES (8, 4, 450, 446, 163, 400, 420, 4, 11, 285, 1, '{"form-factors": ["micro-ATX","mini-ATX","ATX"]}');

-- Lian Li O11 Vision White
INSERT INTO public.cases (extension_slots_quantity, hdd_slots_quantity, height, length, max_cpu_cooler_height,
                          max_gpu_length, max_liquid_cooling_length, ssd_slots_quantity, weight, width, case_id,
                          possible_form_factors)
VALUES (6, 2, 464, 480, 174, 430, 390, 5, 18, 304, 2, '{"form-factors": ["micro-ATX","mini-ATX","ATX"]}');

-- DeepCool CH360
INSERT INTO public.cases (extension_slots_quantity, hdd_slots_quantity, height, length, max_cpu_cooler_height,
                          max_gpu_length, max_liquid_cooling_length, ssd_slots_quantity, weight, width, case_id,
                          possible_form_factors)
VALUES (4, 3, 428, 431, 165, 320, 270, 2, 6, 215, 3, '{"form-factors": ["micro-ATX","mini-ATX"]}');


---------------------- Fans ----------------------
-- Montech AX 120 PWM White
INSERT INTO public.fans (air_flow, max_noise_level, fan_id, backlight, fan_size, fan_speed)
VALUES (59, 27, 1, 'ARGB', '120x120 мм', '800-1800 об/мин');

-- Lian Li UNI FAN AL V2 120 White
INSERT INTO public.fans (air_flow, max_noise_level, fan_id, backlight, fan_size, fan_speed)
VALUES (81, 26.8, 2, 'ARGB', '140x140 мм', '250-1600 об/мин');

-- Thermaltake TOUGHFAN 12 White
INSERT INTO public.fans (air_flow, max_noise_level, fan_id, backlight, fan_size, fan_speed)
VALUES (75, 26.8, 3, 'Отсутствует', '120x120 мм', '500-1600 об/мин');


---------------------- Periphery ----------------------
-- LG UltraGear 24GN65R
INSERT INTO public.periphery (periphery_id, characteristics)
VALUES (1,
        '{"Диагональ":"24\"","Разрешение":"1920x1080 (16:9)","Матрица": "IPS", "Частота обновления экрана": "144 Гц", "Входы": "DisplayPort, HDMI"}');

-- Razer DeathAdder V3 Pro
INSERT INTO public.periphery (periphery_id, characteristics)
VALUES (2,
        '{"КОЛИЧЕСТВО ПРОГРАММИРУЕМЫХ КЛАВИШ":"5","МОДЕЛЬ СЕНСОРА":"Razer Focus Pro 30K","РАЗРЕШЕНИЕ ОПТИЧЕСКОГО СЕНСОРА":"30000 DPI","ВЕС":"64 г"}');

-- Razer Kraken V3
INSERT INTO public.periphery (periphery_id, characteristics)
VALUES (3,
        '{"ТИП ПОДКЛЮЧЕНИЯ":"с проводом","МИКРОФОН С ШУМОПОДАВЛЕНИЕМ":"есть","РАЗЪЕМ":"USB","ВЕС":"250 г"}');


---------------------- Categories ----------------------
INSERT INTO public.categories (category_id, category_name)
VALUES (1, 'Комплектующие');

INSERT INTO public.categories (category_id, category_name)
VALUES (2, 'Периферия');


---------------------- Partitions ----------------------
INSERT INTO public.partitions (partition_id, partition_name)
VALUES (1, 'RTX 4060');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (2, 'Intel Core 12th');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (3, 'Intel Core 14th');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (4, 'RTX 4070');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (5, 'RTX 4080');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (6, 'Intel B760');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (7, 'Intel Z790');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (8, 'Deepcool');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (9, 'Asus');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (10, '16 ГБ');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (11, '32 ГБ');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (12, '64 ГБ');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (13, '512 ГБ');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (14, '1 ТБ');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (15, '2 ТБ');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (16, 'от 500W');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (17, 'от 700W');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (18, 'от 800W');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (19, 'от 800W');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (20, 'Lian Li');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (21, '120x120 ММ');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (22, '140x140 ММ');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (23, '24"');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (24, '27"');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (25, '32"');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (26, 'Razer');


---------------------- Types ----------------------
INSERT INTO public.types (type_id, type_name, alternative_name)
VALUES (1, 'gpu', 'Видеокарта');

INSERT INTO public.types (type_id, type_name, alternative_name)
VALUES (2, 'сpu', 'Процессор');

INSERT INTO public.types (type_id, type_name, alternative_name)
VALUES (3, 'motherboard', 'Материнская плата');

INSERT INTO public.types (type_id, type_name, alternative_name)
VALUES (4, 'cpu_fan', 'Охлаждение');

INSERT INTO public.types (type_id, type_name, alternative_name)
VALUES (5, 'ram', 'Оперативная память');

INSERT INTO public.types (type_id, type_name, alternative_name)
VALUES (6, 'ssd', 'SSD накопитель');

INSERT INTO public.types (type_id, type_name, alternative_name)
VALUES (7, 'psu', 'Блок питания');

INSERT INTO public.types (type_id, type_name, alternative_name)
VALUES (8, 'case', 'Корпус');

INSERT INTO public.types (type_id, type_name, alternative_name)
VALUES (9, 'fan', 'Вентилятор');

INSERT INTO public.types (type_id, type_name, alternative_name)
VALUES (10, 'display', 'Монитор');

INSERT INTO public.types (type_id, type_name, alternative_name)
VALUES (11, 'mouse', 'Мышь');

INSERT INTO public.types (type_id, type_name, alternative_name)
VALUES (12, 'headphones', 'Наушники');


---------------------- Parts ----------------------
-- I5-12400F
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (350, 15, null, 1, null, 1, null, null, null, null, 1, 2, null, null, null, null, 2, 'I5-12400F', 'Описание...',
        '/cpu/i5-12400f');

-- I5-14400F
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (450, 15, null, 1, null, 2, null, null, null, null, 2, 3, null, null, null, null, 2, 'I5-14400F', 'Описание...',
        '/cpu/i5-14400f');

-- I7-14700KF
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (650, 10, null, 1, null, 3, null, null, null, null, 3, 3, null, null, null, null, 2, 'I7-14700KF', 'Описание...',
        '/cpu/i7-14700kf');

-- PALIT GeForce RTX 4060 DUAL
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (1050, 10, null, 1, null, null, null, null, 1, null, 4, 1, null, null, null, null, 1, 'PALIT GeForce RTX 4060 DUAL', 'Описание...',
        '/gpu/palit-geforce-rtx-4060-dual');

-- Palit GeForce RTX 4070 SUPER JetStream
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (1350, 10, null, 1, null, null, null, null, 2, null, 5, 4, null, null, null, null, 1, 'Palit GeForce RTX 4070 SUPER JetStream', 'Описание...',
        '/gpu/palit-geforce-rtx-4070-super-jetstream');

-- MSI GeForce RTX 4080 SUPER GAMING SLIM
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (1650, 10, null, 1, null, null, null, null, 3, null, 6, 5, null, null, null, null, 1, 'MSI GeForce RTX 4080 SUPER GAMING SLIM', 'Описание...',
        '/gpu/msi-geforce-rtx-4080-super-gaming-slim');

-- MSI PRO B760M-A
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (330, 15, null, 1, null, null, null, null, null, 1, 7, 6, null, null, null, null, 3, 'MSI PRO B760M-A', 'Описание...',
        '/motherboard/msi-pro-b760m-a');

-- MSI PRO Z790-A MAX
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (450, 15, null, 1, null, null, null, null, null, 2, 8, 7, null, null, null, null, 3, 'MSI PRO Z790-A MAX', 'Описание...',
        '/motherboard/msi-pro-z790-a-max');

-- DeepCool ASSASSIN 4S
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (150, 15, null, 1, 1, null, null, null, null, null, 9, 8, null, null, null, null, 4, 'DeepCool ASSASSIN 4S', 'Описание...',
        '/cpu-fan/deepcool-assassin-4s');

-- ASUS ROG RYUO III 360 White
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (460, 15, null, 1, null, null, 1, null, null, null, 10, 9, null, null, null, null, 4, 'ASUS ROG RYUO III 360 White', 'Описание...',
        '/cpu-fan/asus-rog-ryuo-III-360-white');

-- 16GB Kingston FURY Beast RGB
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (200, 30, null, 1, null, null, null, null, null, null, 11, 10, null, null, 1, null, 5, '16GB Kingston FURY Beast RGB', 'Описание...',
        '/ram/16gb-kingston-fury-beast-rgb');

-- 32GB Kingston FURY Beast RGB
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (320, 20, null, 1, null, null, null, null, null, null, 12, 11, null, null, 2, null, 5, '32GB Kingston FURY Beast RGB', 'Описание...',
        '/ram/32gb-kingston-fury-beast-rgb');

-- 64GB TEAMGROUP T-Force Delta RGB White
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (600, 20, null, 1, null, null, null, null, null, null, 13, 12, null, null, 3, null, 5, '64GB TEAMGROUP T-Force Delta RGB White', 'Описание...',
        '/ram/64gb-teamgroup-t-force-delta-rgb-white');

-- 512GB ADATA LEGEND 850
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (230, 30, null, 1, null, null, null, null, null, null, 14, 13, null, null, null, 1, 6, '512GB ADATA LEGEND 850', 'Описание...',
        '/ssd/512gb-adata-legend-850');

-- 1TB ADATA LEGEND 850
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (380, 20, null, 1, null, null, null, null, null, null, 15, 14, null, null, null, 2, 6, '1TB ADATA LEGEND 850', 'Описание...',
        '/ssd/1tb-adata-legend-850');

-- 2TB Samsung 990 PRO
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (550, 15, null, 1, null, null, null, null, null, null, 16, 15, null, null, null, 3, 6, '2TB Samsung 990 PRO', 'Описание...',
        '/ssd/2tb-samsung-990-pro');

-- 650W DeepCool PK650D
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (310, 15, null, 1, null, null, null, null, null, null, 17, 16, null, 1, null, null, 7, '650W DeepCool PK650D', 'Описание...',
        '/psu/650w-deepcool-pk650d');

-- 750W DeepCool PK750D
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (410, 15, null, 1, null, null, null, null, null, null, 18, 17, null, 2, null, null, 7, '750W DeepCool PK750D', 'Описание...',
        '/psu/750w-deepcool-pk750d');

-- 850W MSI MAG A850GL
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (610, 10, null, 1, null, null, null, null, null, null, 19, 18, null, 3, null, null, 7, '850W MSI MAG A850GL', 'Описание...',
        '/psu/850w-msi-mag-a850gl');

-- ASUS TUF GAMING GT502 White
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (380, 10, 1, 1, null, null, null, null, null, null, 20, 9, null, null, null, null, 8, 'ASUS TUF GAMING GT502 White', 'Описание...',
        '/case/asus-tuf-gaming-gt502-white');

-- Lian Li O11 Vision White
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (450, 10, 2, 1, null, null, null, null, null, null, 21, 20, null, null, null, null, 8, 'Lian Li O11 Vision White', 'Описание...',
        '/case/lian-li-011-vision-white');

-- DeepCool CH360
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (200, 25, 3, 1, null, null, null, null, null, null, 22, 8, null, null, null, null, 8, 'DeepCool CH360', 'Описание...',
        '/case/deepcool-ch360');

-- Montech AX 120 PWM White
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (60, 40, null, 1, null, null, null, 1, null, null, 23, 21, null, null, null, null, 9, 'Montech AX 120 PWM White', 'Описание...',
        '/fans/montech-ax-120-pwm-white');

-- Lian Li UNI FAN AL V2 120 White
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (70, 40, null, 1, null, null, null, 2, null, null, 24, 21, null, null, null, null, 9, 'Lian Li UNI FAN AL V2 120 White', 'Описание...',
        '/fans/lian-li-uni-fan-al-v2-120-white');

-- Thermaltake TOUGHFAN 12 White
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (80, 30, null, 1, null, null, null, 3, null, null, 25, 22, null, null, null, null, 9, 'Thermaltake TOUGHFAN 12 White', 'Описание...',
        '/fans/thermaltake-toughfan-12-white');

-- LG UltraGear 24GN65R
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (350, 10, null, 2, null, null, null, null, null, null, 26, 23, 1, null, null, null, 10, 'LG UltraGear 24GN65R', 'Описание...',
        '/periphery/lg-ultragear-24gn65r');

-- Razer DeathAdder V3 Pro
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (220, 10, null, 2, null, null, null, null, null, null, 27, 26, 2, null, null, null, 11, 'Razer DeathAdder V3 Pro', 'Описание...',
        '/periphery/razer-deathadder-v3-pro');

-- Razer Kraken V3
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (300, 10, null, 2, null, null, null, null, null, null, 28, 26, 3, null, null, null, 12, 'Razer Kraken V3', 'Описание...',
        '/periphery/razer-kraken-v3');


---------------------- Pc_types ----------------------
INSERT INTO public.pc_types (pc_type_id, type)
VALUES (1, 'pc');

INSERT INTO public.pc_types (pc_type_id, type)
VALUES (2, 'notebook');

INSERT INTO public.pc_types (pc_type_id, type)
VALUES (3, 'workstation');

INSERT INTO public.pc_types (pc_type_id, type)
VALUES (4, 'configuration');


---------------------- Pc_categories ----------------------
INSERT INTO public.pc_categories (pc_category_id, pc_category_name)
VALUES (1, 'Нет категории');

INSERT INTO public.pc_categories (pc_category_id, pc_category_name)
VALUES (2, 'Оптимальные игровые компьютеры');

INSERT INTO public.pc_categories (pc_category_id, pc_category_name)
VALUES (3, 'Мощные игровые компьютеры');

INSERT INTO public.pc_categories (pc_category_id, pc_category_name)
VALUES (4, 'Кастомные компьютеры');

INSERT INTO public.pc_categories (pc_category_id, pc_category_name)
VALUES (5, 'Игровые мини ПК');

INSERT INTO public.pc_categories (pc_category_id, pc_category_name)
VALUES (6, 'Оптимальные рабочие станции');

INSERT INTO public.pc_categories (pc_category_id, pc_category_name)
VALUES (7, 'Мощные рабочие станции');

INSERT INTO public.pc_categories (pc_category_id, pc_category_name)
VALUES (8, 'Кастомные рабочие станции');


---------------------- Pc_header ----------------------
INSERT INTO public.pc_header (pc_header_id, description, image, image_mobile)
VALUES (1, 'Описание...', '/pc/header/header-1', '/pc/header/header-1-mobile');

INSERT INTO public.pc_header (pc_header_id, description, image, image_mobile)
VALUES (2, 'Описание...', '/pc/header/header-2', '/pc/header/header-2-mobile');

INSERT INTO public.pc_header (pc_header_id, description, image, image_mobile)
VALUES (3, 'Описание...', '/pc/header/header-3', '/pc/header/header-3-mobile');


---------------------- Pc_design ----------------------
INSERT INTO public.pc_design (pc_design_id, title, description, image)
VALUES (1, 'Заголовок...', 'Описание...', '/pc/design/design-1');

INSERT INTO public.pc_design (pc_design_id, title, description, image)
VALUES (2, 'Заголовок...', 'Описание...', '/pc/design/design-2');

INSERT INTO public.pc_design (pc_design_id, title, description, image)
VALUES (3, 'Заголовок...', 'Описание...', '/pc/design/design-3');


---------------------- Pc_preview ----------------------
INSERT INTO public.pc_preview (pc_preview_id, title, description, main_image, slider_images)
VALUES (1, 'Заголовок...', 'Описание...', '/pc/preview/preview-1', '{"slider_images": ["/pc/preview/slider-image-1.1","/pc/preview/slider-image-1.2","/pc/preview/slider-image-1.3"]}');

INSERT INTO public.pc_preview (pc_preview_id, title, description, main_image, slider_images)
VALUES (2, 'Заголовок...', 'Описание...', '/pc/preview/preview-2', '{"slider_images": ["/pc/preview/slider-image-2.1","/pc/preview/slider-image-2.2","/pc/preview/slider-image-2.3"]}');

INSERT INTO public.pc_preview (pc_preview_id, title, description, main_image, slider_images)
VALUES (3, 'Заголовок...', 'Описание...', '/pc/preview/preview-3', '{"slider_images": ["/pc/preview/slider-image-3.1","/pc/preview/slider-image-3.2","/pc/preview/slider-image-3.3"]}');

---------------------- Pc_performance ----------------------
INSERT INTO public.pc_performance (pc_performance_id, title, description, image, image2)
VALUES (1, 'Заголовок...', 'Описание...', '/pc/performance/performance-1.1', '/pc/performance/performance-1.2');

INSERT INTO public.pc_performance (pc_performance_id, title, description, image, image2)
VALUES (2, 'Заголовок...', 'Описание...', '/pc/performance/performance-2.1', '/pc/performance/performance-2.2');

INSERT INTO public.pc_performance (pc_performance_id, title, description, image, image2)
VALUES (3, 'Заголовок...', 'Описание...', '/pc/performance/performance-3.1', '/pc/performance/performance-3.2');


---------------------- Pc_model_groups ----------------------
-- One
INSERT INTO public.pc_model_groups (pc_category_id, pc_design_id, pc_header_id, pc_model_group_id, pc_performance_id,
                                    pc_preview_id, pc_type_id, model_group_name, model_group_description,
                                    cpu_description, gpu_description, motherboard_description, psu_description,
                                    ram_description, ssd_description)
VALUES (2, 1, 1, 1, 1, 1, 1,
        'One', 'Начальный игровой компьютер',
        'Процессоры 6 и 10 ядерные Intel Core i5',
        'Графические карты GeForce RTX 4060 и 4060 Ti',
        'Материнские платы на чипсете Intel B760',
        'Блок питания на 550W / 650W стандарта 80+ Bronze',
        'Оперативная память от 16 до 32 GB DDR4 3600MHz',
        'Накопители SSD на 512 GB / 1 TB с интерфейсом М.2');

-- PLAY 17
INSERT INTO public.pc_model_groups (pc_category_id, pc_design_id, pc_header_id, pc_model_group_id, pc_performance_id,
                                    pc_preview_id, pc_type_id, model_group_name, model_group_description,
                                    cpu_description, gpu_description, motherboard_description, psu_description,
                                    ram_description, ssd_description)
VALUES (1, 2, 2, 2, 2, 2, 2,
        'Play 17', 'Игровые ноутбки HYPERPC',
        'Процессоры 6 и 10 ядерные Intel Core i5',
        'Графические карты GeForce RTX 4060 и 4060 Ti',
        null,
        null,
        'Оперативная память от 16 до 32 GB DDR4 3600MHz',
        'Накопители SSD на 512 GB / 1 TB с интерфейсом М.2');

-- G1 PRO
INSERT INTO public.pc_model_groups (pc_category_id, pc_design_id, pc_header_id, pc_model_group_id, pc_performance_id,
                                    pc_preview_id, pc_type_id, model_group_name, model_group_description,
                                    cpu_description, gpu_description, motherboard_description, psu_description,
                                    ram_description, ssd_description)
VALUES (6, 3, 3, 3, 3, 3, 3,
        'G1 PRO', 'Для графических дизайнеров',
        'Процессоры 6 и 10 ядерные Intel Core i5',
        'Графические карты GeForce RTX 4060 и 4060 Ti',
        'Материнские платы на чипсете Intel B760',
        'Блок питания на 550W / 650W стандарта 80+ Bronze',
        'Оперативная память от 16 до 32 GB DDR4 3600MHz',
        'Накопители SSD на 512 GB / 1 TB с интерфейсом М.2');


---------------------- Pc ----------------------
-- One Super
INSERT INTO public.pc (total_price, case_id, cpu_fan_id, cpu_id, gpu_id, motherboard_id, pc_category_id, pc_id,
                       pc_model_group_id, pc_type_id, psu_id, ram_id, name, description)
VALUES (4500, 22, 9, 1, 4, 7, 2,
        1,1, 1, 17, 11,
        'One Super',
        'Платформа для гейминга в Full HD разрешении, созданная на базе центрального процессора Intel® Core™ i5-12400F [до 4.4GHz, 6 ядер] и видеокарты Palit GeForce RTX 4060 Ti Dual [8GB, 4352 CUDA].');

-- One Max
INSERT INTO public.pc (total_price, case_id, cpu_fan_id, cpu_id, gpu_id, motherboard_id, pc_category_id, pc_id,
                       pc_model_group_id, pc_type_id, psu_id, ram_id, name, description)
VALUES (5500, 22, 9, 2, 5, 7, 2,
        2,1, 1, 18, 12,
        'One Max',
        'Платформа для гейминга в Full HD разрешении, созданная на базе центрального процессора Intel® Core™ i5-12400F [до 4.4GHz, 6 ядер] и видеокарты Palit GeForce RTX 4060 Ti Dual [8GB, 4352 CUDA].');

-- One Ultra
INSERT INTO public.pc (total_price, case_id, cpu_fan_id, cpu_id, gpu_id, motherboard_id, pc_category_id, pc_id,
                       pc_model_group_id, pc_type_id, psu_id, ram_id, name, description)
VALUES (6800, 22, 9, 2, 5, 7, 2,
        3,1, 1, 18, 12,
        'One Ultra',
        'Платформа для гейминга в Full HD разрешении, созданная на базе центрального процессора Intel® Core™ i5-12400F [до 4.4GHz, 6 ядер] и видеокарты Palit GeForce RTX 4060 Ti Dual [8GB, 4352 CUDA].');

-- PLAY 17 M1
INSERT INTO public.pc (total_price, case_id, cpu_fan_id, cpu_id, gpu_id, motherboard_id, pc_category_id, pc_id,
                       pc_model_group_id, pc_type_id, psu_id, ram_id, name, description)
VALUES (7400, null, null, 2, 5, null, 1,
        4,1, 2, null, 12,
        'PLAY 17 M1',
        'Ноутбук PLAY 17 – это отличный выбор для тех, кто хочет обладать современным ноутбуком, который можно использовать для игр, работы и учёбы. Имеет установленную ОС Windows 11 Home.');

-- G1 PRO Super
INSERT INTO public.pc (total_price, case_id, cpu_fan_id, cpu_id, gpu_id, motherboard_id, pc_category_id, pc_id,
                       pc_model_group_id, pc_type_id, psu_id, ram_id, name, description)
VALUES (3500, 22, 9, 2, 5, 7, 2,
        5,3, 3, 18, 12,
        'G1 PRO Super',
        'Надежный начального уровня компьютер, оснащенный быстрым процессором и высокоскоростной памятью, предназначенный для профессиональных приложений и эффективной многозадачности.');

-- Configuration without pc_model_group
INSERT INTO public.pc (total_price, case_id, cpu_fan_id, cpu_id, gpu_id, motherboard_id, pc_category_id, pc_id,
                       pc_model_group_id, pc_type_id, psu_id, ram_id, name, description)
VALUES (3500, 22, 9, 2, 5, 7, 2,
        6,null, 3, 18, 12,
        'My Configuration',
        null);


---------------------- Pc_ssd_quantity ----------------------
INSERT INTO public.pc_ssd_quantity (quantity, id, pc_id, ssd_id)
VALUES (1, 1, 1, 14);

INSERT INTO public.pc_ssd_quantity (quantity, id, pc_id, ssd_id)
VALUES (1, 2, 4, 15);


---------------------- Pc_fans_quantity ----------------------
INSERT INTO public.pc_fans_quantity (quantity, fan_id, id, pc_id)
VALUES (2, 23, 1, 2);

INSERT INTO public.pc_fans_quantity (quantity, fan_id, id, pc_id)
VALUES (4, 24, 2, 3);


---------------------- Roles ----------------------
INSERT INTO public.roles (role_id, position)
VALUES (1, 'admin');

INSERT INTO public.roles (role_id, position)
VALUES (2, 'user');


---------------------- Person ----------------------
INSERT INTO public.person (person_id, phone, email, name, surname)
VALUES (1, '+375(29)3641160', 'email@mail.ru', 'Гемран', 'Гей');

INSERT INTO public.person (person_id, phone, email, name, surname)
VALUES (2, '+375(29)1234567', 'email@gmail.com', 'Иван', 'Иванов');

INSERT INTO public.person (person_id, phone, email, name, surname)
VALUES (3, '+375(29)3334444', 'email@gmail.com', 'Имя', 'Фамилия');


---------------------- Users ----------------------
INSERT INTO public.users (person_id, role_id, user_id, password, login)
VALUES (1, 1, 1, 'password', 'login');

INSERT INTO public.users (person_id, role_id, user_id, password, login)
VALUES (2, 2, 2, '123', '123');

INSERT INTO public.users (person_id, role_id, user_id, password, login)
VALUES (3, 2, 3, 'user', 'user');


---------------------- Purchase_items ----------------------
-- LG UltraGear 24GN65R
INSERT INTO public.purchase_items (quantity, total_price, part_id, pc_id, purchase_id, purchase_item_id)
VALUES (1, 300, 26, null, null, 1);

-- LG UltraGear 24GN65R
INSERT INTO public.purchase_items (quantity, total_price, part_id, pc_id, purchase_id, purchase_item_id)
VALUES (2, 230, 15, null, null, 2);

INSERT INTO public.purchase_items (quantity, total_price, part_id, pc_id, purchase_id, purchase_item_id)
VALUES (1, 6800, null, 3, null, 3);


---------------------- Cart ----------------------
INSERT INTO public.cart (purchase_item_purchase_item_id, user_user_id)
VALUES (1, 2);

INSERT INTO public.cart (purchase_item_purchase_item_id, user_user_id)
VALUES (2, 2);

INSERT INTO public.cart (purchase_item_purchase_item_id, user_user_id)
VALUES (3, 3);


---------------------- Purchases ----------------------
INSERT INTO public.purchases (date, purchase_id, user_id, destination)
VALUES ('2024-08-11 20:31:32.000000', 1, 2, 'Сюда');
-- Обновляем purchase_items и добавляем ссылку на purchase
UPDATE public.purchase_items
SET purchase_id = 1
WHERE purchase_item_id = 1;
UPDATE public.purchase_items
SET purchase_id = 1
WHERE purchase_item_id = 2;

INSERT INTO public.purchases (date, purchase_id, user_id, destination)
VALUES ('2024-08-11 20:32:32.000000', 2, 3, 'Туда');
-- Обновляем purchase_items и добавляем ссылку на purchase
UPDATE public.purchase_items
SET purchase_id = 2
WHERE purchase_item_id = 3;


---------------------- Compare_items ----------------------
INSERT INTO public.compare_items (compare_item_id, part_id, pc_id)
VALUES (1, null, 1);

INSERT INTO public.compare_items (compare_item_id, part_id, pc_id)
VALUES (2, null, 2);

INSERT INTO public.compare_items (compare_item_id, part_id, pc_id)
VALUES (3, null, 3);

INSERT INTO public.compare_items (compare_item_id, part_id, pc_id)
VALUES (4, 1, null);

INSERT INTO public.compare_items (compare_item_id, part_id, pc_id)
VALUES (5, 2, null);


---------------------- Compare ----------------------
INSERT INTO public.compare (compare_item_compare_item_id, user_user_id)
VALUES (1, 2);

INSERT INTO public.compare (compare_item_compare_item_id, user_user_id)
VALUES (2, 2);

INSERT INTO public.compare (compare_item_compare_item_id, user_user_id)
VALUES (3, 2);

INSERT INTO public.compare (compare_item_compare_item_id, user_user_id)
VALUES (4, 3);

INSERT INTO public.compare (compare_item_compare_item_id, user_user_id)
VALUES (5, 3);