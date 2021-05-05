package com.example.javafx.spring.boot.model;

import javafx.beans.property.*;

public class User {

    private final SimpleIntegerProperty id;
    private final SimpleStringProperty name;
    private final SimpleBooleanProperty isEmployed;


    public User(Integer id, String name, boolean isEmployed) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.isEmployed = new SimpleBooleanProperty(isEmployed);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public boolean getIsEmployed() {
        return isEmployed.get();
    }

    public void setIsEmployed(boolean isEmployed) {
        this.isEmployed.set(isEmployed);
    }

    public BooleanProperty isEmployedProperty() {
        return isEmployed;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isEmployed=" + isEmployed +
                '}';
    }
}
