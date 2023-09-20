package com.example.springmodels.controllers;


import com.example.springmodels.models.*;
import com.example.springmodels.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@PreAuthorize("hasAnyAuthority('USER', 'ADMIN', 'VET')")
public class userController {

    @Autowired
    private VeterinarianRepository veterinarianRepository;
    @Autowired
    private ClinicRepository clinicRepository;
    @Autowired
    private EquipmentRepository equipmentRepository;
    @Autowired
    private PassportRepository passportRepository;
    @Autowired
    private PetRepository petRepository;
    @Autowired
    private PostRepository postRepository;


    @GetMapping("/veterinarian")
    public String employeeMain(Model model)
    {
        Iterable<Veterinarian> veterinarians = veterinarianRepository.findAll();
        model.addAttribute("veterinarians", veterinarians);
        return "veterinarian-main";
    }

    @GetMapping("/clinic")
    public String clinicMain(Model model)
    {
        Iterable<Clinic> clinics = clinicRepository.findAll();
        model.addAttribute("clinics", clinics);
        return "clinic-main";
    }

    @GetMapping("/equipment")
    public String equipmentMain(Model model)
    {
        Iterable<Equipment> equipments = equipmentRepository.findAll();
        model.addAttribute("equipments", equipments);
        return "equipment-main";
    }

    @GetMapping("/passport")
    public String passportMain(Model model)
    {
        Iterable<Passport> passports = passportRepository.findAll();
        model.addAttribute("passports", passports);
        return "passport-main";
    }

    @GetMapping("/pet")
    public String petMain(Model model)
    {
        Iterable<Pet> pets = petRepository.findAll();
        model.addAttribute("pets", pets);
        return "pet-main";
    }

    @GetMapping("/post")
    public String postMain(Model model)
    {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "post-main";
    }

}
