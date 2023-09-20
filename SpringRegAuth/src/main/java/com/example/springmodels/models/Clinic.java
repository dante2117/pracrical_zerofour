package com.example.springmodels.models;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "clinic")
public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String addres;

    @ManyToMany
    @JoinTable(name = "clinic_equipment", joinColumns = @JoinColumn(name = "clinic_id"), inverseJoinColumns = @JoinColumn(name = "equipment_id"))
    private List<Equipment> equipments;

    public Clinic() {
    }

    public Clinic(Long id, String addres) {
        this.id = id;
        this.addres = addres;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public List<Equipment> getEquipment() {
        return equipments;
    }

    public void setEquipment(List<Equipment> equipments) {
        this.equipments = equipments;
    }

}
