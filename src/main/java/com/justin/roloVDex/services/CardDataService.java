package com.justin.roloVDex.services;

import com.justin.roloVDex.model.CardData;
import com.justin.roloVDex.repository.CardDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardDataService {

    private CardDataRepository repository;

    @Autowired
    public CardDataService(CardDataRepository repository) {
        this.repository = repository;
    }

    public CardData create(CardData cardData) { return repository.save(cardData); }

    public List<CardData> readAll() { return repository.findAll(); }

    public CardData read(Long id) { return repository.getOne(id); }

    public CardData update(Long id, CardData updateData) {

        CardData data = read(id);
        data.update(updateData);
        return repository.save(data);

    }

    public Boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }
}
