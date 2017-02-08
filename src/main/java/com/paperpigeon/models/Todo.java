package com.paperpigeon.models;

import org.springframework.data.annotation.Id;

public final class Todo {

    public static final int MAX_LENGTH_DESCRIPTION = 500;
    public static final int MAX_LENGTH_TITLE = 100;

    @Id
    private String id;

    private String description;

    private String title;

    public Todo() {}

    private Todo(Builder builder) {
        this.description = builder.description;
        this.title = builder.title;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public void magic() {
        this.title = this.title + "ish";
        System.out.println("magic happens");
    }

    public void update(String title, String description) {
        checkTitleAndDescription(title, description);

        this.title = title;
        this.description = description;
    }

    /**
     * We don't have to use the builder pattern here because the constructed
     * class has only two String fields. However, I use the builder pattern
     * in this example because it makes the code a bit easier to read.
     */
    public static class Builder {

        private String description;

        private String title;

        private Builder() {}

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Todo build() {
            Todo build = new Todo(this);

            build.checkTitleAndDescription(build.getTitle(), build.getDescription());

            return build;
        }
    }

    private void checkTitleAndDescription(String title, String description) {

    }
}
