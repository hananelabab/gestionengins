package com.marsamaroc.gestionengins.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marsamaroc.gestionengins.dto.PostDTO;
import com.marsamaroc.gestionengins.dto.UserDTO;
import com.marsamaroc.gestionengins.entity.Post;
import com.marsamaroc.gestionengins.entity.User;
import com.marsamaroc.gestionengins.service.UserService;
import com.marsamaroc.gestionengins.service.UserServiceImp;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
    @GetMapping(value="")
    List<UserDTO> getUsers(){
    	
    	List<UserDTO> usreDTOList = new ArrayList<>();
    	
    	List<User> users =userService.getUsres();
    	for(User user : users)
    		usreDTOList.add(new UserDTO(user));
        return usreDTOList;
    }
    @PostMapping(value="/")
    UserDTO setUser(@RequestBody User user){
    	System.out.println(user.getPassword()+" Id !");
    	if(userService.getUserById(user.getId())!=null)
    		return new UserDTO(userService.saveUser(user));
    	return null;
    		
    }
}