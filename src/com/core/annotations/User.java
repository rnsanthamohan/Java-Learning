package com.core.annotations;

@JSonSerializable
public class User {
    @JSonElement
    private String firstName;
    @JSonElement
    private String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Init
    public void initUser() {
        this.firstName = this.firstName.substring(0, 1).toUpperCase()
                + this.firstName.substring(1);
        this.lastName = this.lastName.substring(0, 1).toUpperCase()
                + this.lastName.substring(1);
    }
}
