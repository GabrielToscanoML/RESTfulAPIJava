package me.toscano.santanderdev2023.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.toscano.santanderdev2023.model.User;
import me.toscano.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User userToCreate) {
        return ResponseEntity.ok(userService.create(userToCreate));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateById(@PathVariable Long id, @RequestBody User userToCreate) {
        userService.updateById(id, userToCreate);
        return ResponseEntity.ok(userToCreate);
    }

    @DeleteMapping
    public ResponseEntity<User> deleteById(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
