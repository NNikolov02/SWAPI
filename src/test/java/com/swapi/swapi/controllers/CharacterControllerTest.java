package com.swapi.swapi.controllers;

import com.swapi.swapi.Web.CharacterController;
import com.swapi.swapi.Web.Model.Character;
import com.swapi.swapi.Web.mapping.CharacterMapper;
import com.swapi.swapi.Web.mapping.CharacterMapperC;
import com.swapi.swapi.Web.service.CharacterService;
import com.swapi.swapi.Web.validation.ObjectValidator;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CharacterController.class)
public class CharacterControllerTest {



        @MockBean
        private CharacterService characterService;

        @MockBean
        private CharacterMapperC characterMapper;

        @MockBean
        private ObjectValidator validator;

        @InjectMocks
        private CharacterController controller;

        @Autowired
        private MockMvc mockMvc;


    @Test
    void shouldHavePaginationOnFetchAll() throws Exception {
        Page<Character> emptyCharacterPage = new PageImpl<>(
                Collections.emptyList(),
                PageRequest.of(0, 10) , 0);
        when(characterService.fetchAll(0, 10)).thenReturn(emptyCharacterPage);


        mockMvc.perform(
                        get("/characters")
                                // .param("currPage", "5")
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pagination.currentPage").value(0))
                .andExpect(jsonPath("$.pagination.pageSize").value(10))
                .andExpect(jsonPath("$.pagination.totalElements").value(0));
    }

    @Test
    void shouldReturnBadRequestWithErrors() throws Exception {

        Map<String, String> validationErrors = new HashMap<>();
        validationErrors.put("mass",  "cannot be negative");

        when(
                validator.validate(any())
        ).thenReturn(validationErrors);

        mockMvc.perform(post("/characters")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Luke\",\n" +
                                "                \"mass\": -5,\n" +
                                "                \"gender\": \"male\"}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors.mass").value( "cannot be negative"));
    }
}
