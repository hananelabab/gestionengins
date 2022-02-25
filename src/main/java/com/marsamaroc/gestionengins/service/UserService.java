package com.marsamaroc.gestionengins.service;

import com.marsamaroc.gestionengins.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User getUserById(Long id);
    List<User> getUsres();

    User saveUserIfNotExist(User user);

    User getUserByMatricule(String matricule);


}
