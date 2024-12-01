package ru.netology.task_4_Hibernate.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity
@IdClass(PersonId.class) // Для составного ключа
public class Person {

    @Id
    @Column(nullable = false, length = 50)
    private String name;

    @Id
    @Column(nullable = false, length = 50)
    private String surname;

    @Id
    @Column(nullable = false)
    private Integer age;

    @Column(length = 20)
    private String phoneNumber;

    @Column(length = 50)
    private String cityOfLiving;

    // Геттеры и сеттеры
}