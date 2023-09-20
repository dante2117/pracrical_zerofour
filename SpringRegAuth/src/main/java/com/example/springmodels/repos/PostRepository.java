package com.example.springmodels.repos;

import com.example.springmodels.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long>{

    Post findByNamePost(String namePost);

}
