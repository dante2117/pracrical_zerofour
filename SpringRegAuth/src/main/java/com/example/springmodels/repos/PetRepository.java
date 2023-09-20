package com.example.springmodels.repos;

import com.example.springmodels.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
    Pet findByName(String name);
}
