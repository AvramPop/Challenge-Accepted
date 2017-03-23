package com.paperpigeon.model;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * This is a POJO(Plain Old Java Object), so its purpose is to model a entity
 * that will be then handled by the DB, calls, and so on.
 */
@Document(collection = "Order")
public final class Order {

    public static final int MAX_LENGTH_ADDRESS = 500;
    public static final int MAX_LENGTH_TITLE = 100;

    @Id
    private String id;

    @Field(value = "cardId")
    private String cardId;

    @Field(value = "address")
    private String address;

    @Field(value = "date")
    private DateTime orderDate;

    @Field(value = "ownerId")
    private String ownerId;

    public Order() {}

    private Order(Builder builder) {
        this.cardId = builder.cardId;
        this.address = builder.address;
        this.orderDate = builder.dateOrder;
        this.ownerId = builder.ownerId;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public String getAddress() {
        return address;
    }

    public String getCardId() {
        return cardId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public DateTime getOrderDate() {
        return orderDate;
    }

    public String getId() {
        return id;
    }

    public void update(String address, String cardId, String ownerId) {
        checkAddressAndCardId(address, cardId);

        this.address = address;
        this.cardId = cardId;
        this.ownerId = ownerId;
    }

    /**
     * We don't have to use the builder pattern here because the constructed
     * class has only two String fields. However, I use the builder pattern
     * in this example because it makes the code a bit easier to read.
     */
    public static class Builder {

        private String cardId;

        private String address;

        private DateTime dateOrder;

        private String ownerId;

        private Builder() {}

        public Builder cardId(String cardId) {
            this.cardId = cardId;
            return this;
        }

        public Builder ownerId(String ownerId) {
            this.ownerId = ownerId;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder dateOrder(){
            this.dateOrder = DateTime.now();
            return this;
        }

        public Order build() {
            Order build = new Order(this);
            if(build.checkAddressAndCardId(build.getAddress(), build.getCardId())){
                return build;
            }
            throw new IllegalArgumentException();
        }
    }

    private boolean checkAddressAndCardId(String address, String cardId) {
        if(address == null) {
            System.err.println("Address cannot be null");
            return false;
        }

        if(address.isEmpty()) {
            System.err.println("Address cannot be empty");
            return false;
        }

        if(address.length() > MAX_LENGTH_TITLE){
            System.err.println("Address cannot be longer than " + MAX_LENGTH_TITLE + " characters");
            return false;
        }

        return true;
    }
}
