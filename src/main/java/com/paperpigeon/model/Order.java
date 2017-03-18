package com.paperpigeon.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by Huzdu on 3/16/2017.
 */
@Document(collection = "Order")
public class Order {
    public final static int LENGHT_CARD = 16;
    public final static int MAX_LENGHT_ADRESS = 100;

    @Id
    private String id;

    @Field(value = "cardNumber")
    private String cardNumber;

    @Field(value = "adress")
    private String adress;

    @Field(value= "cost")
    private int cost;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    private Order(Builder builder){
        this.cardNumber=builder.cardNumber;
        this.adress=builder.adress;
        this.cost=builder.cost;
    }

    public static class Builder {
        private String cardNumber;
        private String adress;
        private int cost;

        public Builder(){}

        public Order.Builder cardNumber(String cardNumber){
            this.cardNumber = cardNumber;
            return this;
        }
        public Order.Builder adress(String adress){
            this.adress = adress;
            return this;
        }
        public Order.Builder cost(String adress){
            this.cost = cost;
            return this;
        }

        public Order build(){
            Order build = new Order(this);
            if(build.checkOrder(build.getCardNumber(),build.getAdress(),build.getCost())){
                return build;
            }
            throw new IllegalArgumentException();
        }

    }

    private boolean checkOrder(String cardNumber,String adress,int cost){
        if((cardNumber.equals(null)&&(adress.equals(null) && (cost==0)))){
            return false;
        } else if ((cardNumber.equals(LENGHT_CARD)&&(adress.length()<MAX_LENGHT_ADRESS) && (cost > 0))){
            return true;
        }
        return false;
    }

}
