package com.github.pavelkv96.hw_12102017.parser;

import com.github.pavelkv96.hw_12102017.model.PhoneBook;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel on 19.10.2017.
 */

public class JsonPhoneBookParser implements Parser<PhoneBook> {
    private static final String FIELD_ID = "id";
    private static final String FIELD_FIRST_NAME = "firstname";
    private static final String FIELD_LAST_NAME = "lastname";
    private static final String FIELD_ADDRESS = "address";
    private static final String FIELD_NUMBER = "number";

    @Override
    public PhoneBook parse(String json) throws Exception {
        JSONObject jsonObject = new JSONObject(json);
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.setId(jsonObject.optLong(FIELD_ID));
        phoneBook.setFirstName(jsonObject.optString(FIELD_FIRST_NAME));
        phoneBook.setLastName(jsonObject.optString(FIELD_LAST_NAME));
        phoneBook.setAddress(jsonObject.optString(FIELD_ADDRESS));
        phoneBook.setNumber(jsonObject.optString(FIELD_NUMBER));
        return phoneBook;
    }

    @Override
    public List<PhoneBook> parseArray(String json) throws Exception {
        List<PhoneBook> list = new ArrayList<>();
        JSONArray array = new JSONArray(json);
        for (int i = 0; i < array.length(); i++) {
            list.add(parse(array.getJSONObject(i).toString()));
        }
        return list;
    }

    @Override
    public String toJson(PhoneBook object) {
        throw new IllegalArgumentException("NOT IMPLEMENTED");
    }
}
