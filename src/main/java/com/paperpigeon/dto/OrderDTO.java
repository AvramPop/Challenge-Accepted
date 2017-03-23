package com.paperpigeon.dto;


import com.paperpigeon.model.Order;
import org.joda.time.DateTime;

import javax.validation.constraints.Size;

/**
 * This is the object we use as a information-holder for our REST calls. This means that we pass this object
 * as body in our controller, if we want a body(for the id, for example).
 *
 * A DTO (data transfer object) is meant to carry data between different processes,
 * in our case between the DB and the controller.
 * Every POJO should have this equivalent!
 */
public final class OrderDTO {

    private String id;
    
    private String cardId;

    private String ownerId;

    //@NotEmpty
    @Size(max = Order.MAX_LENGTH_TITLE)
    private String address;

    private DateTime orderDate;

    public OrderDTO findOrderById(String id){
        if(this.id.equals(id)){
            return this;
        } else {
            return null;
        }
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public DateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(DateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
