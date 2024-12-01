package ru.netology.task_4_Hibernate.repository;


import ru.netology.task_4_Hibernate.entity.Person;
import ru.netology.task_4_Hibernate.entity.PersonId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, PersonId> {
    List<Person> findByCityOfLiving(String city);
}
