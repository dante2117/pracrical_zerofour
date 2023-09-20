package com.example.springmodels.models;

import javax.persistence.*;

@Entity
@Table(name = "passport")
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    @OneToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public Passport() {
    }

    public Passport(Long id, String number, Pet pet) {
        this.id = id;
        this.number = number;
        this.pet = pet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPerson(Pet pet) {
        this.pet = pet;
    }
}

