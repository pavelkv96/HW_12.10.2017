package com.github.pavelkv96.hw_12102017.backend;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MyPhoneBook {
    @Id
    private long id;
    private String firstname;
    private String lastname;
    private String address;
    private String number;
}