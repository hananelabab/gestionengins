package com.marsamaroc.gestionengins.service;

import com.marsamaroc.gestionengins.entity.User;
import com.marsamaroc.gestionengins.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImp implements UserService{
    @Autowired
    UserRepository userRepository;
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public List<User> getUsres() {
        return userRepository.findAll();
    }

    @Override
    public User saveUserIfNotExist(User user){
        System.out.println(user.getMatricule());
        User user_Test = getUserByMatricule(user.getMatricule());
        if (user_Test == null)
            user_Test = saveUser(user);
        return user_Test;
    }
    @Override
    public User getUserByMatricule(String matricule) {
        return userRepository.findByMatricule(matricule);
    }
}
