package com.paperpigeon.mongo_service;

import com.paperpigeon.dto.CardDTO;
import com.paperpigeon.repository.CardRepository;
import com.paperpigeon.service.CardService;
import com.paperpigeon.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

/**
 * This is the place where we implement the methods from the controller(here, CardController)
 * the way they behave and connect to the DB
 * <p>!NEVER forget to save your changes in the DB (obj = repository.save(obj))!!</p>
 */

@Service
public final class MongoCardService implements CardService {

    private final CardRepository repository;

    @Autowired
    public MongoCardService(CardRepository repository) {
        this.repository = repository;
    }

    @Override
    public CardDTO create(CardDTO card) {
        Card persisted = Card.getBuilder()
                .title(card.getTitle())
                .message(card.getMessage())
                .imagePath(card.getImagePath())
                .build();
        persisted = repository.save(persisted);
        return convertToDTO(persisted);
    }

    @Override
    public CardDTO delete(String id) {
        Card deleted = findCardById(id);
        repository.delete(deleted);
        return convertToDTO(deleted);
    }

    @Override
    public List<CardDTO> findAll() {
        List<Card> cardEntries = repository.findAll();
        return convertToDTOs(cardEntries);
    }

    private List<CardDTO> convertToDTOs(List<Card> models) {
        return models.stream()
                .map(this::convertToDTO)
                .collect(toList());
    }

    @Override
    public CardDTO findById(String id) {
        Card found = findCardById(id);
        return convertToDTO(found);
    }

    @Override
    public CardDTO update(CardDTO card) {
        Card updated = findCardById(card.getId());
       // updated.update(card.getTitle(), card.getDescription());
        updated = repository.save(updated);
        return convertToDTO(updated);
    }

    private Card findCardById(String id) {
        Optional<Card> result = repository.findOne(id);
        return result.orElseThrow(() -> new NullPointerException(id));

    }

    public CardDTO magic(String id){
        Card card = findCardById(id);
        card.magic();
        card = repository.save(card);
        return  convertToDTO(card);
    }

    private CardDTO convertToDTO(Card model) {
        CardDTO dto = new CardDTO();

        dto.setId(model.getId());
        dto.setTitle(model.getTitle());
        dto.setMessage(model.getMessage());
        dto.setImagePath(model.getImagePath());

        return dto;
    }
}