package com.justin.roloVDex.controller;

import com.justin.roloVDex.exception.InvalidInputException;
import com.justin.roloVDex.model.User;
import com.justin.roloVDex.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<User>> index() {
        return new ResponseEntity<>(service.read(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(service.read(id), HttpStatus.OK);
        }
        catch(InvalidInputException ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<User> post(@RequestBody User user) {
        return new ResponseEntity<>(service.create(user), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> put(@PathVariable Long id, @RequestBody User user) {
        try {
            return new ResponseEntity<>(service.update(id, user), HttpStatus.OK);
        }
        catch(InvalidInputException ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<User> put(@RequestParam("userId") Long userId, @RequestParam("cardDataId") Long cardDataId) {
        try {
            return new ResponseEntity<>(service.update(userId, cardDataId), HttpStatus.OK);
        }
        catch(InvalidInputException ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
        }
        catch(InvalidInputException ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
