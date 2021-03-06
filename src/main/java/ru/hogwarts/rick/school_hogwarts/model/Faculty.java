package ru.hogwarts.rick.school_hogwarts.model;

import java.util.Collection;
import java.util.Objects;
import javax.persistence.*;

/**
 * Faculty имеет следующие поля: Long id, String name, String color.
 * 1. Добавить конструкторы к классам, с помощью которых можно проинициализировать все поля (создать объект класса через new и передать в него все параметры).
 * 2. Создать методы для получения и изменения переменных класса. Сами переменные должны быть private.
 **/

@Entity
public class Faculty {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String color;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "faculty")
    private Collection<Student> student;

    public Faculty(Long id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public Faculty() {
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return id.equals(faculty.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
