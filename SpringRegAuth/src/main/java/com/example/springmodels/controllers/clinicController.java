package com.example.springmodels.controllers;

import com.example.springmodels.models.Clinic;
import com.example.springmodels.models.Equipment;
import com.example.springmodels.repos.ClinicRepository;
import com.example.springmodels.repos.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/vet")
@PreAuthorize("hasAnyAuthority('VET')")
public class clinicController {
    @Autowired
    private ClinicRepository clinicRepository;
    @Autowired
    private EquipmentRepository equipmentRepository;


//
//
//    @GetMapping("/clinic/add")
//    public String clinicAdd(@ModelAttribute("veterinarians") Clinic clinic, Model clinics)
//    {
//        Iterable<Equipment> equipment = equipmentRepository.findAll();
//        clinics.addAttribute("equipment", equipment);
//        return "clinic-add";
//    }
//
//
//
//    @PostMapping("/clinic/add")
//    public String clinicPostAdd(@ModelAttribute("veterinarians") @Valid Clinic clinic, BindingResult bindingResult,
//                                  @RequestParam String addres, Model clinics)
//    {
//        if(bindingResult.hasErrors()) {
//            Iterable<Equipment> equipment = equipmentRepository.findAll();
//            clinics.addAttribute("equipment", equipment);
//            return "clinic-add";
//        }
//        clinic.setEquipment(equipmentRepository.findEquipmentByName(addres));
//        veterinarianRepository.save(clinic);
//        return "redirect:/clinic";
//    }
//
//    @GetMapping("/clinic/{id}/edit")
//    public  String clinicDetails(@PathVariable(value = "id") long id, Model model, Model clinics)
//    {
//        Iterable<Equipment> equipment = equipmentRepository.findAll();
//        clinics.addAttribute("equipment", equipment);
//        Clinic res1 = veterinarianRepository.findById(id).orElseThrow();
//        model.addAttribute("clinic",res1);
//        return "clinic-edit";
//    }
//
//    @PostMapping("/clinic/{id}/edit")
//    public String clinicUpdate(@ModelAttribute("clinic") @Valid Clinic clinic,
//                                 BindingResult bindingResult,
//                                 @PathVariable(value = "id") Long id,
//                                 Model model) {
//        if (bindingResult.hasErrors()) {
//            Iterable<Equipment> equipment = equipmentRepository.findAll();
//            model.addAttribute("equipment", equipment);
//            model.addAttribute("clinic", clinic);
//            return "clinic-edit";
//        }
//
//        Clinic existingClinic = veterinarianRepository.findById(id).orElse(null);
//
//        if (existingClinic == null) {
//            return "redirect:/clinic";
//        }
//
//
//        Equipment equipment = equipmentRepository.findByNamePost(clinic.getPost().getNamePost());
//        if (equipment == null) {
//            equipment = new Equipment();
//            equipment.setNamePost(clinic.getPost().getNamePost());
//            equipmentRepository.save(equipment);
//        }
//
//
//        existingClinic.setName(clinic.getName());
//        existingClinic.setExperience(clinic.getExperience());
//        existingClinic.setEquipment(equipment);
//
//        veterinarianRepository.save(existingClinic);
//
//        return "redirect:/clinic";
//    }
//
//
//    @GetMapping("/clinic/{id}/remove")
//    public  String clinicDelete(@PathVariable(value = "id") long id, Model model)
//    {
//        Clinic clinic = veterinarianRepository.findById(id).orElseThrow();
//        veterinarianRepository.delete(clinic);
//        return "redirect:/clinic";
//    }
}
