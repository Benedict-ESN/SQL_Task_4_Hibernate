package ru.netology.task_4_Hibernate.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.netology.task_4_Hibernate.entity.Person;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    // Метод для поиска пользователей по городу
    @Query("SELECT p FROM Person p WHERE p.cityOfLiving = :city")
    List<Person> findByCity(String city);

    // Метод для поиска пользователей моложе определённого возраста, отсортированных по возрастанию
    List<Person> findByAgeLessThanOrderByAgeAsc(int age);

    // Метод для поиска пользователя по имени и фамилии
    Optional<Person> findByNameAndSurname(String name, String surname);
}