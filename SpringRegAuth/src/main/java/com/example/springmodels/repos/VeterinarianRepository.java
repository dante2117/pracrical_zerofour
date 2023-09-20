package com.example.springmodels.repos;

import com.example.springmodels.models.Veterinarian;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VeterinarianRepository extends JpaRepository<Veterinarian, Long> {

    Veterinarian findByName(String name);

    List<Veterinarian> findByNameContains(String name);
    List<Veterinarian> findByNameContaining(String name);
    List<Veterinarian> findByNameIsContaining(String name);
    List<Veterinarian> findByNameEquals(String name);
}
