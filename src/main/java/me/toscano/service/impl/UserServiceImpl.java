package me.toscano.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import me.toscano.santanderdev2023.model.User;
import me.toscano.santanderdev2023.repository.UserRepository;
import me.toscano.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    // constructor
    public UserServiceImpl(UserRepository userRepository) {this.userRepository = userRepository;}

    @Override
    public List<User> findAll() {return userRepository.findAll();}

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
        if (!userExists.isPresent()){
            throw new NoSuchElementException("User does not exist.");
        }
        userRepository.save(user);
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
