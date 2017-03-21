package com.paperpigeon.service;


import com.paperpigeon.dto.CardDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Here are the methods of Card that can be called via Rest.
 * If you want to add a new method, add it here, because the
 * DB service implements this interface.
 */

public interface CardService {

    CardDTO create(CardDTO card);

    CardDTO delete(String id);

    List<CardDTO> findAll();

    CardDTO findById(String id);

    CardDTO update(CardDTO card);
}
