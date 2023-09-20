package com.example.springmodels.models;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long post_id;



    private String namePost;
    @OneToMany(mappedBy = "post")
    private List<Veterinarian> veterinarians;

    public Post() {
    }

    public Post(Long post_id, String namePost) {
        this.post_id = post_id;
        this.namePost = namePost;
    }
    public Long getPost_id() {
        return post_id;
    }

    public void setPost_id(Long post_id) {
        this.post_id = post_id;
    }

    public String getNamePost() {
        return namePost;
    }

    public void setNamePost(String namePost) {
        this.namePost = namePost;
    }

    public List<Veterinarian> getVeterinarians() {
        return veterinarians;
    }

    public void setVeterinarians(List<Veterinarian> veterinarians) {
        this.veterinarians = veterinarians;
    }
}
