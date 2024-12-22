package ru.netology.task_4_Hibernate.controller;


import org.springframework.web.bind.annotation.*;
import ru.netology.task_4_Hibernate.entity.Person;
import ru.netology.task_4_Hibernate.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    // Получение списка пользователей по городу
    @GetMapping("/by-city")
    public List<Person> getPersonsByCity(@RequestParam("city") String city) {
        return repository.findByCity(city);
    }

    // Получение списка пользователей младше указанного возраста
    @GetMapping("/younger-than")
    public List<Person> getPersonsYoungerThan(@RequestParam("age") int age) {
        return repository.findByAgeLessThanOrderByAgeAsc(age);
    }

    // Получение пользователя по имени и фамилии
    @GetMapping("/by-name-and-surname")
    public Optional<Person> getPersonByNameAndSurname(
            @RequestParam("name") String name,
            @RequestParam("surname") String surname) {
        return repository.findByNameAndSurname(name, surname);
    }
}