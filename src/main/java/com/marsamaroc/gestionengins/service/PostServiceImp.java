package com.marsamaroc.gestionengins.service;

import com.marsamaroc.gestionengins.dto.PostDTO;
import com.marsamaroc.gestionengins.entity.Post;
import com.marsamaroc.gestionengins.repository.PostRepository;

import java.util.List;

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

    @Override
    public PostDTO savOrUpdate(Post post) {
        Post oldpost = postRepository.getPostByCodePost(post.getCodePost());
        if(oldpost!= null)  oldpost.sync(post);
        else oldpost = post;
        return new PostDTO(postRepository.save(oldpost));
    }

	@Override
	public List<Post> getAll() {
		// TODO Auto-generated method stub
		return postRepository.findAll();
		}
}
