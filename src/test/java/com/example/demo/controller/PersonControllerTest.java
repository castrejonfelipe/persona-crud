package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PersonController.class)
class PersonControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    PersonService service;

    @Autowired
    ObjectMapper mapper;

    /**
     * ✅ Configuración de prueba para inyectar un mock como bean.
     * Esto reemplaza el uso de @MockBean (deprecated).
     */
    @TestConfiguration
    static class MockConfig {
        @Bean
        public PersonService personService() {
            return Mockito.mock(PersonService.class);
        }
    }

    @Test
    void list_shouldReturn200() throws Exception {
        when(service.list()).thenReturn(Arrays.asList(new Person("A", "a@a")));
        mvc.perform(get("/api/persons"))
                .andExpect(status().isOk());
    }

    @Test
    void create_shouldReturn201() throws Exception {
        Person p = new Person("New", "n@x.com");
        when(service.create(any())).thenAnswer(i -> {
            Person arg = i.getArgument(0);
            arg.setId(1L);
            return arg;
        });

        mvc.perform(post("/api/persons")
                        .contentType("application/json")
                        .content(mapper.writeValueAsString(p)))
                .andExpect(status().isCreated());
    }
}

