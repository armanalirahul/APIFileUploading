package com.api.api.controller;

import java.util.List;
import java.util.Optional;

import com.api.api.Services.Services;
import com.api.api.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private Services s;

    @PostMapping("/adduser")
    public ResponseEntity<HttpStatus> add(@RequestBody User user) {
        User users = s.addUser(user);
        if (users != null) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).build();
        }
    }

    @GetMapping("/users")
    public List<User> AllUsers() {
        List<User> users = s.getAllUsers();
        return users;
    }

    @GetMapping("/user/{id}")
    public Optional<User> getById(@PathVariable("id") int id) {
        Optional<User> user = s.getById(id);
        return user;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id) {
        int i = s.delete(id);
        if (i > 0) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
        }
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<HttpStatus> update(@RequestBody User user, @PathVariable("id") int id) {
        User update = s.update(user, id);
        if (update != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
        }
    }

}
