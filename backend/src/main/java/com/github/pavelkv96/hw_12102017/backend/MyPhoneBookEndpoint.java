package com.github.pavelkv96.hw_12102017.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.NotFoundException;
import com.googlecode.objectify.ObjectifyService;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.inject.Named;

import lombok.extern.java.Log;

@Api(
        name = "myPhoneBookApi",
        version = "v1",
        resource = "myPhoneBook",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.Pavel.example.com",
                ownerName = "backend.myapplication.Pavel.example.com",
                packagePath = ""
        )
)
@Log
public class MyPhoneBookEndpoint {

    private static Map<Long, MyPhoneBook> phoneBookMap;

    static {
        ObjectifyService.register(MyPhoneBook.class);
        phoneBookMap = new LinkedHashMap<>();
    }

    @ApiMethod(
            name = "get",
            path = "myPhoneBook/{id}",
            httpMethod = ApiMethod.HttpMethod.GET)
    public MyPhoneBook get(@Named("id") long id) throws NotFoundException {
        MyPhoneBook phoneBook = phoneBookMap.get(id);
        if (phoneBook == null) {
            throw new NotFoundException("Could not find MyPhoneBook with ID: " + id);
        }
        return phoneBook;
    }

    @ApiMethod(
            name = "insert",
            path = "myPhoneBook",
            httpMethod = ApiMethod.HttpMethod.POST)
    public MyPhoneBook insert(MyPhoneBook myPhoneBook) {
        if (phoneBookMap.values().size() == 0) {
            myPhoneBook.setId(1);
        } else {
            Object[] array = phoneBookMap.values().toArray();
            MyPhoneBook last = (MyPhoneBook) array[array.length - 1];
            myPhoneBook.setId(last.getId() + 1);
        }
        phoneBookMap.put(myPhoneBook.getId(), myPhoneBook);
        return myPhoneBook;
    }
}
