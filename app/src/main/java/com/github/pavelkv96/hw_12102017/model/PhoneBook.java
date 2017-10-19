package com.github.pavelkv96.hw_12102017.model;

/**
 * Created by Pavel on 19.10.2017.
 */

public class PhoneBook implements IUser {
    private long id;
    private String firstname;
    private String lastname;
    private String address;
    private String number;

    public PhoneBook() {
    }

    public PhoneBook(long id, String firstname, String lastname, String address, String number) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.number = number;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getFirstName() {
        return firstname;
    }

    @Override
    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public String getLastName() {
        return lastname;
    }

    @Override
    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                "\nFirst name: " + firstname +
                "\nLast name: " + lastname +
                "\nAddress: " + address +
                "\nNumber: " + number;
    }
}
