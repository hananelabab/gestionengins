package com.marsamaroc.gestionengins.service;

import com.marsamaroc.gestionengins.dto.PostDTO;
import com.marsamaroc.gestionengins.entity.Post;

import java.util.List;

import org.springframework.stereotype.Service;

public interface PostService {
    Post getById(Long id);
    List<Post> getAll();
    PostDTO savOrUpdate(Post post);
}

