package com.example.springmodels.controllers;

import com.example.springmodels.models.Post;
import com.example.springmodels.models.Veterinarian;
import com.example.springmodels.repos.PostRepository;
import com.example.springmodels.repos.VeterinarianRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/vet")
@PreAuthorize("hasAnyAuthority('VET')")
public class vetController {


    @Autowired
    private VeterinarianRepository veterinarianRepository;
    @Autowired
    private PostRepository postRepository;




    @GetMapping("/veterinarian/add")
    public String employeeAdd(@ModelAttribute("veterinarians") Veterinarian veterinarian, Model posts)
    {
        Iterable<Post> post = postRepository.findAll();
        posts.addAttribute("post", post);
        return "veterinarian-add";
    }



    @PostMapping("/veterinarian/add")
    public String employeePostAdd(@ModelAttribute("veterinarians") @Valid Veterinarian veterinarian, BindingResult bindingResult,
                                  @RequestParam String namePost, Model posts)
    {
        if(bindingResult.hasErrors()) {
            Iterable<Post> post = postRepository.findAll();
            posts.addAttribute("post", post);
            return "veterinarian-add";
        }
        veterinarian.setPost(postRepository.findByNamePost(namePost));
        veterinarianRepository.save(veterinarian);
        return "redirect:/veterinarian";
    }

    @GetMapping("/veterinarian/{id}/edit")
    public  String employeeDetails(@PathVariable(value = "id") long id, Model model, Model posts)
    {
        Iterable<Post> post = postRepository.findAll();
        posts.addAttribute("post", post);
        Veterinarian res1 = veterinarianRepository.findById(id).orElseThrow();
        model.addAttribute("veterinarian",res1);
        return "veterinarian-edit";
    }

    @PostMapping("/veterinarian/{id}/edit")
    public String employeeUpdate(@ModelAttribute("veterinarian") @Valid Veterinarian veterinarian,
                                 BindingResult bindingResult,
                                 @PathVariable(value = "id") Long id,
                                 Model model) {
        if (bindingResult.hasErrors()) {
            Iterable<Post> post = postRepository.findAll();
            model.addAttribute("post", post);
            model.addAttribute("veterinarian", veterinarian);
            return "veterinarian-edit";
        }

        Veterinarian existingVeterinarian = veterinarianRepository.findById(id).orElse(null);

        if (existingVeterinarian == null) {
            return "redirect:/veterinarian";
        }


        Post post = postRepository.findByNamePost(veterinarian.getPost().getNamePost());
        if (post == null) {
            post = new Post();
            post.setNamePost(veterinarian.getPost().getNamePost());
            postRepository.save(post);
        }


        existingVeterinarian.setName(veterinarian.getName());
        existingVeterinarian.setExperience(veterinarian.getExperience());
        existingVeterinarian.setPost(post);

        veterinarianRepository.save(existingVeterinarian);

        return "redirect:/veterinarian";
    }


    @GetMapping("/veterinarian/{id}/remove")
    public  String employeeDelete(@PathVariable(value = "id") long id, Model model)
    {
        Veterinarian veterinarian = veterinarianRepository.findById(id).orElseThrow();
        veterinarianRepository.delete(veterinarian);
        return "redirect:/veterinarian";
    }
}
