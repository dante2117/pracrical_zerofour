package com.example.springmodels.repos;

import com.example.springmodels.models.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ClinicRepository extends CrudRepository<Clinic, Long> {
    //Clinic findByClinic(String addres);
}
