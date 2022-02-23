package com.marsamaroc.gestionengins.service;

import com.marsamaroc.gestionengins.entity.Post;
import com.marsamaroc.gestionengins.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImp implements PostService {
    @Autowired
    PostRepository postRepository;

    @Override
    public Post getById(Long id) {
        return postRepository.getPostByCodePost(id);
    }
}
