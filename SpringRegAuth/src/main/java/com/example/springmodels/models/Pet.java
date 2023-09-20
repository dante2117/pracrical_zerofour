package com.example.springmodels.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Поле 'Имя' не должно быть пустым")
    private String name;

    @NotBlank(message = "Поле 'Тип' не должно быть пустым")
    private String type;

    @Min(value=0, message = "Возраст должен быть больше 0")
    @Max(value = 150, message = "Возраст должен быть меньше 100")
    @NotNull
    private int age;

    public Passport getPassportAvailability() {
        return passport;
    }

    public void setPassportAvailability(Passport passport) {
        this.passport = passport;
    }

    @OneToOne(mappedBy = "pet")
    private Passport passport;

    public Pet() {}

    public Pet(String name, String type, int age) {

        this.name = name;
        this.type = type;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
