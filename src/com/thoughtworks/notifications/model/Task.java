package com.thoughtworks.notifications.model;

import java.util.Date;

public class Task {

    private long id;

    private String name;
    private Date dueDate;

    public Task(long id, String name, String description) {

        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    private String description;

    public Task(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
    // TODO Date created
    // TODO Date lastModified

    @Override
    public String toString() {
        return name;
    }
}
