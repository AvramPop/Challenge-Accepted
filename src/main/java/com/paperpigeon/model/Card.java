package com.paperpigeon.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * This is a POJO(Plain Old Java Object), so its purpose is to model a entity
 * that will be then handled by the DB, calls, and so on.
 */
@Document(collection = "Card")
public final class Card {

    public static final int MAX_LENGTH_MESSAGE = 100;
    public static final int MAX_LENGTH_TITLE = 100;
    public static final int MAX_LENGTH_IMAGEPATH = 100;

    @Id
    private String id;

    @Field(value = "message")
    private String message;

    @Field(value = "title")
    private String title;

    @Field(value = "imagePath")
    private String imagePath;

    @Field(value = "price")
    private double price;

    public Card() {}

    private Card(Builder builder) {
        this.message = builder.message;
        this.title = builder.title;
        this.imagePath = builder.imagePath;
        this.price = builder.price;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getMessage() {
        return message;
    }

    public String getId() {
        return id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void update(String title, String message, String imagePath, double price) {
        checkInfo(title, message, imagePath);

        this.title = title;
        this.imagePath = imagePath;
        this.message = message;
        this.price = price;
    }

    public static class Builder {

        private String message;

        private String title;

        private double price;

        private String imagePath;

        private Builder() {}

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder imagePath(String imagePath) {
            this.imagePath = imagePath;
            return this;
        }

        public Card build() {
            Card build = new Card(this);
            if(build.checkInfo(build.getTitle(), build.getMessage(), build.getImagePath())){
                return build;
            }
            throw new IllegalArgumentException();
        }
    }

    private boolean checkInfo(String title, String message, String imagePath) {
        if(title == null) {
            System.err.println("Title cannot be null");
            return false;
        }

        if(title.isEmpty()) {
            System.err.println("Title cannot be empty");
            return false;
        }

        if(imagePath == null) {
            System.err.println("Image path cannot be null");
            return false;
        }

        if(imagePath.isEmpty()) {
            System.err.println("Image path cannot be empty");
            return false;
        }

        if(title.length() > MAX_LENGTH_TITLE){
            System.err.println("Title cannot be longer than " + MAX_LENGTH_TITLE + " characters");
            return false;
        }

        if (message != null) {
            if(message.length() > MAX_LENGTH_MESSAGE){
                System.err.println("Description cannot be longer than " + MAX_LENGTH_MESSAGE + " characters");
                return false;
            }
        }

        return true;
    }
}
