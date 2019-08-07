package com.justin.roloVDex.services;

import com.justin.roloVDex.model.User;
import com.justin.roloVDex.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User create(User user) {
        return repository.save(user);
    }

    public List<User> read() {
        return repository.findAll();
    }

    public User read(Long id) {
        Optional<User> opt = repository.findById(id);
        if(opt.isPresent()) return opt.get();
        return null;
    }

    public User update(Long id, User updatedUser) {
        User user = read(id);
        if(user != null) {
            user.update(updatedUser);
            return repository.save(user);
        }

        return null;

    }

    public Boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }
}
