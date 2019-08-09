package com.justin.roloVDex.services;

import com.justin.roloVDex.exception.InvalidInputException;
import com.justin.roloVDex.model.CardData;
import com.justin.roloVDex.model.User;
import com.justin.roloVDex.repository.CardDataRepository;
import com.justin.roloVDex.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private CardDataRepository cardDataRepository;

    @Autowired
    public UserService(UserRepository userRepository, CardDataRepository cardDataRepository) {
        this.userRepository = userRepository;
        this.cardDataRepository = cardDataRepository;
    }

    public User create(User user) {
        user.setJoinDate(LocalDate.now());
        return userRepository.save(user);
    }

    public List<User> read() {
        return userRepository.findAll();
    }

    public User read(Long id) throws InvalidInputException {
        Optional<User> opt = userRepository.findById(id);
        if(opt.isPresent()) return opt.get();
        throw new InvalidInputException();
    }

    /**
     * Update a User in the database with new information
     * @param id - the id of the User to be updated
     * @param updatedUser - A User object containing the new information to update
     * @return the updated version of the User
     * @throws InvalidInputException if the User does not exist
     */
    public User update(Long id, User updatedUser) throws InvalidInputException {
        User user = read(id);
        user.update(updatedUser);
        return userRepository.save(user);

    }

    /**
     * Update a User in the database by adding a shared CardData from the database
     * @param id - the id of the User
     * @param cardDataId - the id of the CardData
     * @return the updated User with the CardData
     * @throws InvalidInputException if the User or CardData does not exist
     */
    public User update(Long id, Long cardDataId) throws InvalidInputException {
        User user = read(id);

        Optional<CardData> optional = cardDataRepository.findById(cardDataId);
        if(optional.isPresent()) {
            user.addCard(optional.get());
            return userRepository.save(user);
        }

        throw new InvalidInputException();

    }

    /**
     * Delete a User from the database
     * @param id - the id of the User to be deleted
     * @return true if the User was deleted
     * @throws InvalidInputException if the User does not exist
     */
    public Boolean delete(Long id) throws InvalidInputException {
        userRepository.deleteById(read(id).getId());
        return true;
    }
}
