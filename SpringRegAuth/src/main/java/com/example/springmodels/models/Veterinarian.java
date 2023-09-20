package com.example.springmodels.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "veterinarian")
public class Veterinarian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Поле 'Имя' не должно быть пустым")
    private String name;


    @NotBlank(message = "Опыт' не должно быть пустым")
    private String experience;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Veterinarian() {
    }

    public Veterinarian(String name, String experience, Post post) {

        this.name = name;
        this.experience = experience;
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
}
