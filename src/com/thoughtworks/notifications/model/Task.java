package com.thoughtworks.notifications.model;

import java.util.Date;

public class Task {

    private long id;

    private String title;
    private Date dueDate;

    public Task(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        return title;
    }
}
