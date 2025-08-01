package com.paymentchain.jpa.helper;

import com.paymentchain.jpa.CustomerJPARepository;
import com.paymentchain.jpa.CustomerJPARepositoryAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.data.domain.Example;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class AdapterOperationsTest {

    @Mock
    private CustomerJPARepository repository;

    @Mock
    private ObjectMapper objectMapper;

    private CustomerJPARepositoryAdapter adapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        when(objectMapper.map("value", Object.class)).thenReturn("value");

        adapter = new CustomerJPARepositoryAdapter(repository, objectMapper);
    }

    @Test
    void testSave() {

        Object objectValue = "value";

        when(repository.save(objectValue)).thenReturn(objectValue);

        Object result = adapter.save(objectValue);

        assertEquals(result, objectValue);
    }

    @Test
    void testSaveAllEntities() {

        List<Object> objectValues = List.of("value", "value");

        when(repository.saveAll(objectValues)).thenReturn(objectValues);

        Object result = adapter.saveAllEntities(objectValues);

        assertEquals(result, objectValues);
    }

    @Test
    void testFindById() {

        Object objectValue = "value";

        when(repository.findById("id")).thenReturn(Optional.of(objectValue));

        Object result = adapter.findById("id");

        assertEquals(result, objectValue);
    }

    @Test
    void testFindAll() {

        List<Object> objectValues = List.of("value", "value");

        when(repository.findAll()).thenReturn(objectValues);

        Object result = adapter.findAll();

        assertEquals(result, objectValues);
    }

    @Test
    void testFindByExample() {

        Object objectValue = "value";
        List<Object> objectValues = List.of(objectValue, objectValue);

        when(repository.findAll(any(Example.class))).thenReturn(objectValues);

        Object result = adapter.findByExample(objectValue);

        assertEquals(result, objectValues);
    }
}
