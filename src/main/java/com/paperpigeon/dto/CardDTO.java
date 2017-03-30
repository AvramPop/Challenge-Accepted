package com.paperpigeon.dto;


import com.paperpigeon.model.Card;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * This is the object we use as a information-holder for our REST calls. This means that we pass this object
 * as body in our controller, if we want a body(for the id, for example).
 *
 * A DTO (data transfer object) is meant to carry data between different processes,
 * in our case between the DB and the controller.
 * Every POJO should have this equivalent!
 */
public final class CardDTO {

    private String id;

    @Size(max = Card.MAX_LENGTH_MESSAGE)
    private String message = "";

    @NotEmpty
    @Size(max = Card.MAX_LENGTH_IMAGEPATH)
    private String imagePath = "";

    @NotEmpty
    @Size(max = Card.MAX_LENGTH_TITLE)
    private String title;

    @NotEmpty
    private double price;

    public CardDTO findCardById(String id){
        if(this.id.equals(id)){
            return this;
        } else {
            return null;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setMessage(String description) {
        this.message = message;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

