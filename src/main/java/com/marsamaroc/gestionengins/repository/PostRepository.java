package com.marsamaroc.gestionengins.repository;

import com.marsamaroc.gestionengins.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
    Post getPostByCodePost(Long codePost);
}
