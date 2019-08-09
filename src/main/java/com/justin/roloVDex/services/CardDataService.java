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
public class CardDataService {

    private CardDataRepository cardDataRepository;
    private UserRepository userRepository;

    @Autowired
    public CardDataService(CardDataRepository cardDataRepository, UserRepository userRepository) {
        this.cardDataRepository = cardDataRepository;
        this.userRepository = userRepository;
    }

    /**
     *
     * @param cardData - the CardData object to be saved in the database
     * @param ownerId - the id of the User who created the CardData
     * @return the saved version of the CardData object
     * @throws InvalidInputException if owner does not exist
     */
    public CardData create(CardData cardData, Long ownerId) throws InvalidInputException {
        Optional<User> owner = userRepository.findById(ownerId);

        if(owner.isPresent()) {
            cardData.setOwner(owner.get());
            cardData.setDateCreated(LocalDate.now());
            cardData.setDateUpdated(cardData.getDateCreated());
            return cardDataRepository.save(cardData);
        }

        throw new InvalidInputException();

    }

    /**
     * Get all of the CardData objects that are in the database
     * @return a list of all the CardData objects in the database
     */
    public List<CardData> readAll() { return cardDataRepository.findAll(); }

    /**
     * Get a single CardData object from the database
     * @param id - Id of the CardData
     * @return - the respective CardData with the Id
     * @throws InvalidInputException if CardData does not exist
     */
    public CardData read(Long id) throws InvalidInputException {
        Optional<CardData> optional = cardDataRepository.findById(id);
        if(optional.isPresent()) return optional.get();
        throw new InvalidInputException();
    }

    /**
     * Update the values of a CardData object in the database
     * @param id - The Id of the CardData to be updated
     * @param updateData - A CardData object containing new data
     * @return - the updated version of the CardData object
     * @throws InvalidInputException if CardData to be updated does not exist
     */
    public CardData update(Long id, CardData updateData) throws InvalidInputException {

        CardData data = read(id);
        data.update(updateData);
        data.setDateUpdated(LocalDate.now());
        return cardDataRepository.save(data);

    }

    /**
     * Delete a CardData object from the database
     * @param id - The id of the CardData to by deleted
     * @return true if card is deleted
     * @throws InvalidInputException if CardData to be deleted does not exist
     */
    public Boolean delete(Long id) throws InvalidInputException {
        cardDataRepository.deleteById(read(id).getId());
        return true;
    }

}
