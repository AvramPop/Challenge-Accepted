package com.paperpigeon.dto;


import com.paperpigeon.model.Todo;

import javax.validation.constraints.Size;

/**
 * This is the object we use as a information-holder for our REST calls. This means that we pass this object
 * as body in our controller, if we want a body(for the id, for example).
 *
 * A DTO (data transfer object) is meant to carry data between different processes,
 * in our case between the DB and the controller.
 * Every POJO should have this equivalent!
 */
public final class TodoDTO {

    private String id;

    @Size(max = Todo.MAX_LENGTH_DESCRIPTION)
    private String description;

    //@NotEmpty
    @Size(max = Todo.MAX_LENGTH_TITLE)
    private String title;

    public TodoDTO findTodoById(String id){
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
