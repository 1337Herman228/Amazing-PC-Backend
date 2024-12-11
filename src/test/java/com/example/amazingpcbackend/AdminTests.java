package com.example.amazingpcbackend;

import com.example.amazingpcbackend.entity.Partitions;
import com.example.amazingpcbackend.repo.PartitionsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AdminTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private PartitionsRepository partitionsRepository;

    // Заранее задаем валидный токен
    public String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTczMzg2MDIxOSwiZXhwIjoxNzM0MDMzMDE5fQ.SXXHW196lMcGn6DlxVv6nezGPSnn1LDVSNPrfSYIvuQ";

    @Test
    public void testAddPartition_Success() throws Exception {

        // Создаем объект для сохранения в БД
        Partitions partition = new Partitions();
        partition.setPartitionId(7777L);
        partition.setPartitionName("Test Partition");  // Название раздела комплектующих

        // Преобразуем объект в JSON
        String requestBody = objectMapper.writeValueAsString(partition);

        // Выполняем POST-запрос к контроллеру
        ResultActions result = mockMvc.perform(post("/admin/add-partition")
                .contentType("application/json")
                .header("Authorization", "Bearer " + token)  // Добавляем токен в заголовок
                .content(requestBody));

        // Проверяем успешный ответ
        result.andExpect(status().isCreated());
    }

    @Test
    public void testEditPartition_Success() throws Exception {

        // Находим ранее добавленный раздел
        Partitions partition = partitionsRepository.findByPartitionName("Test Partition").get();

        // Редактируем название
        partition.setPartitionName("Edited Partition");

        // Преобразуем объект в JSON
        String requestBody = objectMapper.writeValueAsString(partition);

        // Выполняем PUT-запрос к контроллеру
        ResultActions result = mockMvc.perform(put("/admin/edit-partition")
                .contentType("application/json")
                .header("Authorization", "Bearer " + token)  // Добавляем токен в заголовок
                .content(requestBody));

        // Проверяем успешный ответ
        result.andExpect(status().isOk());
    }

    @Test
    public void testDeletePartition_Success() throws Exception {

        // id существующего раздела
        long partitionIdToDelete = 7777L;

        // Выполняем DELETE-запрос к контроллеру
        ResultActions result = mockMvc.perform(delete("/admin/delete-partition/" + partitionIdToDelete)
                .contentType("application/json")
                .header("Authorization", "Bearer " + token));  // Добавляем токен в заголовок

        // Проверяем успешный ответ
        result.andExpect(status().isOk());
    }

}
