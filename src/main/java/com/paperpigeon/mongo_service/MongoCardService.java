package com.paperpigeon.mongo_service;

import com.paperpigeon.dto.CardDTO;
import com.paperpigeon.repository.CardRepository;
import com.paperpigeon.service.CardService;
import com.paperpigeon.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
                .price(card.getPrice())
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

    @Override
    public List<CardDTO> findByTitle(String title) {
        List<Card> cardEntries = repository.findAll();
        List<Card> cardsWithDesiredTitle = new ArrayList<>();
        for(Card card : cardEntries){
            if(card.getTitle().contains(title)){
                cardsWithDesiredTitle.add(card);
            }
        }
        return convertToDTOs(cardsWithDesiredTitle);
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
        String title = card.getTitle() == null ? updated.getTitle() : card.getTitle(),
                imagePath = card.getImagePath() == null ? updated.getImagePath() : card.getImagePath(),
                message = card.getMessage() == null ? updated.getMessage() : card.getMessage();
        double price = card.getPrice() == 0 ? updated.getPrice() : card.getPrice();
        updated.update(title, message, imagePath, price);
        updated = repository.save(updated);
        return convertToDTO(updated);
    }

    private Card findCardById(String id) {
        Optional<Card> result = repository.findOne(id);
        return result.orElseThrow(() -> new NullPointerException(id));
    }

    private CardDTO convertToDTO(Card model) {
        CardDTO dto = new CardDTO();

        dto.setId(model.getId());
        dto.setTitle(model.getTitle());
        dto.setMessage(model.getMessage());
        dto.setImagePath(model.getImagePath());
        dto.setPrice(model.getPrice());

        return dto;
    }
}