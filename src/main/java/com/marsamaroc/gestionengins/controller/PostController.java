package com.marsamaroc.gestionengins.controller;

import com.marsamaroc.gestionengins.dto.EnginSEDTO;
import com.marsamaroc.gestionengins.dto.PostDTO;
import com.marsamaroc.gestionengins.entity.Engin;
import com.marsamaroc.gestionengins.entity.Post;
import com.marsamaroc.gestionengins.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping(value="/add")
    PostDTO saveOrUpdate(@RequestBody Post post){
        return postService.savOrUpdate(post);
    }
    @GetMapping(value="/get")
    List<PostDTO> getPost(){
    	
    	List<PostDTO> postDTOList = new ArrayList<>();
    	
    	List<Post> posts = postService.getAll();
    	for(Post post : posts)
    		postDTOList.add(new PostDTO(post));
        return postDTOList;
    }
    
}
