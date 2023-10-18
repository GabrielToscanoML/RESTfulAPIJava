package me.toscano.service;

import java.util.List;
import me.toscano.santanderdev2023.model.User;

public interface UserService {
    List<User> findAll();
    User findById(Long Id);
    User create(User userToCreate);
    void updateById(Long id, User user);
    void deleteById(Long id);
}
