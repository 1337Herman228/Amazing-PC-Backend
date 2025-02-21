package com.example.amazingpcbackend;

import com.example.amazingpcbackend.dto.AuthenticationRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AuthenticationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testAuthenticate_Success() throws Exception {
        //Создаем объект аутентификации
        AuthenticationRequest authenticationRequest = new AuthenticationRequest(
                false,
                "",
                "",
                "{}",
                "user",
                "88888888"
        );

        // Преобразуем объект в JSON
        String requestBody = objectMapper.writeValueAsString(authenticationRequest);

        // Выполняем POST-запрос к контроллеру
        ResultActions result = mockMvc.perform(post("/auth/authenticate")
                .contentType("application/json")
                .content(requestBody));

        // Проверяем успешный ответ
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.authenticationResponse.token").exists())  // Проверка наличия токена
                .andExpect(jsonPath("$.role").value("user"))  // Проверка роли
                .andExpect(jsonPath("$.userId").exists());  // Проверка наличия userId
    }

    @Test
    public void testAuthenticate_Failure_InvalidCredentials() throws Exception {
        // Создаем объект с неверными данными для аутентификации
        AuthenticationRequest authenticationRequest = new AuthenticationRequest(
                false,
                "",
                "",
                "{}",
                "ThisLoginDoesNotExist",
                "ThisPasswordDoesNotExist"
        );

        // Преобразуем объект в JSON
        String requestBody = objectMapper.writeValueAsString(authenticationRequest);

        // Выполняем POST-запрос к контроллеру
        ResultActions result = mockMvc.perform(post("/auth/authenticate")
                .contentType("application/json")
                .content(requestBody));

        // Проверяем, что вернулся статус ошибки (403 Forbidden)
        result.andExpect(status().isForbidden());
    }

}


