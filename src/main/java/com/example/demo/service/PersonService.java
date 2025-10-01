package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository repo;
    public PersonService(PersonRepository repo) { this.repo = repo; }
    public Person create(Person p) { return repo.save(p); }
    public List<Person> list() { return repo.findAll(); }
    public Optional<Person> get(Long id) { return repo.findById(id); }
    public Person update(Long id, Person p) {
        return repo.findById(id).map(existing -> {
            existing.setName(p.getName());
            existing.setEmail(p.getEmail());
            return repo.save(existing);
        }).orElseThrow(() -> new RuntimeException("Not found"));
    }
    public void delete(Long id) { repo.deleteById(id); }
}
