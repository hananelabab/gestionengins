package com.marsamaroc.gestionengins.service;

import com.marsamaroc.gestionengins.entity.Post;
import org.springframework.stereotype.Service;

public interface PostService {
    Post getById(Long id);
}

