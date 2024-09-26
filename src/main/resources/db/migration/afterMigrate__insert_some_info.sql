---------------------- Cpu ----------------------
-- I5-12400F
INSERT INTO public.cpu (base_frequency, boost_frequency, cpu_cores, cpu_threads, max_ram_capacity, tdp, cpu_id, cachel1,
                        cachel2, cachel3, socket, tech_process, ram_type)
VALUES (2500, 4400, 6, 12, 128, 65, 10001, null, '7680 КБ', '18432 КБ', 'LGA 1700', 'intel 7',
        '["DDR4","DDR5"]');

-- I5-14400F
INSERT INTO public.cpu (base_frequency, boost_frequency, cpu_cores, cpu_threads, max_ram_capacity, tdp, cpu_id, cachel1,
                        cachel2, cachel3, socket, tech_process, ram_type)
VALUES (2500, 4700, 10, 16, 128, 65, 10002, null, '9728 КБ', '20480 КБ', 'LGA 1700', '7 нм',
        '["DDR4","DDR5"]');

-- I7-14700KF
INSERT INTO public.cpu (base_frequency, boost_frequency, cpu_cores, cpu_threads, max_ram_capacity, tdp, cpu_id, cachel1,
                        cachel2, cachel3, socket, tech_process, ram_type)
VALUES (2100, 5400, 20, 28, 128, 65, 10003, '80 КБ', '20 MБ', '33 MБ', 'LGA 1700', 'intel 7',
        '["DDR4","DDR5"]');


---------------------- Gpu ----------------------
-- PALIT GeForce RTX 4060 DUAL
INSERT INTO public.gpu (base_frequency, boost_frequency, bus_width, cuda, display_port, extension_slots, fans, hdmi,
                        height, length, max_displays_quantity, min_power_unit, tech_process, vram_capacity, width,
                        gpu_id, max_resolution, vram_type, power_connector)
VALUES (1830, 2460, 128, 3072, 3, 2, 2, 1, 40, 249, 4, 500, 5, 8, 123, 10001, '5120x2880', 'GDDR6', '8 pin');

-- Palit GeForce RTX 4070 SUPER JetStream
INSERT INTO public.gpu (base_frequency, boost_frequency, bus_width, cuda, display_port, extension_slots, fans, hdmi,
                        height, length, max_displays_quantity, min_power_unit, tech_process, vram_capacity, width,
                        gpu_id, max_resolution, vram_type, power_connector)
VALUES (1980, 2640, 192, 7680, 3, 3.1, 3, 1, 63.5, 329, 4, 700, 5, 12, 130, 10002, '7680x4320', 'GDDR6X', '8+8 pin');

-- MSI GeForce RTX 4080 SUPER GAMING SLIM
INSERT INTO public.gpu (base_frequency, boost_frequency, bus_width, cuda, display_port, extension_slots, fans, hdmi,
                        height, length, max_displays_quantity, min_power_unit, tech_process, vram_capacity, width,
                        gpu_id, max_resolution, vram_type, power_connector)
VALUES (2000, 2565, 256, 10240, 2, null, 3, 2, 62, 322, 4, 850, 5, 16, 136, 10003, '7680x4320', 'GDDR6X', '8+8 pin');


---------------------- Motherboard ----------------------
-- MSI PRO B760M-A
INSERT INTO public.motherboard (m2quantity, max_ram_capacity, pcie16quantity, ram_slots, sata_quantity, motherboard_id,
                                chipset, form_factor, ram_type, socket)
VALUES (2, 128, 2, 4, 4, 10001, 'Intel B760', 'microATX', 'DDR4', 'LGA 1700');

-- MSI PRO Z790-A MAX
INSERT INTO public.motherboard (m2quantity, max_ram_capacity, pcie16quantity, ram_slots, sata_quantity, motherboard_id,
                                chipset, form_factor, ram_type, socket)
VALUES (4, 128, 3, 4, 6, 10002, 'Intel Z790', 'ATX', 'DDR5', 'LGA 1700');


---------------------- Cpu_Air_Cooling ----------------------
-- DeepCool ASSASSIN 4S
INSERT INTO public.cpu_air_cooling (air_flow, fans_quantity, height, max_noise_level, tdp, cpu_air_cooling_id,
                                    backlight, connector, fan_size, fan_speed, sockets)
VALUES (61.25, 1, 165, 23.7, 250, 10001, 'Отсутствует', '4-pin PWM', '140x140x25 мм', '500-1800 об/мин',
        '["AM4", "AM5", "LGA 1150", "LGA 1151", "LGA 1155", "LGA 1200", "LGA 1700", "LGA 2011", "LGA 2011-3", "LGA 2066"]');

---------------------- Cpu_Liquid_Cooling ----------------------
-- ASUS ROG RYUO III 360 White
INSERT INTO public.cpu_liquid_cooling (air_flow, fans_quantity, height, length, max_noise_level, tdp, width,
                                       cpu_liquid_cooling_id, backlight, connector, fan_size, fan_speed, sockets)
VALUES (70.07, 3, 30, 399.5, 36.45, 280, 120, 10001, 'ARGB', '4-pin PWM', '120x120x25 мм', '2200 +/- 300 RPM', '["AM4", "AM5", "LGA 1150", "LGA 1151", "LGA 1155", "LGA 1200", "LGA 1700", "LGA 2011", "LGA 2011-3", "LGA 2066"]');


---------------------- Ram ----------------------
-- 16GB Kingston FURY Beast RGB
INSERT INTO public.ram (capacity, frequency, ram_id, type)
VALUES (16, 3600, 10001, 'DDR4');

-- 32GB Kingston FURY Beast RGB
INSERT INTO public.ram (capacity, frequency, ram_id, type)
VALUES (32, 3600, 10002, 'DDR4');

-- 64GB TEAMGROUP T-Force Delta RGB White
INSERT INTO public.ram (capacity, frequency, ram_id, type)
VALUES (64, 6000, 10003, 'DDR5');


---------------------- Ssd ----------------------
-- 512GB ADATA LEGEND 850
INSERT INTO public.ssd (max_temperature, mtbf_time, random_write_speed, read_velocity, write_velocity, ssd_id, capacity,
                        flash_memory_type, form_factor, connection_type, controller_type)
VALUES (null, null, 530000, 5000, 2700, 10001, '512 ГБ', '3D NAND', 'M.2 NVME', 'PCI-E 4.0 x4', 'Silicon Motion SM2269XT');

-- 1TB ADATA LEGEND 850
INSERT INTO public.ssd (max_temperature, mtbf_time, random_write_speed, read_velocity, write_velocity, ssd_id, capacity,
                        flash_memory_type, form_factor, connection_type, controller_type)
VALUES (null, null, 530000, 5000, 4500, 10002, '1 TБ', '3D NAND', 'M.2 NVME', 'PCI-E 4.0 x4', 'Silicon Motion SM2269XT');

-- 2TB Samsung 990 PRO
INSERT INTO public.ssd (max_temperature, mtbf_time, random_write_speed, read_velocity, write_velocity, ssd_id, capacity,
                        flash_memory_type, form_factor, connection_type, controller_type)
VALUES ('70 °C', null, 1550000, 7450, 6900, 10003, '2 TБ', 'MLC 3D NAND', 'M.2 NVME', null, null);


---------------------- Psu ----------------------
-- 650W DeepCool PK650D
INSERT INTO public.psu (cpu4plus4quantity, gpu6plus2quantity, power, sata_quantity, psu_id, form_factor, mb_connector,
                        pfc, certificate, modular, cooling_system)
VALUES (1, 2, 650, 5, 10001, 'ATX', '20+4 pin', 'активный', '80+ Bronze', 'Полумодульный', '1 вентилятор (120 мм)');

-- 750W DeepCool PK750D
INSERT INTO public.psu (cpu4plus4quantity, gpu6plus2quantity, power, sata_quantity, psu_id, form_factor, mb_connector,
                        pfc, certificate, modular, cooling_system)
VALUES (2, 4, 750, 7, 10002, 'ATX', '20+4 pin', 'активный', '80+ Bronze', 'Полумодульный', '1 вентилятор (120 мм)');

-- 850W MSI MAG A850GL
INSERT INTO public.psu (cpu4plus4quantity, gpu6plus2quantity, power, sata_quantity, psu_id, form_factor, mb_connector,
                        pfc, certificate, modular, cooling_system)
VALUES (2, 5, 850, 8, 10003, 'ATX12V 3.0', '20+4 pin', 'активный', '80+ Gold', 'Модульный', '1 вентилятор (120 мм)');


---------------------- Cases ----------------------
-- ASUS TUF GAMING GT502 White
INSERT INTO public.cases (extension_slots_quantity, hdd_slots_quantity, height, length, max_cpu_cooler_height,
                          max_gpu_length, max_liquid_cooling_length, ssd_slots_quantity, weight, width, case_id,
                          possible_form_factors)
VALUES (8, 4, 450, 446, 163, 400, 420, 4, 11, 285, 10001, '["micro-ATX","mini-ATX","ATX"]');

-- Lian Li O11 Vision White
INSERT INTO public.cases (extension_slots_quantity, hdd_slots_quantity, height, length, max_cpu_cooler_height,
                          max_gpu_length, max_liquid_cooling_length, ssd_slots_quantity, weight, width, case_id,
                          possible_form_factors)
VALUES (6, 2, 464, 480, 174, 430, 390, 5, 18, 304, 10002, '["micro-ATX","mini-ATX","ATX"]');

-- DeepCool CH360
INSERT INTO public.cases (extension_slots_quantity, hdd_slots_quantity, height, length, max_cpu_cooler_height,
                          max_gpu_length, max_liquid_cooling_length, ssd_slots_quantity, weight, width, case_id,
                          possible_form_factors)
VALUES (4, 3, 428, 431, 165, 320, 270, 2, 6, 215, 10003, '["micro-ATX","mini-ATX"]');


---------------------- Fans ----------------------
-- Montech AX 120 PWM White
INSERT INTO public.fans (air_flow, max_noise_level, fan_id, backlight, fan_size, fan_speed)
VALUES (59, 27, 10001, 'ARGB', '120x120 мм', '800-1800 об/мин');

-- Lian Li UNI FAN AL V2 120 White
INSERT INTO public.fans (air_flow, max_noise_level, fan_id, backlight, fan_size, fan_speed)
VALUES (81, 26.8, 10002, 'ARGB', '140x140 мм', '250-1600 об/мин');

-- Thermaltake TOUGHFAN 12 White
INSERT INTO public.fans (air_flow, max_noise_level, fan_id, backlight, fan_size, fan_speed)
VALUES (75, 26.8, 10003, 'Отсутствует', '120x120 мм', '500-1600 об/мин');


---------------------- Periphery ----------------------
-- LG UltraGear 24GN65R
INSERT INTO public.periphery (periphery_id, characteristics)
VALUES (10001,
        '{"Диагональ":"24\"","Разрешение":"1920x1080 (16:9)","Матрица": "IPS", "Частота обновления экрана": "144 Гц", "Входы": "DisplayPort, HDMI"}');

-- Razer DeathAdder V3 Pro
INSERT INTO public.periphery (periphery_id, characteristics)
VALUES (10002,
        '{"КОЛИЧЕСТВО ПРОГРАММИРУЕМЫХ КЛАВИШ":"5","МОДЕЛЬ СЕНСОРА":"Razer Focus Pro 30K","РАЗРЕШЕНИЕ ОПТИЧЕСКОГО СЕНСОРА":"30000 DPI","ВЕС":"64 г"}');

-- Razer Kraken V3
INSERT INTO public.periphery (periphery_id, characteristics)
VALUES (10003,
        '{"ТИП ПОДКЛЮЧЕНИЯ":"с проводом","МИКРОФОН С ШУМОПОДАВЛЕНИЕМ":"есть","РАЗЪЕМ":"USB","ВЕС":"250 г"}');


---------------------- Categories ----------------------
INSERT INTO public.categories (category_id, category_name)
VALUES (10001, 'Комплектующие');

INSERT INTO public.categories (category_id, category_name)
VALUES (10002, 'Периферия');


---------------------- Partitions ----------------------
INSERT INTO public.partitions (partition_id, partition_name)
VALUES (10001, 'RTX 4060');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (10002, 'Intel Core 12th');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (10003, 'Intel Core 14th');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (10004, 'RTX 4070');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (10005, 'RTX 4080');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (10006, 'Intel B760');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (10007, 'Intel Z790');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (10008, 'Deepcool');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (10009, 'Asus');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (100010, '16 ГБ');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (100011, '32 ГБ');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (100012, '64 ГБ');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (100013, '512 ГБ');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (100014, '1 ТБ');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (100015, '2 ТБ');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (100016, 'от 500W');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (100017, 'от 700W');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (100018, 'от 800W');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (100020, 'Lian Li');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (100021, '120x120 ММ');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (100022, '140x140 ММ');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (100023, '24"');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (100024, '27"');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (100025, '32"');

INSERT INTO public.partitions (partition_id, partition_name)
VALUES (100026, 'Razer');


---------------------- Types ----------------------
INSERT INTO public.types (type_id, type_name, alternative_name, type_image)
VALUES (10001, 'gpu', 'Видеокарта', '/svg-icons/gpu.svg');

INSERT INTO public.types (type_id, type_name, alternative_name, type_image)
VALUES (10002, 'cpu', 'Процессор', '/svg-icons/cpu.svg');

INSERT INTO public.types (type_id, type_name, alternative_name, type_image)
VALUES (10003, 'motherboard', 'Материнская плата', '/svg-icons/motherboard.svg');

INSERT INTO public.types (type_id, type_name, alternative_name, type_image)
VALUES (10004, 'cpu_fan', 'Охлаждение', '/svg-icons/cpu_fan.svg');

INSERT INTO public.types (type_id, type_name, alternative_name, type_image)
VALUES (10005, 'ram', 'Оперативная память', '/svg-icons/ram.svg');

INSERT INTO public.types (type_id, type_name, alternative_name, type_image)
VALUES (10006, 'ssd', 'SSD накопитель', '/svg-icons/ssd.svg');

INSERT INTO public.types (type_id, type_name, alternative_name, type_image)
VALUES (10007, 'psu', 'Блок питания', '/svg-icons/psu.svg');

INSERT INTO public.types (type_id, type_name, alternative_name, type_image)
VALUES (10008, 'cases', 'Корпус', '/svg-icons/cases.svg');

INSERT INTO public.types (type_id, type_name, alternative_name, type_image)
VALUES (10009, 'fan', 'Вентиляторы', '/svg-icons/fan.svg');

INSERT INTO public.types (type_id, type_name, alternative_name, type_image)
VALUES (100010, 'monitor', 'Монитор', '/svg-icons/monitor.svg');

INSERT INTO public.types (type_id, type_name, alternative_name, type_image)
VALUES (100011, 'mouse', 'Мышь', '/svg-icons/mouse.svg');

INSERT INTO public.types (type_id, type_name, alternative_name, type_image)
VALUES (100012, 'headphones', 'Наушники', '/svg-icons/headphones.svg');


---------------------- Parts ----------------------
-- I5-12400F
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (350, 15, null, 10001, null, 10001, null, null, null, null, 10001, 10002, null, null, null, null, 10002, 'I5-12400F', 'Описание...',
        '/uploads/i5-12400f.jpg');

-- I5-14400F
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (450, 15, null, 10001, null, 10002, null, null, null, null, 10002, 10003, null, null, null, null, 10002, 'I5-14400F', 'Описание...',
        '/uploads/i5-14400f.jpg');

-- I7-14700KF
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (650, 10, null, 10001, null, 10003, null, null, null, null, 10003, 10003, null, null, null, null, 10002, 'I7-14700KF', 'Описание...',
        '/uploads/i7-14700kf.jpg');

-- PALIT GeForce RTX 4060 DUAL
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (1050, 10, null, 10001, null, null, null, null, 10001, null, 10004, 10001, null, null, null, null, 10001, 'PALIT GeForce RTX 4060 DUAL', 'Описание...',
        '/uploads/palit-geforce-rtx-4060-dual.jpg');

-- Palit GeForce RTX 4070 SUPER JetStream
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (1350, 10, null, 10001, null, null, null, null, 10002, null, 10005, 10004, null, null, null, null, 10001, 'Palit GeForce RTX 4070 SUPER JetStream', 'Описание...',
        '/uploads/palit-geforce-rtx-4070-super-jetstream.jpg');

-- MSI GeForce RTX 4080 SUPER GAMING SLIM
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (1650, 10, null, 10001, null, null, null, null, 10003, null, 10006, 10005, null, null, null, null, 10001, 'MSI GeForce RTX 4080 SUPER GAMING SLIM', 'Описание...',
        '/uploads/msi-geforce-rtx-4080-super-gaming-slim.jpg');

-- MSI PRO B760M-A
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (330, 15, null, 10001, null, null, null, null, null, 10001, 10007, 10006, null, null, null, null, 10003, 'MSI PRO B760M-A', 'Описание...',
        '/uploads/msi-pro-b760m-a.jpg');

-- MSI PRO Z790-A MAX
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (450, 15, null, 10001, null, null, null, null, null, 10002, 10008, 10007, null, null, null, null, 10003, 'MSI PRO Z790-A MAX', 'Описание...',
        '/uploads/msi-pro-z790-a-max.jpg');

-- DeepCool ASSASSIN 4S
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (150, 15, null, 10001, 10001, null, null, null, null, null, 10009, 10008, null, null, null, null, 10004, 'DeepCool ASSASSIN 4S', 'Описание...',
        '/uploads/deepcool-assassin-4s.jpg');

-- ASUS ROG RYUO III 360 White
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (460, 15, null, 10001, null, null, 10001, null, null, null, 100010, 10009, null, null, null, null, 10004, 'ASUS ROG RYUO III 360 White', 'Описание...',
        '/uploads/asus-rog-ryuo-III-360-white.jpg');

-- 16GB Kingston FURY Beast RGB
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (200, 30, null, 10001, null, null, null, null, null, null, 100011, 100010, null, null, 10001, null, 10005, '16GB Kingston FURY Beast RGB', 'Описание...',
        '/uploads/16gb-kingston-fury-beast-rgb.jpg');

-- 32GB Kingston FURY Beast RGB
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (320, 20, null, 10001, null, null, null, null, null, null, 100012, 100011, null, null, 10002, null, 10005, '32GB Kingston FURY Beast RGB', 'Описание...',
        '/uploads/32gb-kingston-fury-beast-rgb.jpg');

-- 64GB TEAMGROUP T-Force Delta RGB White
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (600, 20, null, 10001, null, null, null, null, null, null, 100013, 100012, null, null, 10003, null, 10005, '64GB TEAMGROUP T-Force Delta RGB White', 'Описание...',
        '/uploads/64gb-teamgroup-t-force-delta-rgb-white.jpg');

-- 512GB ADATA LEGEND 850
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (230, 30, null, 10001, null, null, null, null, null, null, 100014, 100013, null, null, null, 10001, 10006, '512GB ADATA LEGEND 850', 'Описание...',
        '/uploads/512gb-adata-legend-850.jpg');

-- 1TB ADATA LEGEND 850
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (380, 20, null, 10001, null, null, null, null, null, null, 100015, 100014, null, null, null, 10002, 10006, '1TB ADATA LEGEND 850', 'Описание...',
        '/uploads/1tb-adata-legend-850.jpg');

-- 2TB Samsung 990 PRO
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (550, 15, null, 10001, null, null, null, null, null, null, 100016, 100015, null, null, null, 10003, 10006, '2TB Samsung 990 PRO', 'Описание...',
        '/uploads/2tb-samsung-990-pro.jpg');

-- 650W DeepCool PK650D
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (310, 15, null, 10001, null, null, null, null, null, null, 100017, 100016, null, 10001, null, null, 10007, '650W DeepCool PK650D', 'Описание...',
        '/uploads/650w-deepcool-pk650d.jpg');

-- 750W DeepCool PK750D
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (410, 15, null, 10001, null, null, null, null, null, null, 100018, 100017, null, 10002, null, null, 10007, '750W DeepCool PK750D', 'Описание...',
        '/uploads/750w-deepcool-pk750d.jpg');

-- 850W MSI MAG A850GL
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (610, 10, null, 10001, null, null, null, null, null, null, 100019, 100018, null, 10003, null, null, 10007, '850W MSI MAG A850GL', 'Описание...',
        '/uploads/850w-msi-mag-a850gl.jpg');

-- ASUS TUF GAMING GT502 White
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (380, 10, 10001, 10001, null, null, null, null, null, null, 100020, 10009, null, null, null, null, 10008, 'ASUS TUF GAMING GT502 White', 'Описание...',
        '/uploads/asus-tuf-gaming-gt502-white.jpg');

-- Lian Li O11 Vision White
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (450, 10, 10002, 10001, null, null, null, null, null, null, 100021, 100020, null, null, null, null, 10008, 'Lian Li O11 Vision White', 'Описание...',
        '/uploads/lian-li-011-vision-white.jpg');

-- DeepCool CH360
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (200, 25, 10003, 10001, null, null, null, null, null, null, 100022, 10008, null, null, null, null, 10008, 'DeepCool CH360', 'Описание...',
        '/uploads/deepcool-ch360.jpg');

-- Montech AX 120 PWM White
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (60, 40, null, 10001, null, null, null, 10001, null, null, 100023, 100021, null, null, null, null, 10009, 'Montech AX 120 PWM White', 'Описание...',
        '/uploads/montech-ax-120-pwm-white.jpg');

-- Lian Li UNI FAN AL V2 120 White
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (70, 40, null, 10001, null, null, null, 10002, null, null, 100024, 100021, null, null, null, null, 10009, 'Lian Li UNI FAN AL V2 120 White', 'Описание...',
        '/uploads/lian-li-uni-fan-al-v2-120-white.jpg');

-- Thermaltake TOUGHFAN 12 White
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (80, 30, null, 10001, null, null, null, 10003, null, null, 100025, 100022, null, null, null, null, 10009, 'Thermaltake TOUGHFAN 12 White', 'Описание...',
        '/uploads/thermaltake-toughfan-12-white.jpg');

-- LG UltraGear 24GN65R
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (350, 10, null, 10002, null, null, null, null, null, null, 100026, 100023, 10001, null, null, null, 100010, 'LG UltraGear 24GN65R', 'Описание...',
        '/uploads/lg-ultragear-24gn65r.jpg');

-- Razer DeathAdder V3 Pro
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (220, 10, null, 10002, null, null, null, null, null, null, 100027, 100026, 10002, null, null, null, 100011, 'Razer DeathAdder V3 Pro', 'Описание...',
        '/uploads/razer-deathadder-v3-pro.jpg');

-- Razer Kraken V3
INSERT INTO public.parts (price, remaining_quantity, case_id, category_id, cpu_air_cooling_id, cpu_id,
                          cpu_liquid_cooling_id, fan_id, gpu_id, motherboard_id, part_id, partition_id, periphery_id,
                          psu_id, ram_id, ssd_id, type_id, name, description, image)
VALUES (300, 10, null, 10002, null, null, null, null, null, null, 100028, 100026, 10003, null, null, null, 100012, 'Razer Kraken V3', 'Описание...',
        '/uploads/razer-kraken-v3.jpg');


---------------------- Pc_types ----------------------
INSERT INTO public.pc_types (pc_type_id, type)
VALUES (10001, 'gaming-pc');

INSERT INTO public.pc_types (pc_type_id, type)
VALUES (10002, 'notebook');

INSERT INTO public.pc_types (pc_type_id, type)
VALUES (10003, 'workstation');

INSERT INTO public.pc_types (pc_type_id, type)
VALUES (10004, 'configuration');


---------------------- Pc_categories ----------------------
INSERT INTO public.pc_categories (pc_category_id, pc_category_name)
VALUES (10001, 'Нет категории');

INSERT INTO public.pc_categories (pc_category_id, pc_category_name, pc_category_description)
VALUES (10002, 'Оптимальные игровые компьютеры', 'Современные игровые компьютеры с процессорами Intel Core и видеокартами NVIDIA GeForce RTX предлагают идеальное сочетание производительности и стоимости. Максимум эффективности.');

INSERT INTO public.pc_categories (pc_category_id, pc_category_name, pc_category_description)
VALUES (10003, 'Мощные игровые компьютеры', 'Мощные игровые компьютеры для максимальных настроек графики в играх, на базе процессоров Intel Core и видеокарт NVIDIA GeForce RTX. Отлично подходят для киберспортивных игроков и геймеров, ценящих плавность игрового процесса с высоким FPS на максимальных графических настройках. Выбор чемпионов.');

INSERT INTO public.pc_categories (pc_category_id, pc_category_name, pc_category_description)
VALUES (10004, 'Кастомные компьютеры', 'Эксклюзивная линейка компьютеров для тех, кто не ищет компромиссов в играх. Конфигурации на основе самых мощных процессоров Intel Core и видеокарт NVIDIA GeForce RTX обеспечивают высший уровень производительности, уникальные корпуса с RGB-подсветкой и системой водяного охлаждения. Персонализированные варианты для самых изысканных геймеров.');

INSERT INTO public.pc_categories (pc_category_id, pc_category_name, pc_category_description)
VALUES (10005, 'Игровые мини ПК', 'Добро пожаловать в эпоху компактных игровых компьютеров нового поколения! Это воплощение мощи и стиля в одном устройстве. Оформленные в современном дизайне, они скрывает в себе потрясающую производительность, способную обеспечить вас плавным геймплеем на максимальных настройках графики.');

INSERT INTO public.pc_categories (pc_category_id, pc_category_name, pc_category_description)
VALUES (10006, 'Оптимальные рабочие станции', 'Современные рабочие компьютеры с процессорами Intel Core и видеокартами NVIDIA GeForce RTX предлагают идеальное сочетание производительности и стоимости для профессиональных задач. Они обеспечивают максимум эффективности для работы с графическими и многозадачными приложениями без лишних затрат.');

INSERT INTO public.pc_categories (pc_category_id, pc_category_name, pc_category_description)
VALUES (10007, 'Мощные рабочие станции', 'Эксклюзивная линейка рабочих компьютеров для профессионалов, которые не ищут компромиссов в производительности. Конфигурации на основе самых мощных процессоров Intel Core и видеокарт NVIDIA Quadro RTX обеспечивают высший уровень производительности для работы с самыми требовательными приложениями. Уникальные корпуса с эргономичным дизайном и системой водяного охлаждения. Персонализированные варианты для самых требовательных специалистов.');

INSERT INTO public.pc_categories (pc_category_id, pc_category_name, pc_category_description)
VALUES (10008, 'Кастомные рабочие станции', 'Эксклюзивная линейка компьютеров для тех, кто не ищет компромиссов в играх. Конфигурации на основе самых мощных процессоров Intel Core и видеокарт NVIDIA GeForce RTX обеспечивают высший уровень производительности, уникальные корпуса с RGB-подсветкой и системой водяного охлаждения. Персонализированные варианты для самых изысканных геймеров.');


---------------------- Pc_header ----------------------
INSERT INTO public.pc_header (pc_header_id, description, image, image_mobile)
VALUES (10001, 'Описание...', '/pc/header/header-1', '/pc/header/header-1-mobile');

INSERT INTO public.pc_header (pc_header_id, description, image, image_mobile)
VALUES (10002, 'Описание...', '/pc/header/header-2', '/pc/header/header-2-mobile');

INSERT INTO public.pc_header (pc_header_id, description, image, image_mobile)
VALUES (10003, 'Описание...', '/pc/header/header-3', '/pc/header/header-3-mobile');

INSERT INTO public.pc_header (pc_header_id, description, image, image_mobile)
VALUES (10004, 'Описание...', '/pc/header/header-3', '/pc/header/header-3-mobile');

INSERT INTO public.pc_header (pc_header_id, description, image, image_mobile)
VALUES (10005, 'Описание...', '/pc/header/header-3', '/pc/header/header-3-mobile');

INSERT INTO public.pc_header (pc_header_id, description, image, image_mobile)
VALUES (10006, 'Описание...', '/pc/header/header-3', '/pc/header/header-3-mobile');


---------------------- Pc_design ----------------------
INSERT INTO public.pc_design (pc_design_id, title, description, image)
VALUES (10001, 'Заголовок...', 'Описание...', '/pc/design/design-1');

INSERT INTO public.pc_design (pc_design_id, title, description, image)
VALUES (10002, 'Заголовок...', 'Описание...', '/pc/design/design-2');

INSERT INTO public.pc_design (pc_design_id, title, description, image)
VALUES (10003, 'Заголовок...', 'Описание...', '/pc/design/design-3');

INSERT INTO public.pc_design (pc_design_id, title, description, image)
VALUES (10004, 'Заголовок...', 'Описание...', '/pc/design/design-3');

INSERT INTO public.pc_design (pc_design_id, title, description, image)
VALUES (10005, 'Заголовок...', 'Описание...', '/pc/design/design-3');

INSERT INTO public.pc_design (pc_design_id, title, description, image)
VALUES (10006, 'Заголовок...', 'Описание...', '/pc/design/design-3');

---------------------- Pc_preview ----------------------
INSERT INTO public.pc_preview (pc_preview_id, title, description, main_image, slider_images)
VALUES (10001, 'Заголовок...', 'Описание...', '/pc/preview/preview-1', '["/pc/preview/slider-image-1.1","/pc/preview/slider-image-1.2","/pc/preview/slider-image-1.3"]');

INSERT INTO public.pc_preview (pc_preview_id, title, description, main_image, slider_images)
VALUES (10002, 'Заголовок...', 'Описание...', '/pc/preview/preview-2', '["/pc/preview/slider-image-2.1","/pc/preview/slider-image-2.2","/pc/preview/slider-image-2.3"]');

INSERT INTO public.pc_preview (pc_preview_id, title, description, main_image, slider_images)
VALUES (10003, 'Заголовок...', 'Описание...', '/pc/preview/preview-3', '["/pc/preview/slider-image-3.1","/pc/preview/slider-image-3.2","/pc/preview/slider-image-3.3"]');

INSERT INTO public.pc_preview (pc_preview_id, title, description, main_image, slider_images)
VALUES (10004, 'Заголовок...', 'Описание...', '/pc/preview/preview-1', '["/pc/preview/slider-image-1.1","/pc/preview/slider-image-1.2","/pc/preview/slider-image-1.3"]');

INSERT INTO public.pc_preview (pc_preview_id, title, description, main_image, slider_images)
VALUES (10005, 'Заголовок...', 'Описание...', '/pc/preview/preview-2', '["/pc/preview/slider-image-2.1","/pc/preview/slider-image-2.2","/pc/preview/slider-image-2.3"]');

INSERT INTO public.pc_preview (pc_preview_id, title, description, main_image, slider_images)
VALUES (10006, 'Заголовок...', 'Описание...', '/pc/preview/preview-3', '["/pc/preview/slider-image-3.1","/pc/preview/slider-image-3.2","/pc/preview/slider-image-3.3"]');

---------------------- Pc_performance ----------------------
INSERT INTO public.pc_performance (pc_performance_id, title, description, image, image2)
VALUES (10001, 'Заголовок...', 'Описание...', '/pc/performance/performance-1.1', '/pc/performance/performance-1.2');

INSERT INTO public.pc_performance (pc_performance_id, title, description, image, image2)
VALUES (10002, 'Заголовок...', 'Описание...', '/pc/performance/performance-2.1', '/pc/performance/performance-2.2');

INSERT INTO public.pc_performance (pc_performance_id, title, description, image, image2)
VALUES (10003, 'Заголовок...', 'Описание...', '/pc/performance/performance-3.1', '/pc/performance/performance-3.2');

INSERT INTO public.pc_performance (pc_performance_id, title, description, image, image2)
VALUES (10004, 'Заголовок...', 'Описание...', '/pc/performance/performance-1.1', '/pc/performance/performance-1.2');

INSERT INTO public.pc_performance (pc_performance_id, title, description, image, image2)
VALUES (10005, 'Заголовок...', 'Описание...', '/pc/performance/performance-2.1', '/pc/performance/performance-2.2');

INSERT INTO public.pc_performance (pc_performance_id, title, description, image, image2)
VALUES (10006, 'Заголовок...', 'Описание...', '/pc/performance/performance-3.1', '/pc/performance/performance-3.2');


---------------------- Pc_model_groups ----------------------
-- One
INSERT INTO public.pc_model_groups (pc_category_id, pc_design_id, pc_header_id, pc_model_group_id, pc_performance_id,
                                    pc_preview_id, pc_type_id, model_group_name, model_group_description,
                                    cpu_description, gpu_description, motherboard_description, psu_description,
                                    ram_description, ssd_description)
VALUES (10002, 10001, 10001, 10001, 10001, 10001, 10001,
        'One', 'Начальный игровой компьютер',
        'Процессоры 6 и 10 ядерные Intel Core i5',
        'Графические карты GeForce RTX 4060 и 4060 Ti',
        'Материнские платы на чипсете Intel B760',
        'Блок питания на 550W / 650W стандарта 80+ Bronze',
        'Оперативная память от 16 до 32 GB DDR4 3600MHz',
        'Накопители SSD на 512 GB / 1 TB с интерфейсом М.2');

-- Lumen Core
INSERT INTO public.pc_model_groups (pc_category_id, pc_design_id, pc_header_id, pc_model_group_id, pc_performance_id,
                                    pc_preview_id, pc_type_id, model_group_name, model_group_description,
                                    cpu_description, gpu_description, motherboard_description, psu_description,
                                    ram_description, ssd_description)
VALUES (10003, 10004, 10004, 10004, 10004, 10004, 10001,
        'Lumen Core', 'Начальный игровой компьютер',
        'Процессоры 6 и 10 ядерные Intel Core i5',
        'Графические карты GeForce RTX 4060 и 4060 Ti',
        'Материнские платы на чипсете Intel B760',
        'Блок питания на 550W / 650W стандарта 80+ Bronze',
        'Оперативная память от 16 до 32 GB DDR4 3600MHz',
        'Накопители SSD на 512 GB / 1 TB с интерфейсом М.2');

-- Fury
INSERT INTO public.pc_model_groups (pc_category_id, pc_design_id, pc_header_id, pc_model_group_id, pc_performance_id,
                                    pc_preview_id, pc_type_id, model_group_name, model_group_description,
                                    cpu_description, gpu_description, motherboard_description, psu_description,
                                    ram_description, ssd_description)
VALUES (10003, 10005, 10005, 10005, 10005, 10005, 10001,
        'Fury', 'Начальный игровой компьютер',
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
VALUES (10001, 10002, 10002, 10002, 10002, 10002, 10002,
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
VALUES (10006, 10003, 10003, 10003, 10003, 10003, 10003,
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
                       pc_model_group_id, pc_type_id, psu_id, ram_id, name, description, image)
VALUES (4500, 100022, 10009, 10001, 10004, 10007, 10002,
        10001,10001, 10001, 100017, 100011,
        'One Super',
        'Платформа для гейминга в Full HD разрешении, созданная на базе центрального процессора Intel® Core™ i5-12400F [до 4.4GHz, 6 ядер] и видеокарты Palit GeForce RTX 4060 Ti Dual [8GB, 4352 CUDA].',
        'uploads/one.jpg');

-- One Max
INSERT INTO public.pc (total_price, case_id, cpu_fan_id, cpu_id, gpu_id, motherboard_id, pc_category_id, pc_id,
                       pc_model_group_id, pc_type_id, psu_id, ram_id, name, description, image)
VALUES (5500, 100022, 10009, 10002, 10005, 10007, 10002,
        10002,10001, 10001, 100018, 100012,
        'One Max',
        'Платформа для гейминга в Full HD разрешении, созданная на базе центрального процессора Intel® Core™ i5-12400F [до 4.4GHz, 6 ядер] и видеокарты Palit GeForce RTX 4060 Ti Dual [8GB, 4352 CUDA].',
        'uploads/one.jpg');

-- One Ultra
INSERT INTO public.pc (total_price, case_id, cpu_fan_id, cpu_id, gpu_id, motherboard_id, pc_category_id, pc_id,
                       pc_model_group_id, pc_type_id, psu_id, ram_id, name, description, image)
VALUES (6800, 100022, 10009, 10002, 10005, 10007, 10002,
        10003,10001, 10001, 100018, 100012,
        'One Ultra',
        'Платформа для гейминга в Full HD разрешении, созданная на базе центрального процессора Intel® Core™ i5-12400F [до 4.4GHz, 6 ядер] и видеокарты Palit GeForce RTX 4060 Ti Dual [8GB, 4352 CUDA].',
        'uploads/one.jpg');

-- Lumen Core Super
INSERT INTO public.pc (total_price, case_id, cpu_fan_id, cpu_id, gpu_id, motherboard_id, pc_category_id, pc_id,
                       pc_model_group_id, pc_type_id, psu_id, ram_id, name, description, image)
VALUES (7800, 100022, 10009, 10002, 10005, 10007, 10002,
        11000,10004, 10001, 100018, 100012,
        'Lumen Core Super',
        'Платформа для гейминга в Full HD разрешении, созданная на базе центрального процессора Intel® Core™ i5-12400F [до 4.4GHz, 6 ядер] и видеокарты Palit GeForce RTX 4060 Ti Dual [8GB, 4352 CUDA].',
        'uploads/lumen-core.jpg');

-- Fury Super
INSERT INTO public.pc (total_price, case_id, cpu_fan_id, cpu_id, gpu_id, motherboard_id, pc_category_id, pc_id,
                       pc_model_group_id, pc_type_id, psu_id, ram_id, name, description, image)
VALUES (8800, 100022, 10009, 10002, 10005, 10007, 10002,
        11001,10005, 10001, 100018, 100012,
        'Fury Super',
        'Платформа для гейминга в Full HD разрешении, созданная на базе центрального процессора Intel® Core™ i5-12400F [до 4.4GHz, 6 ядер] и видеокарты Palit GeForce RTX 4060 Ti Dual [8GB, 4352 CUDA].',
        'uploads/fury.jpg');

-- PLAY 17 M1
INSERT INTO public.pc (total_price, case_id, cpu_fan_id, cpu_id, gpu_id, motherboard_id, pc_category_id, pc_id,
                       pc_model_group_id, pc_type_id, psu_id, ram_id, name, description, image)
VALUES (7400, null, null, 10002, 10005, null, 10001,
        10004,10001, 10002, null, 100012,
        'PLAY 17 M1',
        'Ноутбук PLAY 17 – это отличный выбор для тех, кто хочет обладать современным ноутбуком, который можно использовать для игр, работы и учёбы. Имеет установленную ОС Windows 11 Home.',
        'uploads/hyperpc-play.jpg');

-- G1 PRO Super
INSERT INTO public.pc (total_price, case_id, cpu_fan_id, cpu_id, gpu_id, motherboard_id, pc_category_id, pc_id,
                       pc_model_group_id, pc_type_id, psu_id, ram_id, name, description, image)
VALUES (3500, 100022, 10009, 10002, 10005, 10007, 10002,
        10005,10003, 10003, 100018, 100012,
        'G1 PRO Super',
        'Надежный начального уровня компьютер, оснащенный быстрым процессором и высокоскоростной памятью, предназначенный для профессиональных приложений и эффективной многозадачности.',
        'uploads/pro-g1.jpg');

-- Configuration without pc_model_group
INSERT INTO public.pc (total_price, case_id, cpu_fan_id, cpu_id, gpu_id, motherboard_id, pc_category_id, pc_id,
                       pc_model_group_id, pc_type_id, psu_id, ram_id, name, description, image)
VALUES (3500, 100022, 10009, 10002, 10005, 10007, 10002,
        10006,null, 10003, 100018, 100012,
        'My Configuration',
        null,
        'components/case/no-case.jpg');


---------------------- Pc_ssd_quantity ----------------------
INSERT INTO public.pc_ssd_quantity (quantity, id, pc_id, ssd_id)
VALUES (1, 10001, 10001, 100014);

INSERT INTO public.pc_ssd_quantity (quantity, id, pc_id, ssd_id)
VALUES (1, 10002, 10004, 100015);


---------------------- Pc_fans_quantity ----------------------
INSERT INTO public.pc_fans_quantity (quantity, fan_id, id, pc_id)
VALUES (2, 100023, 10001, 10002);

INSERT INTO public.pc_fans_quantity (quantity, fan_id, id, pc_id)
VALUES (4, 100024, 10002, 10003);


---------------------- Roles ----------------------
INSERT INTO public.roles (role_id, position)
VALUES (10001, 'admin');

INSERT INTO public.roles (role_id, position)
VALUES (10002, 'user');


---------------------- Person ----------------------
INSERT INTO public.person (person_id, phone, email, name, surname)
VALUES (10001, '+375(29)3641160', 'email@mail.ru', 'Гемран', 'Гей');

INSERT INTO public.person (person_id, phone, email, name, surname)
VALUES (10002, '+375(29)1234567', 'email@gmail.com', 'Иван', 'Иванов');

INSERT INTO public.person (person_id, phone, email, name, surname)
VALUES (10003, '+375(29)3334444', 'email@gmail.com', 'Имя', 'Фамилия');


---------------------- Users ----------------------
INSERT INTO public.users (person_id, role_id, user_id, password, login)
VALUES (10001, 10001, 10001, '$2a$10$RrH9jCooA8rrgcQUpfWctOr3H6x5Lxn/8.0qcAadCjE711QmdH/gO', 'admin');

INSERT INTO public.users (person_id, role_id, user_id, password, login)
VALUES (10002, 10002, 10002, '$2a$10$ZNCDiKrhA/EMkjNCA8x8Xu7hOaU.7/UT3S6Ox2rm2z/uMPbkomrhi', '88888888');

INSERT INTO public.users (person_id, role_id, user_id, password, login)
VALUES (10003, 10002, 10003, '$2a$10$ZNCDiKrhA/EMkjNCA8x8Xu7hOaU.7/UT3S6Ox2rm2z/uMPbkomrhi', 'user');

---------------------- Purchase_items ----------------------
-- LG UltraGear 24GN65R
INSERT INTO public.purchase_items (quantity, total_price, part_id, pc_id, purchase_id, purchase_item_id)
VALUES (1, 300, 100026, null, null, 10001);

-- LG UltraGear 24GN65R
INSERT INTO public.purchase_items (quantity, total_price, part_id, pc_id, purchase_id, purchase_item_id)
VALUES (2, 230, 100015, null, null, 10002);

INSERT INTO public.purchase_items (quantity, total_price, part_id, pc_id, purchase_id, purchase_item_id)
VALUES (1, 6800, null, 10003, null, 10003);


---------------------- Cart ----------------------
INSERT INTO public.cart (purchase_item_purchase_item_id, user_user_id)
VALUES (10001, 10002);

INSERT INTO public.cart (purchase_item_purchase_item_id, user_user_id)
VALUES (10002, 10002);

INSERT INTO public.cart (purchase_item_purchase_item_id, user_user_id)
VALUES (10003, 10003);


---------------------- Purchases ----------------------
INSERT INTO public.purchases (date, purchase_id, user_id, destination)
VALUES ('2024-08-11 20:31:32.000000', 10001, 10002, 'Сюда');
-- Обновляем purchase_items и добавляем ссылку на purchase
UPDATE public.purchase_items
SET purchase_id = 10001
WHERE purchase_item_id = 10001;
UPDATE public.purchase_items
SET purchase_id = 10001
WHERE purchase_item_id = 10002;

INSERT INTO public.purchases (date, purchase_id, user_id, destination)
VALUES ('2024-08-11 20:32:32.000000', 10002, 10003, 'Туда');
-- Обновляем purchase_items и добавляем ссылку на purchase
UPDATE public.purchase_items
SET purchase_id = 10002
WHERE purchase_item_id = 10003;


---------------------- Compare_items ----------------------
INSERT INTO public.compare_items (compare_item_id, part_id, pc_id)
VALUES (10001, null, 10001);

INSERT INTO public.compare_items (compare_item_id, part_id, pc_id)
VALUES (10002, null, 10002);

INSERT INTO public.compare_items (compare_item_id, part_id, pc_id)
VALUES (10003, null, 10003);

INSERT INTO public.compare_items (compare_item_id, part_id, pc_id)
VALUES (10004, 10001, null);

INSERT INTO public.compare_items (compare_item_id, part_id, pc_id)
VALUES (10005, 10002, null);


---------------------- Compare ----------------------
INSERT INTO public.compare (compare_item_compare_item_id, user_user_id)
VALUES (10001, 10002);

INSERT INTO public.compare (compare_item_compare_item_id, user_user_id)
VALUES (10002, 10002);

INSERT INTO public.compare (compare_item_compare_item_id, user_user_id)
VALUES (10003, 10002);

INSERT INTO public.compare (compare_item_compare_item_id, user_user_id)
VALUES (10004, 10003);

INSERT INTO public.compare (compare_item_compare_item_id, user_user_id)
VALUES (10005, 10003);