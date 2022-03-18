package com.marsamaroc.gestionengins.service;

import java.util.List;

import com.marsamaroc.gestionengins.dto.PostDTO;
import com.marsamaroc.gestionengins.entity.Post;

public interface PostService {
	Post getById(Long id);

	List<Post> getAll();

	PostDTO savOrUpdate(Post post);
}
