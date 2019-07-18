package com.justin.roloVDex.repository;

import com.justin.roloVDex.model.CardData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardDataRepository extends JpaRepository<CardData, Long> {
}
