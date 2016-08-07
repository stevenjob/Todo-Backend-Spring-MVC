package com.sjob;

import java.net.URI;

class Todo {

    private Long id;
    private String title;
    private Boolean completed;
    private Integer order;
    private URI url;

    public Todo() {
        this.completed = false;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Boolean isCompleted() {
        return completed;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public URI getUrl() {
        return url;
    }

    public void setUrl(URI url) {
        this.url = url;
    }

    Todo patchWith(Todo todo) {
        if (todo.getTitle() != null) {
            this.title = todo.getTitle();
        }

        if (todo.isCompleted() != null) {
            this.completed = todo.isCompleted();
        }

        if (todo.getOrder() != null) {
            this.order = todo.getOrder();
        }

        return this;
    }

}
