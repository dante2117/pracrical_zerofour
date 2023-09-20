package com.example.springmodels.repos;

import com.example.springmodels.models.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EquipmentRepository extends CrudRepository<Equipment, Long> {
   Equipment findEquipmentByName(String name);
}
