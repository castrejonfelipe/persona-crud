package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class PersonServiceTest {
    private final PersonRepository repo = Mockito.mock(PersonRepository.class);
    private final PersonService service = new PersonService(repo);

    @Test
    void create_shouldSave() {
        Person p = new Person("John", "john@example.com");
        when(repo.save(any(Person.class))).thenAnswer(i -> {
            Person arg = i.getArgument(0);
            arg.setId(1L);
            return arg;
        });

        Person created = service.create(p);
        assertNotNull(created.getId());
        assertEquals("John", created.getName());
        verify(repo, times(1)).save(any());
    }

    @Test
    void list_shouldReturnAll() {
        when(repo.findAll()).thenReturn(Arrays.asList(new Person("A", "a@a"), new Person("B", "b@b")));
        List<Person> list = service.list();
        assertEquals(2, list.size());
        verify(repo).findAll();
    }

    @Test
    void get_shouldReturnOptional() {
        Person p = new Person("X", "x@x");
        p.setId(5L);
        when(repo.findById(5L)).thenReturn(Optional.of(p));
        Optional<Person> res = service.get(5L);
        assertTrue(res.isPresent());
        assertEquals("X", res.get().getName());
    }

    @Test
    void delete_shouldCallRepo() {
        service.delete(10L);
        verify(repo).deleteById(10L);
    }
}
