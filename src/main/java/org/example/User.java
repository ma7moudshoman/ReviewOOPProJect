package org.example;

public abstract class User {
    public String name;
    private String email;
    private  String phoneNumber;
    protected IOOperation [] operation;

    public User() {}

    public User(String name) {
        this.name = name;
}

    public User(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public IOOperation[] getOperation() {
        return operation;
    }
    public void setOperation(IOOperation[] operation) {
        this.operation = operation;
    }

abstract public void menu();
}
