package me.toscano.santanderdev2023.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import me.toscano.santanderdev2023.model.User;
import me.toscano.santanderdev2023.repository.UserRepository;
import me.toscano.santanderdev2023.service.UserService;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long Id) {
        return userRepository.findById(Id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("User Account number already exists.");
        }
        return userRepository.save(userToCreate);
    }

    // Sinto que esse método está errado. Mas, vou fazer uns testes com ele depois
    @Override
    public void updateById(Long id, User user) {
        Optional<User> userExists = userRepository.findById(id);
        System.out.println("TRUE OU NAO AQUI"+ " " + userExists.isPresent());
        if (userExists.isPresent()){
            userRepository.save(user);
        }
        throw new NoSuchElementException("User does not exist.");
    }

    @Override
    public void deleteById(Long id) {
        Optional<User> userExists = userRepository.findById(id);
        if (!userExists.isPresent()){
            throw new NoSuchElementException("User does not exist.");
        }
        userRepository.deleteById(id);
    }

}
