package com.paperpigeon.dto;

/**
 * Created by dani on 2/7/17.
 */
import com.paperpigeon.models.Todo;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public final class TodoDTO {

    private String id;

    @Size(max = Todo.MAX_LENGTH_DESCRIPTION)
    private String description;

    @NotEmpty
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

    //Constructor, getters, and setters are omitted
}
