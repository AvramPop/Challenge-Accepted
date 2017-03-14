package com.paperpigeon.repository;


import com.paperpigeon.model.Card;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;
/**
 * Here are the operations linked to the repo,
 * they are probably the same for every object
 */

public interface CardRepository extends Repository<Card, String> {

    void delete(Card deleted);

    List<Card> findAll();

    Optional<Card> findOne(String id);

    Card save(Card saved);
}
