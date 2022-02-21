package ru.hogwarts.rick.school_hogwarts.model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Класс Student имеет следующие поля: Long id, String name, int age.
 * 1. Добавить конструкторы к классам, с помощью которых можно проинициализировать все поля (создать объект класса через new и передать в него все параметры).
 * 2. Создать методы для получения и изменения переменных класса. Сами переменные должны быть private.
 **/

@Entity
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int age;


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(id, student.id) && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }
}
