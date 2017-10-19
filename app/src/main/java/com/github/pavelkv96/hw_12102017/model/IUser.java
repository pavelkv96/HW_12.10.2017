package com.github.pavelkv96.hw_12102017.model;

import java.io.Serializable;

/**
 * Created by Pavel on 19.10.2017.
 */

interface IUser extends Serializable{
    long getId();
    void setId(long id);
    String getFirstName();
    void setFirstName(String firstname);
    String getLastName();
    void setLastName(String lastname);
    String getAddress();
    void setAddress(String address);
    String getNumber();
    void setNumber(String number);
}
