package com.paperpigeon.dto;

import com.paperpigeon.model.Order;

import javax.validation.constraints.Size;

/**
 * Created by Huzdu on 3/16/2017.
 */
public class OrderDTO {
    private String id;

    @Size(max = Order.LENGHT_CARD)
    private String cardNumber = "";

    @Size(max = Order.MAX_LENGHT_ADRESS)
    private String adress = "";

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    private String cost;

}
